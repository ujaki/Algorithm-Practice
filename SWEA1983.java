import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

//SWEA 1983 조교의 성적 매기기, D2
public class SWEA1983 {
	static int T;
	static int N;
	static int K;
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static String[] grades = {"A+", "A0", "A-",
		"B+", "B0", "B-", "C+", "C0", "C-", "D0"};
	
	
	static class Student{
		int num;
		double total;
		String grade = "";
		public Student(int num, double total) {
			this.num = num;
			this.total = total;
		}
		
		public String toString() {
			return " " + total+"("+grade+")" + " "+num;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			N = stoi(st.nextToken().trim());
			K = stoi(st.nextToken().trim());
			
			LinkedList<Student> ss = new LinkedList<>();
			for (int n = 1; n <= N; n++) {
				st = new StringTokenizer(br.readLine().trim());
				int mid = stoi(st.nextToken());
				int fin = stoi(st.nextToken());
				int hw = stoi(st.nextToken());
				double cal = (mid*0.35) + (fin*0.45) + (hw*0.2);
				ss.add(new Student(n, cal));
			}
			
			//내림차순으로 정렬
			ss.sort(new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					if(o1.total > o2.total) return -1;
					else if(o1.total < o2.total) return 1;
					else return 0; 
				}
			});
			
			int idx = -1;
			int div = N / 10; //
			
						
			for (int i = 0; i < ss.size(); i++) {
				if(i % div == 0) idx++;
				ss.get(i).grade = grades[idx];
			}
			
			String ret = "";
			for (int i = 0; i < ss.size(); i++) {
				if(ss.get(i).num == K) {
					ret = ss.get(i).grade;
					break;
				}
			}
			
			System.out.printf("#%d %s\n", t, ret);
//			System.out.println(ss);
			
		}
		
		
	}


}
