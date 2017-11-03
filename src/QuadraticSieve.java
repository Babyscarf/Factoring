
import java.util.ArrayList;

mport java.lang.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

import java.lang.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;


public class Pollard {
   static ArrayList<BigInteger> ans=new ArrayList<>();
    ArrayList<Integer> prim=new ArrayList<>();
    public static final BigInteger TWO=new BigInteger("2");
    public static SecureRandom random= new SecureRandom();//Handles bits up to 128, whereas Random class only handles bits up to 48


    public static void main(String[] args) {
        Pollard t = new Pollard();
        BigInteger n = new BigInteger("20");
        if (n.bitLength() > 66) {
            System.out.println("bigger than 66");
            System.exit(1);
        }
            while (true) {
                if (n.isProbablePrime(20)) {
                    ans.add(n);

                    System.out.println( ans.toString());
                    System.exit(1);
                }
                BigInteger answ = t.rh(n);
               // System.out.println(answ);
                ans.add(answ);
                System.out.println( ans.toString());
                n=n.divide(answ);
            }

           // System.out.println(n.divide(div) + " " + div);
            // System.out.println("false");
            // while( t.rh(n).compareTo(BigInteger.ZERO)==0)
            //   System.out.println("hej");  ;

    }

    public void getFactors(BigInteger n) {
        if(n.isProbablePrime(20))
            return;//prime
        else if(n.bitLength()>66)
        return;//"failure"


    }

    public BigInteger func(BigInteger a, BigInteger b, BigInteger n ){

        return  a.multiply(a).add(b).mod(n);
    }

    public BigInteger rh(BigInteger n) {
        BigInteger x=new BigInteger(n.bitLength(),random);
        BigInteger y=x;
        BigInteger rand=new BigInteger(n.bitLength(),random);
        BigInteger d= BigInteger.ONE;
       // BigInteger v=  x.abs().subtract(y).abs();
       // System.out.println("x:" + x + " y=" + y );
        //System.out.println(x.abs().subtract(y).abs());

            if(n.mod(TWO).equals(BigInteger.ZERO)) {

                //System.out.println("mod 2");
                return TWO;
            }
        while (d.compareTo(BigInteger.ONE)==0) {
            x = func(x, rand, n);
            y = func(y, rand, n);
            y = func(y, rand, n);
           // System.out.println("x= " + x + " y=" + y);
            d = x.abs().subtract(y).abs().gcd(n);
            System.out.println(d);

        }


           System.out.println(" d=" + d);
            // x=y;
           return d;
    }

/*public class QuadraticSieve {
    static ArrayList<Integer> prim = new ArrayList<>();
    public static void main(String[] args) {

        QuadraticSieve test = new QuadraticSieve();
        int bSmooth = test. b_Smooth();
        test.SieveOfEratosthenes(bSmooth);
        for(int i=1; i<prim.size(); i++){

           int value= test.Jacobi(87463,prim.get(i));
           if(value!=1) {
               prim.remove(i);
               i--;
           }
        }
        // test.trial_division(6720);

       System.out.println(prim.toString());


    }

    //Find factors when N is small
    public ArrayList<Integer> trial_division(int n) {

        ArrayList<Integer> prime = new ArrayList<>();
        if (n < 2) {
            prime.add(n);
            return prime;
        }
        int loop = (int) Math.sqrt(n);
        System.out.println(loop);
        for (int i = 2; i <= 52; i++) {
            if (i * i > n)
                break;
            while (n % i == 0) {
                // System.out.println("i:" + i);
                prime.add(i);
                n /= i;
            }
        }
        if (n > 1)
            prime.add(n);

        System.out.println(prime.toString());
        return prime;
    }


    // Find b-Smooth
    private int b_Smooth() {
        double input = 100000010;
        //  System.out.println("test");
        double bSmooth = Math.exp(Math.sqrt(Math.log(input) * Math.log(Math.log(input))) * 0.5);
        System.out.println("b: " + bSmooth);
        //if(bSmooth%)
        // System.out.println("mod: " + 47%47);
        return (int) bSmooth;


    }
        // Find all primes for p<bSmooth and store in the ArrayList
    private void SieveOfEratosthenes(int bSmooth) {
        boolean[] prime = new boolean[bSmooth + 1];

        System.out.println(prime.length);
        for (int i = 2; i < prime.length; i++)
            prime[i] = true;

        for (int factor = 2; factor * factor <= bSmooth; factor++) {

            if (prime[factor] == true) {
                for (int j = factor; j * factor <= bSmooth; j++) {
                    prime[factor * j] = false;

                }
            }
        }

            for (int k = 2; k <= bSmooth; k++) {
                if (prime[k])
                    prim.add(k);
            }
            System.out.println(prim.toString());
        }

    Determine if a number a is a quadratic residue to the modulus p, a^(p-1/2). If output
      is 1, then there is a perfect square such that there exist a x so x^2=a mod p.
      If output is -1 there is NO perfect square.
      Output 0 means that a|p. However, we'll ignore that output.
      We'll save all p that gives the output 1 and erase from the ArrayList given from
      SieveOfEratosthenes method otherwise

    public int Jacobi(int a, int n)
Precondition: a, n >= 0; n is odd 
    {
        int ans=0;
        if (a == 0)
            ans = (n==1) ? 1 : 0;
        else if (a == 2) {
            switch (n%8) {
                case 1:
                case 7:
                    ans = 1;
                    break;
                case 3:
                case 5:
                    ans = -1;
                    break;
            }
        }
        else if ( a >= n )
            ans = Jacobi(a%n, n);
        else if (a%2 == 0)
            ans = Jacobi(2,n)*Jacobi(a/2, n);
        else
            ans = (a%4 == 3 && n%4 == 3) ? -Jacobi(n,a) : Jacobi(n,a);
        return ans;
    }
//    public int Jacobi(int a,int b) {
//        if(b<=0 || (b % 2)==0)
//            return 0;
//       // a = a % b;
//        int j=1;
//        int temp=0;
//        if (a<0) {
//            a=-a;
//             if((b % 4)==3)
//                 j=-j;
//        }
//        while (a!=0) {
//            while ((a % 2)==0) {
//          Process factors of 2: Jacobi(2,b)=-1 if b=3,5 (mod 8) 
//                a = a/2;
//                if((b % 8)==3 || (b & 8)==5)
//                    j=-j;
//
//            }
//       Quadratic reciprocity: Jacobi(a,b)=-Jacobi(b,a) if a=3,b=3 (mod 4) 
//           // In other words, (a|n)= (n|a), unless a = n = 3 (mod 4), in which case (a|n) = -(n|a).
//          temp = a;
//          a = b;
//          b = temp;
//            System.out.println("a= " + a+ " b=" +b);
//            if((a % 4)==3 && (b % 4)==3)
//                j = -j;
//
//
//
//           // System.out.println(j);
//            a = a % b;
//            System.out.println("a%b=" + a);
//        }
//        if(b==1)
//            return j;
//         else
//             return 0;
//    }
//    Input: an integer n > 1.
//
//    Let A be an array of Boolean values, indexed by integers 2 to n,
//    initially all set to true.
//
//            for i = 2, 3, 4, ..., not exceeding √n:
//            if A[i] is true:
//            for j = i2, i2+i, i2+2i, i2+3i, ..., not exceeding n:
//    A[j] := false.
//
//    Output: all i such that A[i] is true.

 


*/


}
