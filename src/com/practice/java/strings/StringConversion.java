/**
 * 
 */
package com.practice.java.strings;

/**
 * @author mihir
 *
 */
public class StringConversion {
	
	public String reverse(String source){
		char[] chars = new char[(2 * source.length())+1];
		System.out.println(chars.length);
		
		int j=0;
		chars=source.toCharArray();
		
		System.out.println(chars.length);
		System.out.println(source.length());
		
		for (int i = chars.length-1; i>=(source.length()-1); i--) {
			chars[i]=chars[j];
			System.out.println(chars[i]);
			chars[j]='\0';
			j++;			
		}
		source=String.valueOf(chars);
		return source;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(new StringConversion().reverse("mihir"));
	}

}
