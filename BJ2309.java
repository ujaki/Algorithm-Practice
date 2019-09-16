import java.util.Arrays;
import java.util.Scanner;

/*백준 2309, 일곱 난쟁이, Brute force*/
//중첩 반복문으ㅣ로 풀릴 수 이ㅆ음
 
public class BJ2309 {
	static int[] dwarfs;
	static int[] real;
	static boolean[] visited = new boolean[9];
	static boolean flag = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dwarfs = new int[9];
		real = new int[7];
		for (int i = 0; i < 9; i++) {
			dwarfs[i] = sc.nextInt();
		}

		solve(0, dwarfs.length, real.length, 0);
		
	}

	static void solve(int start, int n, int r, int sum) {
		if(flag) return;
		if (r == 0) {
			if(sum == 100) {
				int idx = 0;
				for (int i = 0; i < dwarfs.length; i++) {
					if(visited[i]) {
						real[idx++] = dwarfs[i];
					}
				}
				
				Arrays.sort(real);
				for (int i = 0; i < real.length; i++) {
					System.out.println(real[i]);
				}
				flag = true;
			}
			return;
		}
		for (int i = start; i < n; i++) {
			visited[i] = true;
			solve(i + 1, n, r - 1, sum + dwarfs[i]);
			visited[i] = false;
		}

	}
}
