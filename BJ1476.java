import java.util.Scanner;

/*백준 1476, 날짜 계산, Brute force*/
//중국인의 나머지 정리를 이용한 풀이, 그..그치만...
//(1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)
public class BJ1476 {
	static int E, S, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		E = sc.nextInt();
		S = sc.nextInt();
		M = sc.nextInt();
		int sum = 0;
		int e =1, s=1, m=1;
		while(true) {
			if(e == E && s == S && m == M) {
				break;
			}else {
				e++;
				s++;
				m++;
				if(e == 16) e = 1;
				if(s == 29) s = 1;
				if(m == 20) m = 1;
				sum++;
			}
		}
		System.out.println(++sum);
	}
}
