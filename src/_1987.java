
import java.util.Scanner;

public class _1987 {
	static int R;
	static int C;
	static int count;
	static char[][] graph;
	static boolean[][] check;
	static char[] Alpa;
	static int n;
	static boolean compare(char[] x, char y) {
		boolean result=false;
		for(int i=0;i<x.length;i++) {
			if(x[i]==y) {
				result=true;
			}
		}
		return result;
	}
	
	static int DFS(int x, int y) {
		++n;
		if(x<R-1&&check[x+1][y]==false) {
			if(!compare(Alpa, graph[x+1][y])) {
				check[x+1][y]=true;
				Alpa[n]=graph[x+1][y];
				count++;
				DFS(x+1,y);
			}
		}
		if(x>0&&check[x-1][y]==false) {
			if(!compare(Alpa, graph[x-1][y])) {
				check[x-1][y]=true;
				Alpa[n]=graph[x-1][y];
				count++;
				DFS(x-1,y);
			}
		}
		if(y<C-1&&check[x][y+1]==false) {
			if(!compare(Alpa, graph[x][y+1])) {
				check[x][y+1]=true;
				Alpa[n]=graph[x][y+1];
				count++;
				DFS(x,y+1);
			}
		}
		if(y>0&&check[x][y-1]==false) {
			if(!compare(Alpa, graph[x][y-1])) {
				check[x][y-1]=true;
				Alpa[n]=graph[x][y-1];
				count++;
				DFS(x,y-1);
			}
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		R=scan.nextInt();
		C=scan.nextInt();
		Alpa=new char[R*C];
		graph=new char[R][C];
		check=new boolean[R][C];
		n=0;
		for(int i=0;i<R;i++) {
			 String str = scan.next();
	         char ch[]=str.toCharArray();
			for(int j=0;j<C;j++) {
				graph[i][j]=ch[j];
			}
		}
		count=1;
		Alpa[n]=graph[0][0];
		int result=DFS(0,0);
		count=0;
		Alpa=new char[R*C];
		System.out.println(result);
		scan.close();

	}

}
