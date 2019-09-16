package typea.prepare.day0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//SWEA 현주가 좋아하는 제곱근 놀이
public class SqrtPlay {
	static int T;
	static long ret;
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			long N = Long.parseLong(br.readLine().trim());
			ret = Long.MAX_VALUE;
			
			dfs(N, 0);
			
		
			System.out.printf("#%d %d\n", t , ret);
//			System.out.println();
		}
		
	}// end main

	private static void dfs(long n, long cnt) { 
//		System.out.println("n : " + n);
//		System.out.println("cnt : " + cnt);

		if(n == 2) {
			ret = cnt;
			return;
		}
		
		double tmp = Math.sqrt(n);
//		System.out.println("tmp : " + tmp);
		if((int)tmp == tmp) { //sqrt(n)이 정수가 되는 경우
			dfs((int)tmp, cnt + 1);
		}
		else {
			tmp = (int)tmp;
			cnt += ((tmp+1)*(tmp+1)-n);
			dfs((int)Math.sqrt((tmp+1)*(tmp+1)), cnt + 1);
		}
	}
}
