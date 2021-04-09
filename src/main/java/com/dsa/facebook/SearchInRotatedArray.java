package com.dsa.facebook;

public class SearchInRotatedArray {

    public static int search(int [] array, int left, int right, int element){
        if(left > right)
            return -1;

        int mid = left + (right-left)/2;
        if(array[mid] == element)
            return mid;

        if(array[left] < array[mid]){ //left side is ordered
            if(array[mid] >  element && array[left] <= element){
                return search(array,left,mid-1,element);
            } else {
                return search(array,mid+1,right,element);
            }

        } else if(array[left] > array[mid]){ // right side is ordered
            if(array[mid] <  element && array[right] <= element){
                return search(array,mid+1,right,element);
            } else {
                return search(array,left,mid-1,element);
            }
        } else if(array[left] == array[mid]){ // repeated elements for the first and last element
            if(array[mid] != array[right]){
                return search(array,mid+1,right,element);
            } else{
                int res = search(array,left,mid-1,element);
                if(res == -1){
                    return search(array,mid+1,right,element);
                } else{
                    return res;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
