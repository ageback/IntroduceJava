package ch19;

public class AnyWildCardDemo {
    public static void main(String[] args) {
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(-2);

        print(intStack);
    }

    /**
     * 这里参数不能用 GenericStack<Object>，原因如下：
     *      虽然Integer是Object的子类型，但是GenericStack<Integer>不是GenericStack<Object>的子类型，
     *      所以intStack不是GenericStack<Object>的实例
     * @param stack
     */
    public static void print(GenericStack<?> stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
