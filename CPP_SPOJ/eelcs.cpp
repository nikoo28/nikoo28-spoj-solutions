#include <stdio.h>
#include <limits.h>
#include <string.h>

int main(void) {

    char str1[200];
    char str2[200];

    while(scanf("%s", str1)!=EOF && scanf("%s",str2)!=EOF) {

        int str1Length = strlen(str1);
        int str2Length = strlen(str2);

        int mat[202][202];
        for (int i = 0; i < str1Length; ++i) {
            mat[i][0] = 0;
        }

        for (int j = 0; j < str2Length; ++j) {
            mat[0][j] = 0;
        }

        for (int k = 1; k <= str1Length; ++k) {

            for (int i = 1; i <= str2Length; ++i) {

                if (str1[k-1] == str2[i-1]) {
                    mat[k][i] = mat[k-1][i-1] + 1;
                } else {
                    mat[k][i] = (mat[k-1][i] > mat[k][i-1]) ? mat[k-1][i] : mat[k][i-1];
                }
            }
        }

//        printf("  ");
//        for (int m = 0; m < str2Length; ++m) {
//            printf("%c ", str2[m]);
//        }
//        printf("\n");
//
//        for (int l = 1; l <= str1Length; ++l) {
//
//            printf("%c ", str1[l-1]);
//
//            for (int i = 1; i <= str2Length; ++i) {
//                printf("%d ", mat[l][i]);
//            }
//            printf("\n");
//        }

        printf("%d\n", mat[str1Length][str2Length]);
    }
    return 0;
}