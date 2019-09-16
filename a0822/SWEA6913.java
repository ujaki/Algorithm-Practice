package a0822;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SWEA 6913 동철이의 프로그래밍 대회, D3
public class SWEA6913 {
	static int T;
	static int[][] arr;
	static int N;
	static int M;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = stoi(st.nextToken().trim());
			M = stoi(st.nextToken().trim());
			arr = new int[N][M+1];
			
			int maxValue = -1;
					
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				int sum=0;
				for (int m = 0; m < M; m++) {
					arr[n][m] = stoi(st.nextToken().trim());
					if(arr[n][m] == 1) sum++;
				}
				arr[n][M] = sum;
				if(sum > maxValue) maxValue = sum;
			}
			
			int cnt=0;
			for (int i = 0; i < N; i++) {
				if(arr[i][M] == maxValue) cnt++;
			}
			
			System.out.printf("#%d %d %d\n", t, cnt, maxValue);
		}
	}
		
}
