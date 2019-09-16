package day0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//SWEA 3408 세가지 합 구하기, D3
public class SWEA3408 {
	static int T;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());
		
//		(2n-1) * (2n) / 2 --> 4n2-2n / 2
//		(2n + 1) * (2n+2) / 2 --> 4n^2 + 6n +2
		//N * (2*A + (N-1)*D) / 2                 10 * 22 / 2
//		                                         10* (2 + 9*2) / 2
		for (int t = 1; t <= T; t++) {
			long N = Long.parseLong(br.readLine().trim());

			long s1 = (N * (N + 1)) / 2;
			long s2 = (N * (2 + (N-1) * 2) / 2); //홀수
			long s3 = (N * (4 + (N-1) * 2) / 2); //짝수
			
			//1 3 5 7 9 11 13 15 17
			System.out.printf("#%d %d %d %d\n", t, s1, s2, s3);
		}
	}
}
