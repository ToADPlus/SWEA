
import java.util.Arrays;
import java.util.Scanner;
 
public class SWEA1486_Solution_김형준 {
    public static int ans = Integer.MAX_VALUE;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int i = 0; i < TC; i++) {
            int N = sc.nextInt();// 점원
            int B = sc.nextInt();// 높이 b이상인 탑중에서 가장 낮은탑
            int[] co = new int[N];
            int[] arr = new int[N];
             
            int k;
            int sum = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length; j++) {
                arr[j] = sc.nextInt();
                sum +=arr[j];
             
            }
            com(arr,0,B,0,co,0,ans);
            System.out.printf("#%d %d\n",i+1,ans-B);
            ans = Integer.MAX_VALUE;
         
        }
         
         
         
         
         
         
    }
     
    public static void com(int []arr,int dep, int B, int idx, int []co, int pick,int min) {
 
        int sum = 0;
        if(pick==arr.length){
             for (int i = 0; i < dep; i++) {
                //System.out.print(co[i]);
                sum+=co[i];
            }//System.out.println();
            if(sum>=B) {
                if(ans>=sum) {
                    ans =sum;
                }
                 
            }
             
             
            //System.out.println(Arrays.toString(co));
            return;
        }else {
            co[dep] = arr[idx];
 
            com(arr,dep+1,B,idx+1,co,pick+1,min); //뽑
 
             
            com(arr,dep,B,idx+1,co,pick+1,min);//안뽑
             
             
             
        }
    }
     
     
 
}