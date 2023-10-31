package com.company.oop;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class MyListImpl<T> implements MyList<T> {
    private static final int DEAF_CAP = 4;
    private static final int GROWTH_FACTOR = 2;
    private T[] elements;
    private int size;
    public MyListImpl(int capacity) {
        if(capacity <= 0){
            throw new IllegalArgumentException("Capacity must be a positive integer");
        }
        this.elements =(T[]) new Object[capacity];
        this.size = 0;
    }//constructor
    public MyListImpl(){
        this(DEAF_CAP);
    }//secondConstructor
    //---------------------------------methods--------------------------------------
    @Override
    public int size() {
        return size;
    }//size

    @Override
    public int capacity() {
        return elements.length;
    }//capacity

    @Override
    public void add(T element) {
        if(size == elements.length){
            resizeArray();
        }
        elements[size] = element;
        size++;
    }//add

    private void resizeArray(){
        int newCapacity = elements.length * GROWTH_FACTOR;
        elements = Arrays.copyOf(elements, newCapacity);
    }//resizeArray doubling the size, so the array doesn't need to be resized too often.

    @Override
    public T get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of range:" + index);
        }
        return elements[index];
    }//get

    @Override
    public int indexOf(T element) {
        for(int i = 0; i < size; i++){
            if(elements[i].equals(element)){
                return i;
            }
        }
        return -1;
    }//indexOf

    @Override
    public int lastIndexOf(T element) {
        for(int i = size-1; i >= 0; i--){
            if(elements[i].equals(element)){
                return i;
            }
        }
        return -1;
    }//lastIndexOf

    @Override
    public boolean contains(T element) {
        for(int i = 0; i < size; i++){
            if(elements[i].equals(element)){
                return true;
            }
        }
        return false;
    }//contains

    @Override
    public void removeAt(int index) {
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i = index; i < size - 1; i++){
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size --;
    }//removeAt

    @Override
    public boolean remove(T element) {
        for(int i = 0; i < size; i++){
            if(elements[i].equals(element)){
                removeAt(i);
                return true;
            }
        }
        return false;
    }//remove

    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }//clear

    @Override
    public void swap (int from, int to) {
        if(from < 0 || from >= size || to < 0 || to >= size){
            throw new IndexOutOfBoundsException("Index out of range");
        }
        T temp = elements[from];
        elements[from] = elements [to];
        elements[to] = temp;
    }//swap

    @Override
    public void print () {
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < size; i++){
            sb.append(elements[i]);
            if(i < size - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }//iterator

    //-------------------------------private class----------------------------------
    private class ListIterator implements Iterator<T> {
        private int currentIndex ;

        public ListIterator(){
            currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }//hasNext

        @Override
        public T next() {
            if(!hasNext()){
                throw new IndexOutOfBoundsException();
            }
            T element = elements[currentIndex];
            currentIndex++;
            return element;
        }
    }

}
