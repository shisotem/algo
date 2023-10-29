#include <iostream>
#include <algorithm>
using namespace std;

int binary_search(int A[], int N, int X) {
  int left = 0, right = N - 1;
  while (left <= right) {
    int mid = (left + right) / 2;
    if (A[mid] == X) return mid;
    if (A[mid] > X) right = mid - 1;
    if (A[mid] < X) left = mid + 1;
  }
  return -1; // not found
}

int main() {
  int N, X, A[100000];
  cin >> N >> X;
  for (int i = 0; i < N; i++) cin >> A[i];

  sort(A, A + N); // O(N log N): A[0]からA[N-1]を昇順にソート

  int ans = binary_search(A, N, X);
  cout << ans << endl;
  return 0;
}