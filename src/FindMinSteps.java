import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// We will be given a grid , where we will start from top left corner and need to reach bottom right corner.
// We will have to get the min steps to reach the end.

public class FindMinSteps {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] grid = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j] = sc.nextInt();
            }
        }

        boolean[][] vis = new boolean[n][m];

        // using dfs
        //System.out.println(findMinSteps( 0,0, n, m, vis));

        // using bfs
        System.out.println(findMinStepsUsingBfs( 0,0, n, m, vis));
    }

    private static int findMinStepsUsingBfs(int srcx, int srcy, int n, int m, boolean[][] vis){
        Queue<Pair> queue = new LinkedList<>();
        vis[srcx][srcy] = true;
        queue.offer(new Pair(srcx,srcy));

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int steps = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Pair curPair = queue.poll();
                int curx = curPair.x;
                int cury = curPair.y;

                if (curx == n - 1 && cury == m - 1) {
                    return steps;
                }

                for(int j=0;j<4;j++) {
                    int newx = curx + dx[j];
                    int newy = cury + dy[j];

                    if (newx >= 0 && newy >= 0 && newx <= n - 1 && newy <= m - 1 && !vis[newx][newy]) {
                        vis[newx][newy] = true;
                        queue.offer(new Pair(newx, newy));
                    }
                }
            }
            steps++;
        }
        return -1;
    }




    private static int findMinSteps(int x, int y, int row, int col, boolean[][] vis){
        if(x<0 || y<0 || x>row-1 || y>col-1 || vis[x][y]){
            return (int)1e8;
        }

        if(x==row-1 && y==col-1){
            return 0;
        }

        vis[x][y] = true;
        int down = findMinSteps(x+1,y,row,col,vis);
        int up = findMinSteps(x-1,y,row,col,vis);
        int right = findMinSteps(x,y+1,row,col,vis);
        int left = findMinSteps(x,y-1,row,col,vis);
        vis[x][y] = false;
        return 1 + Math.min(down, Math.min(up, Math.min(right, left)));
    }

}
