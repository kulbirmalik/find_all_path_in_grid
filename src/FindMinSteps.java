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
        System.out.println(findMinSteps(grid, 0,0, n, m, vis));
    }

    private static int findMinSteps(int[][] grid, int x, int y, int row, int col, boolean[][] vis){
        if(x<0 || y<0 || x>row-1 || y>col-1 || vis[x][y]){
            return (int)1e8;
        }

        if(x==row-1 && y==col-1){
            return 0;
        }

        vis[x][y] = true;
        int down = findMinSteps(grid,x+1,y,row,col,vis);
        int up = findMinSteps(grid,x-1,y,row,col,vis);
        int right = findMinSteps(grid,x,y+1,row,col,vis);
        int left = findMinSteps(grid,x,y-1,row,col,vis);
        vis[x][y] = false;
        return 1 + Math.min(down, Math.min(up, Math.min(right, left)));
    }

}
