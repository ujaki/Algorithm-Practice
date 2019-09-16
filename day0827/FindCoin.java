package day0827;

import java.util.Scanner;

/*

*/
public class FindCoin {
	static int N, M; // N개의 동전, M개의 비교정보
	static boolean[][] map;
	static int tmp, ans;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			map[sc.nextInt()][sc.nextInt()] = true;
		}

		ans = 0;

		for (int i = 1; i <= N; i++) { // N개의 동전 각각 자기보다 무거운거 몇개 가벼운거 몇개 있나 세어볼 예정
			tmp = 0; // 동전 갯수 누적할 변수 초기화 해놓고 시작
			visit = new boolean[N + 1];
			light_dfs(i);
			if (tmp > (N / 2)) { // i보다 가벼운 동전이 반이 넘으면 i번 동전은 중간에 못옴
				ans++;
			} else { // i번 가벼운 동전은 일단 N/2개 보다 적었는데 혹시 i보다 무거운게 반 넘을 수도 있지
				tmp = 0;
				visit = new boolean[N + 1];
				heavy_dfs(i);
				if (tmp > (N / 2)) {
					ans++;
				}
			}
		}

	}

	static void light_dfs(int n) { // n보다 가벼운 동전의 갯수 세기
		for (int i = 1; i <= N; i++) {
			if (!visit[i] && map[n][i]) { // n번 동전보다 가벼운 동전이면
				visit[i] = true;
				tmp++; // 몇개인지 세기, 그리고 i 보다 더 가벼운 동전이 있나 보라고 하자
				light_dfs(i);
			}
		}
	}

	static void heavy_dfs(int n) { // n보다 무거운 동전의 갯수 세기
		for (int i = 1; i <= N; i++) {
			if (!visit[i] && map[i][n]) { // n번 동전보다 무거운 동전이면
				visit[i] = true;
				tmp++; // 몇개인지 세기, 그리고 i 보다 더 무거운 동전이 있나 보라고 하자
				heavy_dfs(i);
			}
		}
	}

}
