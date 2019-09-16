package day0827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//SWEA 3142 영준이와 신비한 뿔의 숲, D3
public class SWEA3142 {
	static int T;

	static int stoi(String s) {	return Integer.parseInt(s); }

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int N = stoi(st.nextToken().trim()); //n개의 뿔
			int M = stoi(st.nextToken().trim()); //m마리 짐승
			
			int x = N - M;
			int y = 2 * M - N;
			
			//y        x
			//유니콘 1, 트윈혼 2
			
			bw.write("#" + t + " " + y + " " + x + "\n");
			bw.flush();
			
		}
		bw.close();
	}

	
}
