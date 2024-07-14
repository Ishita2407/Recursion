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

Time Complexity: O(2^n)+O(2^n log(2^n)). Each index has two ways. You can either pick it up or not pick it. So for n index time complexity for O(2^n) and for sorting it will take (2^n log(2^n)).

Space Complexity: O(2^n) for storing subset sums, since 2^n subsets can be generated for an array of size n.
