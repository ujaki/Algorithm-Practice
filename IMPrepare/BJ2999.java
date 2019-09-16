package IMPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//2999 백준,  비밀 이메일

public class BJ2999 {

	static char[][] decode;
	static int R;
	static int C;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String msg = br.readLine().trim();

		int N = msg.length(); // msg 길이(글자 수)

		if (N == 0)
			System.out.println();
		else if (N == 1)
			System.out.println(msg);
		else {
			R = 0;
			C = 0;
			// R<=C이고, R*C=N
			// find r, c
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					if (r * c == N) {
						if (!(r > c)) {
							R = r;
							C = c;
						}
					}
				}
			}

			decode = new char[R][C];

			// write recived msg
			int idx = 0;
			for (int i = 0; i < C; i++) {
				for (int j = 0; j < R; j++) {
					decode[j][i] = msg.charAt(idx++);
				}
			}

			// decoding
			if (R == 1) { // N이 소수이면
				System.out.println(msg);
			} else {
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						sb.append(decode[i][j]);
					}
				}
				System.out.println(sb.toString());
			}

		}

	}
}
