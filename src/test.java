import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class test {

    public static void main(String[] args) {
        try {
            String lookAndFeel = "com.sun.java.swing.plaf.mac.MacLookAndFeel"; // Mac風格
            UIManager.setLookAndFeel(lookAndFeel);
        } catch(Exception e) {}
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainGame();
            }
        });
    }
}
