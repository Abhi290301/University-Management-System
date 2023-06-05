import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeaveDetails extends JFrame implements ActionListener {
    Choice cempId;
    JTable table;
    JButton search,print,update,add,cancel;
    TeacherLeaveDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading=new JLabel("Search by Employee ID");
        heading.setBounds(20,20,150,20);
        add(heading);

        cempId=new Choice();
        cempId.setBounds(180,20,150,20);
        add(cempId);
        try {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from teacher");
            while (rs.next()){
                cempId.add(rs.getString("empId"));
            }
//          table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
        table=new JTable();
        try {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from teacherleave");
//            while (rs.next()){
//                crollno.add(rs.getString("rollno"));
//            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);


        //Search
        search =new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        //Print
        print =new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        //Cancel
        cancel =new JButton("Cancel");
        cancel.setBounds(220,70,80,20);
        cancel.addActionListener(this);
        add(cancel);


        setSize(900,700);
        setLocation(320,50);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            String query="select * from studentleave where empId='"+cempId.getSelectedItem()+"'";
            try {
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e1){

            }

        }else if(e.getSource()==print){
            try {
                table.print();
            }catch (Exception e1){
                e1.printStackTrace();
            }

        }else if(e.getSource()==cancel){
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new TeacherLeaveDetails();
    }


}
