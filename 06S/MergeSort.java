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
}