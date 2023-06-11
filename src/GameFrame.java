import javax.swing.JFrame;
import java.awt.event.KeyEvent;

public class GameFrame extends JFrame{
    public GameFrame(){
        add(new GamePanel());
        setSize(700,1000);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
