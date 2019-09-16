package a0822;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//SWEA 2948 문자열 교집합, D3
public class SWEA2948 {
	static int T;
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
			
			Set<String> set = new HashSet<>();
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				set.add(st.nextToken().trim());
			}
			
			int ret = 0;
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				if(set.contains(st.nextToken().trim()))
					ret++;
			}
			
			System.out.printf("#%d %d\n", t, ret);
		}
	}
}
