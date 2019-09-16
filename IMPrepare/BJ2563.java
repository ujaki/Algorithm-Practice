package IMPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//2563 백준, 색종이

public class BJ2563 {

	static int[][] board;
	static final int len = 10;

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
			int sr = stoi(st.nextToken().trim()); //start row
			int sc = stoi(st.nextToken().trim()); //start col
			
			for (int r = sr; r < sr + len; r++) {
				for (int c = sc; c < sc + len; c++) {
					if(board[r][c] == 0) {
						board[r][c] = 1;
						ret++;
					}
				}
			}
			
		}
		
		//print board
//		for (int i = 1; i <= 100; i++) {
//			for (int j = 1; j <= 100; j++) {
//				System.out.print(board[i][j]);
//			}
//			System.out.println();
//		}
		
		System.out.println(ret);
	}
}
