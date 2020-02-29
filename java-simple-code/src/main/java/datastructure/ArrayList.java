package datastructure;

public class ArrayList<T> {
    private int size;
    private Object[] elements = new Object[100];

    public ArrayList() {
        this.size = 0;
    }

    public boolean addLast(T element) {
        // TODO: 2020/02/29 size 검사, size 초과되면 크기 2배로 증가
        elements[size] = (T) element;
        size++;
        return true;
    }

    public boolean add(int index, T element) {
        if (index == size) {
            addLast(element);
        } else if (index < size && index >= 0) {
            for (int i = size - 1; i >= index; --i) {
                elements[i + 1] = elements[i];
            }

            elements[index] = element;
        } else {
            return false;
        }

        size++;
        return true;
    }

    public boolean addFirst(T element) {
        return add(0, element);
    }

    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("유효하지 않은 index 입니다.");
        }

        T removeValue = (T) elements[index];
        for (int i = index; i < size - 1; ++i) {
            elements[i] = elements[i + 1];
        }

        size--;
        elements[size] = null;

        return removeValue;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("유효하지 않은 index 입니다.");
        }

        return (T) elements[index];
    }

    public int size() {
        return size;
    }
}
