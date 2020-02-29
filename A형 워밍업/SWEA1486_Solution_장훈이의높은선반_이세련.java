package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_장훈이의높은선반_D4 {
	public static int cnt;
	public static int B;
	public static int min; 
	public static int[] H;
	public static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 수
		
		for (int test_case = 1; test_case <= T; test_case++) {
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken()); // 점원의 수
			B = Integer.parseInt(st.nextToken()); // 선반의 높이
			H = new int[N]; // 점원의 키를 담을 배열
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < H.length; i++) {
				H[i] = Integer.parseInt(st.nextToken());
			}

			cnt = N;
			arr = new int[N];
			if(N == 1) {
				min = H[0];
			}else {
				powerSet(0);
			}
				
			System.out.println("#"+test_case+" "+ (min-B) );
			///////////////////////////// 출력
			
		}
			
	}
	
	public static void powerSet(int i) {
		
		for (int j = 0; j <= 1; j++) {
			arr[i] = j;
			if(i<cnt-1) {
				powerSet(++i);
				i--;
				continue;
			}

			int sum = 0;
			
			for (int k = 0; k < H.length; k++) {
				if(arr[k] == 1) {
					sum+=H[k];
				}
			}
			if(sum >= B && min >= sum) {
				min=sum;
			}
		}
		
		
	}


}
