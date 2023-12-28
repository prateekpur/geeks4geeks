package geeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {

    public static void main (String args[]) {
        Permutations p = new Permutations();
        List<String> li = p.find_permutation("ABC");
        System.out.println( String.join(", " , li));
        System.out.println(li.size());
    }
    public List<String> find_permutation(String S) {
        List<String> perms = new ArrayList<>();
        perms.add("");
        perms = find1(S, "");
        return perms;
    }

    public List<String> find1(String parent, String current) {
        //System.out.println("parent - " + parent);
        //System.out.println("current - " + current);
        List<String> li = new ArrayList<>();
        if (parent.length() == 1)   {
            li.add(current.concat(parent));
            return li;
        }
        for (int i = 0; i < parent.length(); ++i)   {
            li.addAll(find1(parent.substring(0, i) + parent.substring(i+1),
                    current.concat(Character.toString(parent.charAt(i)))));
        }
        java.util.Set<String> set = new java.util.HashSet<>();
        set.addAll(li);
        List<String> li1 = new ArrayList<>();
        for (String s : set)    {
            li1.add(s);
        }
        Collections.sort(li1);
        return li1;
    }



    /*public List<String> find(String parent, List<String> perms)  {
        if (!perms.isEmpty() && perms.get(0).length() == parent.length())    {
            return perms;
        }
        Set<String> set = new HashSet<>();
        for (String s : perms)  {
            for (char c: parent.toCharArray())  {
                set.add(s.concat(Character.toString(c)));
            }
        }
        return find(parent, set.stream().toList());
    }*/

}
