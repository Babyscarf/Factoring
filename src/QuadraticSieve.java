import java.lang.Math;
import java.util.ArrayList;
public class QuadraticSieve {

    public static void main(String[] args) {
	
	new QuadraticSieve();
}

public QuadraticSieve(){
	alg();
}

private void alg() {
	System.out.println("test");
	double bSmooth=2.0;
	
	}
public ArrayList<Integer> trial_division(int n){

    ArrayList<Integer> prime= new ArrayList<>();
    if(n<2) {
        prime.add(n);
        return prime;
    }
    int loop=(int)Math.sqrt(n) ;
    System.out.println(loop);
    for(int i=2; i<=loop; i++) {
        if (i * i > n)
            break;
        while(n % i==0){

            prime.add(i);
            n/=i;
        }
    }
    if(n>1)
        prime.add(n);

    System.out.println(prime.toString());
    return prime;
}
}