import java.util.Scanner;

//백준 14888, 연산자 끼워넣기
public class BJ14888 {
	static int N; //수의 개수
	static int[] nums;
	static int[] op = new int[4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			op[i] = sc.nextInt();
		}
		  //idx   +     -      *      /
		dfs(1, 0,0,0,0, nums[0]);
		System.out.println(max);
		System.out.println(min);
	}
	private static void dfs(int idx, int plus, int minus, int mul, int div, int result) {
		if(idx == N) {
			if(result > max) max = result;
			if(result < min) min = result;
			return;
		}
		if(plus < op[0])
			dfs(idx + 1, plus+1, minus, mul, div, result + nums[idx]);
		if(minus < op[1])
			dfs(idx + 1, plus, minus+1, mul, div, result - nums[idx]);
		if(mul < op[2])
			dfs(idx + 1, plus, minus, mul+1, div, result * nums[idx]);
		if(div < op[3])
			dfs(idx + 1, plus, minus, mul, div+1, result / nums[idx]);
	}
	
}
