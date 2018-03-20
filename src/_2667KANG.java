import java.util.Scanner;
/*
 * 단지 번호로 인접행렬을 바꾸면서 진행하는 알고리즘으로
 * DFS메소드 안에서의 제어 조건은 상하좌우만 움직일 수 있다는 것이다.
 * 또한 DFS메소드 재귀 호출시 count를 +1하여 단지내에 몇가구가 있는지 구하는 문제.
 */
public class _2667KANG {
	static int[][] graph;
	static boolean[][] check;
	static int N;
	static int[] cnt;
	static int count;
	static int DFS(int x, int y,int danji) {
		graph[x][y]=danji;
		if(x<N-1&&graph[x+1][y]==1&&check[x+1][y]==false) {
			check[x+1][y]=true;
			count++;
			DFS(x+1,y,danji);
		}
		if(x>0&&graph[x-1][y]==1&&check[x-1][y]==false) {
			check[x-1][y]=true;
			count++;
			DFS(x-1,y,danji);
		}
		if(y<N-1&&graph[x][y+1]==1&&check[x][y+1]==false) {
			check[x][y+1]=true;
			count++;
			DFS(x,y+1,danji);
		}
		if(y>0&&graph[x][y-1]==1&&check[x][y-1]==false) {
			check[x][y-1]=true;
			count++;
			DFS(x,y-1,danji);
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		cnt=new int[N*N];
		graph=new int[N][N];
		check=new boolean[N][N];
		int danji=0;
		for(int i=0;i<N;i++) {
			 String str = scan.next();
	         char ch[]=str.toCharArray();
			for(int j=0;j<ch.length;j++) {
				graph[i][j]=ch[j]-'0';// char - '0'을 이용하면 아스키코드값을 알 필요없이 int형으로 변환 가능
				                      //Character.getNumervalue(input.charAt(i)) 방법을 이용해도 형변환이 가능하다.
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(graph[i][j]==1&&check[i][j]==false) {
					count=1;
					danji++;
					cnt[danji]=DFS(i,j,danji);
				}
			}
		}
		cnt[1]=cnt[1]-1;
		System.out.println(danji);
		int tmep;
		for(int i=1;i<=danji;i++) {
			for(int j=i+1;j<=danji;j++) {
				if(cnt[i]>=cnt[j]) {
					tmep=cnt[i];
					cnt[i]=cnt[j];
					cnt[j]=tmep;
			
				}
			}
		}
		for(int i=1;i<=danji;i++) {
			System.out.println(cnt[i]);
		}
		scan.close();

	}

}
