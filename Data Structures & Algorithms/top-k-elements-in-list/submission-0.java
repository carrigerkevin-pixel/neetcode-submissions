class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int frequency = entry.getValue();
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(entry.getKey());
        }
        int[] result = new int[k];
        int index = 0;
        for (int f = buckets.length - 1; f > 0 && index < k; f--) {
            if (buckets[f] == null) {
                continue;
            }
            for (int n : buckets[f]) {
                result[index++] = n;
                if (index == k) {
                    break;
                }
            }
        }
        return result;
    }
}
