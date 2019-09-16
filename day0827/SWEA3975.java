package day0827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//SWEA 3975 승률 비교하기, D3
public class SWEA3975 {
	static int T;

	static int stoi(String s) {	return Integer.parseInt(s); }

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			
			int A = stoi(st.nextToken().trim());
			int B = stoi(st.nextToken().trim());
			int C = stoi(st.nextToken().trim());
			int D = stoi(st.nextToken().trim());
			
			double alice = (double)A / B;
			double bob = (double)C / D;
			
//			System.out.println(alice + " : " + bob);
			
			String ans = "";
			
			if(alice == bob) ans = "DRAW";
			else if(alice > bob) ans = "ALICE";
			else ans = "BOB";
			
			
			bw.write("#" + t + " " + ans + "\n");
			bw.flush();
			
//			System.out.printf("#%d %s\n", t, ans);
		}
		bw.close();
	}

	
}
