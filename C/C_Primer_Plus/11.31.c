#include <stdio.h>
int main(int argc, char *atgv [])
{
    int count;

    printf("The command line has %d arguments:\n", argc - 1);
    for (count = 1; count < argc; count++)
        printf("%d: %s\n", count, atgv[count]);\
    printf("\n");

    return 0;
}