class Solution {
    private void helper(int index, int[] candidates, int target, List<Integer> arr, List<List<Integer>> ans){
      if(target == 0){
        ans.add(new ArrayList<>(arr));
        return;
      }
      if(target < 0 || index == candidates.length){
        return;
      }

      arr.add(candidates[index]);
      helper(index + 1, candidates, target - candidates[index], arr, ans);
      arr.remove(arr.size() - 1);

      for(int i = index + 1; i < candidates.length; i++){
        if(candidates[i] != candidates[index]){
          helper(i, candidates, target, arr, ans);
          break;
        }
      }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, candidates, target, arr, ans);
        return ans;
    }
}
