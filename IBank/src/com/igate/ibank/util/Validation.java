package com.igate.ibank.util;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author trgl1
 *
 */
public class  Validation {

	public static boolean isTxtStringRangeValid(int minLength,int maxLength,String str){
		int size=str.length();
		if(maxLength==0){
			if(size<minLength)
				return false;
		}
		else {
			if(maxLength<minLength)
				return false;
			if(size<minLength && size>maxLength)
				return false;
		}
		return true;
		
//		String validateStrPatt="";
//		if(maxLength==0){
//			validateStrPatt="[A-Za-z]{"+minLength+",}";
//		}
//		else {
//			validateStrPatt="[A-Za-z]{"+minLength+","+maxLength+"}";
//		}
//		
//		Pattern patt=Pattern.compile(validateStrPatt);
//		Matcher match=patt.matcher(str);
//		
//		if(minLength>maxLength && maxLength!=0)
//			return false;
//		return  match.find();
	}
	public static boolean isTxtBoxEmpty(String str){
		return(str.length()==0);
	}
	public static boolean isPhoneNumValid(String phoneNumber){
		String phonePatt="^[0-9]{10}$";
		Pattern patt=Pattern.compile(phonePatt);
		Matcher match=patt.matcher(phoneNumber);
		return  match.find();
	}
	public static boolean isEmailValid(String email){
		String emailPatt="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern patt=Pattern.compile(emailPatt);
		Matcher match=patt.matcher(email);
		return  match.find();
	}
//	public static boolean isAmountNegative(double amt){
//		return(amt<=-1);
//	}
	public static boolean isAmountNegative(String amt) {
		String amtNegPatt="[-]";
		Pattern patt=Pattern.compile(amtNegPatt);
		Matcher match=patt.matcher(amt);
		return match.find(); 
	}
	
	public static boolean isUserNameValid(String uName){
		String userNamePatt="^[a-zA-Z0-9_]+$";
		Pattern patt=Pattern.compile(userNamePatt);
		Matcher match=patt.matcher(uName);
		return  match.find();
	}
	public static boolean isPANValid(String PAN){
		String panPatt="^[A-Z0-9]{10}$";
		Pattern patt=Pattern.compile(panPatt);
		Matcher match=patt.matcher(PAN);
		return  match.find();
	}
	
}
