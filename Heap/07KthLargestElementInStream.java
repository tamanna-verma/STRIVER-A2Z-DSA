class KthLargest {

PriorityQueue<Integer> pq = new  PriorityQueue<>();
int k;
    public KthLargest(int k, int[] nums) {
       this.k = k;
        int n=nums.length;
        for(int i=0;i<n;i++){
           pq.add(nums[i]);
           if(pq.size()>k)pq.poll();
        }
    }
    
    public int add(int val) {
           pq.add(val);
           if(pq.size()>k)pq.poll();
           return pq.peek();
       }
    }


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */