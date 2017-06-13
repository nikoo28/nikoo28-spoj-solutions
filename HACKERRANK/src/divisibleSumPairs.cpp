#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <unordered_map>

using namespace std;
int main() {

    int n;
    int k;
    cin >> n >> k;
    int a[n];
    int m[k];
    for(int i=0; i<k; i++)
       m[i]=0;
    for(int i = 0; i < n; i++) {
        cin >> a[i];
        m[a[i]%k]++;
    }
    int sum=0;
    sum+=(m[0]*(m[0]-1))/2;
    for(int i=1; i<=k/2 && i!=k-i; i++) {
        sum+=m[i]*m[k-i];
    }
    if(k%2==0)
        sum+=(m[k/2]*(m[k/2]-1))/2;
    cout<<sum;
    return 0;
}

