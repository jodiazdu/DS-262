package QUIZ_3;

import java.util.NoSuchElementException;

public class DynamicArray<T> {
    private T[] data;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public DynamicArray(int initialCapacity) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException("La capacidad inicial debe ser al menos 1");
        }
        this.capacity = initialCapacity;
        this.size = 0;
        this.data = (T[]) new Object[initialCapacity];
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.capacity;
    }

    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Índice fuera del rango lógico: " + index);
        }
        return this.data[index];
    }

    public void set(int index, T value) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Índice fuera del rango lógico: " + index);
        }
        this.data[index] = value;
    }

    public void append(T value) {
        if (this.size == this.capacity) {
            resize(this.capacity * 2);
        }
        this.data[this.size] = value;
        this.size++;
    }

    public T removeLast() {
        if (this.size == 0) {
            throw new NoSuchElementException("No se puede eliminar de una estructura vacía");
        }
        T value = this.data[this.size - 1];
        this.data[this.size - 1] = null;
        this.size--;
        return value;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < this.size; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
        this.capacity = newCapacity;
    }
}