import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//삼성 기출, 백준 5373, 큐빙
public class Samsung5373 {

	static int T;
	static int N;
	static String[] commands;

	static char[][] U = new char[3][3];
	static char[][] D = new char[3][3];
	static char[][] F = new char[3][3];
	static char[][] B = new char[3][3];
	static char[][] L = new char[3][3];
	static char[][] R = new char[3][3];

	static char[][] tU = new char[3][3];
	static char[][] tD = new char[3][3];
	static char[][] tF = new char[3][3];
	static char[][] tB = new char[3][3];
	static char[][] tL = new char[3][3];
	static char[][] tR = new char[3][3];

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			initCube();
			N = stoi(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			
			while (st.hasMoreTokens()) {
				String str = st.nextToken();
				char rotate = str.charAt(0);
				char dir = str.charAt(1);

				switch (rotate) {
				case 'U':
					rotateU(dir);
					break;
				case 'D':
					rotateD(dir);
					break;
				case 'F':
					rotateF(dir);
					break;
				case 'B':
					rotateB(dir);
					break;
				case 'L':
					rotateL(dir);
					break;
				case 'R':
					rotateR(dir);
					break;
				}
			}
			printU();
		}

	}

	private static void printU() {
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				System.out.print(R[r][c]);
			} 
			System.out.println();
		}
	}

	private static void rotateR(char dir) {
		if (dir == '+') {

		} else{

		}
	}
///////////
	private static void rotateL(char dir) {
		if (dir == '+') {
			for (int i = 0; i < 3; i++) {  
				tL[2-i][2] = L[0][2-i];
				tL[2][i] = L[2-i][2];
				tL[i][0] = L[2][i];
				tL[0][2-i] = L[i][0];
				
				tF[i][0] = U[i][0];
				
			}
		} else { //반시계
			for (int i = 0; i < 3; i++) {  
				tL[2-i][0] = L[0][i];
				tL[2][2-i] = L[2-i][0];
				tL[i][2] = L[2][2-i];
				tL[0][i] = L[i][2];
				
				
			}
		}
		tL[1][1] = L[1][1];
		//복구
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				L[r][c] = tL[r][c];
			}
		}
		for (int i = 0; i < 3; i++) {
			
		}
	}

	private static void rotateB(char dir) {
		if (dir == '+') {

		} else {

		}
	}

	private static void rotateF(char dir) {
		if (dir == '+') {

		} else {

		}
	}

	private static void rotateD(char dir) {
		if (dir == '+') {
			for (int i = 0; i < 3; i++) {  
				tD[2-i][2] = D[0][2-i];
				tD[2][i] = D[2-i][2];
				tD[i][0] = D[2][i];
				tD[0][2-i] = D[i][0];
				
				tR[2][i] = B[2][i];
				tF[2][i] = R[2][i];
				tL[2][i] = F[2][i];
				tB[2][i] = L[2][i];
			}
		} else { //반시계
			for (int i = 0; i < 3; i++) {  
				tD[2-i][0] = D[0][i];
				tD[2][2-i] = D[2-i][0];
				tD[i][2] = D[2][2-i];
				tD[0][i] = D[i][2];
				
				tL[2][i] = B[2][i];
				tF[2][i] = L[2][i];
				tR[2][i] = F[2][i];
				tB[2][i] = R[2][i];
			}
		}
		tD[1][1] = D[1][1];
		//복구
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				D[r][c] = tD[r][c];
			}
		}
		for (int i = 0; i < 3; i++) {  
			R[2][i] = tR[2][i];
			F[2][i] = tF[2][i];
			L[2][i] = tL[2][i];
			B[2][i] = tB[2][i];
		}
	}

	private static void rotateU(char dir) {
		if (dir == '+') {
			for (int i = 0; i < 3; i++) {  
				tU[2-i][2] = U[0][2-i];
				tU[2][i] = U[2-i][2];
				tU[i][0] = U[2][i];
				tU[0][2-i] = U[i][0];
				
				tR[0][i] = B[0][i];
				tF[0][i] = R[0][i];
				tL[0][i] = F[0][i];
				tB[0][i] = L[0][i];
			}
		} else { //반시계
			for (int i = 0; i < 3; i++) {  
				tU[2-i][0] = U[0][i];
				tU[2][2-i] = U[2-i][0];
				tU[i][2] = U[2][2-i];
				tU[0][i] = U[i][2];
				
				tL[0][i] = B[0][i];
				tF[0][i] = L[0][i];
				tR[0][i] = F[0][i];
				tB[0][i] = R[0][i];
			}
		}
		tU[1][1] = U[1][1];
		//복구
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				U[r][c] = tU[r][c];
			}
		}
		for (int i = 0; i < 3; i++) {  
			B[0][i] = tB[0][i];
			R[0][i] = tR[0][i];
			F[0][i] = tF[0][i];
			L[0][i] = tL[0][i];
		}
	}

	private static void initCube() {
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				R[r][c] = tR[r][c] = 'w';
				D[r][c] = tD[r][c] = 'y';
				F[r][c] = tF[r][c] = 'r';
				B[r][c] = tB[r][c] = 'o';
				L[r][c] = tL[r][c] = 'g';
				R[r][c] = tR[r][c] = 'b';
			}
		}
	}
}
