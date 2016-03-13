public class Quick{
    public static int partitionUnoptimized(int[] data,int left, int right){
	if (left==right){
	    return left;
	}
	int pos=(int)(Math.random()*(right-left+1))+left;
	int num=data[pos];
	int end=right;
	data[pos]=data[right];
	data[right]=num;
	right--;
	while(left!=right){
	    if(data[left]<=num){
		left++;
	    }else{
		int temp=data[left];
		data[left]=data[right];
		data[right]=temp;
		right--;
	    }
	}
	if(data[left]>num){
	    data[end]=data[right];
	    data[right]=num;
	    return left;
	}else{
	    data[end]=data[left+1];
	    data[left+1]=num;
	    return left+1;
	}
    }

    public static int[] partition(int[] data, int left, int right){
	int[] ans=new int[2];
	if (left==right){
	    ans[0]=left;
	    ans[1]=right;
	    return ans;
	}
	int pos=(int)(Math.random()*(right-left+1))+left;
	int num=data[pos];
	int[] copy=new int[data.length];
	for(int k=0;k<data.length;k++){
	    copy[k]=data[k];
	}
	int start=right;
	for(int i=left;i<=start;i++){
	    if(data[i]>num){
		copy[right]=data[i];
		right--;
	    }else if(data[i]<num){
		copy[left]=data[i];
		left++;
	    }
	}
	for(int j=left;j<=right;j++){
	    copy[j]=num;
	}
	for(int k=0;k<data.length;k++){
	    data[k]=copy[k];
	}
	ans[0]=left;
	ans[1]=right;
	return ans;
    }
    public static int quickselect(int[] data,int k){
	return quickselect(data,k,0,data.length-1);
    }
    
    public static int quickselect(int[] data,int k,int left,int right){
	int pos=partitionUnoptimized(data,left,right);
	if(pos==k){
	    return data[k];
	}else if(pos>k){
	    return quickselect(data,k,left,pos-1);
	}else{
	    return quickselect(data,k,pos+1,right);
	}	    
    }

    public static void quickSortUnoptimized(int[] data){
	quickSort(data,0,data.length-1);
    }

    public static void quickSortUnoptimized(int[] data, int left, int right){
	if(right-left>0){
	    int pos=partitionUnoptimized(data,left,right);
	    quickSort(data,left,pos-1);
	    quickSort(data,pos+1,right);
	}
    }

    public static void quickSort(int[] data){
	quickSort(data,0,data.length-1);
    }

    public static void quickSort(int[] data, int left, int right){
	if(right-left>0){
	    int[] pos=partition(data,left,right);
	    quickSort(data,left,pos[0]-1);
	    quickSort(data,pos[1]+1,right);
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

}
	
