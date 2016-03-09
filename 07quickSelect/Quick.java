public class Quick{
    public static int partition(int[] data,int left, int right){
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
    
    public static int quickselect(int[] data,int k){
	return quickselect(data,k,0,data.length-1);
    }
    
    public static int quickselect(int[] data,int k,int left,int right){
	int pos=partition(data,left,right);
	if(pos==k){
	    return data[k];
	}else if(pos>k){
	    return quickselect(data,k,left,pos-1);
	}else{
	    return quickselect(data,k,pos+1,right);
	}	    
    }
    
    public static void printArray(int[] data){
	for (int i=0;i<data.length;i++){
	    System.out.print(data[i]+" ");
	}
	System.out.println();
    }

}
	
