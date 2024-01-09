/*
 * Copyright(C) 2024, Charles Theetten, <chalimede@proton.me>
 *
 */

#include "snake.h"


static WINDOW   *win    = { 0 };
static WINDOW   *infos  = { 0 };


WINDOW          *create_win(int height, int width, int y, int x) {
    WINDOW      *w    = NULL;

    w = newwin(height, width, y, x);
    box(w, 0, 0);
    wrefresh(w);

    return w;
}

void            init(Game *game) {
    srand(time(NULL));
    game->state     = 'r';
    game->direction = WEST;
    game->length    = 8;
    game->score     = 0;
    init_borders(game);
    init_food(game);
    init_snake(game, 10, 50);
}

void            init_borders(Game *game) {
    game->right     = WIDTH;
    game->bottom    = HEIGHT;
}

void            init_food(Game *game) {
    game->food.x    = 10;
    game->food.y    = 10;
}

void            init_snake(Game *game, int x, int y) {
    game->snake[0].x = x;
    game->snake[0].y = y;

    for (int i = 1; i < game->length; i++) {
        y++;
        game->snake[i].x = x;
        game->snake[i].y = y;
    }
}

void            eat_food(Game *game) {
    if (game->snake[0].x == game->food.x && game->snake[0].y == game->food.y) {
        game->snake[game->length].x = game->tail.x;
        game->snake[game->length].y = game->tail.y;
        game->length++;
        game->score++;
        generate_food(game);
    }
}

void            generate_food(Game *game) {
    int         array_x[HEIGHT] = { [0 ... HEIGHT - 1] = -1 };
    int         array_y[WIDTH]  = { [0 ... WIDTH - 1] = -1 };
    int         row             = 1 + (rand() % (HEIGHT - 2));
    int         col             = 0;

    for (int i = 1; i < game->length; i++) {
        array_x[game->snake[i].x] = game->snake[i].x;
        array_y[game->snake[i].y] = game->snake[i].y;
    }
    if (array_x[row] == -1) {
        col = 1 + (rand() % (WIDTH - 2));
        game->food.x = row;
        game->food.y = col;
    } else {
        for (col = 0; col < WIDTH; col++) {
            if (array_y[col] != -1) break;
        }
        game->food.x = row;
        game->food.y = col - 1;
    }
}

void            update_snake(Game *game) {
    game->tail.x = game->snake[game->length - 1].x;
    game->tail.y = game->snake[game->length - 1].y;

    for (int i = game->length - 1; i > 0; i--) {
        game->snake[i].x = game->snake[i - 1].x;
        game->snake[i].y = game->snake[i - 1].y;
    }

    if (game->direction == NORTH) {
        game->snake[0].x--;
    } else if (game->direction == WEST) {
        game->snake[0].y--;
    } else if (game->direction == SOUTH) {
        game->snake[0].x++;
    } else if (game->direction == EAST) {
        game->snake[0].y++;
    }
}

void            end_game(Game *game) {
    if (game->snake[0].y <= 0 || game->snake[0].x <= 0) {
        game->state = 'q';
    } else if (game->snake[0].y >= game->right || game->snake[0].x >= game->bottom) {
        game->state = 'q';
    }
}

void            handle_inputs(Game *game) {
    int         ch = wgetch(win);

    switch (ch) {
        case KEY_UP:
            game->direction = NORTH;
            break;
        case KEY_RIGHT:
            game->direction = EAST;
            break;
        case KEY_DOWN:
            game->direction = SOUTH;
            break;
        case KEY_LEFT:
            game->direction = WEST;
            break;
        case 'q':
            game->state = 'q';
            break;
        case 'r':
            game->state = 'r';
            break;
        default:
            break;
    }
}

void            render(Game *game) {
    werase(win);
    box(win, 0, 0);
    mvwprintw(win, game->food.x, game->food.y, " ");

    for (int i = 0; i < game->length; i++) {
        mvwprintw(win, game->snake[i].x, game->snake[i].y, " ");
    }

    wrefresh(win);

    werase(infos);
    mvwprintw(infos, 1, 1, " Q: QUIT  ");
    mvwprintw(infos, 2, 1, " R: RESET ");
    mvwprintw(infos, 3, 1, " S: START ");
    mvwprintw(infos, 3, 57, " J E U  DU  S N A K E ");
    mvwprintw(infos, 2, 32, " SCORE:  %d ", game->score);
    box(infos, 0, 0);
    wrefresh(infos);
}

void            quit(Game *game) {
    game->state = 'q';
}

void            reset(Game *game) {
    init(game);
    render(game);
}

void            run(Game *game) {
    while (game->state == 's') {
        handle_inputs(game);
        eat_food(game);
        update_snake(game);
        render(game);
        end_game(game);
        usleep(DELAY);
    }
}

void            start(Game *game)
{
    reset(game);

    while (game->state != 'q') {
        switch (game->state) {
            case 's':
                nodelay(win, true);
                run(game);
                break;
            case 'r':
                nodelay(win, false);
                reset(game);
                game->state = wgetch(win);
                break;
            default:
                break;
        }
    }
}

int             main(int argc, char *argv[]) {
    Game        game = { 0 };

    initscr();
    cbreak();
    curs_set(false);

    win   = create_win(30, 80, 15, 20);
    infos = create_win(5, 80, 50, 20);

    start_color();
    init_pair(1, COLOR_WHITE, COLOR_BLACK);
    wbkgd(win, COLOR_PAIR(1));
    wattron(win, A_REVERSE);
    wattron(infos, A_REVERSE);

    keypad(win, true);

    start(&game);
    delwin(win);
    delwin(infos);
    endwin();

    return 0;
}
