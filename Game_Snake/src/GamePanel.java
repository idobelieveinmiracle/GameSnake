
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Quoc Hung
 */
public class GamePanel extends JPanel implements KeyListener, Runnable{
    
    Thread thread;
    int posx, posy;
    int[][] map;
    int rectSize;
    int windowSize;
    
    Snake snake;
    
    public GamePanel() {
        map = new int[20][20];
        rectSize = 20;
        windowSize = 400;
        snake = new Snake(map);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fillRect(0, 0, windowSize, windowSize);
        g2.setColor(Color.red);
        g2.drawString(String.valueOf(snake.tail+1), 0, 20);
        for ( int i = 0; i < 20; i ++ ) {
            for ( int j = 0; j < 20; j ++ ) {
                if ( map[i][j] == 1 ) {
                    g2.setColor(Color.gray);
                    g2.fillRect(i*rectSize, j*rectSize, rectSize, rectSize);
                }
                if ( map[i][j] == 2 ) {
                    g2.setColor(Color.red);
                    g2.fillRect(i*rectSize, j*rectSize, rectSize, rectSize);
                }
            }
        }
    }
    
    public void startGame(){        
        thread = new Thread(this);
        thread.start();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if ( keyCode == KeyEvent.VK_UP ) {
            if ( snake.getDirection() != Snake.DOWN ) snake.setDirection(Snake.UP);
        }
        if ( keyCode == KeyEvent.VK_DOWN ) {
            if ( snake.getDirection() != Snake.UP ) snake.setDirection(Snake.DOWN);
        }
        if ( keyCode == KeyEvent.VK_LEFT ) {
            if ( snake.getDirection() != Snake.RIGHT ) snake.setDirection(Snake.LEFT);
        }
        if ( keyCode == KeyEvent.VK_RIGHT ) {
            if ( snake.getDirection() != Snake.LEFT ) snake.setDirection(Snake.RIGHT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void run() {
        long FPS = 80;                      //Frames per Seconds
        long period = 1000*1000000/FPS;     //Tru kì
        long beginTime;
        long sleepTime;
        
        int a = 1;
        
        beginTime = System.nanoTime();      //nanoTime() là hàm lấy thời gian hệ thống
        
        
        while(true){
            
            //System.out.println("a = "+a++);
            snake.checkEat();
            if ( ! snake.move() ) {
                JOptionPane.showMessageDialog(null, "You fucking lose");
                map = new int[20][20];
                snake = new Snake(map);
            }
            repaint();
            while ( System.nanoTime() - beginTime < 100000000 );
            long deltaTime = System.nanoTime() - beginTime;
            sleepTime = period - deltaTime;
            
            try {
                if(sleepTime > 0)
                    Thread.sleep(sleepTime/1000000);
                else Thread.sleep(period/2000000);
            } catch (InterruptedException ex) {
            
            }
            
            beginTime = System.nanoTime();
            
        }
    }
    
}
