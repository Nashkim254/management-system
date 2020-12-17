
package mobile.reparing.project;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DashBoard extends JPanel implements ActionListener{
    JLabel heding,Reg,UnRep,Rep,Recv,Rop;
    JButton imReg,imUnRep,imRep,imRecv,imRop;
    JPanel p;
    
        Font f1=new Font("TimesRoman", Font.BOLD, 35);
        Font f2=new Font("TimesRoman", Font.BOLD, 20);
    public DashBoard(){
        heding=new JLabel("Computer Reparing Management System");  heding.setFont(f1);
        Reg=new JLabel("Register");                                 Reg.setFont(f2);
        UnRep=new JLabel("UnRepaired Computers");             UnRep.setFont(f2);
        Rep=new JLabel("Repair Computer");                        Rep.setFont(f2);
        Recv=new JLabel("Received Computers");                    Recv.setFont(f2);
        Rop=new JLabel("Report");                                    Rop.setFont(f2);
        
        heding.setForeground(Color.white);
        Reg.setForeground(Color.white);
        UnRep.setForeground(Color.white);
        Rep.setForeground(Color.white);
        Recv.setForeground(Color.white);
        Rop.setForeground(Color.white);
        
        imReg=new JButton();imReg.addActionListener(this);
        imUnRep=new JButton();imUnRep.addActionListener(this);
        imRep=new JButton();imRep.addActionListener(this);
        imRecv=new JButton();imRecv.addActionListener(this);
        imRop=new JButton();imRop.addActionListener(this);
        
        imReg.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon imgc1=new ImageIcon((new ImageIcon("C:\\Users\\nash.FATHEROFHACKER\\Desktop\\Mobile Reparing Project\\add.png").getImage()
                .getScaledInstance(150,150,Image.SCALE_SMOOTH)));
        imReg.setIcon(imgc1);
        
        imUnRep.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon imgc2=new ImageIcon((new ImageIcon("C:\\Users\\nash.FATHEROFHACKER\\Desktop\\Mobile Reparing Project\\unrep.jpg").getImage()
                .getScaledInstance(150,150,Image.SCALE_SMOOTH)));
        imUnRep.setIcon(imgc2);
        
        imRep.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon imgc3=new ImageIcon((new ImageIcon("C:\\Users\\nash.FATHEROFHACKER\\Desktop\\Mobile Reparing Project\\rep.jpg").getImage()
                .getScaledInstance(150,150,Image.SCALE_SMOOTH)));
        imRep.setIcon(imgc3);
        
        imRecv.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon imgc5=new ImageIcon((new ImageIcon("C:\\Users\\nash.FATHEROFHACKER\\Desktop\\Mobile Reparing Project\\rev.png").getImage()
                .getScaledInstance(150,150,Image.SCALE_SMOOTH)));
        imRecv.setIcon(imgc5);
        
        imRop.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon imgc6=new ImageIcon((new ImageIcon("C:\\Users\\nash.FATHEROFHACKER\\Desktop\\Mobile Reparing Project\\rop.jpg").getImage()
                .getScaledInstance(150,150,Image.SCALE_SMOOTH)));
        imRop.setIcon(imgc6);
        
        p=new JPanel(new GridBagLayout());
        GridBagConstraints c1= new GridBagConstraints();
        c1.anchor=GridBagConstraints.CENTER;
        c1.gridx=0;c1.gridy=0;c1.insets=new Insets(30,30,0,30);p.add(imReg,c1);
        c1.gridx=0;c1.gridy=1;c1.insets=new Insets(0,0,0,0);p.add(Reg,c1);
        c1.gridx=1;c1.gridy=0;c1.insets=new Insets(30,30,0,30);p.add(imUnRep,c1);
        c1.gridx=1;c1.gridy=1;c1.insets=new Insets(0,0,0,0);p.add(UnRep,c1);
        c1.gridx=2;c1.gridy=0;c1.insets=new Insets(30,30,0,30);p.add(imRep,c1);
        c1.gridx=2;c1.gridy=1;c1.insets=new Insets(0,0,0,0);p.add(Rep,c1);
        c1.gridx=0;c1.gridy=2;c1.insets=new Insets(30,30,0,30);p.add(imRecv,c1);
        c1.gridx=0;c1.gridy=3;c1.insets=new Insets(0,0,0,0);p.add(Recv,c1);
        c1.gridx=1;c1.gridy=2;c1.insets=new Insets(30,30,0,30);p.add(imRop,c1);
        c1.gridx=1;c1.gridy=3;c1.insets=new Insets(0,0,0,0);p.add(Rop,c1);
        p.setBackground(Color.BLACK);
        
        this.setBackground(Color.black);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c= new GridBagConstraints();
        c.insets=new Insets(30,0,0,0);
        c.gridx=0;c.gridy=0;this.add(heding,c);
        c.gridx=0;c.gridy=1;this.add(p,c);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(imReg)){
            this.removeAll();
            this.repaint();
            this.revalidate();

            RegisterPanel r1=new RegisterPanel();

            this.add(r1);
            this.repaint();
            this.revalidate();
            this.setBackground(Color.BLACK);
        }
        if(ae.getSource().equals(imUnRep)){
            this.removeAll();
            this.repaint();
            this.revalidate();

            UnRepairPanel up=new UnRepairPanel();

            this.add(up);
            this.repaint();
            this.revalidate();
            this.setBackground(Color.BLACK);
        }
        if(ae.getSource().equals(imRep)){
            this.removeAll();
            this.repaint();
            this.revalidate();

            RepairPanel rp=new RepairPanel();

            this.add(rp);
            this.repaint();
            this.revalidate();
            this.setBackground(Color.BLACK);
        }
        if(ae.getSource().equals(imRop)){
            this.removeAll();
            this.repaint();
            this.revalidate();

            ReportPanel up;
            try {
                up = new ReportPanel();
                this.add(up);
                this.repaint();
                this.revalidate();
                this.setBackground(Color.BLACK);
            } catch (SQLException ex) {
            }
        }
        if(ae.getSource().equals(imRecv)){
            this.removeAll();
                 this.repaint();
                 this.revalidate();
                 
            try {
                RecivePanel recp=new RecivePanel();
                this.add(recp);
                 this.repaint();
                 this.revalidate();
                 this.setBackground(Color.BLACK);
            } catch (SQLException ex) {
            }
                 
                 
        }
        
    }
}
