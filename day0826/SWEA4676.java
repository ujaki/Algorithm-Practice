package day0826;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

//SWEA 4676 늘어지는 소리 만들기, D3
public class SWEA4676 {
	static int T;
	static int H;
	
	static int stoi(String s) {	return Integer.parseInt(s); }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] str = br.readLine().trim().split("");
			String zero = "";
			H = stoi(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			
			for (int h = 0; h < H; h++) {
				int pos = stoi(st.nextToken().trim());
				if(pos == 0) zero += '-';
				else {
					str[pos-1] += '-';
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append(zero);
			for (int i = 0; i < str.length; i++) {
				sb.append(str[i]);
			}
			System.out.printf("#%d %s\n", t, sb.toString());
			
		}
	}
}
