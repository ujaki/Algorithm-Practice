package day0827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//SWEA 5601 [Professional] 쥬스 나누기, D3
public class SWEA5601 {
	static int T;

	static int stoi(String s) {	return Integer.parseInt(s); }

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = stoi(br.readLine());
			StringBuffer sb = new StringBuffer();
			sb.append("1/"+N);
			
			bw.write("#" + t + " ");
			for (int i = 0; i < N; i++) {
				bw.write(sb.toString() + " ");
			}
			bw.write("\n");
			bw.flush();
		}
		bw.close();
	}
}
