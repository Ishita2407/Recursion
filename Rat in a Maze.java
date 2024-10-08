Solution 1


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        int vis[][] = new int[n][n];  // visited array
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                vis[i][j] = 0; // initializing the array with 0
            }
        }
        
        int di[] = {1, 0, 0, -1};
        int dj[] = {0, -1, 1, 0};
        
        ArrayList<String> ans = new ArrayList<>();
        if(m[0][0] == 1){                           // If path is available/unblocked
            solve(0,0, m,n, ans, "", vis, di, dj);
        }
        return ans;
    }
    
    public static void solve(int i, int j, int a[][], int n, ArrayList < String > ans, String move,
    int vis[][], int di[], int dj[]){
        if (i == n - 1 && j == n - 1) {   // reached end succesfully
          ans.add(move);
          return;
        }
        String dir = "DLRU";
        for (int ind = 0; ind < 4; ind++) {
          int nexti = i + di[ind];
          int nextj = j + dj[ind];
          
          // checking boundary conditions. visited or not and 1/0 i.e valid path or not
          if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n &&
            vis[nexti][nextj] == 0 && a[nexti][nextj] == 1) {
    
            vis[i][j] = 1;
            solve(nexti, nextj, a, n, ans, move + dir.charAt(ind), vis, di, dj);
            vis[i][j] = 0;
          }
        }
    }
}


Solution 2
  

// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    private static void solve(int i, int j, int a[][], int n, ArrayList < String > ans, String move,
    int vis[][]) {
    if (i == n - 1 && j == n - 1) {
      ans.add(move);
      return;
    }

    // downward
    if (i + 1 < n && vis[i + 1][j] == 0 && a[i + 1][j] == 1) {
      vis[i][j] = 1;
      solve(i + 1, j, a, n, ans, move + 'D', vis);
      vis[i][j] = 0;
    }

    // left
    if (j - 1 >= 0 && vis[i][j - 1] == 0 && a[i][j - 1] == 1) {
      vis[i][j] = 1;
      solve(i, j - 1, a, n, ans, move + 'L', vis);
      vis[i][j] = 0;
    }

    // right 
    if (j + 1 < n && vis[i][j + 1] == 0 && a[i][j + 1] == 1) {
      vis[i][j] = 1;
      solve(i, j + 1, a, n, ans, move + 'R', vis);
      vis[i][j] = 0;
    }

    // upward
    if (i - 1 >= 0 && vis[i - 1][j] == 0 && a[i - 1][j] == 1) {
      vis[i][j] = 1;
      solve(i - 1, j, a, n, ans, move + 'U', vis);
      vis[i][j] = 0;
    }
  }
    public static ArrayList<String> findPath(int[][] m, int n) {
        int vis[][] = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                vis[i][j] = 0;
            }
        }
        
        ArrayList<String> ans = new ArrayList<>();
        if (m[0][0] == 1) solve(0, 0, m, n, ans, "", vis);
        return ans;
    }
}
