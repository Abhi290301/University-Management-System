import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddStudent extends JFrame implements ActionListener {
    JTextField tfName,tffName,tfAddress,tfPhone,tfEmail,tfx,tfxii,tfaadhar;
    Random ran=new Random();
    JLabel labelRollno;
    JDateChooser dcdob;
    JComboBox cbcourse,cbbranch;
    JButton submit,cancel;
    long first4=Math.abs((ran.nextLong()%9000L)+1000L);

    AddStudent(){
        setSize(900,700);
        setLocation(320,50);

        setLayout(null);

        JLabel heading=new JLabel("Enter Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
//Student Name
        JLabel lblname=new JLabel(" Student Name:");
        lblname.setBounds(50,150,150,30);
       lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);
        tfName=new JTextField();
        tfName.setBounds(200,150,150,30);
        add(tfName);
        //Father Name
        JLabel lblfname=new JLabel(" Father's Name:");
        lblfname.setBounds(400,150,150,30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);
        tffName=new JTextField();
        tffName.setBounds(600,150,150,30);
        add(tffName);

        //Roll number
        JLabel lblrollno=new JLabel(" Student RollNo.:");
        lblrollno.setBounds(50,200,200,30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);
        labelRollno=new JLabel(" 1533"+first4);
        labelRollno.setBounds(200,200,200,30);
        labelRollno.setFont(new Font("serif",Font.BOLD,20));
        add(labelRollno);

        //D.O.B
        JLabel lbldob=new JLabel(" Date of Birth:");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);
      dcdob=new JDateChooser();
      dcdob.setBounds(600,200,200,30);
      add(dcdob);

      //Address
        JLabel lbladdress=new JLabel("Student Address:");
        lbladdress.setBounds(50,250,200,30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);
        tfAddress=new JTextField();
        tfAddress.setBounds(200,250,150,30);
        add(tfAddress);

        //Phone No.
        JLabel lblphone=new JLabel(" Mobile No.:");
        lblphone.setBounds(400,250,200,30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);
        tfPhone=new JTextField();
        tfPhone.setBounds(600,250,150,30);
        add(tfPhone);

        //Email
        JLabel lblemail=new JLabel(" E-mail:");
        lblemail.setBounds(50,300,250,30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);
        tfEmail=new JTextField();
        tfEmail.setBounds(200,300,150,30);
        add(tfEmail);

        //10%
        JLabel lblx=new JLabel(" Class X (%):");
        lblx.setBounds(400,300,200,30);
        lblx.setFont(new Font("serif",Font.BOLD,20));
        add(lblx);
        tfx=new JTextField();
        tfx.setBounds(600,300,150,30);
        add(tfx);
        //X+2
        JLabel lblxii=new JLabel(" Class XII(%)");
        lblxii.setBounds(50,350,200,30);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);
        tfxii=new JTextField();
        tfxii.setBounds(200,350,150,30);
        add(tfxii);
        //Aadhar
        JLabel lblaadhar=new JLabel(" Aadhar No.");
        lblaadhar.setBounds(400,350,200,30);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);
        tfaadhar=new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);
//Course preference
        JLabel lblCourse=new JLabel(" Aadhar No.");
        lblCourse.setBounds(50,400,200,30);
        lblCourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblCourse);

        String course[]={"B.Tech","BBA","BCA","BSC","MSC","MBA","MCA","B.A"};
        cbcourse=new JComboBox(course);
        cbcourse.setBackground(Color.WHITE);
        cbcourse.setBounds(200,400,150,30);
        add(cbcourse);

        //Branch preference
        JLabel lblbranch=new JLabel(" Branch");
        lblbranch.setBounds(400,400,200,30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);

        String branch[]={"Computer Science","Electrical","Electronics","IT","Civil"};
        cbbranch=new JComboBox(branch);
        cbbranch.setBackground(Color.WHITE);
        cbbranch.setBounds(600,400,150,30);
        add(cbbranch);


        //Buttons
        submit=new JButton("SUBMIT");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.ORANGE);
        submit.setForeground(Color.WHITE);
      submit.addActionListener(this);
        submit.setFont(new Font("serif",Font.BOLD,16));
        add(submit);

        cancel=new JButton("CANCEL");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.ORANGE);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif",Font.BOLD,16));
        add(cancel);


        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String name=tfName.getText();
            String fname=tffName.getText();
            String rollno=labelRollno.getText();
            String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address=tfAddress.getText();
            String phone=tfPhone.getText();
            String email=tfEmail.getText();
            String x=tfx.getText();
            String xii=tfxii.getText();
            String adhar=tfaadhar.getText();
            String course=(String) cbcourse.getSelectedItem();
            String branch=(String) cbbranch.getSelectedItem();

            try {
                String query="insert into student values('"+name+"','"+fname+"','"+rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+adhar+"','"+course+"','"+branch+"')";
                Conn con=new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Student Details inserted successfully");
                setVisible(false);

            }catch (Exception e1){
e1.printStackTrace();
            }
        }else {
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new AddStudent();
    }

}
