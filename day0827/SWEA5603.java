package day0827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//SWEA 5601 [Professional] 건초더미, D3
public class SWEA5603 {
	static int T;

	static int stoi(String s) {	return Integer.parseInt(s); }

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = stoi(br.readLine());
			
			int[] arr = new int[N];
			
			int avg = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = stoi(br.readLine());
				avg += arr[i];
			}
			avg /= N;
			
			int ret = 0;
			
			for (int i = 0; i < N; i++) {
				if(arr[i] < avg)
					ret += (avg - arr[i]);
			}

			
			bw.write("#" + t + " " + ret + "\n");
			bw.flush();
		}
		bw.close();
	}
}
