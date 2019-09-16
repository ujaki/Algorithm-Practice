package day0717;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		
		for (int t = 1; t <= T; t++) {
			double sum =0 ;
			double[] arr = new double[10];
			for (int i = 0; i < 10; i++) {
				arr[i] = sc.nextDouble();
			}
			Arrays.sort(arr);
			for (int i = 1; i <= 8; i++) {
					sum += arr[i];
			}
//			sum = Math.round((double)sum / 8);
			
			System.out.println("#" + t + " " + Math.round((double)sum / 8));
		}

	}
}
