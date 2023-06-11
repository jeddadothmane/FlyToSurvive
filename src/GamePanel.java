import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    final int HEIGHT = 1000, WIDTH = 700;
    int shipV = 0, shipA = 0, shipI = 0;
    int cloudV = 0, cloudA = 0, cloudI = 0;
    private ArrayList<Rectangle> obstacles = new ArrayList<>();
    private Rectangle ship;
    private boolean gameRunning = false;

    public GamePanel() {
        setSize(WIDTH, HEIGHT);
        setFocusable(true);
        addKeyListener(this);
        setBackground(Color.BLACK);
        ship = new Rectangle(75, 400 + shipV, 50, 50);
        new Timer(40, this).start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawShip(g);
        drawCloud(g);
        if (!gameRunning) {
            // Draw the "Press SPACE to start" message box
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 24));
            String message = "Press SPACE to start";
            int messageWidth = g.getFontMetrics().stringWidth(message);
            int messageHeight = g.getFontMetrics().getHeight();
            int messageX = (WIDTH - messageWidth) / 2;
            int messageY = (HEIGHT - messageHeight) / 2;
            g.drawString(message, messageX, messageY);
        } else {
            drawShip(g);
            drawCloud(g);
            
        }

    }

    private void drawShip(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(ship.x, ship.y + shipV, ship.width, ship.height);
    }

    private void drawCloud(Graphics g) {
        g.setColor(Color.RED);
        for (Rectangle obstacle : obstacles) {
            g.fillRect(obstacle.x + cloudV, obstacle.y, obstacle.width, obstacle.height);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (!gameRunning) {
            return; // Don't update the game if it's not running
        }

        shipA += shipI;
        shipV += shipA;
        cloudA += cloudI;
        cloudV += cloudA;

        if (Math.random() < 0.03) {
            generateObstacle();
        }
        for (Rectangle obstacle : obstacles) {
            obstacle.x -= 5;
            if (obstacle.intersects(ship)) {
                restartGame();
                return;
            }
        }
        if (ship.y + shipV <= 0 || ship.y + shipV >= 1000-(ship.height*2)) {
            restartGame();
            return;
        }
        repaint();
    }


    private void generateObstacle() {
        int obstacleWidth = 100;
        int obstacleHeight = 100;
        int obstacleY = (int) (Math.random() * (HEIGHT - obstacleHeight));
        int obstacleX = WIDTH;

        obstacles.add(new Rectangle(obstacleX, obstacleY, obstacleWidth, obstacleHeight));
    }

    private void restartGame() {
        obstacles.clear();
        shipV = 0;
        shipA = 0;
        shipI = 0;
        ship.y = 400;
        gameRunning = false;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_SPACE) {
            if (!gameRunning) {
                gameRunning = true;
                shipA = 0;
            }
        } else if (code == KeyEvent.VK_UP) {
            shipA = -8;
            shipI = 0;
        } else if (code == KeyEvent.VK_DOWN) {
            shipA = 8;
            shipI = 0;
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
