package ADPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ12100 {

	static int[] nums = { 1, 2, 3, 4 };
	static int maxNum;
	static int N;
	static List<ArrayList<Integer>> list;
	static int[][] board;
	static int[][] copyBoard;

	static int stoi(String s) {	return Integer.parseInt(s);	}

	public static void main(String[] args) throws IOException {
		int[] temp = new int[5]; // 최대 5번 이동 //중복순열
		list = new LinkedList<>();
		rePermu(0, temp);
		
		//test case
//		list.add(new ArrayList<>());
//		//2 4 1 4 2
//		list.get(0).add(2);
//		list.get(0).add(4);
//		list.get(0).add(1);
//		list.get(0).add(4);
//		list.get(0).add(2);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());

		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = stoi(st.nextToken().trim());
			}
		} // end input



		maxNum = -1;
		for (int i = 0; i < list.size(); i++) {
			copyBoard = new int[N][N];
			copyOriginalBoard();
			ArrayList<Integer> moveCase = list.get(i);
//			System.out.println("start new case");
			int prev = 0;
			for (int j = 0; j < 5; j++) {
				int cs = moveCase.get(j); // case
				if(cs != prev) prev = cs;
				else if(cs == prev) continue;
				switch (cs) {
				case 1:
//					System.out.println("U" + ":"+cs);
					moveUp();
					break;
				case 2:
//					System.out.println("D"+ ":"+cs);
					moveDown();
					break;
				case 3:
//					System.out.println("L"+ ":"+cs);
					moveLeft();
					break;
				case 4:
//					System.out.println("R"+ ":"+cs);
					moveRight();
					break;
				}
//				printBoard();
			}
			
			findMax();
		}
		System.out.println(maxNum);
	}

	private static void printBoard() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(copyBoard[i][j] +  " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void moveRight() {
		for (int r = 0; r < N; r++) {
			List<Integer> temp = new LinkedList<>();
			for (int c = N-1; c >= 0; c--) {
				if(copyBoard[r][c] != 0)
					temp.add(copyBoard[r][c]);
			} //0이 아닌 모든 수 저장
//			System.out.println("temp : "+temp.toString());
			Queue<Integer> qu = new LinkedList<>();
			
			int idx=0;
			for (; idx < temp.size();) {
				if(idx == temp.size() - 1) {
					qu.add(temp.get(idx));
					break;
				}
//				System.out.println("cur : " + temp.get(idx));
//				System.out.println("next : " + temp.get(idx+1));
				if((int)temp.get(idx) == (int)temp.get(idx + 1)) {
//					System.out.println("1 : " + temp.get(idx));
//					System.out.println("2 : " + temp.get(idx+1));
					qu.add(temp.get(idx) * 2);
					idx+=2;
				}else {
					qu.add(temp.get(idx));
					idx+=1;
				}
			}
			
			idx = N-1;
			while(!qu.isEmpty()) {
//				System.out.println(qu.peek());
				copyBoard[r][idx--] = qu.poll();
			}
			for (int i = idx; i >= 0; i--) {
				copyBoard[r][i] = 0;
			}
		}
	}

	private static void moveLeft() {
		for (int r = 0; r < N; r++) {
			List<Integer> temp = new LinkedList<>();
			for (int c = 0; c < N; c++) {
				if(copyBoard[r][c] != 0)
					temp.add(copyBoard[r][c]);
			} //0이 아닌 모든 수 저장
			
			Queue<Integer> qu = new LinkedList<>();
			
			int idx=0;
			for (; idx < temp.size();) {
				if(idx == temp.size() - 1) {
					qu.add(temp.get(idx));
					break;
				}
				if((int)temp.get(idx) == (int)temp.get(idx + 1)) {
					qu.add(temp.get(idx) * 2);
					idx+=2;
				}else {
					qu.add(temp.get(idx));
					idx+=1;
				}
			}
			
			idx = 0;
			while(!qu.isEmpty()) {
				copyBoard[r][idx++] = qu.poll();
			}
			for (int i = idx; i < N; i++) {
				copyBoard[r][i] = 0;
			}
		}
	}

	private static void moveDown() {
		for (int c = 0; c < N; c++) {
			List<Integer> temp = new LinkedList<>();
			for (int r = N-1; r >= 0; r--) {
				if(copyBoard[r][c] != 0)
					temp.add(copyBoard[r][c]);
			} //0이 아닌 모든 수 저장
			
			Queue<Integer> qu = new LinkedList<>();
			
			int idx=0;
			for (; idx < temp.size();) {
				if(idx == temp.size() - 1) {
					qu.add(temp.get(idx));
					break;
				}
				if((int)temp.get(idx) == (int)temp.get(idx + 1)) {
					qu.add(temp.get(idx) * 2);
					idx+=2;
				}else {
					qu.add(temp.get(idx));
					idx+=1;
				}
			}
			
			idx = N-1;
			while(!qu.isEmpty()) {
				copyBoard[idx--][c] = qu.poll();
			}
			for (int i = idx; i >= 0; i--) {
				copyBoard[i][c] = 0;
			}
		}
	}

	private static void moveUp() {
		for (int c = 0; c < N; c++) {
			List<Integer> temp = new LinkedList<>();
			for (int r = 0; r < N; r++) {
				if(copyBoard[r][c] != 0)
					temp.add(copyBoard[r][c]);
			} //0이 아닌 모든 수 저장
			
			Queue<Integer> qu = new LinkedList<>();
			
			int idx=0;
			for (; idx < temp.size();) {
				if(idx == temp.size() - 1) {
					qu.add(temp.get(idx));
					break;
				}
				if((int)temp.get(idx) == (int)temp.get(idx + 1)) {
					qu.add(temp.get(idx) * 2);
					idx+=2;
				}else {
					qu.add(temp.get(idx));
					idx+=1;
				}
			}
			
			idx = 0;
			while(!qu.isEmpty()) {
				copyBoard[idx++][c] = qu.poll();
			}
			for (int i = idx; i < N; i++) {
				copyBoard[i][c] = 0;
			}
		}
	}

	private static void findMax() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(copyBoard[i][j] > maxNum)
					maxNum = copyBoard[i][j];
			}
		}
	}

	private static void copyOriginalBoard() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copyBoard[i][j] = board[i][j];
			}
		}
	}

	private static void rePermu(int depth, int[] temp) {
		if (depth == 5) {
			list.add(new ArrayList<>());
			for (int i = 0; i < 5; i++) {
				list.get(list.size() - 1).add(temp[i]);
			}
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			temp[depth] = nums[i];
			rePermu(depth + 1, temp);
		}
	}
}
