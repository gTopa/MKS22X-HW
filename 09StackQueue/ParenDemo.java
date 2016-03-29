import java.util.*;

public class ParenDemo{
    
    public static boolean isMatching(String input){
	try{
	    MyStack<String> open=new MyStack<String>();
	    for(int i=0;i<input.length();i++){
		if(input.charAt(i)=='('||input.charAt(i)=='['||input.charAt(i)=='{'||input.charAt(i)=='<'){
		    open.push(""+input.charAt(i));
		}else{
		    if(input.charAt(i)==')'){
			if(!open.pop().equals("(")){
			    return false;
			}		
		    }else if(input.charAt(i)==']'){
			if(!open.pop().equals("[")){
			    return false;
			}
		    }else if(input.charAt(i)=='}'){
			if(!open.pop().equals("{")){
			    return false;
			}
		    }else if(input.charAt(i)=='>'){
			if(!open.pop().equals("<")){
			    return false;
			}
		    }
		}
	    }
	    return true;
	}catch(NoSuchElementException e){
	    return false;
	}
    }

    public static void main(String[]args){
	String input = "()()(([[]]))";
	if(args.length > 0){
	    input = args[0];
	    System.out.println( isMatching(input)); 
	}else{
	    System.out.println("Usage:"); 
	    System.out.println("java ParenDemo \"text\""); 
	}
	
    }
}
