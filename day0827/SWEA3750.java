package day0827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//SWEA 3750 Digit sum, D3
public class SWEA3750 {
	static int T;

	static int stoi(String s) {	return Integer.parseInt(s); }

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());

		for (int t = 1; t <= T; t++) {
			String num = br.readLine().trim();
			
			while(num.length() != 1) {
				int sum = 0;
				for (int i = 0; i < num.length(); i++) {
					sum += (num.charAt(i) - '0');
				}
				num = ""+sum;
			}
			
			bw.write("#" + t + " " + num + "\n");
			bw.flush();
			
//			System.out.printf("#%d %s\n", t, ans);
		}
		bw.close();
	}

	
}
