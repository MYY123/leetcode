package com.leetcode.hashtable;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashTable {


	/**  ============== 202题目，Happy Number ===================
	 *
	 * Write an algorithm to determine if a number is "happy".
	 *
	 * A happy number is a number defined by the following process:
	 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
	 * and repeat the process until the number equals 1 (where it will stay),
	 * or it loops endlessly in a cycle which does not include 1.
	 * Those numbers for which this process ends in 1 are happy numbers.
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

	/**
	 * 计算小于非负数n的素数
	 * @param n
	 * @return
	 * Example:
	 *
	 * Input: 10
	 * Output: 4
	 * Explanation: There are 4 prime numbers less than 10,
	 * they are 2, 3, 5, 7.
	 */
	@Test
	public void testCountPrimes(){
		System.out.println("222222");
		System.out.println(countPrimes(15));
	}

	/**
	 * 出现的问题：Time Limit Exceeded
	 * Details
	 * @param n
	 * @return
	 */
	public int countPrimes(int n){
		if(n==2) return 0;

		int sum = 0;
		boolean flag = true;
		for (int i = 2; i <n ; i++) {
			if(i==2){
				sum = sum+1;
				continue;
			}
			flag = true;
			for (int j = 2; j <i ; j++) {
				if(i%j==0){
					flag = false;
					break;//不是质数
				}
			}
			if(flag){
				sum = sum+1;
			}

		}
		return sum;
	}

	/**
	 * 参考的其他人答案，主要的问题是：1，没有理解质数的另外一种求法
	 * 								   2，并没有用到hashTable数据结构
	 * @param n
	 * @return
	 */
	public int countPrimes_Plus(int n) {
		if(n<=1) return 0;
		boolean[] isPrime = new boolean[n];
		for(int i = 2; i<isPrime.length; i++){
			isPrime[i] = true;
		}

		for(int i = 2; i<isPrime.length; i++){

			if(isPrime[i]){
				for(int k =2; i*k<isPrime.length; k++){
					isPrime[i*k] =false;
				}
			}
		}
		int count = 0;
		for(boolean i : isPrime){
			if(i)count++;
		}
		return count;
	}
}
