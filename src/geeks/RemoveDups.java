package geeks;

import java.io.*;

public class RemoveDups {
    static String s = "";
    public static void main (String args[]) throws IOException {
        File file = new File("C:\\Users\\naina\\IdeaProjects\\leetcode\\src\\nums1.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        s = reader.readLine();
//        s = "assfg";
        String s1 = rremove(s);
        System.out.println("Answer : " + s1);
    }

    static String rremove(String s) {
        if (s.isEmpty())    {
            return "";
        }
        System.out.println(s);
        String s1 = rremove1(0);
        if (s1.equals(s))   {
            return s1;
        }   else {
            s1 = rremove(s1);
        }
        return s1;
    }
    static String  rremove1(int index) {
        boolean found = false;
        if (s.length() - index < 2)    {
            return s;
        }
        if (s.charAt(index) == s.charAt(index + 1)) {
            //remove all chars of value ar s[0]
            char first = s.charAt(index);
            do {
//                System.out.println(index);
                index++;
            } while ((index < s.length()) && s.charAt(index) == first);
            found = true;
        }
        if (found)  {
            //System.out.println(index);
            return rremove1(index);
        }   else {
            //System.out.println(index + 1);
            return rremove1(index + 1);
        }
        //return "";
    }

}
