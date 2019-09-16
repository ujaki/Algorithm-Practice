import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//원형 연결리스트를 이용한 문제풀이
//큐를 원형 연결리스트 처럼 사용
//백준 1158, 조세퍼스 문제
public class BJ1158 {
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb= new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		for (int n = 0; n < N; n++) {
			queue.add(n + 1);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M-1; j++) {
				//M-1만큼 앞에 사람 빼서 큐 뒤로 돌리기
				int tmp = queue.poll();
				queue.add(tmp);
			}
			if(i == N - 1) {
				sb.append(", " + queue.poll());
				sb.append(">");
			}else {
				sb.append(", " + queue.poll());
			}
		}
		

		String answer = sb.toString();
		answer = answer.substring(2, answer.length());
		System.out.print("<");
		System.out.print(answer);
	}
}
