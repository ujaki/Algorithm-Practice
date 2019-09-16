package typea.prepare.day0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class CYViligeCount {

	static int T;
	static int N, M;
	static int[] muri;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = stoi(st.nextToken().trim());
			M = stoi(st.nextToken().trim());

			muri = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				muri[i] = i;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int n1 = stoi(st.nextToken().trim());
				int n2 = stoi(st.nextToken().trim());
				union(n1, n2);
			}

			int ret = 0;
			Set<Integer> set = new HashSet<>();
			
			for (int i = 1; i <= N; i++) {
				set.add(find(i));
			}
			
			
//			System.out.println(Arrays.toString(muri));
			System.out.printf("#%d %d\n", t, set.size());

		}
	}

	static int find(int x) {
		if (muri[x] == x)
			return x;
		else
			return muri[x] = find(muri[x]);
	}

	static void union(int x1, int x2) {
		int p1 = find(x1);
		int p2 = find(x2);
		
		if(p1 == p2) return;
		
		if(p2 != p1) {
			muri[p2] = p1;
		}
	}
}
