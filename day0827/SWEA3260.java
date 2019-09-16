package day0827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

//SWEA 3260 두 수의 덧셈, D3
public class SWEA3260 {
	static int T;

	static int stoi(String s) {	return Integer.parseInt(s); }

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			BigInteger a = new BigInteger(st.nextToken().trim());
			BigInteger b = new BigInteger(st.nextToken().trim());
			
			BigInteger sum = a.add(b);
			
			bw.write("#" + t + " " + sum.toString() + "\n");
			bw.flush();
			
		}
		bw.close();
	}

	
}
