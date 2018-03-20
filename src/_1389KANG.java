import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
/*
 * 이 알고리즘은 플로이드 와샬알고리즘으로도 풀 수 있지만 BFS의 연습을 위해 BFS알고리즘으로 작성함.
 * 알고리즘 순서는 다음과 같다.
 * 1.인접행렬을 만듦.
 * 2.입력받은 N의 개수 만큼 BFS를실행 시키며 BFS는 시작점을 파라미터로 가짐.
 * 3.큐에 거리와 노드를 한꺼번에 저장하기 위하여 큐를 Point 클래스로 생성.
 * 4.큐에 데이터가 없어질 때 까지 계속 BFS를 실행.
 * 5.BFS실행시 경로를 찾으면 거리를 +1로 저장하여 result값을 갱신함.
 * 
 */
public class _1389KANG {
	static int graph[][];
	static boolean check[];
	static int result[];
	static int N,M;
	public static void BFS(int S) {
		Queue<Point> q=new LinkedList<>();// Point를 이용하여 방문 노드와 거리를 큐에 한번에 넣는다.
		check[S]=true;
		Point p=new Point(S, 0);// point 생성 parameter(x,y)
		q.offer(p);
		while(!q.isEmpty()) {
			int now=q.peek().x;// peek메소드는 q에있는 변수를 삭제시키면서 꺼내는것이 아니라 q에있는 데이터는 보존됨.
			int dist=q.poll().y;
			for(int i=1;i<=N;i++) {
				if(graph[now][i]==1 && !check[i]) {
					 p=new Point(i, dist+1);
					 q.offer(p);
	                 check[i]=true;
	                 result[S]+=dist+1;// 거리의 총합을 더함.
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		graph=new int[N+1][N+1];
		result=new int[N+1];
		for(int i=1;i<=M;i++) {
			int SN=scan.nextInt();
			int EN=scan.nextInt();
			graph[SN][EN]=graph[EN][SN]=1;
			
			
		}
		for(int i=1;i<=N;i++) {
			check=new boolean[N+1];
			BFS(i);
		}
		int min = Integer.MAX_VALUE;
        for(int i=1;i<=N;i++){
            if(result[i]<min){
                min = result[i];
            }
        }
        for(int i = 1 ; i<= N ; i++){
            if(result[i]==min){
                System.out.println(i);
                break;
            }    
        }
		
	}

}
