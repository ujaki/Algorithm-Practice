import java.util.Scanner;
//백준, 9095, 1,2,3의 합,  dp
public class BJ9095 {
	static int T;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int result = 0;
			int n = sc.nextInt();
			//1 -> 1
			//2 -> 1 + 1, 2 //2
			//3 -> 1 + 1 + 1, 1 + 2, 2 + 1, 3 // 4
			System.out.println(dp(n));
		}
	}
	private static int dp(int n) {
		if(n == 1) return 1;
		else if(n == 2) return 2;
		else if(n == 3) return 4;
		
		return dp(n - 1) + dp(n - 2) + dp(n - 3);
	}

}
