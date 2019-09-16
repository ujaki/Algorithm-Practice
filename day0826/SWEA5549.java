package day0826;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

//SWEA 5549 홀수일까 짝수일까, D3
public class SWEA5549 {

	static int T;
	
	static int stoi(String s) {	return Integer.parseInt(s); }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());

		for (int t = 1; t <= T; t++) {
			String str = br.readLine().trim();
			int num = str.charAt(str.length()-1) - '0';
			if(num % 2 == 0) System.out.printf("#%d %s\n", t, "Even");
			else System.out.printf("#%d %s\n", t, "Odd");
		}
	}
}
