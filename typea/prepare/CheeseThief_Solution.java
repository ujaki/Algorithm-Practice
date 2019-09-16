package typea.prepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CheeseThief_Solution {

	static int T; 
	static int N;
	static int[][] cheese; //치즈 상태
	static boolean[][] ate;
	
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine().trim());

		int ans = 0;
		for (int t = 1; t <= T; t++) {
			N = stoi(br.readLine().trim());
			cheese = new int[N][N];
			int ccnt = 0;
			ans = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < N; j++) {
					cheese[i][j] = stoi(st.nextToken().trim());
					if(cheese[i][j] != 0) ccnt++;
				}
			}//end input
			
			int group = 0;
			while(ccnt > group) {
				group = 0; //덩어리의 갯수 세기 전에 초기화
				ate = new boolean[N][N];

				for (int i = 0; i < N; i++) { //전체 돌면서 치즈덩어리 카운팅 하기
					for (int j = 0; j < N; j++) {
						if(cheese[i][j] > 0 && !ate[i][j]) {//덩어리 카운팅 안한 치즈 발견
							group++;
							dfs(0,0);
						}
					}
				}
				
				if(group > ans) ans = group;
				
				ccnt = 0;
				for (int i = 0; i < N; i++) { //전체 돌면서 치즈덩어리 카운팅 하기
					for (int j = 0; j < N; j++) {
						if(cheese[i][j] > 0) {//덩어리 카운팅 안한 치즈 발견
							cheese[i][j]--;
							ccnt++;
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n", t, ans);
		}

	}

	private static void dfs(int i, int j) {
		ate[i][j] = true;
		
		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			
			if(nx >= 0 && ny >=0 && nx < N && ny <N && !ate[nx][ny]) {
				dfs(nx,ny);
			}
		}
	}
}
