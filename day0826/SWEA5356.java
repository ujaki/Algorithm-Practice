package day0826;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

//SWEA 5356 의석이의 세로로 말해요, D3
public class SWEA5356 {

	static int T;

	static char[][] arr;
	
	static int stoi(String s) {	return Integer.parseInt(s); }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());

		for (int t = 1; t <= T; t++) {
			arr = new char[5][15];
			
			for (int i = 0; i < 5; i++) {
				char[] cs = br.readLine().trim().toCharArray();
				for (int j = 0; j < cs.length; j++) {
					arr[i][j] = cs[j];
				}
				for (int j = cs.length; j < 15; j++) {
					arr[i][j] = '!';
				}
				
			}
			
			
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 5; j++) {
					if(arr[j][i] == '!') sb.append("");
					else sb.append(arr[j][i]);
				}
			}
			
			System.out.printf("#%d %s\n", t, sb.toString());
			
		}
	}
}
