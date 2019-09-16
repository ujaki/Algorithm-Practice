import java.util.Arrays;

public class RePermutation {

	static int[] nums = { 1, 2, 3, 4};
	
	static int cnt;
	
	public static void main(String[] args) {
		int[] temp = new int[5];
		cnt = 0;
		rePermutation(0, temp);
		System.out.println(cnt);
	}



	private static void rePermutation(int depth, int[] temp) {
		if(depth == 5) {
			System.out.println(Arrays.toString(temp));
			cnt++;
			return;
		}
//		System.out.println("SDfsdfsdf");
		for (int i = 0; i < nums.length; i++) {
			temp[depth] = nums[i];
			rePermutation(depth + 1, temp);
		}
	}

}
