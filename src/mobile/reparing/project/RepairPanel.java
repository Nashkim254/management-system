
package mobile.reparing.project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RepairPanel extends JPanel implements ActionListener{
    JTabbedPane tp;
    JLabel cusDetail,cusName,cusMobileNo,cusAdress,cusEmail;
    JTextField tName,tMobileNo,tEmail;
    JTextArea tAdress;
    
    JLabel pDetail,pName,pSN,pModel,pType,pMainFault,pFaultDescription;
    JRadioButton desktop,laptop;
    ButtonGroup pTypeGroup;
    JTextField tpName,tpModel,tpSN;
    JTextArea tpFaultDetail;
    JPanel radioButtonPane,pf,searchPane,buttonPane;
    JButton recv,search,back,ok;
         Connection con;
         Register register=new Register();
   
         Font f=new Font("TimesRoman", Font.BOLD, 25);
         Font f1=new Font("TimesRoman", Font.BOLD, 18);
         Font f2=new Font("TimesRoman", Font.PLAIN, 15);
    
    public RepairPanel( ){
        super();
       
        search=new JButton("Search");search.setForeground(Color.white);
        search.setFont(f1);search.setBackground(Color.BLUE);
        back=new JButton("Main Menu");back.setForeground(Color.white);
        back.setFont(f1);back.setBackground(Color.BLUE);
        back.addActionListener(this);
        ok=new JButton("  Ok  ");ok.setForeground(Color.white);
        ok.setFont(f1);ok.setBackground(Color.BLUE);

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
        
        // Computer Detail Panel 
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
        desktop=new JRadioButton(" Desktop "); desktop.setBackground(Color.BLACK);
        desktop.setForeground(Color.white); desktop.setFont(f1);
        laptop=new JRadioButton(" Laptop ");laptop.setBackground(Color.BLACK);
        laptop.setForeground(Color.white); laptop.setFont(f1);
        pTypeGroup=new ButtonGroup();
        pTypeGroup.add(desktop);pTypeGroup.add(laptop);
        recv=new JButton(" Receive ");recv.setForeground(Color.white);
        recv.setBackground(Color.BLUE);recv.setFont(f1);
        
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
        c3.anchor=GridBagConstraints.LINE_START;
        c3.insets=new Insets(0,10,0,0);
        c3.gridx=0;c3.gridy=0;buttonPane.add(recv,c3);
        c3.gridx=1;c3.gridy=0;buttonPane.add(ok,c3);
        c3.gridx=2;c3.gridy=0;buttonPane.add(back,c3);
        buttonPane.setBackground(Color.BLACK);
        
        c1.gridx=1;c1.gridy=11;pf.add(buttonPane, c1);
        
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //Step :- 1) Add the Drivers      
    
        //Step:-2) Established Connection Data Base 
        try{
            con=DriverManager.getConnection
        ("jdbc:mysql://localhost/repair", "root", "");
        }catch(SQLException e){
            System.out.println(" Database is Not Found ");
        }
        //Step:-3) Statement SQL
        String query=" Select* from RepairComputer where SN="+tpSN.getText();
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            
            //Step:-4) Process Result 
            ResultSetMetaData md=rs.getMetaData();
            int column=md.getColumnCount();
            if(rs.next()){
                tName.setText(rs.getObject("CustomerName").toString());
                tMobileNo.setText(rs.getObject("MobileNo").toString());
                tAdress.setText(rs.getObject("Adress").toString());
                tEmail.setText(rs.getObject("Email").toString());
                tpName.setText(rs.getObject("ComputerName").toString());
                tpSN.setText(rs.getObject("SN").toString());
                tpModel.setText(rs.getObject("Model").toString());
                tpFaultDetail.setText(rs.getObject("FaultDescription").toString());
                String radioB_select=rs.getObject("Type").toString();
                if(radioB_select.equals(" desktop ")){desktop.setSelected(true);}
                if(radioB_select.equals(" laptop ")){laptop.setSelected(true);}
            }else{
                JOptionPane.showMessageDialog(null,"Your Computer does not Exits ");
            }
    
            //Step:-5) Connection and Result Process Close
             rs.close();con.close();
             
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Qurey incorrect ");
        }
    }
});
       recv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFrame fr=new JFrame("Bill");
                fr.setSize(600,600);
                JButton ok;
                JLabel problem,charg,servCharg,heading,SN,total;
                JLabel dbproblem,dbcharg,dbservCharg,dbSN,dbtotal;
                JPanel p;
       
                ok=new JButton("Ok");ok.setForeground(Color.white);
                ok.setFont(f1);ok.setBackground(Color.BLUE);
                heading=new JLabel("Bill");heading.setFont(f);
                charg=new JLabel("Charges");charg.setFont(f1);
                servCharg=new JLabel("Service Charges");servCharg.setFont(f1);
                problem=new JLabel("Faults Description");problem.setFont(f1);
                SN=new JLabel("SN");SN.setFont(f1);
                total=new JLabel("Total");total.setFont(f1);
                
                dbcharg=new JLabel();dbcharg.setFont(f1);
                dbservCharg=new JLabel();dbservCharg.setFont(f1);
                dbproblem=new JLabel();dbproblem.setFont(f1);
                dbSN=new JLabel();dbSN.setFont(f1);
                dbtotal=new JLabel();dbtotal.setFont(f1);
                
                heading.setForeground(Color.white);
                charg.setForeground(Color.white);
                servCharg.setForeground(Color.white);
                problem.setForeground(Color.white);
                SN.setForeground(Color.white);
                total.setForeground(Color.white);
                
                dbcharg.setForeground(Color.white);
                dbservCharg.setForeground(Color.white);
                dbproblem.setForeground(Color.white);
                dbSN.setForeground(Color.white);
                dbtotal.setForeground(Color.white);
                //Step :- 1) Add the Drivers      
        
        //Step:-2) Established Connection Data Base 
        try{
            con=DriverManager.getConnection
        ("jdbc:mysql://localhost/repair", "root", "");
        }catch(SQLException e){
            System.out.println(" Database is Not Found ");
        }
         //Step:-3) Statement SQL
         String query=" Select* from Bill where SN="+tpSN.getText();
        
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            
            //Step:-4) Process Result 
            ResultSetMetaData md=rs.getMetaData();
            int column=md.getColumnCount();
            
            if(rs.next()){
                   
                dbSN.setText(rs.getObject("SN").toString());
                dbcharg.setText(rs.getObject("Charges").toString());
                dbproblem.setText(rs.getObject("FaultDescription").toString());
                dbservCharg.setText(rs.getObject("ServiceCharges").toString());
                Double t;
                t=Double.parseDouble(rs.getObject("Charges").toString())+Double.parseDouble(rs.getObject("ServiceCharges").toString());
                dbtotal.setText(""+t);
            }else{
                JOptionPane.showMessageDialog(null,"Your Computer does not Exits ");
            }
            
            //Step:-5) Connection and Result Process Close
             rs.close();con.close();
             
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Qurey incorrect ");
        }
        
        p=new JPanel(new GridBagLayout());
                GridBagConstraints c4= new GridBagConstraints();
                c4.insets=new Insets(30,30,0,0);
                c4.anchor=GridBagConstraints.LINE_START;
                c4.gridx=1;c4.gridy=0;p.add(heading,c4);
                c4.anchor=GridBagConstraints.LINE_START;
                c4.gridx=0;c4.gridy=1;p.add(SN,c4);
                c4.gridx=1;c4.gridy=1;p.add(dbSN,c4);
                c4.gridx=0;c4.gridy=2;c4.anchor=GridBagConstraints.NORTHWEST;p.add(problem,c4);
                c4.anchor=GridBagConstraints.LINE_START;
                c4.gridx=1;c4.gridy=2;p.add(dbproblem,c4);
                c4.gridx=0;c4.gridy=3;p.add(charg,c4);
                c4.gridx=1;c4.gridy=3;p.add(dbcharg,c4);
                c4.gridx=0;c4.gridy=4;p.add(servCharg,c4);
                c4.gridx=1;c4.gridy=4;p.add(dbservCharg,c4);
                c4.gridx=0;c4.gridy=5;p.add(total,c4);
                c4.gridx=1;c4.gridy=5;p.add(dbtotal,c4);
                c4.gridx=1;c4.gridy=6;p.add(ok,c4);
                
                p.setBackground(Color.BLACK);
                fr.add(p);
                fr.setVisible(true);
                
                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        
                        fr.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Your Computer is Recived ");
                      
               
                //Step:-2) Established Connection Data Base 
                try{
                    con=DriverManager.getConnection
                ("jdbc:mysql://localhost/repair", "root", "");
                }catch(SQLException e){
                    System.out.println(" Data Base is Not Found ");
                }
                // Step:-3) Statement SQL
                String query="insert into Received(CustomerName,MobileNo,Email,Adress,ComputerName,Model,SN,Type,FaultDescription)"+" values(?,?,?,?,?,?,?,?,?)";

                //Step:-4) Insert Data
                try {
                    PreparedStatement pst=con.prepareStatement(query);
                    pst.setString(1, tName.getText());
                    pst.setString(2, tMobileNo.getText());
                    pst.setString(3, tEmail.getText());
                    pst.setString(4,tAdress.getText());
                    pst.setString(5,tpName.getText());
                    pst.setString(6,tpModel.getText());
                    pst.setString(7,tpSN.getText());
                    String pType = "";
                    if(desktop.isSelected()){pType=desktop.getText();}
                    if(laptop.isSelected()){pType=laptop.getText();}
                    pst.setString(8, pType);
                    pst.setString(9,tpFaultDetail.getText());
                    pst.executeUpdate();
                    
                    //Step:-5) Connection Close
                    con.close();
                } catch (SQLException ex) {
                    System.out.println("Nash");
                    System.out.println(ex.getMessage());
                }
                 
                try{
                    con=DriverManager.getConnection
                ("jdbc:mysql://localhost/repair", "root", "");
                }catch(SQLException e){
                    System.out.println(" Data Base is Not Found ");
                }
                try{
                 Statement st=con.createStatement();
                 String sql = " delete from RepairComputer where SN = '"+tpSN.getText()+"' ";
                 st.executeUpdate(sql);
                 
                 //Step:-5) Connection Close
                   con.close();
                 }catch(SQLException ex){
                     System.out.println(ex.getMessage());
                     System.out.println("Nash");
                 }
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
    }
        });
                
                
        pf.setBackground(Color.BLACK); 
        searchPane=new JPanel(new GridBagLayout());
        GridBagConstraints c= new GridBagConstraints();
        c.insets=new Insets(0,30,0,0);
        c.gridx=0;c.gridy=0;searchPane.add(pSN,c);
        c.gridx=1;c.gridy=0;searchPane.add(tpSN,c);
        c.gridx=2;c.gridy=0;searchPane.add(search,c);
        searchPane.setBackground(Color.BLACK);
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints c2= new GridBagConstraints();
        c2.insets=new Insets(20,0,0,0);
        c2.gridx=0;c2.gridy=0;this.add(searchPane,c2);
        c2.gridx=0;c2.gridy=1;this.add(pf,c2);
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
