class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                int count = map.get(key);

                map.put(key, count + 1);
            } else {
                map.put(key, 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for(int num : map.keySet()){
            pq.add(num);

            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] result = new int[k];

        for(int i = 0; i < k; i++) {

            result[i] = pq.poll();
        }

        return result;
    }
}
