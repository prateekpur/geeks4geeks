package geeks;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {
    public static void main (String args[]) {
        int[][] arr = new int[8][];
        arr[0] = new int[2]; arr[1] = new int[2]; arr[2] = new int[2];
        arr[3] = new int[2]; arr[4] = new int[2]; arr[5] = new int[2];
        arr[6] = new int[2]; arr[7] = new int[2];
//arr[3] = new int[2]; arr[4] = new int[2]; arr[5] = new int[2];
        //arr[6] = new int[2];
        /*arr[0][0] = 0; arr[0][1] = 1; arr[1][0] = 0; arr[1][1] = 4;
        arr[2][0] = 4; arr[2][1] = 1; arr[3][0] = 4; arr[3][1] = 3;
        arr[4][0] = 1; arr[4][1] = 3; arr[5][0] = 1; arr[5][1] = 2;
        arr[6][0] = 3; arr[6][1] = 2;*/
        /*arr[0][0] = 0; arr[0][1] = 3; arr[1][0] = 0; arr[1][1] = 2;
        arr[2][0] = 2; arr[2][1] = 1;*/
        arr[0][0] = 5; arr[0][1] = 7;
        arr[1][0] = 0; arr[1][1] = 1;
        arr[2][0] = 0; arr[2][1] = 4;
        arr[3][0] = 1; arr[3][1] = 2;
        arr[4][0] = 1; arr[4][1] = 3;
        arr[5][0] = 1; arr[5][1] = 4;
        arr[6][0] = 2; arr[6][1] = 3;
        arr[7][0] = 3; arr[7][1] = 4;
        List<List<Integer>> li = printGraph(8, arr);
    }

    public static List<List<Integer>> printGraph(int V, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        //System.out.println(edges.length);
        for (int i = 0 ; i < V; ++i)  {
            list.add(new ArrayList<Integer>());
        }
        for (int[] i : edges) {
            List<Integer> l = list.get(i[0]);
            l.add(i[1]);
            //list.add(i[0], l);
            List<Integer> l1 = list.get(i[1]);
            l1.add(i[0]);
            //list.add(i[1], l1);
        }
        return list;
    }
}
