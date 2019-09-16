import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//SWEA 1213 String, D3
public class SWEA1213 {

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int tNum = stoi(br.readLine());
			String word = br.readLine();
			String statement = br.readLine();
			int wl = word.length();
			int sl = statement.length();
			statement = statement.replaceAll(word, "");
			int asl = statement.length();
			int ret = (sl - asl) / wl;
			// 원래 문장길이 20
			// 단어 길이 2
			// 단어 빼고 남은 길이 16
			System.out.printf("#%d %d\n", tNum, ret);
		}

	}

}
