
package mobile.reparing.project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RegisterPanel extends JPanel implements ActionListener{
    
    JTabbedPane tp;
    JLabel cusDetail,cusName,cusMobileNo,cusAdress,cusEmail;
    JTextField tName,tMobileNo,tEmail;
    JTextArea tAdress;
    
    JLabel pDetail,pName,pSN,pModel,pType,pMainFault,pFaultDescription;
    JRadioButton desktop,laptop;
    ButtonGroup pTypeGroup;
    JTextField tpName,tpModel,tpSN;
    JTextArea tpFaultDetail;
    JPanel radioButtonPane,pf,buttonPane;
    JButton reg,back;
         Connection con;
         Register register=new Register();
   
         Font f=new Font("TimesRoman", Font.BOLD, 25);
         Font f1=new Font("TimesRoman", Font.BOLD, 18);
         Font f2=new Font("TimesRoman", Font.PLAIN, 15);
    
    public RegisterPanel( ){
        super();
        
        // Customer Detail Panel 
        cusDetail=new JLabel(" Customer Detail ");cusDetail.setForeground(Color.white);
        cusName=new JLabel(" Name ");cusName.setForeground(Color.white);
        cusMobileNo=new JLabel(" Mobile No. ");cusMobileNo.setForeground(Color.white);
        cusAdress=new JLabel(" Adress ");cusAdress.setForeground(Color.white);
        cusEmail=new JLabel(" Email ");cusEmail.setForeground(Color.white);
        tName=new JTextField(25);
        tMobileNo=new JTextField(25);
        tEmail=new JTextField(25);
        tAdress=new JTextArea();
        tAdress.setPreferredSize(new Dimension(330, 80)); 
        tAdress.setLineWrap(true);
        
        cusDetail.setFont(f);
        cusName.setFont(f1);cusMobileNo.setFont(f1);
        cusAdress.setFont(f1);cusEmail.setFont(f1);
        tName.setFont(f2);tMobileNo.setFont(f2);
        tEmail.setFont(f2);tAdress.setFont(f2);
        pf=new JPanel(new GridBagLayout());
      //  super.setLayout(new GridBagLayout());
        GridBagConstraints c1= new GridBagConstraints();
        c1.insets=new Insets(10,0,0,0);
        c1.anchor=GridBagConstraints.LINE_START;
        c1.gridx=0;c1.gridy=0;pf.add(cusDetail,c1);
        c1.gridx=0;c1.gridy=1;pf.add(cusName,c1);
        c1.gridx=1;c1.gridy=1;pf.add(tName,c1);
        c1.gridx=0;c1.gridy=2;pf.add(cusMobileNo,c1);
        c1.gridx=1;c1.gridy=2;pf.add(tMobileNo, c1);
        c1.gridx=0;c1.gridy=3;pf.add(cusEmail,c1);
        c1.gridx=1;c1.gridy=3;pf.add(tEmail,c1);
        c1.gridx=0;c1.gridy=4;c1.anchor=GridBagConstraints.NORTHWEST;pf.add(cusAdress,c1);
        c1.gridx=1;c1.gridy=4;pf.add(tAdress,c1);
        
        // Mobile Detail Panel 
        pDetail=new JLabel(" Product Detail ");pDetail.setForeground(Color.white);
        pName=new JLabel(" Name ");pName.setForeground(Color.white);
        pSN=new JLabel(" SN ");pSN.setForeground(Color.white);
        pModel=new JLabel(" Model ");pModel.setForeground(Color.white);
        pType=new JLabel(" Type ");pType.setForeground(Color.white);
        pMainFault=new JLabel(" Main Fault ");pMainFault.setForeground(Color.white);
        pFaultDescription=new JLabel(" Fault Description ");pFaultDescription.setForeground(Color.white);
        tpName=new JTextField(25);
        tpModel=new JTextField(25);
        tpSN=new JTextField(25);
        tpFaultDetail=new JTextArea();tpFaultDetail.setPreferredSize(new Dimension(330, 80));
        tpFaultDetail.setLineWrap(true);
        desktop=new JRadioButton(" desktop "); desktop.setBackground(Color.BLACK);
        desktop.setForeground(Color.white); desktop.setFont(f1);
        laptop=new JRadioButton(" laptop ");laptop.setBackground(Color.BLACK);
        laptop.setForeground(Color.white); laptop.setFont(f1);
        pTypeGroup=new ButtonGroup();
        pTypeGroup.add(desktop);pTypeGroup.add(laptop);
        back=new JButton("Main Menu");back.setForeground(Color.white);
        back.setFont(f1);back.setBackground(Color.BLUE);
        back.addActionListener(this);
        reg=new JButton(" Register ");reg.setForeground(Color.white);
        reg.setBackground(Color.BLUE);reg.setFont(f1);
        // Action Listener in Add Button
        reg.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                 register.setCustomerName(tName.getText());
                 register.setMobileNo(tMobileNo.getText());
                 register.setEmail(tEmail.getText());
                 register.setAdress(tAdress.getText());
                 register.setProductName(tpName.getText());
                 register.setsn(tpSN.getText());
                 register.setModel(tpModel.getText());
                 register.setFault(tpFaultDetail.getText());
                  //checked Selected Radio Button
                String radioB_select="";
                if(desktop.isSelected()){radioB_select=desktop.getText();}
                if(laptop.isSelected()){radioB_select=laptop.getText();}
                register.setType(radioB_select); 
                
                //Step :- 1) Add the Drivers      
                
                //Step:-2) Established Connection Data Base 
                try{
                    con=DriverManager.getConnection
                ("jdbc:mysql://localhost/repair", "root", "");
                }catch(SQLException e){
                    System.out.println(" Database is Not Found ");
                }
                // Step:-3) Statement SQL
                String query="insert into UnRepairedComputer(CustomerName,MobileNo,Email,Adress,ComputerName,Model,SN,Type,FaultDescription)"+" values(?,?,?,?,?,?,?,?,?)";
                String query2="insert into Report(CustomerName,MobileNo,Email,Adress,ComputerName,Model,SN,Type,FaultDescription)"+" values(?,?,?,?,?,?,?,?,?)";
                String query3="insert into Received(CustomerName,MobileNo,Email,Adress,ComputerName,Model,SN,Type,FaultDescription)"+" values(?,?,?,?,?,?,?,?,?)";

                //Step:-4) Insert Data
                try {
                    PreparedStatement pst=con.prepareStatement(query);
                    pst.setString(1, register.getCustomerName());
                    pst.setString(2, register.getMobileNo());
                    pst.setString(3, register.getEmail());
                    pst.setString(4,register.getAdress());
                    pst.setString(5,register.getProductName());
                    pst.setString(6,register.getModel());
                    pst.setString(7,register.getsn());
                    pst.setString(8, register.getType());
                    pst.setString(9,register.getFault());
                    pst.executeUpdate();
                    
                    //Step:-5) Connection Close
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                try{
                    con=DriverManager.getConnection
                ("jdbc:mysql://localhost/repair", "root", "");
                }catch(SQLException e){
                    System.out.println(" Database is Not Found ");
                }
                
                   try {
                    PreparedStatement pst=con.prepareStatement(query2);
                    pst.setString(1, register.getCustomerName());
                    pst.setString(2, register.getMobileNo());
                    pst.setString(3, register.getEmail());
                    pst.setString(4,register.getAdress());
                    pst.setString(5,register.getProductName());
                    pst.setString(6,register.getModel());
                    pst.setString(7,register.getsn());
                    pst.setString(8, register.getType());
                    pst.setString(9,register.getFault());
                    pst.executeUpdate();
                    
                    //Step:-5) Connection Close
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                JOptionPane.showMessageDialog(null," Computer Register ");
            
                 tName.setText("");
                 tMobileNo.setText("");
                 tEmail.setText("");
                 tAdress.setText("");
                 tpName.setText("");
                 tpModel.setText("");
                 tpSN.setText("");
                 tpFaultDetail.setText("");
                 pTypeGroup.clearSelection();
            } 
        });
        pDetail.setFont(f);
        pName.setFont(f1);pSN.setFont(f1);
        pModel.setFont(f1);pType.setFont(f1);
        pMainFault.setFont(f1);pFaultDescription.setFont(f1);
        tpName.setFont(f2);tpModel.setFont(f2);
        tpSN.setFont(f2);tpFaultDetail.setFont(f2);
        
        radioButtonPane=new JPanel();
        radioButtonPane.add(desktop);radioButtonPane.add(laptop);
        radioButtonPane.setBackground(Color.BLACK);
        
        c1.gridx=0;c1.gridy=5;pf.add(pDetail,c1);
        c1.gridx=0;c1.gridy=6;pf.add(pName,c1);
        c1.gridx=1;c1.gridy=6;pf.add(tpName,c1);
        c1.gridx=0;c1.gridy=7;pf.add(pModel,c1);
        c1.gridx=1;c1.gridy=7;pf.add(tpModel,c1);
        c1.gridx=0;c1.gridy=8;pf.add(pSN,c1);
        c1.gridx=1;c1.gridy=8;pf.add(tpSN,c1);
        c1.gridx=0;c1.gridy=9;pf.add(pType, c1);
        c1.gridx=1;c1.gridy=9;c1.anchor=GridBagConstraints.CENTER;pf.add(radioButtonPane, c1);
        c1.gridx=0;c1.gridy=10;c1.anchor=GridBagConstraints.NORTHWEST;pf.add(pFaultDescription, c1);
        c1.gridx=1;c1.gridy=10;pf.add(tpFaultDetail, c1);
        
        buttonPane=new JPanel(new GridBagLayout());
        GridBagConstraints c3= new GridBagConstraints();
        c3.insets=new Insets(0,10,0,0);
        c3.gridx=0;c3.gridy=0;buttonPane.add(reg,c3);
        c3.gridx=1;c3.gridy=0;buttonPane.add(back,c3);
        buttonPane.setBackground(Color.BLACK);
        
        c1.gridx=1;c1.gridy=11;pf.add(buttonPane, c1);
        
        pf.setBackground(Color.BLACK);
        pf.setPreferredSize(new Dimension(600, 600));
        this.add(pf);
        this.setBackground(Color.BLACK);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(back)){
            this.removeAll();
            this.repaint();
            this.revalidate();

           DashBoard d1=new DashBoard();

            this.add(d1);
            this.repaint();
            this.revalidate();
            this.setBackground(Color.BLACK);
        }
    }
}
