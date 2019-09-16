package day0827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//SWEA 3314 보충학습과 평균, D3
public class SWEA3314 {
	static int T;

	static int stoi(String s) {	return Integer.parseInt(s); }

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int sum = 0;
			for (int i = 0; i < 5; i++) {
				int score = stoi(st.nextToken().trim());
				if(score < 40) score = 40;
				sum += score;
			}
			
			bw.write("#" + t + " " + (sum/5) + "\n");
			bw.flush();
			
		}
		bw.close();
	}

	
}
