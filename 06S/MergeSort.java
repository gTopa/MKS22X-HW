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

    public static void mergeSort(int[] data){
	data=mergeSortH(data,0,data.length/2,data.length/2,data.length);
    }

    public static int[] mergeSortH(int[] data, int startA, int endA, int startB, int endB){
	if (startA==endA&&startB==endB){
	    return merge(data,startA,endA,startB,endB);
	}else{
	    int[] data1=mergeSortH(data,startA,endA/2,endA/2+1,endA);
	    int[] data2=mergeSortH(data,startB,endB/2,endB/2+1,endB);
	    for (int i=0;i<data1.length;i++){
		data[i]=data1[i];
	    }
	    for (int i=0;i<data2.length;i++){
		data[i+startB]=data1[i];
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
}
