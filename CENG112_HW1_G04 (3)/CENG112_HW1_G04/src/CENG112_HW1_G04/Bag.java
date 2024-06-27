package CENG112_HW1_G04;

import java.util.Arrays;

public class Bag<T> implements IBag<T>{
    public T[] bag;
    public int numberOfEntries;
    private boolean initialized = false;
    private static final int MAX_CAPACITY = 10000;
    int desiredCapacity;
    public
    Bag(int desiredCapacity)
    {
        if (desiredCapacity <= MAX_CAPACITY)
        {
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[])new Object[desiredCapacity]; // Unchecked cast
            bag = tempBag;
            numberOfEntries = 0;
            initialized = true;}
        else {
            throw new IllegalStateException("Attempt to create a bag " +
                    "whose capacity exceeds " +
                    "allowed maximum.");
        }  
    }
    public boolean add(T newEntry) {
        checkInitialization();
        if (isArrayfull()) {
            doubleCapacity();
        }
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        return true;
    }
    private void checkCapacity(int desiredCapacity){
        if (desiredCapacity>MAX_CAPACITY){
            throw new IllegalStateException("Attempt to create a bag whose " +
                    "capacity exceeds allowed " +
                    "maximum of " + MAX_CAPACITY);
        }
    }
    private void doubleCapacity(){
        int new_capacity = 2 * bag.length;
        checkCapacity(new_capacity);
        bag = Arrays.copyOf(bag, new_capacity);
    }

    public boolean isEmpty(){
        return numberOfEntries==0;}
    public boolean isFull(){
        return bag.length == numberOfEntries;}
    public T removeByIndex(int index){
        T returner = null;
        if (!isEmpty() && index>0){
            returner = bag[index];
            bag[index] = bag[numberOfEntries-1];
            bag[numberOfEntries-1] = null;
            numberOfEntries--;}
        return returner;}
    public boolean remove(T anEntry){
        checkInitialization();
        int index = getIndexOf(anEntry);
        T removed = removeByIndex(index);
        return anEntry.equals(removed);}
    public T remove(){
        checkInitialization();
        T result = null;
        if(numberOfEntries>0){
            result = bag[numberOfEntries - 1];
            bag[numberOfEntries-1] = null;
            numberOfEntries--;}
    return result;}
    public int getFrequencyOf(T anEntry){
        int counter = 0 ;
        for(int index =0; index < numberOfEntries; index++){
            if (anEntry.equals(bag[index])){
                counter ++;
            }
        }
        return counter;}
    public int getIndexOf(T anEntry){
        int location = -1;
        boolean searching = true;
        int index = 0;
        while(searching && index<numberOfEntries){

            if(anEntry.equals(bag[index])){
                location = index;
                searching = false;
            }
            index++;
        }
        return location;}
    public boolean contains(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (anEntry.equals(bag[i])) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        while(!isEmpty()){
            remove();
        }
    }
    public void displayItems() {
        for (int index = 0; index < numberOfEntries; index++) {
        	if (index==numberOfEntries-1) {
                System.out.print(bag[index] + " ");
        	}
        	else {
            System.out.print(bag[index] + ", ");
        }}
        System.out.println();
    }
    public int getCurrentSize(){return numberOfEntries;}
    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] arrBag = (T[]) new Object[numberOfEntries];
        for(int index =0; index<numberOfEntries; index++) {
            arrBag[index] = bag[index];


        }
        return arrBag;
    }
    public void checkInitialization()
    {
        if (!initialized)
            throw new SecurityException("ArrayBag object is not initialized " +
                    "properly.");}
    public boolean isArrayfull() {
        if (MAX_CAPACITY<=bag.length) {return true;}
        else {return false;}
    }}