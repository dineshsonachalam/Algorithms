/*
 * Algorithm for Quick Find.
 * Description of the Algorithm:
 * -Integer array id[] of size N.
 * -Interpretation: p and q are connected iff they
 *  have the same id.
 *
 *        0  1  2  3  4  5  6  7  8  9
 *  id[]  0  1  1  8  8  0  0  1  8  8
 *
 *  0  1--2  3--4
 *  |     |  |  |
 *  5--6  7  8  9
 */

#include<stdio.h>

#define TRUE 1
#define FALSE 0
#define N 1000

int connected(int *, int , int);
void unite(int *, int, int, int);

int main(){
    int i, p, q, id[N];

    for(i = 0; i < N; i++)
        id[i] = i;

    while(scanf("%d %d", &p, &q) == 2){
        if(!connected(id, p, q)){
            unite(id, p, q, N);
        }
    }
    printf("connected(1,5) : %d", connected(id, 1,5));
}

int connected(int id[], int a, int b){
     if(id[a] == id[b])
         return TRUE;
     else
         return FALSE;
}

void unite(int id[], int a, int b, int max){
     int i, j, temp;
     id[a] = temp;
     for(i = 0; i < max; i++){
          if(id[a] == temp)
              id[i] = id[b];
     }
}
