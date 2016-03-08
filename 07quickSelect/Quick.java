public class Quick{
    public static int partition(int[] data,int left, int right){
	int num=data[Math.Random()*data.length];
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
	    data[data.length-1]=data[right];
	    data[right]=num;
	    return left;
	}else{
	    data[data.length-1]=data[right+1];
	    data[right+1]=num;
	    return left+1;
	}
    }
}
	
