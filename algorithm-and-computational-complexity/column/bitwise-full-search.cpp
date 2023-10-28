#include <iostream>
using namespace std;

int main() {
  int N, K, A[10];
  cin >> N >> K;
  for (int i = 0; i < N; i++) cin >> A[i];

  bool exist = false;
  // i: 選び方 (e.g. i = 0: 0b0000000000, i = 2^N - 1: 0b1111111111)
  for (int i = 0; i < (1 << N); i++) {
    int sum = 0;
    for (int j = 0; j < N; j++) {
      // - 方法1. (cf. a04)
      if (i / (1 << j) % 2) {
        sum += A[j]; // j番目のカードに書かれた値を足す
      }
      // - 方法2.
      // if (i & (1 << j)) {
      //   sum += A[j];
      // }
    }
    if (sum == K) {
      exist = true;
      break;
    }
  }

  if (exist) cout << "Yes" << endl;
  else cout << "No" << endl;
  return 0;
}