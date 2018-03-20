import java.util.Scanner;

public class _1012 {
	static int[][] graph=new int[51][51];
	static boolean[] check=new boolean[51];
	static  int M;
	static  int N;
	static  int K;
	static int[] cnt;
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int T=scan.nextInt();
		cnt=new int[T];
		for(int i=0;i<T;i++) {
			M=scan.nextInt();
			N=scan.nextInt();
			K=scan.nextInt();
			for(int j=0;j<K;j++) {
				int X=scan.nextInt();
				int Y=scan.nextInt();
				graph[X][Y]=1;
			}
			for(int m=0;m<M;m++) {
				for(int n=0;n<N;n++) {
					if(graph[m][n]==1) {
						cnt[i]++;
						DFS(m,n);
					}
				}
			}
		}
		for(int i=0;i<cnt.length;i++) {
			System.out.println(cnt[i]);
		}
		
		
	}
	static void DFS(int x, int y) {
		//DFS는 조건을 모두 적고 그것을 다 만족 했을 때 DFS 하나의 메소드 실행이 종료 됨 즉 상하좌우 탐색 후 다음 좌표 검색
		graph[x][y]=0;
		if(x<M-1&&graph[x+1][y]==1) {
			DFS(x+1,y);
		}
		if(x>0&&graph[x-1][y]==1) {
			DFS(x-1,y);
		}
		if(y<N-1&&graph[x][y+1]==1) {
			DFS(x,y+1);
		}
		if(y>0&&graph[x][y-1]==1) {
			DFS(x,y-1);
		}
	}	

}
