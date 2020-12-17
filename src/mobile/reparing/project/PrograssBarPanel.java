
package mobile.reparing.project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

public class PrograssBarPanel extends JPanel {
    JProgressBar pb; 
    JButton icon;
    public PrograssBarPanel(){
        icon=new JButton();
        icon.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon imgc = new ImageIcon(((new ImageIcon("C:\\Users\\nash.FATHEROFHACKER\\Desktop\\Mobile Reparing Project\\download.jpg").getImage()
         .getScaledInstance(160, 160,Image.SCALE_SMOOTH))));
          icon.setIcon(imgc);
          
            UIManager.put("ProgressBar.selectionForeground", Color.white);
            UIManager.put("ProgressBar.selectionBackground", Color.BLACK);
            pb = new JProgressBar(); pb.setBackground(Color.white);
            pb.setForeground(Color.red);pb.setPreferredSize(new Dimension(300, 20));
            pb.setValue(0); 
            pb.setStringPainted(true);
            this.setLayout(new GridBagLayout());
            
            this.add(icon);this.add(pb);
            this.setBackground(Color.WHITE);
    }
     LoginPanel lp;
    public void fill() 
    { 
            int i = 0; 
            try { 
                    while (i <= 100) { 
                            pb.setValue(i + 1); 
                            Thread.sleep(10); 
                            i += 1; 
                    }
                 this.removeAll();
                 this.repaint();
                 this.revalidate();
                 
                 lp=new LoginPanel();
                 
                 this.add(lp);
                 this.repaint();
                 this.revalidate();
                 this.setBackground(Color.BLACK);
            } 
            catch (Exception e) { 
                System.out.println("Nash");
            } 
}
}    