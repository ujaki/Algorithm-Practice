package ssafy0717;

public class Tetris {

	private int[][] arr = {{1,1,1,0},
						   {0,1,0,0},
						   {0,1,0,0},
						   {0,0,0,0}};
	private int n; //n x n 배열의 크기
	
	public void print() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.printf(" %d", arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void turnRight(int[][] temp) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				temp[j][n-1-i] = arr[i][j];
			}
		}
		arr = temp;
	}
	
	public void turnLeft() {
		
	}
	
	public Tetris() {
		n = arr.length;
	}
	
	public int getArrSize() {
		return this.n;
	}
	
	public static void main(String[] args) {
		Tetris tet = new Tetris();
		int size = tet.getArrSize();
		int[][] temp = new int[size][size];
		
		tet.print();
		tet.turnRight(temp);
		System.out.println();
		tet.print();
	}

}
