package A_230719;
import java.util.*;
public class PRG_가장먼노드_정승혜 {
    public int solution(int n, int[][] edge) {
        int[] dist = new int[n+1]; // 거리 저장
        int max = 0; // 최대 거리
        ArrayList<Integer>[] adjList = new ArrayList[n+1];

        for(int i = 1; i <= n; i++) adjList[i] = new ArrayList<Integer>();
        for(int[] e : edge){
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }

        Queue<Integer> q = new LinkedList<>(); //BFS
        q.offer(1);
        dist[1] = 1;
        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int arr : adjList[tmp]){
                if(dist[arr] == 0) {
                    q.offer(arr);
                    dist[arr] = dist[tmp] + 1;
                    max = Math.max(dist[arr], max);
                }
            }
        }

        int result = 0;
        for(int i = 2; i <= n ; i++) if(dist[i] == max) result++;
        return result;
    }
}
