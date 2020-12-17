
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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class RecivePanel extends JPanel implements ActionListener{
    JPanel pf,searchPane;
    JButton search;
    JTextField tpSN;
    JLabel plSN;
    JButton back;
    
    JLabel cusName,cusMobileNo,cusAdress,cusEmail,
            pName,pSN,pModel,pType,pFaultDescription;
    
    JLabel cusName_Db,cusMobileNo_Db,cusAdress_Db,cusEmail_Db,
            pName_Db,pSN_Db,pModel_Db,pType_Db,pFaultDescription_Db,endLine;
    
    JLabel problem,charg,servCharg,heading,sn,total;
    JLabel dbproblem,dbcharg,dbservCharg,dbsn,dbtotal;
    
    Connection con;
    
        Font f1=new Font("TimesRoman", Font.BOLD, 18);
        Font f2=new Font("TimesRoman", Font.PLAIN, 18);
  RecivePanel() throws SQLException{
            
      back=new JButton("Main Menu");back.setForeground(Color.white);
      back.setFont(f1);back.setBackground(Color.BLUE);
      back.addActionListener(this);
      
      tpSN=new JTextField(19);tpSN.setFont(f1);
      search=new JButton("Search");search.setForeground(Color.white);
      search.setFont(f1);search.setBackground(Color.BLUE);
      plSN=new JLabel(" SN ");plSN.setFont(f1);plSN.setForeground(Color.WHITE);
        cusName=new JLabel(" Customer Name  ");cusName.setFont(f1);
        cusMobileNo=new JLabel(" Mobile No. ");cusMobileNo.setFont(f1);
        cusAdress=new JLabel(" Adress ");cusAdress.setFont(f1);
        cusEmail=new JLabel(" Email ");cusEmail.setFont(f1);

        cusName.setForeground(Color.white);
        cusMobileNo.setForeground(Color.white);
        cusAdress.setForeground(Color.white);
        cusEmail.setForeground(Color.white);
        
        pName=new JLabel(" Product Name  ");pName.setFont(f1);
        pSN=new JLabel(" SN ");pSN.setFont(f1);
        pModel=new JLabel(" Model ");pModel.setFont(f1);
        pType=new JLabel(" Type ");pType.setFont(f1);
        pFaultDescription=new JLabel(" Fault Description");pFaultDescription.setFont(f1);
        endLine=new JLabel(" ************** ");endLine.setFont(f1);
        
        pName.setForeground(Color.white);
        pSN.setForeground(Color.white);
        pModel.setForeground(Color.white);
        pType.setForeground(Color.white);
        pFaultDescription.setForeground(Color.white);
        endLine.setForeground(Color.WHITE);
        
        cusName_Db=new JLabel();cusName_Db.setFont(f2);
        cusMobileNo_Db=new JLabel();cusMobileNo_Db.setFont(f2);
        cusAdress_Db=new JLabel();cusAdress_Db.setFont(f2);
        cusEmail_Db=new JLabel();cusEmail_Db.setFont(f2);
        
        cusName_Db.setForeground(Color.white);
        cusMobileNo_Db.setForeground(Color.white);
        cusAdress_Db.setForeground(Color.white);
        cusEmail_Db.setForeground(Color.white);

        pName_Db=new JLabel();pName_Db.setFont(f2);
        pSN_Db=new JLabel();pSN_Db.setFont(f2);
        pModel_Db=new JLabel();pModel_Db.setFont(f2);
        pType_Db=new JLabel();pType_Db.setFont(f2);
        pFaultDescription_Db=new JLabel();pFaultDescription_Db.setFont(f2);
        
        pName_Db.setForeground(Color.white);
        pSN_Db.setForeground(Color.white);
        pModel_Db.setForeground(Color.white);
        pType_Db.setForeground(Color.white);
        pFaultDescription_Db.setForeground(Color.white);
        endLine.setForeground(Color.WHITE);
        
        heading=new JLabel("Bill");heading.setFont(f1);
                charg=new JLabel("Charges");charg.setFont(f1);
                servCharg=new JLabel("Service Charges");servCharg.setFont(f1);
                problem=new JLabel("Faults Description");problem.setFont(f1);
                sn=new JLabel("SN");sn.setFont(f1);
                total=new JLabel("Total");total.setFont(f1);
                
                dbcharg=new JLabel();dbcharg.setFont(f1);
                dbservCharg=new JLabel();dbservCharg.setFont(f1);
                dbproblem=new JLabel();dbproblem.setFont(f1);
                dbsn=new JLabel();dbsn.setFont(f1);
                dbtotal=new JLabel();dbtotal.setFont(f1);
                
                heading.setForeground(Color.white);
                charg.setForeground(Color.white);
                servCharg.setForeground(Color.white);
                problem.setForeground(Color.white);
                sn.setForeground(Color.white);
                total.setForeground(Color.white);
                
                dbcharg.setForeground(Color.white);
                dbservCharg.setForeground(Color.white);
                dbproblem.setForeground(Color.white);
                dbsn.setForeground(Color.white);
                dbtotal.setForeground(Color.white);
    
        pf=new JPanel();pf.setBackground(Color.BLACK);
        pf.setLayout(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        c.anchor=GridBagConstraints.LINE_START;
        c.insets=new Insets(5,20,0,20);
        c.gridx=0;c.gridy=0;pf.add(cusName,c);
        c.gridx=1;c.gridy=0;pf.add(cusName_Db,c);
        c.gridx=0;c.gridy=1;pf.add(cusMobileNo,c);
        c.gridx=1;c.gridy=1;pf.add(cusMobileNo_Db,c);
        c.gridx=0;c.gridy=2;pf.add(cusEmail,c);
        c.gridx=1;c.gridy=2;pf.add(cusEmail_Db,c);
        c.gridx=0;c.gridy=3;pf.add(cusAdress,c);
        c.gridx=1;c.gridy=3;pf.add(cusAdress_Db,c);

        c.gridx=0;c.gridy=4;pf.add(pName,c);
        c.gridx=1;c.gridy=4;pf.add(pName_Db,c);
        c.gridx=0;c.gridy=5;pf.add(pSN,c);
        c.gridx=1;c.gridy=5;pf.add(pSN_Db,c);
        c.gridx=0;c.gridy=6;pf.add(pModel,c);
        c.gridx=1;c.gridy=6;pf.add(pModel_Db,c);
        c.gridx=0;c.gridy=7;pf.add(pType,c);
        c.gridx=1;c.gridy=7;pf.add(pType_Db,c);
        c.gridx=0;c.gridy=8;pf.add(pFaultDescription,c);
        c.gridx=1;c.gridy=8;pf.add(pFaultDescription_Db,c);
        c.gridx=0;c.gridy=9;c.anchor=GridBagConstraints.LINE_END; pf.add(endLine,c);
        c.anchor=GridBagConstraints.LINE_START;
        c.gridx=1;c.gridy=10;pf.add(heading,c);
        c.gridx=0;c.gridy=11;pf.add(sn,c);
        c.gridx=1;c.gridy=11;pf.add(dbsn,c);
        c.gridx=0;c.gridy=12;c.anchor=GridBagConstraints.NORTHWEST;pf.add(problem,c);
        c.anchor=GridBagConstraints.LINE_START;
        c.gridx=1;c.gridy=12;pf.add(dbproblem,c);
        c.gridx=0;c.gridy=13;pf.add(charg,c);
        c.gridx=1;c.gridy=13;pf.add(dbcharg,c);
        c.gridx=0;c.gridy=14;pf.add(servCharg,c);
        c.gridx=1;c.gridy=14;pf.add(dbservCharg,c);
        c.gridx=0;c.gridy=15;pf.add(total,c);
        c.gridx=1;c.gridy=15;pf.add(dbtotal,c);
        
search.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
           
        try{
            con=DriverManager.getConnection
        ("jdbc:mysql://localhost/repair", "root", "");
        }catch(SQLException e){
            System.out.println(" DataBase is Not Found ");
        }
        
        //Step:-3) Statement SQL
        String query=" Select* from Received where SN="+tpSN.getText();
        String query2=" Select* from Bill where SN="+tpSN.getText();
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            
            //Step:-4) Process Result 
            ResultSetMetaData md=rs.getMetaData();
            int column=md.getColumnCount();
            
            if(rs.next()){
                   
                cusName_Db.setText(rs.getObject("CustomerName").toString());
                cusMobileNo_Db.setText(rs.getObject("MobileNo").toString());
                cusAdress_Db.setText(rs.getObject("Adress").toString());
                cusEmail_Db.setText(rs.getObject("Email").toString());
           
                pName_Db.setText(rs.getObject("ComputerName").toString());
                pSN_Db.setText(rs.getObject("SN").toString());
                pModel_Db.setText(rs.getObject("Model").toString());
                pType_Db.setText(rs.getObject("Type").toString());
                pFaultDescription_Db.setText(rs.getObject("FaultDescription").toString());
                    
            }else{
                JOptionPane.showMessageDialog(null,"Your Computer does not Exits ");
            }
            
            //Step:-5) Connection and Result Process Close
             rs.close();con.close();
             
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Qurey incorrect ");
        }
        
        //Step:-2) Established Connection Data Base 
        try{
            con=DriverManager.getConnection
        ("jdbc:mysql://localhost/repair", "root", "");
        }catch(SQLException e){
            System.out.println(" Data Base is Not Found ");
        }
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query2);
            
            //Step:-4) Process Result 
            ResultSetMetaData md=rs.getMetaData();
            int column=md.getColumnCount();
            
            if(rs.next()){
                   
                dbsn.setText(rs.getObject("SN").toString());
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
          }
          
      });
      
        searchPane=new JPanel(new GridBagLayout());
        GridBagConstraints c1= new GridBagConstraints();
        c1.insets=new Insets(0,30,0,0);
        c1.gridx=0;c1.gridy=0;searchPane.add(plSN,c1);
        c1.gridx=1;c1.gridy=0;searchPane.add(tpSN,c1);
        c1.gridx=2;c1.gridy=0;searchPane.add(search,c1);
        searchPane.setBackground(Color.BLACK);
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints c2= new GridBagConstraints();
        c2.insets=new Insets(20,0,0,0);
        c2.gridx=0;c2.gridy=0;this.add(searchPane,c2);
        c2.gridx=0;c2.gridy=1;this.add(pf,c2);
        c2.gridx=0;c2.gridy=2;this.add(back,c2);
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

