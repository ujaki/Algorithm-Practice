package day0826;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

//SWEA 5162 두가지 빵의 딜레마, D3
public class SWEA5162 {

	static int T;

	static int a, b, c;
	
	static int stoi(String s) {	return Integer.parseInt(s); }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());

		for (int t = 1; t <= T; t++) {
			int ret = 0;
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			a = stoi(st.nextToken().trim());
			b = stoi(st.nextToken().trim());
			c = stoi(st.nextToken().trim());
			
			
			if(a>b) {
				ret = c / b;
				c -= (b*ret);
				ret += c / a;
			}else if(a < b) {
				ret = c / a;
				c -= (a*ret);
				ret += c / b;
			}else {
				ret = c / a;
			}
			
			System.out.printf("#%d %s\n", t, ret);
			
		}
	}
}
