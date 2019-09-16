import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BJ17406 배열돌리기 4

public class BJ17406 {
	static int[][] map;
	static int N; // row
	static int M; // col
	static int K; // number of rotating operation
	static Operation[] ops;
	static boolean[] used;
	static Queue<Queue<Operation>> sq;
	static int[] sums; // 각 행의 합계를 저장하는 배열

	static class Operation {
		int r;
		int c;
		int s;

		public Operation(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}

		public String toString() {
			return "[ " + r + ", " + c + ", " + s + " ]";
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(read.readLine(), " ");
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());
		map = new int[N + 1][M + 1]; // original data
		ops = new Operation[K];
		used = new boolean[K];
		sq = new LinkedList<Queue<Operation>>();
		sums = new int[N + 1]; // 각 행의 합계 저장용 배열

		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(read.readLine(), " ");
			for (int m = 1; m <= M; m++) {
				map[n][m] = stoi(st.nextToken());
			}
		}

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(read.readLine(), " ");
			ops[k] = new Operation(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()));
		}

		// 회전 순서의 경우의 수를 순열로 구하여 그 경우들을 sq에 넣기
		LinkedList<Operation> temp = new LinkedList<>();
		for (int i = 1; i <= K; i++) {
			getOpPermutation(i, 0, temp);
		}
		calcSums(); // 각 행의 합계 구하여 sums에 저장
		while (!sq.isEmpty()) {
			int[][] copyMap = new int[N + 1][M + 1];
			copyOriginalMap(copyMap); // 원본 map을 copyMap에 복사
			Queue<Operation> qu = sq.peek(); // 구한 회전 순서 경우의 수중 하나 뽑고 //4?
			int[][] tempMap = new int[N + 1][M + 1];
			while (!qu.isEmpty()) {
				Operation op = qu.peek();
				int tr = op.r - op.s;
				int tc = op.c - op.s;
				int br = op.r + op.s;
				int bc = op.c + op.s;
				// 회전
				rotateMap(tr, tc, br, bc, copyMap, tempMap);
				// 회전 후 값 업데이트
				updateVal(tr, tc, br, bc, copyMap, tempMap);
//				printMap(copyMap);
				qu.poll();
			}
			updateMinValue(copyMap);
			sq.poll();
		}

		System.out.println(getMinValue());
	}

	private static void printMap(int[][] copyMap) {
		for (int n = 1; n <= N; n++) {

			for (int m = 1; m <= M; m++) {
				System.out.print(copyMap[n][m] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void updateMinValue(int[][] copyMap) {
		for (int n = 1; n <= N; n++) {
			int sum = 0;
			for (int m = 1; m <= M; m++) {
				sum += copyMap[n][m];
			}
			sums[n] = Integer.min(sums[n], sum);
		}
	}

	private static void updateVal(int tr, int tc, int br, int bc, int[][] copyMap, int[][] tempMap) {
		for (int r = tr; r <= br; r++) {
			for (int c = tc; c <= bc; c++) {
				copyMap[r][c] = tempMap[r][c];
			}
		}
	}

	private static void rotateMap(int tr, int tc, int br, int bc, int[][] copyMap, int[][] tempMap) {
		// times 가 짝수일 때
		// 3-1 = 2 /2 = 1;
		// 2-1 = 1 /2 = 1;
		// 5-1 = 4 / 2 = 2;
		// 4-1 = 3 / 2 = 1;
		if ((br - tr) == 0) {
			tempMap[tr][tc] = copyMap[tr][tc]; // 가운데 값 복사
			return;
		} else if ((br - tr) % 2 == 0) {
			int times = (br - tr) / 2;
			for (int t = 1; t <= times; t++) {
				int pc = tc; // plus col //top
				int pr = tr; // plus row //right
				int mc = bc; // minus col //bottom
				int mr = br; // minus row //left
				int gap = (bc - tc);
				for (int g = 0; g < gap; g++) {
					tempMap[tr][pc + 1] = copyMap[tr][pc]; // top
					tempMap[pr + 1][bc] = copyMap[pr][bc]; // right
					tempMap[br][mc - 1] = copyMap[br][mc]; // bottom
					tempMap[mr - 1][tc] = copyMap[mr][tc]; // left
					pc++;
					pr++;
					mc--;
					mr--;
				}
				// ------------
				tr++;
				tc++;
				br--;
				bc--;
			}
			tempMap[tr][tc] = copyMap[tr][tc]; // 가운데 값 복사
			return;
		} else { // times 가 홀수일 때
			int times = (br - tr) / 2 + 1;
			// 2-1 = 1 --> 1 / 2 + 1 -> 1
			// 4-1 = 2 --> 2 / 2 + 1 -> 2
			// 6-1 = 5 --> 5 / 2 + 1 -> 3
			// 8-1 = 7 --> 7 / 2 + 1 -> 4
			for (int t = 1; t <= times; t++) {
				int pc = tc; // plus col //top
				int pr = tr; // plus row //right
				int mc = bc; // minus col //bottom
				int mr = br; // minus row //left
				int gap = (bc - tc);
				for (int g = 0; g < gap; g++) {
					tempMap[tr][pc + 1] = copyMap[tr][pc]; // top
					tempMap[pr + 1][bc] = copyMap[pr][bc]; // right
					tempMap[br][mc - 1] = copyMap[br][mc]; // bottom
					tempMap[mr - 1][tc] = copyMap[mr][tc]; // left
					pc++;
					pr++;
					mc--;
					mr--;
				}
				// ------------
				tr++;
				tc++;
				br--;
				bc--;
			}
			return;
		}

	}

	private static void copyOriginalMap(int[][] copyMap) {
		for (int n = 1; n <= N; n++) {
			for (int m = 1; m <= M; m++) {
				copyMap[n][m] = map[n][m];
			}
		}
	}

	private static int getMinValue() {
		int min = Integer.MAX_VALUE;
		for (int n = 1; n <= N; n++) {
			min = Integer.min(min, sums[n]);
		}
		return min;
	}

	private static void calcSums() {
		for (int n = 1; n <= N; n++) {
			int sum = 0;
			for (int m = 1; m <= M; m++) {
				sum += map[n][m];
			}
			sums[n] = sum;
		}
	}

	private static void getOpPermutation(int k, int depth, LinkedList<Operation> q) {
		if (depth == k) {
			Queue<Operation> tq = new LinkedList<>();
			tq.addAll(q);
//			System.out.println(tq);
			sq.add(tq);
			return;
		}

		for (int i = 0; i < K; i++) {
			if (!used[i]) {
				q.add(ops[i]);
				used[i] = true;
				getOpPermutation(k, depth + 1, q);
				used[i] = false;
				q.removeLast();
			}
		}

	}

}
