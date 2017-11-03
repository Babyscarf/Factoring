import sun.swing.BakedArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

public class Pollard {
  //  ArrayList<BigInteger> ans=new ArrayList<>();

    static final BigInteger TWO=new BigInteger("2");
    SecureRandom random= new SecureRandom();//Handles bits up to 128, whereas Random class only handles bits up to 48
    ArrayList<BigInteger> arr=new ArrayList<>();


    public static void main(String[] args) throws IOException {
        new Pollard();


    }
        public Pollard() throws IOException {
            solveProblem();
        }

        public void solveProblem() throws IOException {
        BufferedReader br= new BufferedReader(new FileReader("test.txt"));
       // BigInteger n = new BigInteger(br.readLine());
            String input="";
        while((input=br.readLine())!=null) {
            BigInteger n = new BigInteger(input);
            arr = compositeFactor(n);
            if(arr.size()==0)
                System.out.println("Fail");
          else    for (int i = 0; i < arr.size(); i++) {
                System.out.println(arr.get(i));
            }
          //  n = new BigInteger(br.readLine());
            arr=new ArrayList<BigInteger>();
            System.out.println();
        }
        }

//        if (n.bitLength() > 66) {
//            System.out.println("bigger than 66");
//            System.exit(1);
//        }
//            while (true) {
//                if (n.isProbablePrime(20)) {
//                    ans.add(n);
//                    System.out.println( "prime");
//                    System.out.println( ans.toString());
//                    System.exit(1);
//                }
//                BigInteger answ = t.rh(n);
//
//               // System.out.println(answ);
//                ans.add(answ);
//                System.out.println("List: " + ans.toString());
//                n=n.divide(answ);
//                if(n.compareTo(BigInteger.ONE)==0) {
//                    System.out.println("N=1");
//                    break;
//                }
//            }

           // System.out.println(n.divide(div) + " " + div);
            // System.out.println("false");
            // while( t.rh(n).compareTo(BigInteger.ZERO)==0)
            //   System.out.println("hej");  ;



    public ArrayList<BigInteger> compositeFactor(BigInteger n){


        if(n.compareTo(BigInteger.ONE)==0) {

           return arr;

        }
        if (n.bitLength() > 66) {

            return arr;
        }

            if (n.isProbablePrime(20)) {
                arr.add(n);
                return arr;
            }
            BigInteger answ = rh(n);

        compositeFactor(answ);
        compositeFactor(n.divide(answ));
            return arr;
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
           // System.out.println("X= " + x);
            y = func(y, rand, n);
            //System.out.println("Y1= " + y);
            y = func(y, rand, n);
           // System.out.println("Y2= " + y);
          // System.out.println("x= " + x + " y=" + y);
            d = x.abs().subtract(y).abs().gcd(n);
          //  System.out.println(d);

        }


           //System.out.println(" d=" + d);
            // x=y;
           return d;
    }

//    public int gcd(int a, int n) {
//
//        if (n == 0)
//            return a;
//        return gcd(n, a % n);
//
//    }

 /*   public int f(int x, int y) {
        return (x * x + 1) % y;
    }
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



*/
}