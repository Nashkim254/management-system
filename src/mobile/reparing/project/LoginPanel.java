
package mobile.reparing.project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel implements KeyListener,ActionListener,FocusListener{
    JButton ok,image;
    JLabel l_username,l_password,error,forgot;
    JTextField t_username;
    JPasswordField t_password;
    JPanel p1,p2;
 
    public LoginPanel(){
        ok = new JButton(" Login ");ok.addActionListener(this); ok.addKeyListener(this);
        image = new JButton();
        
        image.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon imgc = new ImageIcon(((new ImageIcon("C:\\Users\\nash.FATHEROFHACKER\\Desktop\\Mobile Reparing Project\\download.jpg").getImage()
         .getScaledInstance(160, 160,Image.SCALE_SMOOTH))));
        image.setIcon(imgc);
        
        error=new JLabel();error.setForeground(Color.cyan);
        l_username = new JLabel(" Username  ");
        l_password = new JLabel(" Password   ");
        forgot=new JLabel(" Forgot Password ? ");forgot.setForeground(Color.cyan);
        t_username = new JTextField(15);  t_username.addKeyListener(this);t_username.addFocusListener(this);
        t_password = new JPasswordField(15);t_password.addFocusListener(this);
       
        Font f1=new Font("TimesRoman", Font.BOLD, 18);
        Font f2=new Font("TimesRoman", Font.PLAIN, 18);
        l_username.setFont(f1);l_username.setForeground(Color.WHITE);
        l_password.setFont(f1);l_password.setForeground(Color.WHITE);
        t_username.setFont(f2);
        t_password.setFont(f2);
        ok.setFont(f1);ok.setForeground(Color.WHITE);ok.setBackground(Color.blue);
        
        p1 = new JPanel(new GridBagLayout());
        GridBagConstraints c1= new GridBagConstraints(); 
        c1.anchor=GridBagConstraints.LINE_END;
        p1.add(image,c1);
        //p1.setPreferredSize(new Dimension(170, 250));
        p1.setBackground(Color.BLACK);
        
        p2 = new JPanel(new GridBagLayout());
        GridBagConstraints c= new GridBagConstraints(); 
        c.insets = new Insets(20,0,0,0);
        c.gridx=0;c.gridy=0;p2.add(l_username,c);
        c.gridx=1;c.gridy=0;p2.add(t_username,c);
        c.gridx=0;c.gridy=1;p2.add(l_password,c);
        c.gridx=1;c.gridy=1;p2.add(t_password,c);
        c.gridx=1;c.gridy=2;c.anchor=GridBagConstraints.LINE_END;p2.add(forgot,c);
        c.gridx=1;c.gridy=3; c.anchor=GridBagConstraints.LINE_START ;p2.add(ok,c);
        c.gridx=1;c.gridy=4;p2.add(error,c);  
        p2.setBackground(Color.BLACK);
        p2.setPreferredSize(new Dimension(360, 250));
       
        this.setBackground(Color.BLACK);
        this.setLayout(new GridBagLayout());
        GridBagConstraints cf= new GridBagConstraints(); 
        cf.gridx=0;cf.gridy=0;this.add(p1,cf);
        cf.gridx=0;cf.gridy=1;this.add(p2,cf);
    }
    
        public void actionPerformed(ActionEvent e){
         
        if(e.getSource() == ok){
             String user = t_username.getText();
             String pass = t_password.getText();
             if(user.equals("nash") && pass.equals("1234"))
             {
                 this.removeAll();
                 this.repaint();
                 this.revalidate();
                 
                 DashBoard d1=new DashBoard();
                 
                 this.add(d1);
                 this.repaint();
                 this.revalidate();
                 this.setBackground(Color.LIGHT_GRAY);
             }
             else if(user.equals("")||pass.equals(""))
             {
                 error.setText("Username or Password is empty ");
             }
             else{
                 error.setText("Username or Password is not correct ");
             }
        }
      }   
 
    @Override
    public void keyTyped(KeyEvent ke) {
        
      char ch;
      ch = ke.getKeyChar();
      if((ch < 'a' || ch > 'z' ) && (ch != '\b') ){
          ke.consume();
      }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
         if(ke.getSource() == ok){
             if (ke.getKeyCode()==KeyEvent.VK_ENTER) {
               ok.doClick();
            }
         }
        }
        

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }

    @Override
    public void focusGained(FocusEvent fe) {
        
        if(fe.getSource().equals(t_username)|| fe.getSource().equals(t_password)){
            error.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent fe) {
        
    }
}


