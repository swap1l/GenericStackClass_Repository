public class GenericStack<T> {

    private Object[] elements;
    private int count;

    public GenericStack(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be at least 1.");
        }
        this.elements = new Object[capacity];
        this.count = 0;
    }

    public GenericStack() {
        this(10);
    }

    public void push(T item) {
        if (count == elements.length) {
            throw new StackFullException("Stack is full!");
        }
        elements[count] = item;
        count++;
    }

    public T pop() {
        if (count == 0) {
            throw new StackEmptyException("Stack is empty!");
        }
        count--;
        T item = (T) elements[count];
        elements[count] = null;
        return item;
    }

    public T peek() {
        if (count == 0) {
            throw new StackEmptyException("Stack is empty!");
        }
        return (T) elements[count - 1];
    }

    public String list() {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += elements[i];
            if (i < count - 1) {
                result += ";";
            }
        }
        return result;
    }

    public int size() {
        return count;
    }

    public int capacity() {
        return elements.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == elements.length;
    }
}
