package IMPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//2563 백준, 색종이2

public class BJ2567 {

	static int[][] board;
	static final int len = 10;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = stoi(br.readLine());
		board = new int[101][101];

		int ret = 0;

		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int sr = stoi(st.nextToken().trim()); // start row
			int sc = stoi(st.nextToken().trim()); // start col

			for (int r = sr; r < sr + len; r++) {
				for (int c = sc; c < sc + len; c++) {
					board[r][c] = 1;
				}
			}
		}
		
		for (int r = 0; r <= 100; r++) {
			for (int c = 0; c <= 100; c++) {
				if(board[r][c] == 1) {
					for (int i = 0; i < 4; i++) {
						int nx = r + dx[i];
						int ny = c + dy[i];
						if(nx >=0 && ny >=0 && nx <= 100 && ny <= 100
								&& board[nx][ny] == 0)
							ret++;
							
					}
				}
			}
		}
		
		
		
		System.out.println(ret);
	}
}
