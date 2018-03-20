import java.util.*;
 
 
public class _1707 {
    static ArrayList<Integer>[] graph=(ArrayList<Integer>[])new ArrayList[20001];
    static int color[]=new int[20001];
     
    static void dfs(int x, int c){
        color[x] = c;
        for(int i=0; i<graph[x].size();i++){
            int tmp = graph[x].get(i);
            if(color[tmp]==0){
                dfs(tmp,3-c);
            }
             
        }
    }
     
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int T=scan.nextInt();
        while(T-->0){//t와 0을 비교하고 t를 뺌.
            int n,m;
            n=scan.nextInt();
            m=scan.nextInt();
            for(int i=1;i<=n;i++){
            	graph[i]=new ArrayList<Integer>();//리스트를 배열로 만들어 첫번째 인덱스에 갈수 있는 모든 노드를 할당함.
                color[i]=0;//dfs진행시 같으컬러여야만 이분 그래프임
            }
            for(int i=0;i<m;i++){
                int u,v;
                u=scan.nextInt();
                v=scan.nextInt();
                graph[u].add(v);
                graph[v].add(u);
            }
            for(int i=1;i<=n;i++){
                if(color[i]==0)
                    dfs(i,1);
                 
            }
            boolean check=true;
            for(int i=1;i<=n;i++){
                for(int k=0;k<graph[i].size();k++){
                    int j=graph[i].get(k);
                    if(color[i]==color[j])
                        check=false;
                }
            }
            System.out.println(check?"YES":"NO");
        }
         
    }
     
}

