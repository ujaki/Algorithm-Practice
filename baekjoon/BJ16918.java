package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 16918, 봄버맨
public class BJ16918 {
	static int R, C, N;

	static char[][] map;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static class Bomb {
		int r;
		int c;
		int sec;
		
		public Bomb(int r, int c) {
			super();
			this.r = r;
			this.c = c;
			this.sec = 0;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		R = stoi(st.nextToken().trim());
		C = stoi(st.nextToken().trim());
		N = stoi(st.nextToken().trim());
		
		map = new char[R][C];
		List<Bomb> bombs = new ArrayList<>();
		
		int second = 1;
		
		for (int r = 0; r < R; r++) {
			String line = br.readLine().trim();
			for (int c = 0; c < C; c++) {
				map[r][c] = line.charAt(c);
				if(map[r][c] == 'O')
					bombs.add(new Bomb(r,c));
			}
		}
		
		while(second != N) {
//			printMap(second, bw);
//			System.out.println();
			if(second % 2 == 1) {
				List<Bomb> blist = new ArrayList<>();
				
				for (int i = 0; i < bombs.size(); i++) {
					if(bombs.get(i).sec + 1 == 1) {
						bombs.get(i).sec++;
						blist.add(bombs.get(i));
					}else if(bombs.get(i).sec + 1 == 2) {
						int r = bombs.get(i).r;
						int c = bombs.get(i).c;
						map[r][c] = '.'; //현재위치 폭발
						
						//주변 폭발
						for (int k = 0; k < 4; k++) {
							int nr = r + dr[k];
							int nc = c + dc[k];
							if(nr >= 0 && nc >= 0 && nr < R && nc < C
									&& map[nr][nc] == 'O') {
								map[nr][nc] = '.';
							}
						}
					}
				}
				System.out.println(blist.size());
				for (int i = 0; i < blist.size(); i++) {
					bombs.add(blist.get(i));
				}
			}else {
				for (int i = 0; i < bombs.size(); i++) {
					bombs.get(i).sec++;
				}
				
				
				for (int r = 0; r < R; r++) {
					for (int c = 0; c < C; c++) {
						if(map[r][c] == '.') {
							map[r][c] = 'O';
							bombs.add(new Bomb(r,c));
						}
					}
				}
				//시간 올리기
			}
			second++;
		}
		
		
		for (int r = 0; r < R; r++) {
			StringBuilder sb = new StringBuilder();
			for (int c = 0; c < C; c++) {
				sb.append(map[r][c]);
			}
			sb.append("\n");
			bw.write(sb.toString());
		}
		bw.close();
		br.close();
	}

	private static void printMap(int second, BufferedWriter bw) throws IOException{
		System.out.println("sec : " + second);
		for (int r = 0; r < R; r++) {
			StringBuilder sb = new StringBuilder();
			for (int c = 0; c < C; c++) {
				sb.append(map[r][c]);
			}
			sb.append("\n");
			bw.write(sb.toString());
		}
		
	}
}
