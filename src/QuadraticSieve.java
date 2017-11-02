import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

public class QuadraticSieve {
    static ArrayList<Integer> prim = new ArrayList<>();
    public static void main(String[] args) {

        QuadraticSieve test = new QuadraticSieve();
        int bSmooth = test.alg();
        test.isPrime(bSmooth);
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



    private void isPrime(int bSmooth) {
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

    public QuadraticSieve() {
            //alg();
        }
//    Jacobi(a,n) {
//        j := 1
//        while (a not 0) do {
//            while (a even) do {
//                a := a/2
//                if (n = 3 (mod 8) or n = 5 (mod 8)) then j := -j
//            }
//            interchange(a,n)
//            if (a = 3 (mod 4) and n = 3 (mod 4)) then j := -j
//            a := a mod n
//        }
//        if (n = 1) then return (j) else return(0)
//    }
 public int Jacobi(int a, int n)
/* Precondition: a, n >= 0; n is odd */
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
//         /* Process factors of 2: Jacobi(2,b)=-1 if b=3,5 (mod 8) */
//                a = a/2;
//                if((b % 8)==3 || (b & 8)==5)
//                    j=-j;
//
//            }
//      /* Quadratic reciprocity: Jacobi(a,b)=-Jacobi(b,a) if a=3,b=3 (mod 4) */
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

    private int alg() {
        double input = 100000010;
        //  System.out.println("test");
        double bSmooth = Math.exp(Math.sqrt(Math.log(input) * Math.log(Math.log(input))) * 0.5);
        System.out.println("b: " + bSmooth);
        //if(bSmooth%)
        // System.out.println("mod: " + 47%47);
        return (int) bSmooth;


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
}
