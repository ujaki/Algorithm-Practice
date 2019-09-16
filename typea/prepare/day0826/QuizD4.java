package typea.prepare.day0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;


//SWEA 퀴즈 D4
public class QuizD4 {
						   
	static final int div = 1000000007;
	static int T, N;
	static long ret;
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = stoi(br.readLine().trim());
			
			int temp = N;
			List<Integer> list = new LinkedList<>();
			//소인수분해
			for (int i = 2; i <= temp; i++) {
				while(temp % i == 0) {
					temp /= i;
					list.add(i);
				}
			}
			
			System.out.println(list);
			
			BigInteger ret = BigInteger.ZERO;
			BigInteger mul = BigInteger.ONE;
			
			for (int i = 0; i < list.size(); i++) {
				
				mul= mul.multiply(BigInteger.valueOf(list.get(i)).pow(N));
				
//				for (int j = 1; j <= i; j++) {
//					mul = mul.multiply(BigInteger.valueOf(i));
////					System.out.println(mul.toString());
//				}
				ret = ret.add(mul);
				
			}
//			System.out.println(ret.toString());
			BigInteger[] results = ret.divideAndRemainder(BigInteger.valueOf(div));
//			System.out.println(results.length);
//			System.out.println("mok : " + results[0]);
//			System.out.println("remain : " + results[1]);
			System.out.printf("#%d %d\n", t , results[1]);
//			System.out.println();
		}
		
	}// end main
}
