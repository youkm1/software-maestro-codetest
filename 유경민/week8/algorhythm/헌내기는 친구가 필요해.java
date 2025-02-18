import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static char[][] campus;
    static boolean[][] visited;
		//x가 감소하면서 위로 올라감
		//y가 감소하면서 왼쪽으로 이동
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Deque<int[]> deque = new ArrayDeque<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        campus = new char[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            campus[i] = br.readLine().toCharArray();
            if (deque.isEmpty()) {
                for (int j = 0; j<M;j++){
                    if (campus[i][j] == 'I') {
                        deque.addLast(new int[]{i,j});
                        break;
                    }
                }
            }
        }

        bfs();

        System.out.println(answer > 0 ? answer: "TT");
    }

    static void bfs() {
        while (!deque.isEmpty()) {
            int[] tmp = deque.removeFirst();
            int x = tmp[0];
            int y = tmp[1];
            
            for (int i = 0; i <4;i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                
                if (campus[nx][ny] != 'X' && !visited[nx][ny]) {
                    if (campus[nx][ny] == 'P') {
                        answer++;
                    }
                    visited[nx][ny] = true;
                    deque.addLast(new int[]{nx,ny});
                }
            }
        }
    }
}
