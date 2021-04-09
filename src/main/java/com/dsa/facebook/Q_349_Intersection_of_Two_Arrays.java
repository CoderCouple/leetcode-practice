package com.dsa.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Q_349_Intersection_of_Two_Arrays {


    /*
    Note:

    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.

    Follow up:
    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?


    Follow-up Questions
    What if the given array is already sorted? How would you optimize your algorithm?

    We can use either Approach 2 or Approach 3, dropping the sort of course. It will give us linear time and constant memory complexity.
    What if nums1's size is small compared to nums2's size? Which algorithm is better?

    Approach 1 is a good choice here as we use a hash map for the smaller array.
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

    If nums1 fits into the memory, we can use Approach 1 to collect counts for nums1 into a hash map. Then, we can sequentially load and process nums2.

    If neither of the arrays fit into the memory, we can apply some partial processing strategies:

    Split the numeric range into subranges that fits into the memory. Modify Approach 1 to collect counts only within a given subrange, and call the method multiple times (for each subrange).

    Use an external sort for both arrays. Modify Approach 2 to load and process arrays sequentially.
    * */

    //if the array is not sorted
    // TC: O(nlogn + mlogm) n:  n: number of elements in one array
    // SC: O(m+n) number of elements in another array
    //OR
    //if the array is already sorted
    // TC: O(n+m) n: number of elements in one array
    // SC: O(n+m) m: number of elements in another array

    // unique intersection
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        if(nums1 == null || nums2 == null)
            return new int [0];

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int num1Index =0;
        int num2Index =0;

        while(num1Index<nums1.length && num2Index<nums2.length){
            if(nums1[num1Index] == nums2[num2Index]){
                set.add(nums1[num1Index]);
                num1Index++;
                num2Index++;
            } else if(nums1[num1Index] < nums2[num2Index]) {
                num1Index++;
            } else {
                num2Index++;
            }
        }

        int [] result = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        int index =0;
        while (it.hasNext()){
            result[index] = it.next();
            index++;
        }
        return result;
    }



    //if the array is not sorted
    // TC: O(nlogn + mlogm) n:  n: number of elements in one array
    // SC: O(m+n) number of elements in another array
    //OR
    //if the array is already sorted
    // TC: O(n+m) n: number of elements in one array
    // SC: O(n+m) m: number of elements in another array

    // Full intersection
    public int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        if(nums1==null || nums2 == null)
            return new int [0];

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int num1Index =0;
        int num2Index =0;

        while(num1Index<nums1.length && num2Index<nums2.length){
            if(nums1[num1Index] == nums2[num2Index]){
                list.add(nums1[num1Index]);
                num1Index++;
                num2Index++;
            } else if(nums1[num1Index] < nums2[num2Index]) {
                num1Index++;
            } else {
                num2Index++;
            }
        }

        int [] result = new int[list.size()];
        Iterator<Integer> it = list.iterator();
        int index =0;
        while (it.hasNext()){
            result[index] = it.next();
            index++;
        }
        return result;
    }

    // Binary Search Approach
    public int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        if(nums1==null || nums2 == null)
            return new int [0];

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        if(nums1.length < nums2.length){
            int [] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        // nums1 == large
        // nums2 == small
        // Iterate on the smaller array
        // Binary Search in the larger array
       int start =0;
       for(int  element : nums2){
           int result = binarySearch(nums1, start,element);
           if( result != -1){
               set.add(element);
               start = result;
           }
       }

        int [] result = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        int index =0;
        while (it.hasNext()){
            result[index] = it.next();
            index++;
        }
        return result;
    }

    public int binarySearch(final int[] nums1, int start, final int element) {
        int end = nums1.length-1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums1[mid] == element) {
                return mid;
            } else if (nums1[mid] < element) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q_349_Intersection_of_Two_Arrays obj = new Q_349_Intersection_of_Two_Arrays();
        System.out.println(Arrays.toString(obj.intersection3(new int []{1},new int []{1})));
    }

}
