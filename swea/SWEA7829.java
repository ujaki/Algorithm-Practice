package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//7829 D4, 보물왕 태혁
public class SWEA7829 {

	static int T;
	static int[] nums;
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			int P = stoi(br.readLine().trim());
			nums = new int[P];
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			for (int p = 0; p < P; p++) {
				nums[p] = stoi(st.nextToken().trim());
			}
			Arrays.sort(nums);
			
			int first = nums[0];
			int last = nums[nums.length-1];
			
			int pm = first * last; //pivot minus
			int pp = first * last; //pivot plus
			int N = 0;
			
			while(true) {
				boolean flag = false;
				for (int p = 0; p < P; p++) {
					if(pm % nums[p] != 0)
						flag = true;
				}
				if(flag) pm--;
				else {
					N = pm;
					break;
				}
				
				flag = false;
				for (int p = 0; p < P; p++) {
					if(pp % nums[p] != 0)
						flag = true;
				}
				if(flag) pp++;
				else {
					N = pp;
					break;
				}
			}
			System.out.printf("#%d %d\n", t, N);
			
		} 
		
		
		
	}

}
