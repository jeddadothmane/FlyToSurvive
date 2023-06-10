import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    final int HEIGHT = 550, WIDTH = 525;
    public GamePanel(){


        setSize(WIDTH,HEIGHT);
        setFocusable(true);
        addKeyListener(this);
        setBackground(Color.BLACK);
    }
    public void actionPerformed(ActionEvent e){
        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

    }
    public void keyTyped(KeyEvent e){

    }


    public void keyPressed(KeyEvent e){

    }

    public void keyReleased(KeyEvent e){

    }


}
