package com.javacodeing.thread.advanced;

/**
 * 乐观锁悲观锁伪代码实现
 * 乐观锁: 无锁,轻量级,非阻塞,效率高,重试 总是认为当前没有其它线程操作,直接尝试写入数据
 * 悲观锁: 重量级,阻塞,效率低 java的synchronized关键字
 */
public class OptimisticPessimisticLock {

    /**
     * 悲观锁sql
     */
    public void optimisticLockSql () {
        // 获取当前数据版本号
        String select = "select version from table where id = #{id}";
        // 如果获取成功,表示当前没有其它线程修改,成功写入数据并更新版本号,否则表示当前已有其它线程修改,重试
        String update = "update x = 1,version = version + 1 where version = #{version} and id = #{id}";
    }

    /**
     * 乐观锁sql
     */
    public void PessimisticLockSql () {
        // synchronized关键字实现乐观锁

        // 对当前select的行上锁后执行update,同样结果的语句需要阻塞等待
        String update = "select x = 1 from table for update a = 1";
    }

}
