import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준, 14501 퇴사

public class BJ14501 {
	static int N;
	static int[][] sch; // 일정표
	static boolean[] pos; // 상담 가능 여부

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		sch = new int[2][N + 1];
		pos = new boolean[N + 1];

		Queue<Integer> posDay = new LinkedList<>();

		for (int n = 1; n <= N; n++) {
			int t = scan.nextInt();
			int p = scan.nextInt();
			sch[0][n] = t;
			sch[1][n] = p;
			if ((n + t) <= N + 1)
				posDay.add(n); // 상담 가능성이 있는 날짜에 해당되는 인덱스 넣기
		}

		int max = Integer.MIN_VALUE;
		while (!posDay.isEmpty()) {
			max = Math.max(max, solve(posDay.peek()));
			posDay.poll();
		}

		System.out.println(max);
	}

	private static int solve(int day) {
//		System.out.println(day);
		// 상담 가능한 요일인지 판단, 이건 이미 입력 받을 때 큐에 넣어둠
		int nday = day + sch[0][day];
		if (nday > N + 1)
			return 0;
		if (nday == N + 1) {
			return sch[1][N];
		} else {
			return sch[1][day] + solve(nday);
		}
	}
}
