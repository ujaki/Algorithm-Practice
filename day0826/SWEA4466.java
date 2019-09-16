package day0826;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//SWEA 4466 최대 성적표 만들기, D3
public class SWEA4466 {
	static int T;
	static int N, K;
	static Integer[] nums;
	static int ret;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			nums = new Integer[N];

			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			
			//내림차순으로 정렬
			Arrays.sort(nums, Collections.reverseOrder());
//			System.out.println(Arrays.toString(nums));
			ret = 0;
			for (int i = 0; i < K; i++) {
				ret += nums[i];
			}
			
			System.out.printf("#%d %s\n", t, ret);

		}
	}
}
