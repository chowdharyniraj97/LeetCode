
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       if (image==null || image.length==0 || image[sr][sc]==newColor) return image;
        int srColor= image[sr][sc];
        dfs(image, sr,sc, srColor,newColor);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int srColor,int newColor){
        if (sr<0 || sr >= image.length || sc<0 || sc>=image[0].length || image[sr][sc]!=srColor)
            return;
        if (image[sr][sc]==srColor)
            image[sr][sc]=newColor;
        dfs(image,sr-1,sc,srColor,newColor);
        dfs(image,sr+1,sc,srColor,newColor);
        dfs(image,sr,sc+1,srColor,newColor);
        dfs(image,sr,sc-1,srColor,newColor);
        
        
    }
}
