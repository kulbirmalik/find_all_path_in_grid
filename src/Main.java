import java.util.*;

public class Main {
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

        List<List<Path>> allPaths = new ArrayList<>();
        findAllPaths(grid,0,0,n,m,allPaths,new ArrayList<>(),vis);

        for(List<Path> curPath : allPaths){
            for(Path path : curPath){
                System.out.print(path.toString());
            }
            System.out.println();
        }
    }

    private static void findAllPaths(int[][] grid, int x, int y, int row, int col,List<List<Path>> allPaths, List<Path> curPath, boolean[][] vis){

        if(x<0 || y<0 || x>row-1 || y>col-1 || vis[x][y]){
            return;
        }

        if(x==row-1 && y==col-1){
            List<Path> temp = new ArrayList<>(curPath);
            temp.add(new Path(x,y,grid[x][y]));
            allPaths.add(new ArrayList<>(temp));
            return;
        }

        curPath.add(new Path(x,y,grid[x][y]));
        vis[x][y] = true;
        findAllPaths(grid,x+1,y,row,col,allPaths,curPath,vis);
        findAllPaths(grid,x-1,y,row,col,allPaths,curPath,vis);
        findAllPaths(grid,x,y+1,row,col,allPaths,curPath,vis);
        findAllPaths(grid,x,y-1,row,col,allPaths,curPath,vis);
        vis[x][y] = false;
        curPath.removeLast();
    }

}