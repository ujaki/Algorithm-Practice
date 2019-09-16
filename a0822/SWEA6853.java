package a0822;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SWEA 6853 직사각형과 점, D3
public class SWEA6853 {
	static int T;
	static int x1,y1,x2,y2;
	static int inside, online, outside;
	static int N;
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			x1 = stoi(st.nextToken().trim());
			y1 = stoi(st.nextToken().trim());
			x2 = stoi(st.nextToken().trim());
			y2 = stoi(st.nextToken().trim());
			
			N = stoi(br.readLine());
			inside = 0;
			online =0;
			outside =0;
			
			
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine(), " ");	
				int tx = stoi(st.nextToken().trim());
				int ty = stoi(st.nextToken().trim());
				check(tx,ty);
			}
			
			System.out.printf("#%d %d %d %d\n", t, inside, online, outside);
		}
	}

	private static void check(int tx, int ty) {
		if(x1 < tx && tx < x2 && y1 < ty && ty < y2) {//in
			inside++; return; 
		}
		else if(tx < x1 || tx > x2 || ty < y1 || ty > y2) { //out
			outside++;
			return;
		}
		else if(x1 <= tx && tx <= x2 && (ty == y1 || ty ==y2)) { //on
			online++;
			return;
		}else if(y1 <= ty && ty <= y2 && (tx == x1 || tx ==x2)) { //on
			online++;
			return;
		}
		
	}
		
}
