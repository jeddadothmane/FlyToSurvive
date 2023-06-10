import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    final int HEIGHT = 550, WIDTH = 525;
    int shipHeight = HEIGHT/2;
    int shipV=0, shipA=0, shipI=0;
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

    }
    private void drawShip(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(75 , 400 + shipV, 50,50);

    }
    public void actionPerformed(ActionEvent e){
        shipA += shipI;
        shipV += shipA;
        repaint();
    }

    public void keyTyped(KeyEvent e){

    }


    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
        if(code == e.VK_UP){
            shipA=-8;
            shipI=0;
        }
        if(code == e.VK_DOWN){
            shipA=+8;
            shipI=0;
        }


    }

    public void keyReleased(KeyEvent e){

    }


}
