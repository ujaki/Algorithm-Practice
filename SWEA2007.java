import java.util.Arrays;
import java.util.Scanner;

//SWEA 2007 패턴 마디의 길이 게임, D2
public class SWEA2007 {
	static int T;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			String str = sc.next().trim();
			ans = getLength(str);
//			System.out.println(str);
			
			System.out.printf("#%d %d\n", t, ans);
		}
	}

	private static int getLength(String s) {
		int ans = 0;
		for (int i = 1; i <= s.length(); i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < i; j++) {
				sb.append(s.charAt(j));
			}
			String strs = s.replaceAll(sb.toString(),"");
//			System.out.println("strs : " + strs);
//			System.out.println("size : " + strs.length());
//			System.out.println("tostring : " + sb.toString());
//			System.out.println("length : " + sb.toString().length());
//			System.out.println("---------------------------");
			if(strs.length() == 0) {
				ans = sb.toString().length();
				break;
			}else {
				if(strs.length() < sb.toString().length()) {
					if(sb.toString().startsWith(strs)) {
						ans = sb.toString().length();
						break;
					}
				}
			}
		}
		return ans;
	}
}
