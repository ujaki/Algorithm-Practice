import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//SWEA 7701 염라대왕의 이름 정렬, D4
public class SWEA7701 {
	static int T;
	static int N;
	static Set<String> nameSet;
	static List<String> nameList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			nameSet = new HashSet<>();
			nameList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				nameSet.add(sc.next().trim());
			}
			
			for (String name : nameSet) {
				nameList.add(name);
			}
//			System.out.println("size  : " + nameList.size());
			nameList.sort(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
//					if(o1 -)
					return o1.compareTo(o2);
				}
			});
			
			System.out.println("#"+t);
			for (int i = 0; i < nameList.size(); i++) {
				if(i == nameList.size() - 1) {
					System.out.print(nameList.get(i));
					break;
				}
				System.out.println(nameList.get(i));
			}
			
		}
		
	}
}
