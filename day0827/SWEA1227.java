package day0827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//SWEA 1227 미로2, D4
public class SWEA1227 {
//	static int T;
	static boolean able;
	static int[][] map;
	static boolean[][] visit;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	
//	static int stoi(String s) {	return Integer.parseInt(s); }

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		T = stoi(br.readLine());
		
		for (int t = 1; t <= 10; t++) {
			
			map = new int[100][100];
			visit = new boolean[100][100];
			
			int sx = 0;
			int sy = 0;
			
			String gabage = br.readLine();
			
			for (int i = 0; i < 100; i++) {
				String nums = br.readLine().trim();
				for (int j = 0; j < 100; j++) {
					map[i][j] = nums.charAt(j) - '0'; 
					if(map[i][j] == 2) {
						sx = i;
						sy = j;
					}else if(map[i][j] == 1) {
						visit[i][j] = true;
					}
				}
			}
			
			able = false;
			dfs(sx, sy);
			
			int ret = able ? 1 : 0;
			
			bw.write("#" + t + " " + ret + "\n");
			bw.flush();
		}
		bw.close();
	}

	private static void dfs(int sx, int sy) {
		if(map[sx][sy] == 3) {
			able = true;
			return;
		}
		
		visit[sx][sy] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = sx + dx[i];
			int ny = sy + dy[i];
			
			if(nx >= 0 && ny >=0 && nx < 100 && ny < 100 && !visit[nx][ny])
				dfs(nx, ny);
		}
	}

	
}
