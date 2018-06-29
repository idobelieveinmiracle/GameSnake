
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Quoc Hung
 */
public class GameFrame extends JFrame {

    /**
     * @param args the command line arguments
     */
    
    GamePanel gamePanel;
    
    public GameFrame() {
        gamePanel = new GamePanel();
        Toolkit toolkit = this.getToolkit();    //Toolkit để lấy size của màn hinh máy tính
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds((dimension.width-400)/2,
                (dimension.height-400)/2,
                400,
                400);
        this.add(gamePanel);
        this.setSize(420, 450);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addKeyListener(gamePanel);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        new GameFrame().gamePanel.startGame();
    }
    
}
