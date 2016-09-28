#include <cstdio>
#include <cmath>
#include <algorithm>
#include <iostream>
using namespace std;

#define INF 9999999999.9

struct Point {
    long double x;
    long double y;
    int index;
};

bool xComp(Point a, Point b) {
    return a.x < b.x;
}

bool yComp(Point a, Point b) {
    return a.y < b.y;
}

Point makePoint(double a, double b, int index) {
    Point tmp;
    tmp.x = a;
    tmp.y = b;
    tmp.index = index;
    return tmp;
}

double dist(Point a, Point b) {
    return sqrt((a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y));
}

int indexa,indexb;
double ans = 999999999;

double closestBrute(Point points[], int n) {
    double d = INF;
    for (int i = 0; i < n; ++i) {
        for (int j = i+1; j < n; ++j) {
            double dTemp = dist(points[i], points[j]);
            if (dTemp < d) {
                d = dTemp;
                if (d < ans) {
                    ans = d;
                    indexa = points[i].index;
                    indexb = points[j].index;
                }
            }
        }
    }
    return d;
}

double closest(Point points[], int n) {
    if (n <= 3) return closestBrute(points, n);
    int mid = n/2;
    double left = closest(points, mid);
    double right = closest(points+mid, n-mid);
    double d = min(left, right);
    Point strip[n];
    int stripSize = 0;
    Point midPoint = points[mid];
    for (int i = 0; i < n; ++i) {
        if (abs(points[i].x - midPoint.x) < d) {
            strip[stripSize++] = points[i];
        }
    }
    sort(strip, strip+stripSize, yComp);
    for (int i = 0; i < stripSize; ++i) {
        for (int j = i+1; j < stripSize; ++j) {
            double tempDist = dist(strip[i], strip[j]);
            if (tempDist >= d) break;
            d = tempDist;
            if (d < ans) {
                ans = d;
                indexa = strip[i].index;
                indexb = strip[j].index;
            }
        }
    }
    return d;
}

int main() {
    int n;
    Point points[50001];
    scanf("%d",&n);
    for (int i =0; i < n; ++i) {
        double a,b;
        scanf("%lf%lf", &a,&b);
        points[i] = makePoint(a,b,i);
    }
    sort(points, points+n, xComp);
    double ans = closest(points, n);
    if (indexa > indexb) {
        int tmp = indexa;
        indexa = indexb;
        indexb = tmp;
    }
    printf("%d %d %.6lfn", indexa, indexb, ans);
    return 0;
}