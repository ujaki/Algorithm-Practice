package IMPrepare;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2941 백준, 크로아티아 알파벳

public class BJ2941 {
	
	static String[] alpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine().trim(); //input
		
		for (int i = 0; i < alpha.length; i++) {
			str = str.replace(alpha[i], "a");
		}
		
		StringBuilder sb=new StringBuilder();
		
		bw.write(sb.append(str.length()).toString());
		bw.flush();
		bw.close();
	}
}
