package com.dsa.facebook;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class SnakeGame {

    Deque<Position> snake;
    Set<Position> body;
    int height;
    int width;
    int [][] food;
    Position head;
    int foodCount;
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {

        this.height = height;
        this.width = width;
        this.food = food;
        snake = new LinkedList<>();
        body = new HashSet<>();
        head = new Position(0,0);
        snake.offer(head);
        body.add(head);
        foodCount = 0;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        Position head = snake.peekFirst();
        int headRow = head.row;
        int headCol = head.col;

        switch(direction){
            case "L" :  headCol--;
                break;
            case "R" :  headCol++;
                break;
            case "U" :  headRow--;
                break;
            case "D" :  headRow++;
                break;
        }

        Position newHead = new Position(headRow,headCol);
        Position currTail = snake.peekLast();

        // breaking the boundary
        if(newHead.row< 0 || newHead.row >= this.height || newHead.col <0 || newHead.col >= this.width)
            return -1;

        // biting himself- He can bite his current tail as after this move its tail will be moved to next position
        body.remove(currTail);
        if(this.body.contains(currTail)){
            return -1;
        }
        body.add(currTail);


        if(this.foodCount < this.food.length && this.food[this.foodCount][0] == newHead.row && this.food[this.foodCount][1] == newHead.col){
            this.foodCount++;
        } else{
            this.body.remove(currTail);
            snake.pollLast();
        }

        this.snake.addFirst(newHead);
        this.body.add(newHead);

        return snake.size()-1;
    }

    public static void main(String[] args) {
        int [][] food ={{2,0},
                        {0,0},
                        {0,2},
                        {0,1},
                        {2,2},
                        {0,1}};

        SnakeGame game = new SnakeGame(3,3,food);
        System.out.println(game.move("D"));//0

        System.out.println(game.move("D"));//1
        System.out.println(game.move("R"));
        System.out.println(game.move("U"));
        System.out.println(game.move("U"));

        System.out.println(game.move("L"));//2
        System.out.println(game.move("D"));
        System.out.println(game.move("R"));
        System.out.println(game.move("R"));

        System.out.println(game.move("U"));//3

        System.out.println(game.move("L"));//4
        System.out.println(game.move("L"));
        System.out.println(game.move("D"));
        System.out.println(game.move("R"));
        System.out.println(game.move("U"));




    }
}

class Position{
    int row;
    int col;

    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }
}
