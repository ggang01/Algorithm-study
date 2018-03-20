import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class _1697 {
	static int N,K;
	static boolean check[];
	static int dist[];
	public static final int max = 100000;
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		N = scan.nextInt();
		K = scan.nextInt();
		go(N);

	}
	static void go(int S) {
		check=new boolean[max+1];
		dist=new int[max+1];
		check[S]=true;
		dist[S]=0;
		Queue<Integer> queue = new LinkedList<Integer>(); 
		queue.offer(S); 
		while(!queue.isEmpty()) {
				int su=queue.poll();
				if(su-1>=0) {
					if(check[su-1]==false) {// 갔던곳은 다시 안감.
						queue.offer(su-1);
						check[su-1]=true;
						dist[su-1]=dist[su]+1;// 몇번째 이동인지
						System.out.println(dist[su-1]);
					}
					
				}
				if(su+1<=max) {
					if(check[su+1]==false) {// 갔던곳은 다시 안감.
						queue.offer(su+1);
						check[su+1]=true;
						dist[su+1]=dist[su]+1;// 몇번째 이동인지
						System.out.println(dist[su+1]);
					}
			
				}
				if(su*2<=max) {
					if( check[su*2]==false) {// 갔던곳은 다시 안감.
						queue.offer(su*2);
						check[su*2]=true;
						dist[su*2]=dist[su]+1;// 몇번째 이동인지
						System.out.println(dist[su*2]);
					}
					
				}
		}
		System.out.println(dist[K]);
		
	}	

}
