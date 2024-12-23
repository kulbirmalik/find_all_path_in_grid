import java.util.Scanner;

// We will be given a grid , where we will start from top left corner and need to reach bottom right corner.
// We have cells having values as 0 and 1 , where 1 indicates an obstacle
// We will have to get the min steps to reach the end after k obstacles removal , if not possible return -1.

public class FindMinStepsWithObstacleRemoval {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // No. of obstacles, we can remove
        int k = sc.nextInt();

        int[][] grid = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j] = sc.nextInt();
            }
        }

        boolean[][] vis = new boolean[n][m];
        int steps = findMinStepsWithObstacleRemoval(grid, 0,0, n, m, vis, k);

        // in case we cannot reach the end
        if(steps >= (int)1e8){
            System.out.println(-1);
        }else{
            System.out.println(steps);
        }
    }

    private static int findMinStepsWithObstacleRemoval(int[][] grid, int x, int y, int row, int col, boolean[][] vis, int k){
        if(x<0 || y<0 || x>row-1 || y>col-1 || vis[x][y]){
            return (int)1e8;
        }

        if(grid[x][y] == 1 && k-- <=0){
            return (int)1e8;
        }

        if(x==row-1 && y==col-1){
            return 0;
        }

        vis[x][y] = true;
        int down = findMinStepsWithObstacleRemoval(grid,x+1,y,row,col,vis,k);
        int up = findMinStepsWithObstacleRemoval(grid,x-1,y,row,col,vis,k);
        int right = findMinStepsWithObstacleRemoval(grid,x,y+1,row,col,vis,k);
        int left = findMinStepsWithObstacleRemoval(grid,x,y-1,row,col,vis,k);
        vis[x][y] = false;
        return 1 + Math.min(down, Math.min(up, Math.min(right, left)));
    }

}
