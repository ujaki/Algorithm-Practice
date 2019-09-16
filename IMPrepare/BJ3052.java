package IMPrepare;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;

//3052 백준, 나머지

public class BJ3052 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		Set<Integer> set = new TreeSet<>();
		
		for (int i = 0; i < 10; i++) {
			set.add(Integer.parseInt(br.readLine())%42);
		}
		sb.append(set.size());
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
