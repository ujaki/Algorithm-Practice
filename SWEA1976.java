import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SWEA 1976 시각 덧셈, D2
public class SWEA1976 {
	static int T;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int h1 = stoi(st.nextToken().trim());
			int m1 = stoi(st.nextToken().trim());
			int h2 = stoi(st.nextToken().trim());
			int m2 = stoi(st.nextToken().trim());

			int rh = h1 + h2;
			int rm = m1 + m2;

			if (rh >= 12)
				rh -= 12;
			if (rm >= 60) {
				rm -= 60;
				rh++;
			}
			System.out.printf("#%d %d %d\n", t, rh, rm);
		}

	}

}
