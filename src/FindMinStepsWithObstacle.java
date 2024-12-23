import java.util.Scanner;

// We will be given a grid , where we will start from top left corner and need to reach bottom right corner.
// We have cells having values as 0 and 1 , where 1 indicates an obstacle
// We will have to get the min steps to reach the end , if not possible return -1.

public class FindMinStepsWithObstacle {

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
        // if final cell is an obstacle we cannot reach the end
        if(grid[n-1][m-1] == 1){
            System.out.println(-1);
        }else{
            int steps = findMinStepsWithObstacle(grid, 0,0, n, m, vis);

            // there can be cases where right most cell contains 0 , but we cannot reach it
            if(steps >= (int)1e8){
                System.out.println(-1);
            }else{
                System.out.println(steps);
            }
        }
    }

    private static int findMinStepsWithObstacle(int[][] grid, int x, int y, int row, int col, boolean[][] vis){
        if(x<0 || y<0 || x>row-1 || y>col-1 || vis[x][y]){
            return (int)1e8;
        }

        if(grid[x][y] == 1){
            return (int)1e8;
        }

        if(x==row-1 && y==col-1){
            return 0;
        }

        vis[x][y] = true;
        int down = findMinStepsWithObstacle(grid,x+1,y,row,col,vis);
        int up = findMinStepsWithObstacle(grid,x-1,y,row,col,vis);
        int right = findMinStepsWithObstacle(grid,x,y+1,row,col,vis);
        int left = findMinStepsWithObstacle(grid,x,y-1,row,col,vis);
        vis[x][y] = false;
        return 1 + Math.min(down, Math.min(up, Math.min(right, left)));
    }

}
