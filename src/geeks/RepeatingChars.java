package geeks;

import java.util.*;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class RepeatingChars {
    public static void main (String args[]) {
        Map<Character, Integer> map = new HashMap<>();
        String s = " ";
        int len = 0;
        int pos = 0;
        for (char c : s.toCharArray())  {
            if (map.containsKey(c))    {
                if (map.size() > len)   {
                    len = map.size();
                }
                remove(map, map.get(c));
            }
            map.put(c, pos);
            pos++;
        }
        if (map.size() > len)   {
            len = map.size();
        }
        System.out.println("len : " + len);
    }

    static void remove(Map<Character, Integer> map, int index) {
        Iterator<Map.Entry<Character, Integer>> iter = map.entrySet().iterator();
        while (iter.hasNext())  {
            if (iter.next().getValue() <= index)    {
                iter.remove();
            }
        }
    }
}
