package day0827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//SWEA 3456 직사각형 길이 찾기, D3
public class SWEA3456 {
	static int T;

	static int stoi(String s) {	return Integer.parseInt(s); }

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			
			int a = stoi(st.nextToken().trim());
			int b = stoi(st.nextToken().trim());
			int c = stoi(st.nextToken().trim());
			
			int ans = 0;
			//    a
			// b     c
			//    d
			if(a == b && b == c && a == c) ans = a;
			else if(a == b && a != c) ans = c;
			else if(a == c && a != b) ans = b;
			else if (b == c && a != c) ans = a;
			
			
			
			bw.write("#" + t + " " + ans + "\n");
			bw.flush();
			
		}
		bw.close();
	}

	
}
