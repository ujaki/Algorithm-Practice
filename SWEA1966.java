import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//SWEA 1966 숫자를 정렬하자, D2
public class SWEA1966 {
	static int T;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = stoi(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = stoi(st.nextToken().trim());
			}
			
			Arrays.sort(arr);
			System.out.printf("#%d",t);
			for (int i = 0; i < arr.length; i++) {
				if(i == arr.length-1) System.out.printf(" %d\n", arr[i]);
				else
				System.out.printf(" %d", arr[i]);
			}
		}

	}

}
