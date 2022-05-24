
import java.awt.Point;
import javax.swing.ImageIcon;

/**
 *
 * @author zeeshan
 */
public class Launcher {

    public static void main(String[] args) {

        // Adding a new look and feel to the JSwing components
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException error");
        } catch (InstantiationException ex) {
            System.out.println("InstantiationException error");
        } catch (IllegalAccessException ex) {
            System.out.println("IllegalAccessException error");
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println("UnsupportedLookAndFeelException error");
        }

        // Declaring instance of menu
        GUI_Main_Menu menu = new GUI_Main_Menu();

        // Configs to the instance
        menu.setTitle("Main Menu");
        menu.setLocation(new Point(500, 150));
        menu.setVisible(true);
        menu.setResizable(false);

        ImageIcon icon = new ImageIcon("src/Images/logo_uni.png");

    }
}
