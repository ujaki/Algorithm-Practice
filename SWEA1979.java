import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

//SWEA 1979 어디에 단어가 들어갈 수 있을까, D2
public class SWEA1979 {
	static int T;
	static int N;
	static int K;
	static int[][] mapR;
	static int[][] mapC;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine().trim());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			N = stoi(st.nextToken().trim());
			K = stoi(st.nextToken().trim());
			mapR = new int[N][N];
			mapC = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					mapR[i][j] = stoi(st.nextToken());
					mapC[i][j] = stoi(st.nextToken());
				}
			}

			int ret = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - K + 1; j++) {
					if(mapR[i][j] == 1) {
						boolean check = true;
						for (int k = 0; k < K; k++) {
							if(mapR[i][k] != 1) {
								check = false;
								break;
							}
						}
						if(check) {
							
						}
					}
				}
			}
		
			
		
			System.out.printf("#%d %d\n", t,ret);
		}

	}

}
