import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//SWEA 1970 쉬운 거스름돈, D2
public class SWEA1970 {
	static int T;
	static final int[] money = {50000,10000,5000,1000,500,100,50,10};
	static int[] cnt;
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = stoi(br.readLine());
			cnt = new int[money.length];
			
			for (int i = 0; i < money.length; i++) {
				cnt[i] = N / money[i];
				N %= money[i]; 
			}
			
			System.out.printf("#%d\n",t);
			for (int i = 0; i < cnt.length; i++) {
				if(i == cnt.length-1) System.out.printf("%d\n", cnt[i]);
				else
				System.out.printf("%d ", cnt[i]);
			}
		}

	}

}
