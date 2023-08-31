/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   newfile.h
 * Author: Dimas
 *
 * Created on November 26, 2020, 3:48 PM
 */

#ifndef QUEUE_H_INCLUDED
#define QUEUE_H_INCLUDED
 
void init(int *head, int *tail);
void push(int *q,int *tail, int element);
int pop(int *q,int *head);
int empty(int head,int tail);
int full(int tail,const int size);
void display(int *q,int head,int tail);
#endif // QUEUE_H_INCLUDED