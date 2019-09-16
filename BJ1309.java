import java.util.Scanner;

//백준, 1309, 동물원
//다시 풀어보기
public class BJ1309 {
	static int N;
	static int[][] c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		c = new int[N+1][3];
		c[1][0] = 1;
		c[1][1] = 1;
		c[1][2] = 1;
		int mod = 9901;
		
	
		//사자 한마리도 배치 안 할 경우 1가지
		
		//N 1일 때 -> 1(한칸) + 1(두번째칸) -> 2 
		//N 2일 때 -> N1 + 2 + 2 - > 6
		//N 3일 때 -> N1 + N2 + 4(2마리씩 배칠할 때) + 2(3마리 배치할때) -> 16
		
		//1		2					3				 4
		//3		7(2*N1 + N1_n)		16(2*N2 + N2_2)  ?(2*N3 + N3_n) -> 32 + 3
		
		for (int i = 2; i <= N; i++) {
			c[i][0] = (c[i-1][0] + c[i-1][1] + c[i-1][2]) % mod;
			c[i][1] = (c[i-1][0] + c[i-1][2]) % mod;
			c[i][2] = (c[i-1][0] + c[i-1][1]) % mod;
		}
		
//		for (int i = 0; i < N+1; i++) {
//				System.out.printf("%d  %d  %d  \n", c[i][0], c[i][1], c[i][2]);
//		}
		
		System.out.println((c[N][0] + c[N][1] + c[N][2])%mod);
		
	}
	
	

}
