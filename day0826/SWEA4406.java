package day0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//SWEA 4406 모음이 보이지 않는 사람, D3
public class SWEA4406 {
	static int T;
	static final char[] mo = { 'a', 'e', 'i', 'o', 'u' };

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());

		for (int t = 1; t <= T; t++) {
			String str = br.readLine().trim();

			for (int i = 0; i < mo.length; i++) {
				str = str.replace(mo[i] + "", "");
			}

			System.out.printf("#%d %s\n", t, str);

		}
	}
}
