package geeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RightShift {
    public static void main (String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        //list.add(1);
        //list.add(2);

        minimumRightShifts(list);
    }

    public static int minimumRightShifts(List<Integer> nums) {
        Integer[] tmp = new Integer[nums.size()];
        nums.toArray(tmp);
        if (isSorted(tmp))  {
            return 0;
        }
        boolean result;
        for (int i = 1; i <= tmp.length; ++i)    {
            rotate(tmp);
            if(isSorted(tmp))   {
                return i;
            }
        }
        return -1;
    }

    public static void rotate(Integer[] list)    {
        int last = list[list.length - 1];
        for (int i = list.length - 1 ; i > 0; --i)  {
            list[i] = list[i-1];
        }
        list[0] = last;
    }

    public static boolean isSorted(Integer[] list)  {
        for (int i = 0 ; i < list.length - 1; ++i)  {
            if (list[i] > list[i+1])    {
                return false;
            }
        }
        return true;
    }

}
