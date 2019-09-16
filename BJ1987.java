import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//백준 1987, 알파벳
public class BJ1987 {
	static int R; // 행 개수
	static int C; // 열 개수
	static boolean[][] visited;
	static int[][] map;
	static Set<Integer> nSet;
	static int result = Integer.MIN_VALUE;
					 // 상, 하, 좌, 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		nSet = new HashSet<>();
		R = sc.nextInt();
		C = sc.nextInt();
		
		map = new int[R][C];
		visited = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			char[] data = sc.next().toCharArray();
			for (int c = 0; c < C; c++) {
				map[r][c] = (data[c] - 'A');
			}
		}
		
		
		dfs(0,0,1);
		
		System.out.println(result);
		sc.close();
	}

	private static void dfs(int row, int col, int cnt) {
		result = Math.max(cnt, result);
	
		for (int i = 0; i < 4; i++) {
			int r = row + dr[i];
			int c = col + dc[i];
			if(r >= 0 && r < R && c >= 0 && c < C) {
				nSet.add(map[row][col]);
				if(!nSet.contains(map[r][c]) && !visited[r][c]) {
					visited[r][c] = true;
					dfs(r,c, cnt + 1);
					visited[r][c] = false;
					nSet.remove(map[r][c]);
				}
			}
		}
	}

}
