package typea.prepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SuJiTravel {

	static int T;
	static char[][] island;
	static int R;
	static int C;
	static boolean[] visited;
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Loaction{
		int x;
		int y;
		char p;
		
		public Loaction(int x, int y, char p) {
			this.x = x;
			this.y = y;
			this.p = p;
		}
	}
	
	static int ret;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			R = stoi(st.nextToken().trim());
			C = stoi(st.nextToken().trim());
			
			island = new char[R+1][C+1];
			visited = new boolean[26];
			
			for (int r = 1; r <= R; r++) {
				String s = br.readLine().trim();
				for (int c = 1; c <= C; c++) {
					island[r][c] = s.charAt(c-1);
				}
			}
			
			ret = Integer.MIN_VALUE;
			
			dfs(1,1,1);
			
			
			System.out.printf("#%d %d\n",t , ret);
		}
	}

	private static void dfs(int sx, int sy, int cnt) {
		ret = Integer.max(ret,cnt);
		
		if(cnt == 26) return;
		
		visited[island[sx][sy] - 'A'] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = sx + dx[i];
			int ny = sy + dy[i];
			
			if(nx <= 0 || ny <= 0 || nx > R ||ny > C) continue;
			if(visited[island[nx][ny] - 'A']) continue;
		
			else {
				dfs(nx, ny, cnt + 1);
			}
		}
		visited[island[sx][sy] - 'A'] = false;
	}



}
