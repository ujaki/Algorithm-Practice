package ADPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//백준 15686, 치킨배달, 삼성기출
public class BJ15686 {
	static int N, M;
	static int[][] map;
	static int ret;
	static List<Position> home;
	static List<Position> chicken;
	static boolean[] picked;
	
	static class Position{
		int x;
		int y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = stoi(st.nextToken().trim());
		M = stoi(st.nextToken().trim());
		
		map = new int[N][N];
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = stoi(st.nextToken().trim());
				if(map[i][j] == 1) {
					home.add(new Position(i, j));
				}
				if(map[i][j] == 2) {
					chicken.add(new Position(i, j));
				}
			}
		}
		
		
		ret = Integer.MAX_VALUE;
		
		picked = new boolean[chicken.size()];
		dfs(0, 0);
		
		System.out.println(ret);
	}

	private static void dfs(int target, int cnt) {
		if(M == cnt) {
			int sum = 0;
			
			for (int i = 0; i < home.size(); i++) {
				int dis = Integer.MAX_VALUE;
				int hx = home.get(i).x;
				int hy = home.get(i).y;
				for (int j = 0; j < chicken.size(); j++) {
					if(picked[j]) {
						int cx = chicken.get(j).x;
						int cy = chicken.get(j).y;
						int minDis = Math.abs(hx - cx) + Math.abs(hy - cy);
//						System.out.println(minDis);
						dis = Integer.min(dis, minDis);
					}
				}
				sum += dis;
			}
			
			ret = Integer.min(ret, sum);
			return;
		}else if(target == chicken.size()) return;
		
		
		picked[target] = true;
		dfs(target + 1, cnt + 1);
		picked[target] = false;
		dfs(target + 1, cnt);
	}
}
