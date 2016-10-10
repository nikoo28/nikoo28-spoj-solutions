#include <stdio.h>
#include <limits.h>

int sum(int pInt[102], int i, int j);

int smoke(int pInt[102], int i, int k, int j);

int main(void) {

    int mixtures = 0;
    while (scanf("%d",&mixtures) == 1) {
        /* process a character */

        int mix[102] = {0};

        for (int i = 0; i < mixtures; ++i) {
            scanf("%d", &mix[i]);
        }

        int matrix[102][102] = {-1};
        for (int counter = 0; counter < mixtures; ++counter) {

            int i = 0;
            for (int j = counter; j < mixtures; ++j) {

                if (i == j) {
                    matrix[i++][j] = 0;
                    continue;
                } else {

                    int min = INT_MAX;
                    for (int k = i; k < j; ++k) {

                        int modValue = smoke(mix, i, k, j);
                        int val = matrix[i][k] + matrix[k + 1][j] + modValue;
                        if (val < min)
                            min = val;
                    }
                    matrix[i++][j] = min;
                }
            }
        }

        printf("%d\n", matrix[0][mixtures - 1]);
    }
    return 0;
}

int smoke(int pInt[102], int i, int k, int j) {
    int x = sum(pInt, i, k);
    int y = sum(pInt, k + 1, j);
    return x * y;
}

int sum(int pInt[102], int i, int j) {

    int modValue = 0;
    for (int k = i; k <= j; ++k) {
        modValue += pInt[k];
    }

    return modValue % 100;
}