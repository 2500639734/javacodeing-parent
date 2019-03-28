package structure;

/**
 * @author: shenke
 * @date: 2019/3/28 16:05
 * @description: 栈 -> 后进先出
 */
public class Stack<E> {

    // 定义栈的最大容量
    private static final int MAX_CAPACITY = 3;

    // 存放栈中数据
    private Object[] data = null;

    // 定义栈顶元素下标
    private int topIndex = -1;

    /**
     * 构造栈,默认最大容量
     */
    public Stack () {
        this(MAX_CAPACITY);
    }

    /**
     * 构造栈,自定义容量
     * @param initSize 自定义容量
     */
    public Stack (int initSize) {
        if (initSize > MAX_CAPACITY) {
            throw new RuntimeException("beyond max capacity");
        }
        data = new Object[initSize];
    }

    /**
     * 栈中数据是否为空
     * @return
     */
    public boolean isEmpty () {
        return topIndex < 0;
    }

    /**
     * 入栈
     * @param e
     */
    public void push (E e) {
        if (topIndex == MAX_CAPACITY) {
            throw new RuntimeException("beyond max capacity");
        }
        data[++topIndex] = e;
    }

    /**
     * 出栈
     * @return
     */
    public E pop () {
        E element = peek();
        topIndex --;
        return element;
    }

    /**
     * 查看栈顶元素,但不出栈
     * @return
     */
    public E peek () {
        if (topIndex < 0) {
            throw new RuntimeException("topIndex < 0");
        }
        return (E) data[topIndex];
    }

    /**
     * 获取栈的实际长度 -> 元素个数
     * @return
     */
    public int size () {
        return topIndex + 1;
    }

    /**
     * 搜索元素下标
     * @param e 元素
     * @return 下标
     */
    public int search (E e) {
        int tempIndex = topIndex;
        while (topIndex != -1) {
            if (peek().equals(e)) {
                int index = topIndex;
                topIndex = tempIndex;
                return index;
            }
            topIndex --;
        }
        return -1;
    }

}
