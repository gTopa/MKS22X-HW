public class Recursion implements hw01{
    public String name(){
	return "Topa,Giovanni";
    }
    public double sqrt(double n){
	if (n<0){
	    throw new IllegalArgumentException();
	}else{
	    return sqrt(n,1);
	}
    }
    public double sqrt (double n, double guess){
	if (guess*guess/n<1.00000001&&guess*guess/n>.99999999){
	    return guess;
	}else{
	    return sqrt(n,(n/guess+guess)/2);
	}
    }
}
