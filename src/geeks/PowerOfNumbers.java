package geeks;

import java.math.BigInteger;

public class PowerOfNumbers {

    private static final BigInteger MODE_VALLUE = new BigInteger("1000000007");
    public static void main (String args[]) {
        //System.out.println(power(3296675, 5766923));
        System.out.println(power(12, 21));
    }

    static long power(int N,int R) {
        if (R == 0) {
            return 1;
        }
        BigInteger res = calcPower(BigInteger.valueOf(N), R);
        //java.math.BigInteger modulo = java.math.BigInteger.TEN.pow(9).add(new java.math.BigInteger("7"));
        return res.mod(new BigInteger("1000000007")).longValue();
    }

    static BigInteger calcPower (BigInteger n, int r) {
        if (r == 1) {
            return n;
        }   else {
            BigInteger tmp;
//            if (r%2 == 0)   {
//                tmp = calcPower(n, r/2);
//            }   else {
//                tmp = calcPower(n, (r-1)/2);
//            }
            tmp = calcPower(n, r/2);
            java.math.BigInteger pow;
            if (r%2 == 0)   {
                pow = tmp.mod(MODE_VALLUE).multiply(tmp.mod(MODE_VALLUE));
            }   else {
                pow = tmp.mod(MODE_VALLUE).multiply(tmp.mod(MODE_VALLUE)).multiply(n);
            }
            return pow.mod(MODE_VALLUE);
        }
    }

}
