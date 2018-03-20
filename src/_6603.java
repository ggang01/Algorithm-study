import java.util.*;
public class _6603 {
    static int n;
    static int a[];
    static void go(int index, int cnt, String ans){
        if(index==n){
            if(cnt==6)
                System.out.println(ans);
            return;//리턴하여 go의 두번째 메소드 호출 문으로 감.
        }
        go(index+1, cnt+1, ans+a[index]+" ");
        go(index+1, cnt, ans);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            n = scan.nextInt();
            if(n==0) break;
            a = new int[n];
            for(int i=0; i<n; i++)
                a[i] = scan.nextInt();
            go(0,0,"");
            System.out.println();
        }
    }
}

