

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

public class Pollard {


    static final BigInteger TWO = new BigInteger("2");
    SecureRandom random = new SecureRandom();//Handles bits up to 128, whereas Random class only handles bits up to 48
    ArrayList<BigInteger> arr = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        new Pollard();


    }

    public Pollard() throws IOException {
        solveProblem();
    }

    public void solveProblem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        while ((input = br.readLine()) != null) {
            BigInteger n = new BigInteger(input);
            arr = compositeFactor(n);
            if (arr.size() == 0)
                System.out.println("fail");
            else for (int i = 0; i < arr.size(); i++) {
                System.out.println(arr.get(i));
            }

            arr = new ArrayList<BigInteger>();
            System.out.println();
        }
    }


    public ArrayList<BigInteger> compositeFactor(BigInteger n) {


        if (n.compareTo(BigInteger.ONE) == 0) {

            return arr;

        }
        if (n.bitLength() > 79) {

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


    public BigInteger func(BigInteger a, BigInteger b, BigInteger n) {

        return a.multiply(a).add(b).mod(n);
    }

    public BigInteger rh(BigInteger n) {
        BigInteger x = new BigInteger(n.bitLength(), random);
        BigInteger y = x;
        BigInteger rand = new BigInteger(n.bitLength(), random);
        BigInteger d = BigInteger.ONE;


        if (n.mod(TWO).equals(BigInteger.ZERO)) {


            return TWO;
        }
        while (d.compareTo(BigInteger.ONE) == 0) {
            x = func(x, rand, n);

            y = func(y, rand, n);

            y = func(y, rand, n);

            d = x.abs().subtract(y).abs().gcd(n);


        }


        return d;
    }

}