public class Path {
    int x;
    int y;
    int val;

    public Path(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public String toString(){
        return "(" + this.x + "," + this.y + "," + this.val + ") ";
    }

}
