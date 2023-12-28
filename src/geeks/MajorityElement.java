package geeks;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main (String args[]) {
        int a[] = {3,1,3,3,2};
        majorityElement(a, a.length);
    }

    public static int majorityElement(int a[], int size) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i : a)    {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }   else {
                map.put(i, 1);
            }
        }
        for (int i : map.keySet())  {
            if (a.length %2 == 0)   {
                if (map.get(i) > a.length/2)    {
                    return i;
                }
            }   else {
                if (map.get(i) >= a.length/2)    {
                    return i;
                }
            }
        }
        return -1;
    }

}
