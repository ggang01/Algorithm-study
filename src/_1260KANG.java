import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * -DFS란?
 * 	깊이 우선탐색으로
 *  현재 정점에 연결된 정점이 존재하면 계속 이동한다.
 *	방문한 정점을 재귀호출을 이용해서 스택에 저장한다.
 *	재귀호출을 이용하면 할수록 깊은 정점의 위치에 들어간다.
 * -BFS란?
 *  넓이 우선탐색으로
 *  생성된 순서에 따라 노드를 확장한다.
 *  시작 정점을 출발로 큐 구조에 방문한 정점을 넣어가며 탐색을 한다.
 *  한 정점에 연결된 모든 정점의 탐색이 끝나면 그 정점을 큐에서 제거한다.
 *  그리고 큐의 다음 정점을 꺼내서 그 정점에 연결된 모든 정점을 탐색한다.
 *  많은 기억 공간이 필요하다.
 */
public class _1260KANG {
	static int graph[][];
	static boolean check[];
	static int N,M,V;
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		V = scan.nextInt();
		graph=new int[N+1][N+1];
		for(int i=1;i<=M;i++) {
			int SN=scan.nextInt();
			int EN=scan.nextInt();
			graph[SN][EN]=graph[EN][SN]=1;
			
			
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				System.out.print(graph[i][j]);
				if(j==N) {
					System.out.println();
				}
			}
		}
		
		check=new boolean[N+1];
		System.out.println("DFS 정답");
		DFS(V);
		System.out.println();
		check=new boolean[N+1];
		System.out.println("BFS 정답");
		BFS(V);

	}
	static void DFS(int S) {
		check[S]=true;
		System.out.print(S+" ");
		for(int i=1;i<=N;i++) {
			if(graph[S][i]==1&&check[i]==false) {
				DFS(i);//재귀 함수로 자신을 계속 호출해서 점점 더 파고 들어감.
			}
		}
	}	
	static void BFS(int S) {
		Queue<Integer> queue = new LinkedList<Integer>(); 
		int out; 
		queue.offer(S); //큐에 시적점 추가 
		check[S] = true; 
		System.out.print(S+" ");
		while(!queue.isEmpty()) { //큐에 값이 없을때까지 실행 
			out = queue.poll();  //큐에서 값 가져옴
			for(int i=1 ; i<= N ; i++) {
				if(graph[out][i] == 1 && check[i] == false) {
					queue.offer(i); //한 정점에서 갈수 있는 정점을 모두 큐에저장 함
					check[i] = true; 
					System.out.print(i+" "); 
					} 
				} 
			}
				
	}
			

}
