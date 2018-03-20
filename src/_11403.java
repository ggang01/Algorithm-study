import java.util.Scanner;

public class _11403 {
	static int graph[][];
	static int result[][];
	static int N;
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		N = scan.nextInt();
		graph=new int[N+1][N+1];
		result=new int[N+1][N+1];
		//행렬만들기
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				graph[i][j]=scan.nextInt();
			}	
			
		}
		for(int i=1;i<=N;i++) {
			int [] check=new int[N+1];
			DFS(i,check,true);
			result[i]=check;
		}
		//정답 행렬 출력
		for(int i=1;i<result.length;i++) {
			for(int j=1;j<result.length;j++) {
				System.out.print(result[i][j]+" ");
				if(j==result.length-1) {
					System.out.println();
				}
			}
		}

	}
	static void DFS(int S,int[] check,boolean isFirst) {
		if(!isFirst) {
			check[S]=1;//이조건을 안하면 다시 돌아오는 것이 안됨.
		}
			for(int i=1;i<=N;i++) {
				if(graph[S][i]==1 && check[i]==0) {
					DFS(i,check,false);
			}	
			
		}
		
	}	
}
