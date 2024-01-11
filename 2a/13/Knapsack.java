import java.util.ArrayList;

class Knapsack {

	static int value; // 荷物の価値の総和　(出力に使う)
	static ArrayList<Integer> T; // ナップザックに詰め込む荷物の種類が入った配列(出力に使う)

	static void knapSack(int W, ArrayList<Integer>  wt, ArrayList<Integer>  val) 
	// 変数　W: ナップザックの制限重量, wt: 荷物の重さの配列, val: 荷物の価値の配列
	{
				T = new ArrayList<>();
        int n = wt.size();
        int[][] dp = new int[n+1][W+1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (wt.get(i-1) <= w)
                    dp[i][w] = Math.max(val.get(i-1) + dp[i-1][w-wt.get(i-1)], dp[i-1][w]);
                else
                    dp[i][w] = dp[i-1][w];
            }
        }

        value = dp[n][W];

        int w = W;
        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i-1][w]) {
                T.add(i);
                w = w - wt.get(i-1);
            }
        }
	}
}

