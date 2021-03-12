package com.example.networktest_11903738;

import java.util.ArrayList;

public class MatrSort {
    long matrNr;

    public MatrSort(Long matrNr) {
        this.matrNr = matrNr;
    }
    
    public void init () {

        ArrayList<Integer> matrList = new ArrayList<>();
        while (matrNr != 0) {
            matrList.add((int)matrNr%10);
            matrNr = matrNr/10;
        }

        ArrayList<Integer> sorted = splitList(matrList);
        printList(sorted);
    }

    private ArrayList<Integer> splitList(ArrayList<Integer> toSort) {
        //list for even numbers
        ArrayList<Integer> evenNums = new ArrayList<>();
        //list for odd numbers
        ArrayList<Integer> oddNums = new ArrayList<>();

        //put even numbers in evenNums and odd numbers in oddNums
        for (int i = 0; i < toSort.size(); i++) {
            if (toSort.get(i)%2 == 0) {
                evenNums.add(toSort.get(i));
            }else {
                oddNums.add(toSort.get(i));
            }
        }

        sortList(evenNums);
        sortList(oddNums);

        return mergeLists(evenNums, oddNums);
    }
    public void sortList(ArrayList<Integer> toSort) {
        int swap;
        //BubbleSort Algorithm, very effective ^^
        for (int i = 0; i < toSort.size()-1; i++) {
            for (int j = 0; j < toSort.size() - i - 1;  j++) {
                if (toSort.get(j) > toSort.get(j+1)) {
                    swap = toSort.get(j);
                    toSort.set(j, toSort.get(j+1));
                    toSort.set(j+1, swap);
                }
            }
        }
    }

    public ArrayList<Integer> mergeLists(ArrayList<Integer> evenNums, ArrayList<Integer> oddNums) {

        ArrayList<Integer> mergedList = new ArrayList<>();
        mergedList.addAll(evenNums);
        mergedList.addAll(oddNums);

        return mergedList;
    }

    private void printList(ArrayList<Integer> sorted) {
        for (Integer integer : sorted) {
            System.out.print(integer);
        }
    }


}
