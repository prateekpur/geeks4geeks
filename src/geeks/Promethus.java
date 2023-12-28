package geeks;

public class Promethus {
    static boolean alive[];
    static int cntAlive;
    public static void main(String args[])  {
        long time = System.currentTimeMillis();
        int count = 1000000, skip = 3;
        alive = new boolean[count];
        cntAlive = count;
        for (int i = 0; i < count; ++i) {
            alive[i] = true;
        }
        findPos(count, 3);
        for (int i = 0; i < count; ++i) {
            if (alive[i])   {
                System.out.println(i+1);
            }
        }
        System.out.println("Time : " + (System.currentTimeMillis() - time));
        Runtime runtime = Runtime.getRuntime();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory : " + memory / (1024L * 1024L));
    }

    public static int findPos(int count, int skip)  {
        int pos = 0;
        int index = 0;
        while (cntAlive > 1)    {
            for (int j = 0; j <= skip; ++j)  {
                index = findNext((index) % alive.length);
                index++;
            }
            index--;
            alive[index++] = false;
            if (cntAlive % 35000000 == 0) {
                System.out.println(cntAlive);

            }
            index %= alive.length;
            while (!alive[index]) {
                index++;
                index %= alive.length;
            }
            pos = index;
            cntAlive--;
        }
        return index;
    }

    //find next alive person
    public static int findNext(int pos)    {
        for (int i = pos; i < alive.length; ++i)    {
            if (alive[i])   {
                return i;
            }
        }
        for (int i = 0; i < pos; ++i)   {
            if (alive[i])   {
                return i;
            }
        }
        return 0;
    }

    public static void printAlive() {
        StringBuffer buff = new StringBuffer();
        for (int i = 0; i < alive.length; ++i)  {
            buff.append(alive[i]);
            buff.append(",");
        }
        System.out.println(buff.toString());
    }
}
