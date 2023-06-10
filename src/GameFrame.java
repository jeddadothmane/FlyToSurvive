import javax.swing.JFrame;
public class GameFrame extends JFrame{
    public GameFrame(){
        add(new GamePanel());

        setSize(700,1000);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
