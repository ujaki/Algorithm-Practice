package day0902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 5577, RBY팡!
public class BJ5577 {

	static int N;

	static int[] list;
	static int ret;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());

		list = new int[N];

		for (int n = 0; n < N; n++) {
			list[n] = stoi(br.readLine());
		} // end input

		ret = Integer.MAX_VALUE;
		// 1은 빨강, 2는 파랑, 3은 노랑
		for (int i = 0; i < N; i++) {
			int origin = list[i];
			
			for (int j = 1; j < 4; j++) {
				if(list[i] == j) continue;
				list[i] = j;
				int cnt = 0;
				int left = i, right = i;
				
				while(left >= 0 && right < N && list[left] == list[right]) {
					int color = list[left];
					int tmp = 0;
					while(left >= 0 && list[left] == color) {
						tmp++;
						left--;
					}
					while(right < N && list[right] == color) {
						tmp++;
						right++;
					}
					if(tmp>=4)
						cnt += tmp;
				}
				
				ret = Integer.min(ret, list.length - (cnt-1));
			}
			
			list[i] = origin;
		}
		System.out.println(ret);

	}

	
}
