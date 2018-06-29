
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Quoc Hung
 */
public class Snake {
    Position[] body;
    int tail;
    int[][] map;
    int direction;
    Random random;
    
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;
    
    public Snake(int[][] map){
        this.body = new Position[400];
        this.map = map;
        this.map[10][10] = 1;
        this.map[10][11] = 1;
        this.body[0] = new Position(10, 10);
        this.body[1] = new Position(10, 11);
        this.tail = 1;
        this.direction = UP;
        random = new Random();
        randomFood();
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
    
    public void randomFood() {
        int ranx, rany;
        do {
            ranx = random.nextInt(20);
            rany = random.nextInt(20);
        } while ( map[ranx][rany] == 1 );
        map[ranx][rany] = 2;
    }
    
    public void showBody(){
        for ( int i = 0; i <= tail; i ++ ) {
            System.out.println(body[i].x+" "+body[i].y);
        }        
        System.out.println("-----------");
    }
    
    public void checkEat() {
        if ( direction == LEFT ) {
            Position temp;
            temp = new Position(body[0].x, body[0].y);
            if ( temp.x > 0 ) temp.x --;
            else temp.x = 19;
            if ( map[temp.x][temp.y] == 2 ) {
                tail ++;
                body[tail] = new Position(body[tail-1].x, body[tail-1].y);
                for ( int i = tail; i > 0; i -- ) {
                    body[i] = new Position(body[i-1].x, body[i-1].y);
                }                
                body[0] = new Position(temp.x, temp.y);
                map[temp.x][temp.y] = 1;
                System.out.println("tail="+tail);
                randomFood();
                showBody();
            }
        }
        else if ( direction == RIGHT ){
            Position temp;
            temp = new Position(body[0].x, body[0].y);
            if ( temp.x < 19 ) temp.x ++;
            else temp.x = 0;
            if ( map[temp.x][temp.y] == 2 ) {
                tail ++;
                body[tail] = new Position(body[tail-1].x, body[tail-1].y);
                for ( int i = tail; i > 0; i -- ) {
                    body[i] = new Position(body[i-1].x, body[i-1].y);
                }                
                body[0] = new Position(temp.x, temp.y);
                map[temp.x][temp.y] = 1;
                System.out.println("tail="+tail);
                randomFood();
                showBody();
            }
        }
        else if ( direction == UP ) {
            Position temp;
            temp = new Position(body[0].x, body[0].y);
            if ( temp.y > 0 ) temp.y --;
            else temp.y = 19;
            if ( map[temp.x][temp.y] == 2 ) {
                tail ++;
                body[tail] = new Position(body[tail-1].x, body[tail-1].y);
                for ( int i = tail; i > 0; i -- ) {
                    body[i] = new Position(body[i-1].x, body[i-1].y);
                }                
                body[0] = new Position(temp.x, temp.y);
                map[temp.x][temp.y] = 1;
                System.out.println("tail="+tail);
                randomFood();
                showBody();
            }
        }
        else if ( direction == DOWN ) {
            Position temp;
            temp = new Position(body[0].x, body[0].y);
            if ( temp.y < 19 ) temp.y ++;
            else temp.y = 0;
            if ( map[temp.x][temp.y] == 2 ) {
                tail ++;
                body[tail] = new Position(body[tail-1].x, body[tail-1].y);
                for ( int i = tail; i > 0; i -- ) {
                    body[i] = new Position(body[i-1].x, body[i-1].y);
                }                
                body[0] = new Position(temp.x, temp.y);
                
                System.out.println("tail="+tail);
                map[temp.x][temp.y] = 1;
                randomFood();
                showBody();
            }
        }
    }
    
    public boolean move(){
        if ( direction == LEFT ) {
            Position temp;
            temp = new Position(body[0].x, body[0].y);
            if ( body[0].x > 0 ) body[0].x --;
            else body[0].x = 19;
            if ( map[body[0].x][body[0].y] == 1) return false;
            for ( int i = 1; i <= tail; i ++ ) {
                Position pos = new Position(body[i].x, body[i].y);
                body[i] = new Position(temp.x, temp.y);
                temp = new Position(pos.x, pos.y);
            }
            for( int i = 0; i < 20; i ++ ){
                for ( int j = 0; j < 20; j ++ ) {
                    if ( map[i][j] == 1 ) map[i][j] = 0;
                }
            }
            for ( int i = 0; i <= tail; i ++ ) map[body[i].x][body[i].y] = 1;
        }
        else if ( direction == RIGHT ) {
            Position temp;
            temp = new Position(body[0].x, body[0].y);
            if ( body[0].x < 19 ) body[0].x ++;
            else body[0].x = 0;
            if ( map[body[0].x][body[0].y] == 1) return false;
            for ( int i = 1; i <= tail; i ++ ) {
                Position pos = new Position(body[i].x, body[i].y);
                body[i] = new Position(temp.x, temp.y);
                temp = new Position(pos.x, pos.y);
            }
            for( int i = 0; i < 20; i ++ ){
                for ( int j = 0; j < 20; j ++ ) {
                    if ( map[i][j] == 1 ) map[i][j] = 0;
                }
            }
            for ( int i = 0; i <= tail; i ++ ) map[body[i].x][body[i].y] = 1;
        }
        else if (direction == UP) {
            Position temp;
            System.out.println("Body");
            showBody();
            System.out.println("---------------------------");
            System.out.println(body[0].y);
            temp = new Position(body[0].x, body[0].y);
            if ( body[0].y > 0 ) body[0].y = body[0].y - 1;
            else body[0].y = 19;
            if ( map[body[0].x][body[0].y] == 1) return false;
            for ( int i = 1; i <= tail; i ++ ) {
                Position pos = new Position(body[i].x, body[i].y);
                body[i] = new Position(temp.x, temp.y);
                temp = new Position(pos.x, pos.y);
            }
            for( int i = 0; i < 20; i ++ ){
                for ( int j = 0; j < 20; j ++ ) {
                    if ( map[i][j] == 1 ) map[i][j] = 0;
                }
            }
            for ( int i = 0; i <= tail; i ++ ) map[body[i].x][body[i].y] = 1;
            System.out.println(body[0].x + " " + body[0].y);
            System.out.println("---------------------------");
        } 
        else if ( direction == DOWN ) {
            Position temp;
            temp = new Position(body[0].x, body[0].y);
            if ( body[0].y < 19 ) body[0].y ++;
            else body[0].y = 0;
            if ( map[body[0].x][body[0].y] == 1) return false;
            for ( int i = 1; i <= tail; i ++ ) {
                Position pos = new Position(body[i].x, body[i].y);
                body[i] = new Position(temp.x, temp.y);
                temp = new Position(pos.x, pos.y);
            }
            for( int i = 0; i < 20; i ++ ){
                for ( int j = 0; j < 20; j ++ ) {
                    if ( map[i][j] == 1 ) map[i][j] = 0;
                }
            }
            for ( int i = 0; i <= tail; i ++ ) map[body[i].x][body[i].y] = 1;
        }
        return true;
    }
    
    
}
