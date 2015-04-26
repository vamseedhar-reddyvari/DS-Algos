/*
 * This class is an implementation of StringBuilder class of java.
 * This will be useful when we need to perform operations of String
 * without much complexity. I am using Arrays to implement this class.
 * Features:
 * The capacity automatically doubles when we run out of space
 * Caveats:
 * This is not thread safe. This helps in efficient implementation
 */
import java.math.*;
public class MyStringBuilder {
	private int capacity; // default capacity
	private int size;
	private char []stringData;
	public MyStringBuilder(){
		//Constructor start with empty string
		capacity = 5; //default
		size = 0;
		stringData = new char[capacity];
	}
	public int insert(int position, String s){
		// Can insert a string at any position of current string
		int len = s.length();
		if(position >size) return -1;
		else{
			if(size+len>capacity) {
				doubleCapacity(size+len);
			}
			//Shift existing data
			for(int i=size-1;i>=position;i--){
				stringData[i+len] = stringData[i];
			}
			//Copy the new data
			for(int i=position;i<position+len;i++){
				stringData[i] = s.charAt(i-position);
			}
			//update the length of appended string
			size = size + len;
			return 0;
		}

	}
	private void doubleCapacity(int minlength){
		
		capacity = 2*capacity;
		if(capacity < minlength) capacity = minlength;
		char []tempStringData = new char[2*capacity];
		for(int i=0;i<size;i++){
			tempStringData[i] = stringData[i];
		}
		stringData = tempStringData;
	}

	public void append(String s){
		insert(size,s);

	}
	public String toString(){
		String str = new String(stringData,0,size);
		return str;
	}

	public static void main(String []args){
		MyStringBuilder testStr = new MyStringBuilder();
		testStr.append("va");
		System.out.println(testStr);
		testStr.append("ms");
		System.out.println(testStr);
		testStr.append("eedhar Reddyvari Raja");
		System.out.println(testStr);
		testStr.insert(10," Reddy");
		System.out.println(testStr);

	}
}

