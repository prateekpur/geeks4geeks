package geeks;

public class MinJumps {
    public static void main(String args[]) {
        int arr[] = {1, 4, 3, 2, 6, 7};
        minJumps(arr);
    }

    public static int minJumps(int[] arr){
        if (arr[0] == 0)    {
            return -1;
        }
        int jumps = 0, i = 0;
        while (i < arr.length-1) {
            ++jumps;
            if (i + arr[i] >= arr.length)   {
                return jumps;
            }   else {
                //find last non-zero element
                int j = arr[i];
                while (j > 0)   {
                    if (arr[i+j] != 0)  {
                        i = i + j;
                        break;
                    }
                    --j;
                }
            }
        }
        return -1;
    }
}
