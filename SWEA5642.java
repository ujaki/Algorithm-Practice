import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SWEA 5642 [Professional] 합, D3
public class SWEA5642 {
	static int T;
	static int ret;
	static int[] arr;
	static int[] sum;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = stoi(br.readLine());
			arr = new int[N];
			sum = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			ret = Integer.MIN_VALUE;
			int prevSum = 0;

			for (int i = 0; i < N; i++) {
				arr[i] = stoi(st.nextToken().trim());
				prevSum = Integer.max(prevSum, 0) + arr[i];
				ret = Integer.max(ret, prevSum);
			}
			System.out.printf("#%d %d\n", t, ret);

		}

	}

}