package com.javacodeing.thread.example;

import java.sql.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 读取线程
 */
public class ReadThread implements Runnable {

    private volatile Watch watch;

    private volatile BlockingQueue<Card> blockingQueue;

    public ReadThread (Watch watch, BlockingQueue<Card> blockingQueue) {
        this.watch = watch;
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int start = 0;
        int size = 10000;
        long total = 0;
        int count = 0;

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/test?userSSL=true&useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT";
            String username = "root";
            String password = "root";

            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            String selectCountSql = "select count(*) as total from card";
            String selectSql = "select card_id,card_number from card limit ?,?";
            ps = connection.prepareStatement(selectCountSql);
            rs = ps.executeQuery();
            rs.next();
            total = rs.getLong("total");

            ps = connection.prepareStatement(selectSql);

            while (watch.getRead()) {
                ps.setInt(1, start);
                ps.setInt(2, size);
                rs = ps.executeQuery();
                if (rs == null || !rs.next()) {
                    watch.setRead(false);
                    break;
                }

                rs.beforeFirst();

                Card card = null;
                while (rs.next()) {
                    card = new Card();
                    card.setCardId(rs.getLong("card_id"));
                    card.setCardNumber(rs.getString("card_number"));
                    boolean offer = blockingQueue.offer(card, 10, TimeUnit.SECONDS);
                    if (offer) {
                        count ++;
                        System.out.printf("已读取第%d条数据,剩余%d条数据,当前数据card = %s\n", count, (total - count), card);
                    }
                }

                start = size;
                size += start;
            }
        } catch (Exception e) {
            e.printStackTrace();
            watch.setRead(false);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }

                if (ps != null) {
                    ps.close();
                    ps = null;
                }

                if (connection != null) {
                    connection.close();
                    connection = null;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("读取完毕");
        }

    }

}
