package jungol;

import java.util.Scanner;

public class JO1309 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n =sc.nextLong();
		long ret = factorial(n);
		System.out.println(ret);
		
	}

	
	static long factorial(long n) {
		if(n==0) return 1;
		if(n==1) {
			System.out.printf("%d! = %d\n", n,n);
			return n;
		}
		System.out.printf("%d! = %d * %d!\n", n,n,n-1);
		return n * factorial(n-1); 
	}
}
