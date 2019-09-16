package day0827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//SWEA 1221 GNS, D3
public class SWEA1221 {
	static int T;

	static int stoi(String s) {	return Integer.parseInt(s); }

	static class GNS implements Comparable<GNS>{
		int num;
		String str;
		
		
		public GNS(int num, String str) {
			this.num = num;
			this.str = str;
		}


		@Override
		public int compareTo(GNS o) {
			return this.num - o.num;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = stoi(br.readLine().trim().split(" ")[1].trim());
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			PriorityQueue<GNS> pq = new PriorityQueue<>();
			
			for (int i = 0; i < N; i++) {
				String s = st.nextToken().trim();
				pq.add(new GNS(getNum(s), s));
			}
//			System.out.println(N);
//			System.out.println(pq.size());
			
			bw.write("#" + t + "\n");
			while(!pq.isEmpty()) {
				GNS gns = pq.poll();
				bw.write(gns.str + " ");
			}
			bw.write("\n");
			bw.flush();
		}
		bw.close();
	}

	static int getNum(String s) {
		if(s.equals("ZRO")) return 0;
		else if(s.equals("ONE")) return 1;
		else if(s.equals("TWO")) return 2;
		else if(s.equals("THR")) return 3;
		else if(s.equals("FOR")) return 4;
		else if(s.equals("FIV")) return 5;
		else if(s.equals("SIX")) return 6;
		else if(s.equals("SVN")) return 7;
		else if(s.equals("EGT")) return 8;
		else return 9;
	}
}
