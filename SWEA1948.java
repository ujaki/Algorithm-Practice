import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//SWEA 1948 날짜 계산기, D2
public class SWEA1948 {
	static int T;
	static final int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int m1 = stoi(st.nextToken().trim());
			int d1 = stoi(st.nextToken().trim());
			int m2 = stoi(st.nextToken().trim());
			int d2 = stoi(st.nextToken().trim());
			
			int ret = 0;
			if(m1==m2) ret = (d2-d1+1);
			else {
				for (int i = m1+1; i < m2; i++) {
					ret += days[i];
				}
				ret += d2;
				ret += (days[m1] - d1) + 1;
			}
			
			System.out.printf("#%d %d\n", t,ret);
			
		}

	}

}
