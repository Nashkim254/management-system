
package mobile.reparing.project;

import java.awt.BorderLayout;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

public class MobileReparingProject {

    public static void main(String[] args) throws SQLException {
        new MyMobileReparing();
    }
    
}
class MyMobileReparing extends JFrame{
    public MyMobileReparing() throws SQLException{
        super();
        setTitle(" Computer Reparing Management System ");
        setSize ( 800,700);
        PrograssBarPanel p1= new PrograssBarPanel();
        this.getContentPane().add(p1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setVisible(true);
        p1.fill(); 
    }
}