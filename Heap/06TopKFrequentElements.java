class Pair{
    int a ;
    int b ;
    Pair(int a , int b){
        this.a = a;
        this.b = b;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.b-y.b);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
           int oldvalue = map.getOrDefault(nums[i],0);
           map.put(nums[i],oldvalue+1);
        }
        for(Integer key:map.keySet()){
           int value = map.get(key);
            Pair pair = new Pair(key,value);
            if(pq.size()<k)
            {
                 pq.offer(pair);
            }else if(pq.peek().b < pair.b){
                pq.poll();
                pq.offer(pair);
            }
             
        }
        int []ans = new int [k];
        for(int i=0;i<k;i++){
           ans[i]=pq.poll().a;
        }
        return ans;
       
    }
}