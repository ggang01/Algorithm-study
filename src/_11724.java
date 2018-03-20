import java.util.Scanner;
 
public class _11724 {
	static int[][] graph;
	static int N,M;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//입력
		N = scan.nextInt();
		M = scan.nextInt();
		graph = new int[N+1][N+1];
		for(int i=1; i<=M; i++) {
			int SN=scan.nextInt();
			int EN=scan.nextInt();
			graph[SN][EN]=graph[EN][SN]=1;
		}
		
		visit = new boolean[N+1];
		int count = 0;
		for(int i=1; i<=N; i++) {
			if(!visit[i]) {
				dfs(i);
				count++;
			}
		}
		System.out.print(count);
	}
	
	
	public static void dfs(int S) {
		visit[S] = true;
		for(int i=1; i<=N; i++) {
			if(graph[S][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
	}
}