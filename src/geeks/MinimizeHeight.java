package geeks;

public class MinimizeHeight {
    public static void main (String args[])  {
        //int arr[] = {2, 6, 3, 4, 7, 2, 10, 3, 2, 1};
        //{1, 5, 8, 10} , k=2 , answer=5
        //{3, 9, 12, 16, 20}  k=3  answer=11
        //{1, 9, 10, 1, 1, 3, 10, 3, 4, 6}  k=4  answer=5
        //{6 1 9 1 1 7 9 5 2 10} k=4 answer=5
        int arr[] = {6, 1, 9, 1, 1, 7, 9, 5, 2, 10};
        System.out.println(getMinDiff(arr, arr.length, 4));
     }
    static int getMinDiff(int[] arr, int n, int k) {
        // code here
        final int origArr[] = new int[arr.length];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, maxIndex = -1, minIndex = -1;
        for ( int i = 0; i < n; ++i)    {
            origArr[i] = arr[i];
            arr[i] = arr[i] + k;
        }
        for (int i = 0; i < arr.length; ++i)    {
            if (arr[i] < min)   {
                min = arr[i];
                minIndex = i;
            }
            if (arr[i] > max)   {
                max = arr[i];
                maxIndex = i;
            }
        }
        while(true) {
            int diff = max - min;
            int origMax = arr[maxIndex] , origMin = arr[minIndex];
            if (origArr[maxIndex] - k > 0)  {
                arr[maxIndex] = origArr[maxIndex] - k;
            }
            arr[minIndex] = origArr[minIndex] + k;
            //check if updating max, min helps
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; ++i)    {
                if (arr[i] < min)   {
                    min = arr[i];
                    minIndex = i;
                }
                if (arr[i] > max)   {
                    max = arr[i];
                    maxIndex = i;
                }
            }
            if ( diff <= max - min)  {
                //updating did not help return original values
                return origMax - origMin;
            }
        }
    }

}
