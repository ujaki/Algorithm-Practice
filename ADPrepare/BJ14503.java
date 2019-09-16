package ADPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14503 {
	static int N,M;
	static int ret;
	static int map;
	
	static class Robot{
		int x;
		int y;
		int dir;
		
		public Robot(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			//0 : north, 1 : east
			//2 : south, 3 : west
		}
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = stoi(st.nextToken().trim());
		M = stoi(st.nextToken().trim());
		
		st = new StringTokenizer(br.readLine(), " ");
		int x = stoi(st.nextToken().trim());
		int y = stoi(st.nextToken().trim());
		int dir = stoi(st.nextToken().trim());
		Robot robot = new Robot(x, y, dir);
		
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				
			}
		}
		
		
		
		
		
		
		ret = 0;
		Queue<Robot> qu = new LinkedList<>();
		qu.add(robot);
		
		while(!qu.isEmpty()) {
			Robot curRobot = qu.poll();
			int cx = curRobot.x;
			int cy = curRobot.y;
			int cdir = curRobot.dir;
			
			
			
			
		}
		
		
		
		
		
		System.out.println(ret);
	}

}
