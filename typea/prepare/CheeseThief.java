package typea.prepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class CheeseThief {

	static int T;
	static int N;
	static int[][] cheese;
	static boolean[][] ate;
	
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

		
	static class Info{
		int x;
		int y;
		int day;
		
		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Info(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
		
		@Override
		public String toString() {
			return day +" : ("+x+","+y+")";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine().trim());

		for (int t = 1; t <= T; t++) {
			int ret = 0;
			N = stoi(br.readLine().trim());
			cheese = new int[N][N];
			
			Map<Integer, LinkedList<Info>> map = new TreeMap<>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < N; j++) {
					cheese[i][j] = stoi(st.nextToken().trim());
					if(!map.containsKey(cheese[i][j])) {
						map.put(cheese[i][j], new LinkedList<Info>());
						map.get(cheese[i][j]).add(new Info(i, j, cheese[i][j]));
					}else {
						map.get(cheese[i][j]).add(new Info(i, j, cheese[i][j]));
					}
				}
			}//end input
			
			
			
			
			for (LinkedList<Info> info : map.values()){
				
				for (int i = 0; i < info.size(); i++) {
//					System.out.println(info.get(i));
					//해당 요일 치즈 먹기
					Info c = info.get(i);
					cheese[c.x][c.y] = -1; 
				}
				//치즈 먹은 후 치즈 덩어리 새기
				//bfs
				ate = new boolean[N][N];
				markAte();
//				printCheese();
				int cnt = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(!ate[i][j]) {
							//bfs
							Queue<Info> qu = new LinkedList<>();
							qu.add(new Info(i,j));
							ate[i][j] = true;
							while(!qu.isEmpty()) {
								Info in = qu.poll();
								
								for (int k = 0; k < 4; k++) {
									int nx = in.x + dx[k];
									int ny = in.y + dy[k];
									
									if(nx >= 0 && ny >=0 && nx < N && ny <N && !ate[nx][ny]) {
										qu.add(new Info(nx,ny));
										ate[nx][ny] = true;
									}
									
								}
							}
							cnt++;
						} //end if
					}
				} // end count
				
//				System.out.println("cnt : " + cnt);
				ret = Integer.max(cnt, ret);
			}
			if(ret == 0)
				ret = 1;
			System.out.printf("#%d %d\n", t, ret);
		}

	}

	private static void printCheese() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(cheese[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void markAte() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(cheese[i][j] == -1)
					ate[i][j] = true;
			}
		}
	}

}
