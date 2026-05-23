class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int n : nums){
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        for(int key : freqMap.keySet()){
            int freq = freqMap.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] res = new int[k];
        int count = 0;
        for(int pos = bucket.length - 1; pos >= 0 && count < k; pos--){
            if(bucket[pos] != null){
                for(Integer integer : bucket[pos])
                    res[count++] = integer;
            }
        }
        return res;
    }
}
