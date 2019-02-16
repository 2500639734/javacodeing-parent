package com.javacodeing.thread.example;

import com.alibaba.fastjson.JSON;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 写入线程
 */
public class WriteThread implements Runnable {

    private volatile Watch watch;

    private volatile BlockingQueue<Card> blockingQueue;

    public WriteThread (Watch watch, BlockingQueue<Card> blockingQueue) {
        this.watch = watch;
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        String fileName = "card.txt";
        String filePath = new StringBuilder("D:").append(File.separatorChar).append(fileName).toString();
        File file = new File(filePath);
        File parentFile = file.getParentFile();

        if (file.exists()) {
            file.delete();
        }
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }

        int count = 0;

        String lineSeparator = System.getProperty("line.separator");

        BufferedOutputStream bufferedOutputStream = null;

        try {
            file.createNewFile();
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));

            while (watch.getWrite()) {
                Card card = blockingQueue.poll(10, TimeUnit.SECONDS);
                if (card != null) {
                    count ++;

                    String cardJson = JSON.toJSONString(card);
                    System.out.printf("写入第%d条数据, cardJson = %s\n", count, cardJson);

                    byte[] buffer = new StringBuilder(cardJson).append(lineSeparator).toString().getBytes();
                    int length = buffer.length;
                    bufferedOutputStream.write(buffer, 0, length);
                } else {
                    watch.setWrite(false);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            watch.setWrite(false);
        } finally {
            try {
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                    bufferedOutputStream = null;
                }
                System.out.println("写入完毕");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
