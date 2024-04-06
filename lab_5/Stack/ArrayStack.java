package Stack;

public class ArrayStack<T> {
    Object[] array;
    int top;
    private static final int DEFAULT_CAPACITY = 10;

    ArrayStack() {
        array = new Object[DEFAULT_CAPACITY];
        top = -1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    void push(T value) {
        if (top == array.length - 1) {
            resizeArray();
        }
        top++;
        array[top] = value;
    }

    T getLastElement() { // без удаления
        if (isEmpty()) {
            return null;
        }
        return (T) array[top];
    }

    T pop() { // с удалением
        if (isEmpty()) {
            return null;
        }
        T popped = (T) array[top];
        top--;
        return popped;
    }

    private void resizeArray() {
        Object[] newArray = new Object[array.length + DEFAULT_CAPACITY];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
}