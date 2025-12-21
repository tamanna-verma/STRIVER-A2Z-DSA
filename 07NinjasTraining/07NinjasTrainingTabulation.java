// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][]) {
        
       int [][]dp = new int [arr.length][4];
       int arr_len=arr.length;
       
       dp[0][0]= Math.max(arr[0][1],arr[0][2]);
       dp[0][1]= Math.max(arr[0][0],arr[0][2]);
       dp[0][2]= Math.max(arr[0][1],arr[0][0]);
       dp[0][3]= Math.max(arr[0][2],Math.max(arr[0][0],arr[0][1]));
         
         
        for(int day = 1;day<arr_len ;day++){
            for(int prev=0;prev<3;prev++){
                
                int max =Integer.MIN_VALUE;
                for(int task = 0;task<3;task++){
                     if(task!=prev){
                     int points= arr[day][task]+ dp[day-1][task];
                     max = Math.max(max , points);
                     }
                     
                }
                dp[day][prev]=max;
                
            }
        }
        
        return Math.max(dp[arr_len-1][0],Math.max(dp[arr_len-1][1],dp[arr_len-1][2]));
    }
}
