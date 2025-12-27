class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]= new int [m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        dp[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
              
                 int up=0,left=0; 
                    if(i>=1){
                        up= dp[i-1][j];
                    }
                    if(j>=1){
                        left= dp[i][j-1];
                    }
                    int total =up +left ;
                
                  if(i>0||j>0)  dp[i][j] = total;                
            }
          }
       return dp[m-1][n-1];
}
}
