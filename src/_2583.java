import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
 
public class _2583 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] inputs = sc.nextLine().split(" ");
		int M = Integer.valueOf(inputs[0]);
		int N = Integer.valueOf(inputs[1]);
		int K = Integer.valueOf(inputs[2]);
		String[][] xyxy = new String[K][4];
		for(int k=0; k<K; k++) {
			xyxy[k] = sc.nextLine().split(" ");
		}
		
		// map에 상자영역과 빈공간을 구분해줍니다.
		boolean[][] map = new boolean[N][M]; //맵을 90도 회전하여 새로 만들어줍니다.
		for(int k=0; k<K; k++) {
			int x1 = Integer.valueOf(xyxy[k][1]); //회전하면 x,y가 서로 바뀝니다.
			int y1 = Integer.valueOf(xyxy[k][0]);
			int x2 = Integer.valueOf(xyxy[k][3]);
			int y2 = Integer.valueOf(xyxy[k][2]);
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					if(!map[n][m] && y1<=n && n<y2 && x1<=m && m<x2) map[n][m] = true;
				}
			}
		}
		
		//bfs
		Queue<int []> q = new LinkedList<int[]>();
		int[][] dir = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};//위,오른,아래,왼
		int count = 0;
		List<Integer> sizes = new ArrayList<Integer>();
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				if(!map[n][m]) {
					q.offer(new int[]{n,m});
					map[n][m] = true;
					int size = 0;
					while(!q.isEmpty()) {
						int[] pos = q.poll();
						size++;
						for(int d=0; d<dir.length; d++) {
							int[] nextPos = new int[]{pos[0]+dir[d][0],pos[1]+dir[d][1]};
							if(0<=nextPos[0] && nextPos[0]<N && 0<=nextPos[1] && nextPos[1]<M && !map[nextPos[0]][nextPos[1]]) {
								q.offer(nextPos);
								map[nextPos[0]][nextPos[1]] = true;
							}
						}
					}
					sizes.add(size);
					count++;
				}
			}
		}
		Collections.sort(sizes);
		System.out.println(count);
		for(int size : sizes) {
			System.out.print(size+" ");
		}
	}
}