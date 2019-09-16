package IMPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//3985 백준, 롤 케이크

public class BJ3985 {
	static int L; // 롤케이크 길이
	static int N; // 방청객 수
	static int[] cake;
	static int[] freq;
	static int[] expect;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = stoi(br.readLine());
		N = stoi(br.readLine());

		cake = new int[L + 1]; // 조각 번호 기록
		freq = new int[N + 1]; // 실제로 가장 많은 조각을 받은 방청객의 번호 출력할 용
		expect = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = stoi(st.nextToken().trim());
			int k = stoi(st.nextToken().trim());

			// 케이크 조각내기
			for (int j = p; j <= k; j++) {
				if (cake[j] == 0) {
					cake[j] = i;
					freq[i]++; // 방청객에 대한 실제 조각수 카운트
				}
			}
			
			expect[i] = k - p;

		} // end input

//		System.out.println(Arrays.toString(cake));
//		System.out.println(Arrays.toString(freq));
//		System.out.println(Arrays.toString(expect));

		int maxExp = -1; //가장 많은 조각을 받을 것으로 기대하고 있던
		int exnum = 0; //방청객의 번호
		for (int i = 1; i < expect.length; i++) {
			if(expect[i] > maxExp) {
				maxExp = expect[i];
				exnum = i;
			}
		}
		
		System.out.println(exnum);
		
		
		int maxCnt = -1;
		int vnum = 0;
		for (int i = 1; i < freq.length; i++) {
			if(freq[i] > maxCnt) {
				maxCnt = freq[i];
			}
		}
		for (int i = 1; i < freq.length; i++) {
			if(freq[i] == maxCnt) {
				System.out.println(i);
				break;
			}
		}

	}

}
