//ȿ����ĳ��...

import java.util.Scanner;

public class SWEA3074_Solution_�Ա��ɻ�_������ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int i = 0; i < TC; i++) {
            long N = sc.nextLong(); //�˹�
            long M = sc.nextLong(); //���
            long max = 0;
            long min = Integer.MAX_VALUE;
            long[]a = new long [(int)N]; //�˹��� �迭
            for (int j = 0; j < N; j++) {
                a[j] = sc.nextLong();
                if(max<a[j]) {
                	max=a[j];
                }
                
            }
            long maxT = max*M;
            long minT = 0;
            long ans = maxT;
            while(maxT>=minT) {
            	long mid = (maxT + minT)/2;
            	long sum = 0;
            	for (int j = 0; j < a.length; j++) {
					sum += (mid/a[j]);
				}
            	if(sum<M) {
            		minT = mid+1;
            	}else {
            		ans = Math.min(ans, mid);
            		maxT = mid-1;
            	}
            }
            
            
            System.out.printf("#%d %d\n",i+1,ans);
             
        }
         
    }
}
