import java.util.Scanner;
//combination
//백준, 6603, 로또, BFS, DFS, BF, 백트래킹
public class BJ6603 {

	static int N;
	static int[] nums;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			N = sc.nextInt();
			if (N == 0)
				break;
			else {
				nums = new int[N];
				visited = new boolean[N];
				for (int i = 0; i < N; i++) {
					nums[i] = sc.nextInt();
				}
				dfs(0, 6);
				System.out.println();
			}
		}
	}

	private static void dfs(int start, int r) {
		if (r == 0) {
			for (int i = 0; i < nums.length; i++) {
				if (visited[i])
					System.out.print(nums[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < nums.length; i++) {
			visited[i] = true;
			dfs(i + 1, r - 1);
			visited[i] = false;
		}

	}

}
