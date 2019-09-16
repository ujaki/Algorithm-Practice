import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SWEA 1974 수도쿠 검증, D2
public class SWEA1974 {
	static int T;
	static int[][] sudoku = new int[9][9];
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = stoi(st.nextToken().trim());
				}
			}
			
			int ret = checkSudoku();
			
			System.out.printf("#%d %d\n",t, ret);
		}
		
		
	}

	private static int checkSudoku() {
		int result = 1;
		//행,열 체크
		for (int i = 0; i < sudoku.length; i++) {
			int sumR = 0; int sumC = 0;
			for (int j = 0; j < sudoku.length; j++) {
				sumR += sudoku[i][j];
				sumC += sudoku[j][i];
			}
			if(sumR != 45 || sumC != 45) return 0;
			else {
//				System.out.println(sumR + " " + sumC);
				continue;
			}
		}
		
		//박스 체크
		int idx=0;
		for (int i = 0; i < 3; i++) {
			int sumA = 0; int sumB = 0; int sumC = 0;
			for (int k = idx; k < idx+3; k++) {
				for (int j = 0; j < 3; j++) {
					sumA += sudoku[k][j];
				}
				for (int j = 3; j < 6; j++) {
					sumB += sudoku[k][j];
				}
				for (int j = 6; j < 9; j++) {
					sumC += sudoku[k][j];
				}
			}
			
			if(sumB != 45 || sumA != 45 || sumC != 45) return 0;
			else {
//				System.out.println(sumA + " " + sumB + " " +sumC);
				idx+=3;
				continue;
			}
		}
		
		
		return result;
	}

}
