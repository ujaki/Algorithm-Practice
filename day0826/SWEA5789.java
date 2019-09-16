package day0826;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

//SWEA 5789 현주의 상자 바꾸기, D3
public class SWEA5789 {

	static int T;
	static int N;
	static int Q;
	static int[] arr;
	
	static int stoi(String s) {	return Integer.parseInt(s); }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			N = stoi(st.nextToken().trim());
			Q = stoi(st.nextToken().trim());
			
			arr = new int[N];
			for (int q = 1; q <= Q; q++) {
				st  = new StringTokenizer(br.readLine().trim(), " ");
				int L = stoi(st.nextToken().trim());
				int R = stoi(st.nextToken().trim());
				for (int i = L-1; i <= R-1; i++) {
					arr[i] = q;
				}
			}
			
			System.out.printf("#%d ",t);
			for (int i = 0; i < arr.length; i++) {
				System.out.printf("%d ",arr[i]);
			}
			System.out.println();
			
		}
	}
}
