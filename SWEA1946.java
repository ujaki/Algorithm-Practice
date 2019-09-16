import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//SWEA 1948 간단한 압축 풀기, D2
public class SWEA1946 {
	static int T;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = stoi(br.readLine());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				char alpha = st.nextToken().trim().charAt(0);
				int n = stoi(st.nextToken().trim());
				for (int j = 0; j < n; j++) {
					sb.append(alpha);
				}
			}

			String ret = sb.toString();
			
//			System.out.println("---"+ret.toString()+"---");
			System.out.printf("#%d", t);
			int idx = 0;
//			System.out.println("length : " + ret.length());
			for (int i = 0; i < ret.length(); i++) {
				if(idx % 10 == 0) System.out.println();
				if(i == ret.length()-1) System.out.print(ret.charAt(i));
				else System.out.print(ret.charAt(i));
				idx++;
			}
			System.out.println();
			
		}

	}

}
