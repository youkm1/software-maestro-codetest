https://school.programmers.co.kr/learn/courses/30/lessons/1844 를 정리한것입니다. 

<h2>기존 코드</h2>
import java.util.Stack;
import java.util.*;

class Solution {
    private int n, m;
    private int answer =101;
    private int[] dx = {-1,1,0,0};
    private int[] dy = {0,0,-1,1};
    private boolean[][] visited;
    
    public int solution(int[][] maps) {
        n = maps.length; //세로
        m = maps[0].length; //가로
        visited = new boolean[n][m];
    
        visited[0][0]  = true;
        dfs(maps,0,0,1);
        
    
        return answer == 101 ? -1 : answer;
        
    }
    
    
    private void dfs(int[][] maps,int x, int y, int distance){
        if (x == m - 1 && y == n -1) {              //목적지에 도달한 경우 최단 거리 갱신
            answer = Math.min(answer, distance);
            return;
        }
        //상하좌우이동
        for (int i =1; i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < m && ny < n && maps[ny][nx] == 1 && !visited[ny][nx]){
                visited[ny][nx] = true;
                dfs(maps,nx,ny,distance+1);
                visited[ny][nx] = false;
            }
        }
    }
}

------

<h2>DFS를 쓰는 올바른 방법</h2>
