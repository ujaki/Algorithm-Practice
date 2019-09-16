import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//SWEA 1959 두개의 숫자열, D2
public class SWEA1959 {
	static int T;
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = stoi(st.nextToken().trim());
			int M = stoi(st.nextToken().trim());
			
			int[] a = new int[N];
			int[] b = new int[M];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				a[i] = stoi(st.nextToken().trim());
			} 
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				b[i] = stoi(st.nextToken().trim());
			}
			
			int ret = Integer.MIN_VALUE;
			
			if(N > M) {
				for (int i = 0; i < N-M+1; i++) {
					int sum = 0;
					for (int j = 0; j < M; j++) {
						sum += (a[i+j] * b[j]); 
					}
					ret = Math.max(ret, sum);
				}
			}else if(M > N) {
				for (int i = 0; i < M-N+1; i++) {
					int sum = 0;
					for (int j = 0; j < N; j++) {
						sum += (a[j] * b[i+j]); 
					}
					ret = Math.max(ret, sum);
				}
			}else {
				for (int i = 0; i < N; i++) {
					ret += (a[i] * b[i]); 
				}
			}
			
			System.out.printf("#%d %d\n", t,ret);
			
		}

	}

}
