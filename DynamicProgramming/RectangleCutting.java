public class RectangleCutting {
    public static void main(String[] args) {
        
        System.out.println(helper(5,3));

    }
    static int helper(int length,int breadth){
        if(length == breadth) return 0;
        int hori = Integer.MAX_VALUE, vert = Integer.MAX_VALUE;
        for(int i=1;i<breadth ;i++){ // horizontal
            hori = Math.min(1 + helper(length,i) + helper(length,breadth-i) , hori) ;
        }
        for(int i=1;i<length;i++){ // vertical 
           vert = Math.min(vert , 1 + helper(i,breadth) + helper(length-i,breadth));
        }
       
        return Math.min(hori,vert);
    }
}
