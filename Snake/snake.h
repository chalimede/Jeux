/*
 * Copyright(C) 2024, Charles Theetten, <chalimede@proton.me>
 *
 */

#ifndef _SNAKE_H_
#define _SNAKE_H_

#include <stdbool.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <ncurses.h>

#define HEIGHT  30
#define WIDTH   80

#define DELAY   100000

#define SIZE    512

typedef enum Direction {NORTH, EAST, SOUTH, WEST} Direction;

typedef struct {
    int     x;
    int     y;
}           Entity;

typedef struct {
    int         state;
    int         right;
    int         bottom;
    int         length;
    int         score;
    Entity      food;
    Entity      snake[SIZE];
    Entity      tail;
    Direction   direction;
}               Game;

WINDOW          *create_win(int , int, int, int);

void            init(Game *);
void            init_borders(Game *);
void            init_food(Game *);
void            init_snake(Game *, int, int);

void            generate_food(Game *);
void            eat_food(Game *);
void            update_snake(Game *);
void            end_game(Game *);

void            handle_inputs(Game *);

void            render(Game *);

void            quit(Game *);
void            run(Game *);
void            reset(Game *);
void            start(Game *);

#endif