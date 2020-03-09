import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA7793_Solution_오나의여신님_김우희 {
	static int n,m;
	static char[][] str;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	static int Min;
	
	static Queue<Point> devils;
	static Queue<Point> human;
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= t; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			str = new char[n][m];
			devils = new LinkedList<>();
			human = new LinkedList<>();

			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String line = st.nextToken();
				for (int j = 0; j < m; j++) {
					str[i][j] = line.charAt(j);	
					if(str[i][j] == '*') {
						devils.offer(new Point(i, j, 0));
					} else if (str[i][j] == 'S') {
						human.offer(new Point(i, j, 0));
					}
			
				}
			} // end of input
	
			while(true) {
				if(human.size() == 0) {
					System.out.println("#" + testCase + " " + "GAME OVER");
					break;
				}
				
				bfsDevils();
				
				int result = bfsHumans();
				
				if(result != -1){
					System.out.println("#" + testCase + " " + result);
					break;
				}
				
			}
			
		} // end of testCase
		
	} // end of main
	
	private static int bfsHumans() {
		int size = human.size();
		
		while(size-- > 0) {
			Point front = human.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int dr = front.row + dx[i];
				int dl = front.col + dy[i];
				
				if(isIn(dr,dl)) {
					if(str[dr][dl] == 'D') {
						return front.depth+1;
					} else if(str[dr][dl] == '.') {
						str[dr][dl] = 'S';
						human.offer(new Point(dr,dl,front.depth+1));
					}
					
				}
				
			}
			
		}
		return -1;
		
	}

	private static void bfsDevils() {
		int size = devils.size();
		while(size-- > 0) {
			Point front = devils.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int dr = front.row + dx[i];
				int dl = front.col + dy[i];
				
				if(isIn(dr,dl)) {
					if(str[dr][dl] == '.' || str[dr][dl] == 'S') {
						str[dr][dl] = '*';
						devils.offer(new Point(dr,dl,front.depth+1));
					}
					
				}
				
			}
		}
	}

	private static boolean isIn(int r, int l) {
		return r >= 0 && l >= 0 && r < n && l < m;
	}

	static class Point {
		
		int row, col, depth;
		
		public Point(int row, int col, int depth) {
			super();
			this.row = row;
			this.col = col;
			this.depth = depth;
		}
		
		
	}

} // end of class
