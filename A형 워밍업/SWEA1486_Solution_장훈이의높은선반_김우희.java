import java.util.Scanner;

public class Solution_SWEA_장훈이의높은선반 {
	
	public static int[] arr;
	public static int b;
	public static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for (int testCase = 1; testCase <= t; testCase++) {
			min = Integer.MAX_VALUE;
			int n = sc.nextInt();
			b = sc.nextInt();
			
			arr = new int[n];
			boolean[] a = new boolean[n];
 			
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			
			backTrack(a, 0,arr.length);
			System.out.println("#"  + testCase +  " " + min);
		}
	}

	public static void backTrack(boolean[] a, int k, int input) {
		if(k == input) {
			int sum = 0;
			for (int i = 0; i < input; i++) {
				if(a[i]) {
					sum += arr[i];
				}
			}
			
			if(b <= sum) {
				int num = sum - b;
				if(min > num) {
					min = num;
				}
			}
			return;
		} else {
			boolean[] c = new boolean[2];
			int ncand = make_candidates(a,k,input,c);
			for (int i = 0; i < ncand; i++) {
				a[k] = c[i];
				backTrack(a, k+1, input);
			}
		}
	
	}

	public static int make_candidates(boolean[] a, int k, int input, boolean[] c) {
		c[0] = true;
		c[1] = false;
		
		return 2;
	}

}
