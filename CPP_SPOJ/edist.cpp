#include <stdio.h>
#include <limits.h>

int string_length(char str1[2002]);

int main(void) {

    int cases;
    scanf("%d", &cases);

    int costForDeletion = 1;
    int costForSubstitution = 1;
    int costForAddition = 1;
    int costForCopying = 0;

    while (cases--) {

        char str1[200];
        char str2[200];

        scanf("%s", str1);
        scanf("%s", str2);

        int matrix[200][200];
        int str1Length = string_length(str1);
        int str2Length = string_length(str2);

        for (int i = 0; i <= str1Length; ++i) {
            matrix[0][i] = i;
        }

        for (int j = 0; j <= str2Length; ++j) {
            matrix[j][0] = j;
        }

        for (int k = 1; k <= str2Length; ++k) {

            for (int i = 1; i <= str1Length; ++i) {

                int min = INT_MAX;

                if (str2[k - 1] == str1[i - 1]) {
                    min = matrix[k - 1][i - 1] + costForCopying;
                } else {
                    int val1 = matrix[k - 1][i] + costForDeletion;
                    if (val1 < min)
                        min = val1;

                    val1 = matrix[k][i - 1] + costForAddition;
                    if (val1 < min)
                        min = val1;

                    val1 = matrix[k - 1][i - 1] + costForSubstitution;
                    if (val1 < min)
                        min = val1;
                }
                matrix[k][i] = min;
            }
        }

        printf("%d\n", matrix[str2Length][str1Length]);
    }

    return 0;
}

int string_length(char str[]) {
    int i;
    for (i = 0; i < 2002; i++) {
        if (str[i] == '\0') {
            return (i);
        }
    }
}