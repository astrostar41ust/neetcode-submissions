class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            List<String> list = map.get(sorted);
            if (list == null) {
                list = new ArrayList<>();
                map.put(sorted, list);
            }

            list.add(word);
        }

        return new ArrayList<>(map.values());
    }
}
