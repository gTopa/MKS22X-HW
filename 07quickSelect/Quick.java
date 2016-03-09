public class Quick{
    public static int partition(int[] data,int left, int right){
	int pos=(int)(Math.random()*data.length);
	int num=data[pos];
	data[pos]=data[data.length-1];
	data[data.length-1]=num;
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
	    data[data.length-1]=data[right];
	    data[right]=num;
	    return left;
	}else{
	    data[data.length-1]=data[right+1];
	    data[right+1]=num;
	    return left+1;
	}
    }
    
    public static int quickselect(int[] data,int k){
	return quickselect(data,k,0,data.length-1);
    }
    
    public static int quickselect(int[] data,int k,int left,int right){
	printArray(data);
	int pos=partition(data,left,right);
	System.out.println(pos);
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
	
