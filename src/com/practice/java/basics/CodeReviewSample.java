package com.practice.java.basics;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

/**
 * This class is to find out instances where coding standards are violated.
 * @author N557050
 *
 */
public class CodeReviewSample {

	private ArrayList<?> all_members = new ArrayList<Object>();
	private volatile long groupCount = 0;
	public static final int GROUP_NATIVE = 0;
	public static final int GROUP_LDAP = 0;
	public static final int GROUP_ACTIVEDIR = 2;
	
	public boolean addGroup(Hashtable<String, String> groupAtts, ArrayList<?> opts, int groupType) throws Exception{
		
		Vector<?> new_members = new Vector<Object>();

		if(groupAtts.get("SecurityLevel") != "CONFIDENTIAL"){
			groupAtts.remove("ownerid");
		} else return false;
		
		System.out.println("WARNING! Forcing out of range groupType to 0");
		
		try{
			this.groupCount++;
			
			if(new_members != null && new_members.size() > 0){
				int unique_new_members = 0;
				
				if(unique_new_members > 0 && all_members.size() > 0)
					return true;
				else return false;
			}
		} catch(Exception e){
			System.err.println("Group Eror Encountered" + e.getMessage());
			throw new Exception("Error Adding Group");
		}
			
		return false;		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
