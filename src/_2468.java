import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class _2468 {
	public static final int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n][n];
		int maxH = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] > maxH) maxH = map[i][j];
			}
		}
		
		int maxArea = 0;
		for(int i=0; i<maxH; i++) {
			int areaNum = bfs(map, n, i);
			if(maxArea < areaNum) maxArea = areaNum;
		}
		System.out.print(maxArea);
	}
	
	public static int bfs(int[][] info, int n, int rain) {
		int count = 0;
		int[][] map = new int[n][n];
		System.arraycopy(info, 0, map, 0, map.length);
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] <= rain) map[i][j] = -1;
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] isVisit = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!isVisit[i][j] && map[i][j] != -1) {
					q.offer(new int[]{i,j});
					isVisit[i][j] = true;
					while(!q.isEmpty()) {
						int[] nowPos = q.poll();
						for(int d=0; d<dir.length; d++) {
							int[] nextPos = new int[] {nowPos[0]+dir[d][0], nowPos[1]+dir[d][1]};
							if(0<=nextPos[0]&&nextPos[0]<n&&0<=nextPos[1]&&nextPos[1]<n&&map[nextPos[0]][nextPos[1]]!=-1&&!isVisit[nextPos[0]][nextPos[1]]) {
								q.offer(nextPos);
								isVisit[nextPos[0]][nextPos[1]] = true;
							}
						}
					}
					count++;
				}
			}
		}
		return count;				
	}
}