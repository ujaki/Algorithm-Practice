import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SWEA 6730 장애물 경주 난이도, D3
public class SWEA6730 {
	
	static int T;
	static int high;
	static int low;
	static int N;
	static int[] arr;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = stoi(br.readLine());
			arr = new int[N];
//			System.out.println("n : " + N);
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < N; i++) {
				arr[i] = stoi(st.nextToken().trim());  
			}
			
//			System.out.println(Arrays.toString(arr));
			high = 0;
			low = 0;
			
			for (int i = 0; i < N-1; i++) {
				int gap = arr[i+1] - arr[i];
//				System.out.println(gap);
				if(gap > 0) {
					if(gap > high) high = gap ;
					continue;
				}
				if(gap < 0){
					if(gap < -low)
						low = -gap;
				}
			}

			System.out.printf("#%d %d %d\n", t, high, low);

		}

	}

}