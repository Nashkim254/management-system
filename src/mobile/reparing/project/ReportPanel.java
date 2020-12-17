
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class ReportPanel extends JPanel implements ActionListener {
    
    JButton back;
    JPanel UnRepairedComputer,ScroolForPane;
    
    JLabel cusName,cusMobileNo,cusAdress,cusEmail,
            pName,pSN,pModel,pType,pFaultDescription;
    
    JLabel cusName_Db,cusMobileNo_Db,cusAdress_Db,cusEmail_Db,
            pName_Db,pSN_Db,pModel_Db,pType_Db,pFaultDescription_Db,endLine;
    
    Connection con;
    
        Font f1=new Font("TimesRoman", Font.BOLD, 18);
        Font f2=new Font("TimesRoman", Font.PLAIN, 18);
  ReportPanel() throws SQLException{
      
      back=new JButton("Main Menu");back.setForeground(Color.white);
      back.setFont(f1);back.setBackground(Color.BLUE);
      back.addActionListener(this);
      
              this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
              this.setPreferredSize(new Dimension(765, 640));
              ScroolForPane=new JPanel();
              ScroolForPane.setLayout(new BoxLayout(ScroolForPane,BoxLayout.PAGE_AXIS));
              
         
        //Step:-2) Established Connection Data Base 
        try{
            con=DriverManager.getConnection
        ("jdbc:mysql://localhost/repair", "root", "");
        }catch(SQLException e){
            System.out.println(" DataBase is Not Found ");
        }
        
        //Step:-3) Statement SQL
        String query=" Select* from Report";
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            
            //Step:-4) Process Result 
            ResultSetMetaData md=rs.getMetaData();
            int column=md.getColumnCount();
            
            while(rs.next()){
                UnRepairedComputer=new JPanel();
                UnRepairedComputer.setLayout(new GridBagLayout());
                UnRepairedComputer.setBackground(Color.WHITE);
                
                cusName=new JLabel(" Customer Name  ");cusName.setFont(f1);
                cusMobileNo=new JLabel(" Mobile No. ");cusMobileNo.setFont(f1);
                cusAdress=new JLabel(" Adress ");cusAdress.setFont(f1);
                cusEmail=new JLabel(" Email ");cusEmail.setFont(f1);
                
                pName=new JLabel(" Product Name  ");pName.setFont(f1);
                pSN=new JLabel(" SN ");pSN.setFont(f1);
                pModel=new JLabel(" Model ");pModel.setFont(f1);
                pType=new JLabel(" Type ");pType.setFont(f1);
                pFaultDescription=new JLabel(" Fault Description");pFaultDescription.setFont(f1);
                endLine=new JLabel(" ************** ");endLine.setFont(f1);
                
                cusName_Db=new JLabel();cusName_Db.setFont(f2);
                cusMobileNo_Db=new JLabel();cusMobileNo_Db.setFont(f2);
                cusAdress_Db=new JLabel();cusAdress_Db.setFont(f2);
                cusEmail_Db=new JLabel();cusEmail_Db.setFont(f2);
                
                pName_Db=new JLabel();pName_Db.setFont(f2);
                pSN_Db=new JLabel();pSN_Db.setFont(f2);
                pModel_Db=new JLabel();pModel_Db.setFont(f2);
                pType_Db=new JLabel();pType_Db.setFont(f2);
                pFaultDescription_Db=new JLabel();pFaultDescription_Db.setFont(f2);
                
                cusName_Db.setText(rs.getObject("CustomerName").toString());
                cusMobileNo_Db.setText(rs.getObject("MobileNo").toString());
                cusAdress_Db.setText(rs.getObject("Adress").toString());
                cusEmail_Db.setText(rs.getObject("Email").toString());
           
                pName_Db.setText(rs.getObject("ComputerName").toString());
                pSN_Db.setText(rs.getObject("SN").toString());
                pModel_Db.setText(rs.getObject("Model").toString());
                pType_Db.setText(rs.getObject("Type").toString());
                pFaultDescription_Db.setText(rs.getObject("FaultDescription").toString());
                
                GridBagConstraints c=new GridBagConstraints();
                c.anchor=GridBagConstraints.LINE_START;
                c.insets=new Insets(5,20,0,20);
                c.gridx=0;c.gridy=0;UnRepairedComputer.add(cusName,c);
                c.gridx=1;c.gridy=0;UnRepairedComputer.add(cusName_Db,c);
                c.gridx=0;c.gridy=1;UnRepairedComputer.add(cusMobileNo,c);
                c.gridx=1;c.gridy=1;UnRepairedComputer.add(cusMobileNo_Db,c);
                c.gridx=0;c.gridy=2;UnRepairedComputer.add(cusEmail,c);
                c.gridx=1;c.gridy=2;UnRepairedComputer.add(cusEmail_Db,c);
                c.gridx=0;c.gridy=3;UnRepairedComputer.add(cusAdress,c);
                c.gridx=1;c.gridy=3;UnRepairedComputer.add(cusAdress_Db,c);
                
                c.gridx=0;c.gridy=4;UnRepairedComputer.add(pName,c);
                c.gridx=1;c.gridy=4;UnRepairedComputer.add(pName_Db,c);
                c.gridx=0;c.gridy=5;UnRepairedComputer.add(pSN,c);
                c.gridx=1;c.gridy=5;UnRepairedComputer.add(pSN_Db,c);
                c.gridx=0;c.gridy=6;UnRepairedComputer.add(pModel,c);
                c.gridx=1;c.gridy=6;UnRepairedComputer.add(pModel_Db,c);
                c.gridx=0;c.gridy=7;UnRepairedComputer.add(pType,c);
                c.gridx=1;c.gridy=7;UnRepairedComputer.add(pType_Db,c);
                c.gridx=0;c.gridy=8;UnRepairedComputer.add(pFaultDescription,c);
                c.gridx=1;c.gridy=8;UnRepairedComputer.add(pFaultDescription_Db,c);
               
                ScroolForPane.setBackground(Color.WHITE);
                ScroolForPane.add(UnRepairedComputer);
                ScroolForPane.add(endLine);
            }
            
            //Step:-5) Connection and Result Process Close
             rs.close();con.close();
             
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Qurey incorrect ");
        }
    
        JScrollPane scrollPane = new JScrollPane(ScroolForPane);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        this.add(scrollPane);
        this.setBackground(Color.BLACK);
        this.add(back);
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