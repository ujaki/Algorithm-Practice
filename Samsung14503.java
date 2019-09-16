import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//삼성 기출, 백준 14503, 로봇 청소지
public class Samsung14503 {

	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;

	static class Robot {
		int x;
		int y;
		int dir;

		public Robot(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	static Robot robot;
	// 북동남서
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		// setting
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		st = new StringTokenizer(br.readLine(), " ");
		robot = new Robot(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()));
		// inputs
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = stoi(st.nextToken());
				if (map[r][c] == 1)
					visited[r][c] = true; // 벽임
			}
		}
		// solve
		boolean flag = false;
		while(true) {
//			2.현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
//				b.왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
//				a.왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
			for (int i = 0; i < 4; i++) {
				flag = false;
				int left = getLeftDir(robot.dir);
				int lx = robot.x + dx[left];
				int ly = robot.y + dy[left];
				
				if(lx >= 0 && ly>=0 && lx < N && ly <M) {
					if(map[lx][ly] == 0) {
						robot.dir = left;
						robot.x = lx;
						robot.y = ly;
						//1. 현재 위치를 청소한다.
						map[lx][ly] = -1;
						flag = true;
					}
				}
			}
//			c.네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
//			d.네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
			if(!flag) {
				int back = getBackDir(robot.dir);
				int bx = robot.x + dx[back];
				int by = robot.y + dy[back]; 
				
				robot.x = bx;
				robot.y = by;
				
				if(map[bx][by] == 1) break;
				
			}
			
			
		}
		
		
		// ----------------------------------------------

		// 방향 d가 주어진다.
		// d가 0인 경우에는 북쪽을,
		// 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽
		int cnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == -1)
					cnt++;
			}
		}
		System.out.println(cnt);
	} // main



	private static void solve() {
		goOne();
	}

	private static void goOne() {
		map[robot.x][robot.y] = -1; // cleaning
		goTwo();
	}

	private static void goTwo() {
		int left = getLeftDir(robot.dir);
		int lx = robot.x + dx[left];
		int ly = robot.y + dy[left];

		if (isAllCleaned() || isAllWalls()) {
			int back = getBackDir(robot.dir);
			int bx = robot.x + dx[back];
			int by = robot.y + dy[back];
			if (bx < 0 || by < 0 || bx >= N || by >= M)
				return;
			else {
				if (map[bx][by] != 0)
					return;
				else {
					robot.x = bx;
					robot.y = by;
					goTwo();
				}
			}
		}else {
			if (lx >= 0 && ly >= 0 && lx < N && ly < M) {
				if (map[lx][ly] == 0) {
					robot.dir = left;
					robot.x = lx;
					robot.y = ly;
					goOne();
				} else {
					robot.dir = left;
					goTwo();
				}
			}else {
				robot.dir = left;
				goTwo();
			}
		}

	}

	private static int getLeftDir(int curDir) {
		int left = 0;
		// 0 : 북 | 1 : 동 | 2 : 남 | 3 : 서
		if (curDir == 0)
			left = 3;
		else if (curDir == 1)
			left = 0;
		else if (curDir == 2)
			left = 1;
		else if (curDir == 3)
			left = 2;
		return left;
	}

	private static int getBackDir(int curDir) {
		int back = 0;
		// 0 : 북 | 1 : 동 | 2 : 남 | 3 : 서
		if (curDir == 0)
			back = 2;
		else if (curDir == 1)
			back = 3;
		else if (curDir == 2)
			back = 0;
		else if (curDir == 3)
			back = 1;
		return back;
	}

	private static boolean isAllCleaned() {
		int nx;
		int ny;
		for (int i = 0; i < 4; i++) {
			nx = robot.x + dx[i];
			ny = robot.y + dy[i];
			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;
			else {
				if (map[nx][ny] != -1)
					return false;
			}
		}
		return true;
	}

	private static boolean isAllWalls() {
		int nx;
		int ny;
		for (int i = 0; i < 4; i++) {
			nx = robot.x + dx[i];
			ny = robot.y + dy[i];
			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;
			else {
				if (map[nx][ny] == 0)
					return false;
			}
		}
		return true;
	}

}
