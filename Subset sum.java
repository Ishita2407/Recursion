class Solution {
    public static void subsetSumHelper(int idx, int sum, ArrayList<Integer> arr ,int N,  ArrayList<Integer> sumsubset){
        if(idx == N){
            sumsubset.add(sum);
            return;
        }
        
        // Pick the element
        subsetSumHelper(idx + 1, sum + arr.get(idx), arr, N, sumsubset);
        
        // Don't pick the element
        subsetSumHelper(idx + 1, sum, arr,N,sumsubset);
    }
    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> sumsubset = new ArrayList<>();
        
        subsetSumHelper(0,0,arr, n, sumsubset);
        Collections.sort(sumsubset);
        return sumsubset;
    }
}
