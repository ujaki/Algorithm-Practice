import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

//SWEA 8338 계산기, D4
public class SWEA8338 {

	static int T;
	static int N;
	static int[] nums;
	static int ret;
	static int visited[]; // [idx] -> idx까지의 현재 최대 연산 값

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());

		for (int t = 1; t <= T; t++) {
			ret = Integer.MIN_VALUE;
			N = stoi(br.readLine());

			if (N == 1) {
				System.out.printf("#%d %d\n", t, stoi(br.readLine().trim()));
			} else {
				nums = new int[N];
				visited = new int[N];
				Arrays.fill(visited, -1);
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int i = 0; i < N; i++) {
					nums[i] = stoi(st.nextToken().trim());
				}
				// idx, sum
				getMaxValue(1, nums[0]);
				System.out.printf("#%d %d\n", t, ret);
			}
		}
	}

	private static void getMaxValue(int idx, int sum) {
		if (idx == N) {
			ret = Integer.max(ret, sum);
			return;
		}
		
		if(visited[idx] >= sum) return;
		visited[idx] = sum;
		
		getMaxValue(idx + 1, sum + nums[idx]);
		getMaxValue(idx + 1, sum * nums[idx]);
		
	}

}
