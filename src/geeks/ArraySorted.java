package geeks;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ArraySorted {
    public static void main (String args[]) throws IOException {
        //C:\Users\naina\IdeaProjects\leetcode\src\numbers.txt
        File file = new File("C:\\Users\\naina\\IdeaProjects\\leetcode\\src\\nums1.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String s = reader.readLine();
        String nums[] = s.split(" ");
        int arr1[] = new int[nums.length];
        int arr[] = {90, 80, 100, 70, 40, 30};
        for (int i = 0; i < nums.length; ++i)   {
            arr1[i] = Integer.parseInt(nums[i]);
        }
        for (int i = 0; i < arr1.length-1; ++i)   {
            if (arr1[i] > arr1[i+1])    {
                System.out.println("pos - " + i + " - " + arr1[i]);
            }
        }
        boolean ans = arraySortedOrNot(arr1, arr1.length);
        System.out.println(ans);
    }
    static boolean arraySortedOrNot(int[] arr, int n) {
        if (arr.length == 3)    {
            return (arr[0] <= arr[1]) && (arr[1] <= arr[2]);
        }
        if (arr.length == 2)    {
            return arr[0] <= arr[1];
        }
        if (arr.length == 1)    {
            return true;
        }
        int mid = arr.length / 2;
        int[] arr1 = new int[mid+1];
        int[] arr2 = new int[arr.length - mid-1];
        //System.out.println("arr1 - " + mid);
        if (arr1[mid] == 1418 || arr1[mid] == 1415) {
            System.out.println("found");
        }
        if (arr[mid] > arr[mid+1])    {
            return false;
        }
        if (mid !=0 && arr[mid-1] > arr[mid] )    {
            return false;
        }
        for ( int i = 0; i <= mid; ++i)  {
            arr1[i] = arr[i];
        }
        for (int i = mid+1; i < arr.length; ++i)    {
            arr2[i-mid-1] = arr[i];
        }
        return arraySortedOrNot(arr1, arr1.length) && arraySortedOrNot(arr2, arr2.length);
    }

}
