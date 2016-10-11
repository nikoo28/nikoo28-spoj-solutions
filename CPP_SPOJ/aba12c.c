#include <stdio.h>
#include <limits.h>

int main(void) {

    int cases;
    scanf("%d", &cases);

    while (cases--) {
        int n, k;
        scanf("%d %d", &n, &k);

        int v[102];
        v[0] = -1;
        for (int i = 1; i <= k; ++i) {
            scanf("%d", &v[i]);
        }

        int c[102];
        c[0] = 0;
        c[1] = v[1];
        for (int j = 2; j <= k; ++j) {

            int min = INT_MAX;
            for (int i = 1; i <= j; ++i) {

                if (v[i] == -1 || c[j - 1] == -1)
                    continue;

                int val = v[i] + c[j - i];
                if (val < min)
                    min = val;
            }
            c[j] = min;

        }

        if (k == 0)
            printf("0\n");
        else {
            if (c[k] > 21474836 || c[k] < -21474836)
                printf("-1\n");
            else
                printf("%d\n", c[k]);
        }
    }
    return 0;
}