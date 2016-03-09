public class MergeSort{
    
    public static int[] merge(int[] data, int startA, int endA, int startB, int endB){
	int start=startA;
	int[] dataMerged=new int[endB-startA+1];
	int c=0;
	while(startA<=endA&&startB<=endB){
	    if(data[startA]>data[startB]){
		dataMerged[c]=data[startB];
		c++;
		startB++;
	    }else{
		dataMerged[c]=data[startA];
		c++;
		startA++;
	    }
	}
	while(c<dataMerged.length){
	    if (startA>endA){
		dataMerged[c]=data[startB];
		c++;
		startB++;
	    }else{
		dataMerged[c]=data[startA];
		c++;
		startA++;
	    }
	}
	for (int i=0;i<dataMerged.length;i++){
	    data[i+start]=dataMerged[i];
	}
	return data;
    }

    public static void mergesort(int[] data){
	data=mergeSortH(data,0,data.length/2,data.length/2+1,data.length-1);
    }

    public static int[] mergeSortH(int[] data, int startA, int endA, int startB, int endB){
	if (startA==endA&&startB==endB){
	    return merge(data,startA,endA,startB,endB);
	}else if(startA==endA){
	    int[] data1=mergeSortH(data,startB,(endB-startB)/2+startB,(endB-startB)/2+startB+1,endB);
	    for(int i=startB;i<=endB;i++){
		data[i]=data1[i];
	    }
	    return merge(data,startA,endA,startB,endB);
	}else if(startB==endB){
	    int[] data2=mergeSortH(data,startA,(endA-startA)/2+startA,(endA-startA)/2+startA+1,endA);
	    for(int i=startA;i<=endA;i++){
		data[i]=data2[i];
	    }
	    return merge(data,startA,endA,startB,endB);
	}else{
	    int[] data1=mergeSortH(data,startA,(endA-startA)/2+startA,(endA-startA)/2+startA+1,endA);
	    int[] data2=mergeSortH(data,startB,(endB-startB)/2+startB,(endB-startB)/2+startB+1,endB);
	    for (int i=startA;i<=endA;i++){
		data[i]=data1[i];
	    }
	    for (int j=startB;j<=endB;j++){
		data[j]=data2[j];
	    }
	    return merge(data,startA,endA,startB,endB);
	}
    }

    public static void printArray(int[] data){
	for (int i=0;i<data.length;i++){
	    System.out.print(data[i]+" ");
	}
	System.out.println();
    }
    public static String name(){
	return "7,Topa,Giovanni";  
    }
    public static void insertionSort(int[] data){
	int temp=0;
	for(int i=1;i<data.length;i++){
	    temp=data[i];
	    data[shift(i,data)]=temp;
	    //printArray(data);
	}
    }
    public static int shift(int pos, int[] data){
	int temp=data[pos];
	for (int i=pos-1;i>=0;i--){
	    if(data[i]>temp){
		data[i+1]=data[i];
	    }else{
		return i+1;
	    }
	}
	return 0;
    }
    public static void selectionSort(int[] data){
	for (int start=0;start<data.length-1;start++){
	    int min=Integer.MAX_VALUE;
	    int pos=0;
	    for (int i=start;i<data.length;i++){
		if(data[i]<min){
		    min=data[i];
		    pos=i;
		}
	    }
	    data[pos]=data[start];
	    data[start]=min;
	    // printArray(data);
	}
    }
    public static void bubbleSort(int[] data){
	int i=0;
	int temp=0;
	while (i<data.length-2){
	    for(int pos=0;pos<data.length-i-1;pos++){
		if (data[pos]>data[pos+1]){
		    temp=data[pos];
		    data[pos]=data[pos+1];
		    data[pos+1]=temp;
		}
	    }
	    i++;
	    //printArray(data);
	}
    }
    public static void fillRandom(int[] ary){
	for (int i=0;i<ary.length;i++){
	    ary[i]=(int)(Math.random()*Integer.MAX_VALUE);
	}
    }
    public static void swap(int[] ary, int i, int a){
	int temp=ary[i];
	ary[i]=ary[a];
	ary[a]=temp;
    }

}
