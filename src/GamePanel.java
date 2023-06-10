import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    final int HEIGHT = 550, WIDTH = 525;
    //int shipHeight = HEIGHT/2;
    int shipV=0, shipA=0, shipI=0;
    int cloudV=0,cloudA=0, cloudI=0;
    private ArrayList<Rectangle> obstacles = new ArrayList<>();

    public GamePanel(){


        setSize(WIDTH,HEIGHT);
        setFocusable(true);
        addKeyListener(this);
        setBackground(Color.BLACK);
        new Timer(40,this).start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawShip(g);
        drawCloud(g);
    }

    private void drawShip(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(75 , 400 + shipV, 50,50);
    }

    private void drawCloud(Graphics g){
        g.setColor(Color.RED);
        for (Rectangle obstacle : obstacles) {
            g.fillRect(obstacle.x + cloudV, obstacle.y, obstacle.width, obstacle.height);
        }
    }
    public void actionPerformed(ActionEvent e){
        shipA += shipI;
        shipV += shipA;
        cloudA += cloudI;
        cloudV += cloudA;

        if (Math.random() < 0.03) { // Adjust the probability to control the frequency of obstacle generation
            generateObstacle();
        }
        for (Rectangle obstacle : obstacles) {
            obstacle.x -= 5; // Adjust the speed of the obstacles
        }

        repaint();
    }

    private void generateObstacle() {
        int obstacleWidth = 50;
        int obstacleHeight = 50; // Randomly generate obstacle height
        int obstacleY = (int) (Math.random() * (HEIGHT - obstacleHeight)); // Randomly generate obstacle vertical position
        int obstacleX = WIDTH + (int) (Math.random() * 100); // Randomly generate obstacle horizontal position

        obstacles.add(new Rectangle(obstacleX, obstacleY, obstacleWidth, obstacleHeight));
    }

    public void keyTyped(KeyEvent e){

    }


    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
        if(code == e.VK_SPACE){

        }
        if(code == e.VK_UP){
            shipA=-8;
            shipI=0;

        }
        if(code == e.VK_DOWN){
            shipA=8;
            shipI=0;
        }


    }

    public void keyReleased(KeyEvent e){

    }


}
