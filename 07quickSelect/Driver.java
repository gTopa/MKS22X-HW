import java.util.*;
public class Driver{
    public static void main(String[]args){
	Random r1=new Random();
	int[] a1=new int[4000000];
	for(int i=0;i<a1.length;i++){
	    a1[i]=(int)(Math.random()*4);
	}
	int[] a2=new int[4000000];
	for(int i=0;i<a1.length;i++){
	    a1[i]=a2[i];
	}
	int[] a3=new int[4000000];
	for(int i=0;i<a1.length;i++){
	    a1[i]=a3[i];
	}
	int[] b1=new int[4000000];
	for(int i=0;i<b1.length;i++){
	    a1[i]=r1.nextInt();
	}
	int[] b2=new int[4000000];
	for(int i=0;i<b1.length;i++){
	    a1[i]=a2[i];
	}
	int[] b3=new int[4000000];
	for(int i=0;i<b1.length;i++){
	    a1[i]=a3[i];
	}
	long startTimea = System.nanoTime();
	Arrays.sort(a1);
	long endTimea = System.nanoTime();
	long durationa = (endTimea - startTimea);
	long startTimeb = System.nanoTime();
	Quick.quickSortUnoptimized(a2);
	long endTimeb = System.nanoTime();
	long durationb = (endTimeb - startTimeb);
	long startTimec = System.nanoTime();
	Quick.quickSort(a3);
	long endTimec = System.nanoTime();
	long durationc = (endTimec - startTimec);
	System.out.println("Arrays.sort small: "+durationa);
	System.out.println("quicksortunoptimized small: "+durationb);
	System.out.println("quicksort small: "+durationc);
	long startTimea1 = System.nanoTime();
	Arrays.sort(b1);
	long endTimea1 = System.nanoTime();
	long durationa1 = (endTimea1 - startTimea1);
	long startTimeb1 = System.nanoTime();
	Quick.quickSortUnoptimized(b2);
	long endTimeb1 = System.nanoTime();
	long durationb1 = (endTimeb1 - startTimeb1);
	long startTimec1 = System.nanoTime();
	Quick.quickSort(b3);
	long endTimec1 = System.nanoTime();
	long durationc1 = (endTimec1 - startTimec1);
	System.out.println("Arrays.sort: "+durationa1);
	System.out.println("quicksortunoptimized: "+durationb1);
	System.out.println("quicksort: "+durationc1);
    }
}
