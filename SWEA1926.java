import java.util.Scanner;

//SWEA 1926 간단한 369 게임, D2
public class SWEA1926 {
	static int N;

	static String[] claps = {"-", "--", "---"};
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			int num = getClap(i);
			if(num == -1) {
				System.out.printf("%d ", i);
			}else {
				System.out.printf("%s ", claps[num]);
			}
		}
	}

	private static int getClap(int i) {
		char[] cs = Integer.toString(i).toCharArray();
		int cnt = 0;
		for (int j = 0; j < cs.length; j++) {
			if(cs[j] == '3' || cs[j] == '6' || cs[j] == '9') {
				cnt++;
			}
		}
		if(cnt == 0) return -1;
		else return cnt-1;
	}
}
