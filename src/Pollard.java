import java.lang.Math;
import java.util.ArrayList;

import java.lang.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

public class Pollard{
    ArrayList<Integer> prim=new ArrayList<>();
    public static final BigInteger TWO=new BigInteger("2");
    public static SecureRandom random= new SecureRandom();//Handles bits up to 128, whereas Random class only handles bits up to 48


    public static void main(String[] args) {
        Pollard t=new Pollard();
        BigInteger n= new BigInteger("256");
        if(n.isProbablePrime(20)) {
            System.out.println("true");
            System.exit(1);
        }
            // getFactors();
        else if(n.bitLength()>66){
            System.out.println("bigger than 66");
            System.exit(1);


        }
        BigInteger div = t.rh(n);
        System.out.println(n.divide(div) + " " + div);
    }


    public void getFactors(BigInteger n) {
        if(n.isProbablePrime(20))
            return;//prime
        else if(n.bitLength()>66)
        	return;//"failure"x
    }

    public BigInteger func(BigInteger a, BigInteger b, BigInteger n ){
        return  a.multiply(a).add(b).mod(n);
    }
    
    public BigInteger g(BigInteger x, BigInteger n) {
    	return x.multiply(x).add(BigInteger.ONE).mod(n);
    }

    public BigInteger rh(BigInteger n) {
        BigInteger x = new BigInteger("2");
        BigInteger y = new BigInteger("2");
        BigInteger rand = new BigInteger(n.bitLength(),random);
        BigInteger d = BigInteger.ONE;
       // BigInteger v=  x.abs().subtract(y).abs();
       // System.out.println("x:" + x + " y=" + y );
        //System.out.println(x.abs().subtract(y).abs());

        if(n.mod(TWO).equals(BigInteger.ZERO)) {
            System.out.println("mod 2");	
            return TWO;
        }
        while (d.compareTo(BigInteger.ONE)==0) {
//            x = func(x, rand, n);
//            y = func(y, rand, n);
//            y = func(y, rand, n);
        	x = g(x, n);
        	y = g(g(y, n), n);
        	System.out.println("x= " + x + " y=" + y);
            d = x.subtract(y).abs().gcd(n);
            System.out.println(d);

        }
       System.out.println(" d=" + d);
        // x=y;
       return d;
    }
}
