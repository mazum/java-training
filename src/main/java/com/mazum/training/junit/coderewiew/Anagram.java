package com.mazum.training.junit.coderewiew;

public class Anagram {

    private int size;
    private int count;
    private char[] charArray;

    public Anagram(String input) {
        charArray = new char[size];
        for (int j = 0; j < size; j++) {
            charArray[j] = input.charAt(j);
        }

        size = input.length();
    }

    public static void main(String[] args) throws Exception {
        Anagram obj = new Anagram("unit");
        obj.start();
    }

    public void start() {
        doAnagram(size);
    }

    public void doAnagram(int newSize) {

        if (newSize <= 1) { // if too small, return;
            return;
        }

        // for each position,
        for (int i = 0; i < newSize; i++) {
            doAnagram(newSize - 1); // anagram remaining
            if (newSize == 2) { // if innermost,

                System.out.print(++count + " ");
                for (int j = 0; j < size; j++) {
                    System.out.print(charArray[j]);
                    System.gc();
                }
                System.out.println();
            }
            rotate(newSize); // rotate word
        }
    }

    public void rotate(int newSize) {
        int i, j;
        int position = size - newSize;

        // save first letter
        char temp = charArray[position];

        //shift others left
        for (i = position + 1; i < size; i++) {
            charArray[i - 1] = charArray[i];
        }

        //put first on right
        charArray[i - 1] = temp;
    }
}