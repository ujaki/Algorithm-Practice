import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

//SWEA 4751 다솔이의 다이아몬드 장식, D3
public class SWEA4751 {

	static int T;
	static int N;
	static char[] arr;
	static char[][] sample = { {'.','.','#','.','.'},
							{'.','#','.','#','.'},
							{'#','.','X','.','#'},
							{'.','#','.','#','.'},
							{'.','.','#','.','.'}};

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());

		for (int t = 1; t <= T; t++) {
			String str = br.readLine().trim();
			N = (str.length() - 1) * 4 + 5;
			char[] alpha = str.toCharArray();
			char[][] deco = new char[5][N];
			
			int k = 0;
			for (int i = 0; i < alpha.length; i++) {
				
				for (int x = 0; x < 5; x++) {
					for (int y = 0; y < 5; y++) {
						if(x == 2 && y == 2) //장식 위치일 때
							deco[x][k+y] = alpha[i];
						else
							deco[x][k+y] = sample[x][y];
					}
				}
				k+= 4;
			}
			
			print(deco);
//			System.out.println();
		}
	}

	private static void print(char[][] deco) {
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < N; y++) {
				System.out.print(deco[x][y]);
			}
			System.out.println();
		}
	}
}
