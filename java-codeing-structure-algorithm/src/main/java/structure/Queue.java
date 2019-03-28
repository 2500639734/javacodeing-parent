package structure;

/**
 * @author: shenke
 * @date: 2019/3/28 17:04
 * @description: 队列 -> 先进先出
 */
public class Queue<E> {

    // 定义队列的最大容量
    private static final int MAX_CAPACITY = 2 << 16;

    // 存放队列元素
    private Object[] data;

    // 队列长度
    private int size = 0;

    // 队列头部下标
    private int front = 0;

    // 队列尾部下标
    private int rear = 0;

    /**
     * 构造队列,使用默认最大容量
     */
    public Queue () {
        this(MAX_CAPACITY);
    }

    /**
     * 构造队列,使用指定容量
     * @param initSize
     */
    public Queue (int initSize) {
        if (initSize > MAX_CAPACITY) {
            throw new RuntimeException("beyond max capacity");
        }
        data = new Object[initSize];
    }

    /**
     * 往队列添加元素,从尾部添加
     * @param e
     */
    public void offer (E e) {
        if (rear == MAX_CAPACITY) {
            throw new RuntimeException("beyond max capacity");
        }
        data[rear++] = e;
        size++;
    }

    /**
     * 获取队列元素,先进先出从头部获取
     * @return
     */
    public E poll () {
        E element = peek();
        front ++;
        size --;
        return element;
    }

    /**
     * 获取队列元素,但不出列
     * @return
     */
    public E peek () {
        if (front == MAX_CAPACITY) {
            throw new RuntimeException("beyond max capacity");
        }
        return (E) data[front];
    }

    /**
     * 获取队列实际容量
     * @return
     */
    public int size () {
        return size;
    }

    /**
     * 队列是否为空
     * @return
     */
    public boolean isEmpty () {
        return size == 0;
    }


}
