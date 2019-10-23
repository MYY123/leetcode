package com.leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashTableTest {


	/**  ============== 202题目，Happy Number ===================
	 *
	 * Example:
	 Input: 19
	 Output: true
	 Explanation:
	 12 + 92 = 82
	 82 + 22 = 68
	 62 + 82 = 100
	 12 + 02 + 02 = 1
	 没有考虑到死循环那一点，这里用HashSet去重，这一点我一开始没考虑到
	 * @param n
	 * @return
	 */
	public static boolean isHappy(int num) {
		if(num==1) return true;
		Set<Integer> set = new HashSet<>();
		while(num>1) {
			int	 a = 0;
			int sum  = 0;
			while(num>0) {
				a = num%10;
				num = num/10;
				System.out.println(a);
				sum = sum+a*a;
			}
			if(sum==1) {
				return true;
			}

			if(!set.contains(sum))
			{
				set.add(sum);
			}
			else
			{
				break;
			}
			num = sum;
		}

		return false;

	}

	public int singleNumber(int[] nums)  {
		//测试git-123456
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
