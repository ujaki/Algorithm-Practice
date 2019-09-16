import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SWEA 1213 String, D3
public class SWEA1209 {

	static int[][] arr;
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int tNum = stoi(br.readLine());
			arr = new int[100][100];
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					arr[i][j] = stoi(st.nextToken().trim());
				}
			}

			int ret = 0;
			//row
			int sumD = 0; int sumRD = 0;
			for (int i = 0; i < 100; i++) {
				int sumR = 0; int sumC = 0;
				for (int j = 0; j < 100; j++) {
					sumC += arr[i][j];
					sumR += arr[j][i];
				}
				sumD += arr[i][i];
				sumRD += arr[99-i][99-i];
				ret = Integer.max(ret, sumC);
				ret = Integer.max(ret, sumR);
			}
			ret = Integer.max(ret, sumD);
			ret = Integer.max(ret, sumRD);
			
			System.out.printf("#%d %d\n", tNum, ret);
		}

	}

}
