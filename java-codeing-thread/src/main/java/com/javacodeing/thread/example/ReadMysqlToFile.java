package com.javacodeing.thread.example;

import java.util.concurrent.*;

/**
 * 例子:读取mysl数据写入到txt文件
 *
 * 建表语句 :
 * ---------------------------------- create table sql start -----------------------------
 * SET NAMES utf8mb4;
 * SET FOREIGN_KEY_CHECKS = 0;
 *
 * -- ----------------------------
 * -- Table structure for card
 * -- ----------------------------
 * DROP TABLE IF EXISTS `card`;
 * CREATE TABLE `card`  (
 *   `card_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
 *   `card_number` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡号',
 *   PRIMARY KEY (`card_id`) USING BTREE
 * ) ENGINE = MyISAM AUTO_INCREMENT = 7207 CHARACTER SET = utf8 CHECKSUM = 1 COLLATE = utf8_general_ci DELAY_KEY_WRITE = 1 ROW_FORMAT = Dynamic;
 * ---------------------------------- create table sql end -----------------------------
 *
 *
 * 插入测试数据方法
 * ---------------------------------- insert data method satrt -----------------------------
 * CREATE DEFINER=`root`@`localhost` PROCEDURE `proc1`()
 * BEGIN
 * DECLARE v_cnt DECIMAL (10)  DEFAULT 0 ;
 * dd:LOOP
 *           INSERT  INTO card (card_number) VALUES (UUID());
 *                   COMMIT;
 *                     SET v_cnt = v_cnt+1 ;
 *                            IF  v_cnt = 100000 THEN LEAVE dd;
 *                           END IF;
 *          END LOOP dd ;
 * END
 * ---------------------------------- insert data method end -----------------------------
 */
public class ReadMysqlToFile {

    public static void main(String[] args) {
        Watch watch = new Watch();
        BlockingQueue<Card> blockingQueue = new LinkedBlockingQueue<>();
        Thread readThread = new Thread(new ReadThread(watch, blockingQueue));
        Thread writeThread = new Thread(new WriteThread(watch, blockingQueue));

        int availProcessors = Runtime.getRuntime().availableProcessors();

        ExecutorService executorService = Executors.newFixedThreadPool(availProcessors / 2);
        executorService.execute(readThread);
        executorService.execute(writeThread);
        executorService.shutdown();

    }

}
