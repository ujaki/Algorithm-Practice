package day0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//SWEA 4047 영준이의 카드 카운팅, D3
public class SWEA4047 {
	static int T;
	
	static int stoi(String s) {	return Integer.parseInt(s); }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());
		
//			A는 1, J, Q, K는 11, 12, 13으로 하여 1~13
//			각각 13장씩 총 52장의 카드
		for (int t = 1; t <= T; t++) {
			String S = br.readLine().trim();
			
			int[][] cards = new int[4][13];
			//0 : S | 1 : D | 2 : H | 3 : C
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 13; j++) {
					cards[i][j] = 1;
				}
			}
			
			for (int i = 0; i < S.length(); i = i + 3) {
				int type = getType(S.charAt(i));
				int num = stoi("" + S.charAt(i+1) + S.charAt(i+2));
				cards[type][num-1] -= 1;
			}
			
			System.out.printf("#%d ", t);
			boolean flag = false;
			int[] sums = new int[4];
			for (int i = 0; i < 4; i++) {
				if(flag) break;
				int sum = 0;
				for (int j = 0; j < 13; j++) {
					if(cards[i][j] < 0) {
						System.out.println("ERROR");
						flag = true;
						break;
					}else {
						sum += cards[i][j];
					}
				}
				sums[i] = sum;
			}
			if(!flag)
				System.out.printf("%d %d %d %d\n", sums[0], sums[1],sums[2],sums[3]);
		}
	}

	private static int getType(char t) {
		if(t == 'S') return 0;
		else if(t == 'D') return 1;
		else if(t == 'H') return 2;
		else return 3;
	}
}
