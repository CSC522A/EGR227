/**
 * The ArrayIntList class stores an ordered list of integers.
 * 
 * @author Adam Blank
 */

public class ArrayIntList {

    private int[] elementData;
    private int size;
    public static final int DEFAULT_CAPACITY = 10;

    /** Initializes a new array list with initial capacity of initialCapacity integers. <br><br>
     *  pre: initialCapacity >= 0 otherwise throws an IllegalArgumentException */
    public ArrayIntList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        this.data = new int[initialCapacity];
        this.size = 0;
    }

    /** Initializes a new empty list with initial capacity of DEFAULT_CAPACITY integers. */
    public ArrayIntList() {
        this(DEFAULT_CAPACITY);
    }

    /** 
     * Initializes a new empty list with initial capacity of DEFAULT_CAPACITY integers.
     **/
    public ArrayIntList() {
        this.elementData = new int[10];
        this.size = 0;
    }

    /**
     * Adds value to the end of the list. <br><br>
     * post: value is appended to the ArrayList
     **/
    public void add(int value) {
        this.add(this.size, value);
    }

    /** 
     * Inserts value into the list at index. <br><br>
     * pre:  0 <= index <= size otherwise throws IndexOutOfBoundsException <br>
     * post: value is inserted at index; all later values are shifted right by 1 element 
     **/
    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index must be non-negative and at most size");
        }

        this.grow(this.size + 1);
        for (int i = this.size() - 1; i >= index; i--) {
            this.elementData[i + 1] = this.elementData[i];
        }
        this.elementData[index] = value;
        this.size++;
    }

    /** 
     * Stores value in index. <br><br>
     * pre: 0 <= index <= size otherwise throws IndexOutOfBoundsException
     **/
    public void set(int index, int value) {
        this.checkIndex(index);
        this.elementData[index] = value;
    } 

    /** 
     * Returns the value at index. <br><br>
     *  pre: 0 <= index <= size otherwise throws IndexOutOfBoundsException 
     **/ 
    public int get(int index) {
        this.checkIndex(index);
        return this.elementData[index];
    }

    /** 
     * Checks if index is a valid index into this ArrayIntList. <br>
     * post: throws IndexOutOfBoundsException if index < 0 or index >= max
     **/
    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException();
        }
    }

    /** 
     * Grows the ArrayIntList to have room for *at least* requiredCapacity elements. <br>
     * pre: 0 <= requiredCapacity otherwise throws IllegalArgumentException
     **/
    private void grow(int minimumCapacity) {
        if (requiredCapacity < 0) {
            throw new IllegalArgumentException();
        }

        // If the current capacity is less than the minimum capacity required...
        if (this.elementData.length < minimumCapacity) {
            int newCapacity = Math.max(minimumCapacity, this.elementData.length * 2);
            int[] newElementData = new int[newCapacity];

            for (int i = 0; i < this.size(); i++) {
                newElementData[i] = this.elementData[i];
            }
            this.elementData = newElementData;
        }
    }

    /**
     * Returns the number of elements in the list.
     **/
    public int size() {
        return this.size;
    }

    /**
     * Returns true if list is empty, false otherwise.
     **/
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns a String representation of the list consisting of the elements in
     * order, separated by commas and enclosed in square brackets.
     **/
    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < this.size() - 1; i++) {
            result += this.elementData[i] + ", ";
        }

        if (this.size() > 0) {
            result += this.elementData[this.size() - 1];
        }
        result += "]";
        return result;
    }

}
