#include <iostream>
#include <algorithm>
using namespace std;

// lower_bound(A, A + N, X)は、配列Aの中でX以上の最初の要素を見つけるためのSTL関数です。これは、ソートされた配列内で二分探索を行います。（注: XがA[N-1]より大きい場合は、A + Nを返す）
// lower_bound(A, A + N, X) - Aは、その要素のインデックスを取得します。これは、lower_boundがイテレータを返すため、配列の先頭イテレータAを引くことでインデックスに変換しています。
// 次に、if (pos < N && A[pos] == X)で、見つけた位置が配列の範囲内にあり、かつその位置の要素がXと等しいかを確認します。もし条件が満たされれば、その位置（インデックス）を返します。
// もし見つけた位置が配列の範囲外であったり、その位置の要素がXと等しくない場合は、-1を返して、Xが配列内に存在しないことを示します。

int search(int A[], int N, int X) {
  int pos = lower_bound(A, A + N, X) - A;
  if (pos < N && A[pos] == X) return pos;
  else return -1;
}

int main() {
  int N, X, A[100000];
  cin >> N >> X;
  for (int i = 0; i < N; i++) cin >> A[i];

  sort(A, A + N); // O(N log N): A[0]からA[N-1]を昇順にソート

  int ans = search(A, N, X);
  cout << ans << endl;
  return 0;
}