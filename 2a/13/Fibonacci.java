class Fibonacci {

// 課題1
    int fibonacciRecursion(int n) { // フィボナッチ数列を求める再帰アルゴリズム
		// 再帰を使ったフィボナッチ数列のアルゴリズムを完成させなさい．
      if (n == 0 || n == 1) {
        return 1;
      } else {
        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
      }
    }
// 課題1　(ここまで)

// 課題2
    int fibonacciDynamic(int n) { // フィボナッチ数列を求めるアルゴリズム
		// 動的計画法を使ったフィボナッチ数列のアルゴリズムを完成させなさい．
      if (n == 0 || n == 1) {
        return 1;
      }
      int[] fib = new int[n + 1];
      fib[0] = 1;
      fib[1] = 1;
      for (int i = 2; i <= n; i++) {
        fib[i] = fib[i - 1] + fib[i - 2];
      }
      return fib[n];
    }
// 課題2　(ここまで)

}