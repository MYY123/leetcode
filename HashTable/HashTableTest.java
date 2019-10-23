package com.leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashTableTest {

	public int singleNumber(int[] nums)  {
		//测试git
		Set<Integer> numSet = new HashSet<Integer>();
	    for(int x: nums){
	    if(numSet.add(x) == false)
	        numSet.remove(x);
	       
	    }
	    Iterator<Integer> iter = numSet.iterator();
	    int answer = iter.next();
	    return answer;
        
    }
}
