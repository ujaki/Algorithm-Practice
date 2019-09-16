package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

//정올 2499, 저울, 그리디
public class JO2499 {

	static Set<Integer> set;
	static int[] inputs;
	static int n;
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = stoi(br.readLine());
		
		inputs = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			inputs[i] = stoi(st.nextToken().trim());
		}
		
		set = new HashSet<>();

		for (int i = 1; i <= n; i++) {
			int[] nums = new int[i];
			makeNumSet(i,0,0, nums);
		}
		
		List<Integer> nlist = new ArrayList<Integer>();
		nlist.addAll(set);
		
		int ret = 0;
		int x = 1;
		for (int i = 0; i < nlist.size(); i++) {
			if(nlist.get(i) == x) {
				x++;
			}else {
				ret = i+1;
				break;
			}
		}
		
		System.out.println(ret);
	}

	private static void makeNumSet(int r, int idx, int target, int[] nums) {
		if(idx == r) {
//			System.out.println(Arrays.toString(nums));
			int sum = 0;
			for (int i = 0; i < r; i++) {
				sum += nums[i];
			}
			set.add(sum);
			return;
		}else if(target == n) return;
		
		nums[idx] = inputs[target];
		makeNumSet(r, idx + 1, target + 1, nums);
		makeNumSet(r, idx, target + 1, nums);
	}
}

/*static TreeSet<Integer> set = new TreeSet<>(); public static void main(String[] args) { int n = 7; int[] array = { 3, 1, 6, 2, 7, 30, 1 }; Arrays.sort(array); for (int num : array) set.add(num); int[] testArray = { 1, 2, 3, 4, 5 }; int[] visited = new int[5]; combi(testArray, visited, 0, 3); } static ArrayList<Integer> list = new ArrayList<>(); public static void combi(int[] array, int[] visited, int pivot, int size) { if (size == 0) { for (int num : list) System.out.printf("%2d", num); System.out.println(); return; } for (int i = pivot; i < array.length; i++) { if (visited[i] == 1) continue; list.add(array[i]); visited[i] = 1; combi(array, visited, pivot + 1, size - 1); list.remove(list.size() - 1); visited[i] = 0; } } }*/
