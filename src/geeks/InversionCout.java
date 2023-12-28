package geeks;

import java.lang.reflect.Array;
import java.util.Arrays;

public class InversionCout {
    public static void main (String args[]) {
        long arr[] = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr, arr.length));
    }
    static long inversionCount(long arr[], long N) {
        // Your Code Here
        int count = 0;
        for (int i = 0; i < arr.length; ++i)    {
            for (int j = i+1; j < arr.length; ++j)  {
                if (arr[i] > arr[j])    {
                    ++count;
                }
            }
        }
        return count;
    }
}
