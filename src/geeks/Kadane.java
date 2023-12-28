package geeks;

import java.util.HashSet;
import java.util.Set;

public class Kadane {
    public static void main (String args[]) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubarraySum(arr, arr.length));
    }

    static long maxSubarraySum(int arr[], int n){
        long res = 0, max = Long.MIN_VALUE;
        Set<Integer> negativeIndexes = new HashSet<>();
        int index = 0;
        for (int i : arr)   {
            ++index;
            if (i < 0)  {
                negativeIndexes.add(index);
            }
            res += i;
            if (res > max)  {
                max = res;
            }
        }
        for (int i : negativeIndexes)   {
            res = 0;
            for (int j = i; j < arr.length; ++j)    {
                res += arr[j];
                if (res > max)  {
                    max = res;
                }
            }
        }
        return max;
    }

}
