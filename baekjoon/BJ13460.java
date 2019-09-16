package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ13460 {

	static int N, M;
	static int ox;
	static int oy;

	static char[][] map;
	static int ans;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static class Bead {
		int x;
		int y;
		char color;
		int cnt;
		
		public Bead(int x, int y, char color) {
			this.x = x;
			this.y = y;
			this.color = color;
			this.cnt = 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine().trim());
		M = stoi(br.readLine().trim());

		map = new char[N][M];

		Queue<Bead> red = new LinkedList<>();
		Queue<Bead> blue = new LinkedList<>();

		for (int n = 0; n < N; n++) {
			String line = br.readLine().trim();
			for (int m = 0; m < M; m++) {
				map[n][m] = line.charAt(m);
				if (map[n][m] == 'R')
					red.add(new Bead(n, m, 'R'));
				if (map[n][m] == 'B')
					blue.add(new Bead(n, m, 'B'));
				if(map[n][m] == 'O') {
					//구멍의 위치 저장
					ox = n;
					oy = m;
				}
			}
		} // end input

		ans = 0;
		
		while(true) {
			if(red.isEmpty() && blue.isEmpty()) break;
			
			
			
		}
		// 빨간 구슬이 구멍에 빠지면 성공이지만, 파란 구슬이 구멍에 빠지면 실패이다.
		// 빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패이다.
		// 기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때 까지

		System.out.println(ans);
	}

}
