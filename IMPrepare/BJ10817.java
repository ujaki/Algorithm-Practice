package IMPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//10817 백준, 세 수

public class BJ10817 {

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[3];
		arr[0] = stoi(st.nextToken().trim());
		arr[1] = stoi(st.nextToken().trim());
		arr[2] = stoi(st.nextToken().trim());

		Arrays.sort(arr);
		
		System.out.println(arr[1]);
	}
}
