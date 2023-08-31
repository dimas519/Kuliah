/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

void init(int *head, int *tail){
    *head = *tail = 0;
}

int full(int tail,const int size){
    return tail == size;
}

int push(int *q,int *head){
    return q[(*head)++];
}

void pop(int *q,int *tail, int element){
    q[(*tail)++] = element;
}

void display(int *q,int head,int tail){
    int i = tail - 1;
    while(i >= head)
        printf("%d ",q[i--]);
    printf("\n");
}

int empty(int head, int tail){
    return tail == head;
}
