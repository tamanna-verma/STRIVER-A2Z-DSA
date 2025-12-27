class Solution {
    public int uniquePaths(int m, int n) {
        int dp[] = new int [n];
        for(int i=0;i<m;i++){
             int temp[] = new int[n];
            for(int j=0;j<n;j++){
                 int up=0,left=0,total=0; 
                 
                    if(i<1 || j<1){
                        temp[j]=1;
                    }
                    else {
                         left = temp[j-1];
                         up = dp[j];
                         total = left + up ;
                        temp[j]= total;
                    }                 
            }
            for(int j=0;j<n;j++){
                dp[j]=temp[j];
            }
          }
       return dp [n-1];
}
}
