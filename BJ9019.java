import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준, 9019, DSLR
//경우의 수, 최소한의 뭐시기 -> BFS

public class BJ9019 {
	
	static class Data {
		int n;
		String str;

		public Data(int n, String str) {
			this.n = n;
			this.str = str;
		}
	}

	static int T;
	static int a;
	static int b;
	static boolean[] used;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		Queue<Data> queue;
		for (int t = 0; t < T; t++) {
			a = sc.nextInt();
			b = sc.nextInt();
			String ret = null;
			queue = new LinkedList<>();
			used =  new boolean[10000];
			queue.add(new Data(a, ""));
			used[a] = true;

			while (!queue.isEmpty()) {
				int n = queue.peek().n;
				String str = queue.peek().str;
				queue.poll();

				if (n == b) {
					ret = str;
					break;
				}

				// D
				int curNum = (2 * n) % 10000;
				if (!used[curNum]) {
					used[curNum] = true;
					queue.add(new Data(curNum, str + "D"));
				}

				// S
				curNum = ((n - 1) < 0) ? 9999 : (n - 1);
				if (!used[curNum]) {
					used[curNum] = true;
					queue.add(new Data(curNum, str + "S"));
				}

				// L
				curNum = ((n % 1000) * 10) + n / 1000;
				if (!used[curNum]) {
					used[curNum] = true;
					queue.add(new Data(curNum, str + "L"));
				}

				// R
				curNum = ((n % 10) * 1000) + (n / 10);
				if (!used[curNum]) {
					used[curNum] = true;
					queue.add(new Data(curNum, str + "R"));
				}

			}

			System.out.println(ret);
		}
	}
}
