import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {
    JButton login,cancel;
    JPasswordField tfpassword;
    JTextField tfusername;
    Login()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel lblusername= new JLabel("Username:");
        lblusername.setBounds(40,20,100,20);
        add(lblusername);
        tfusername=new JTextField();
        tfusername.setBounds(150,22,150,20);
        add(tfusername);
        JLabel lblpassword= new JLabel("Password:");
        lblpassword.setBounds(40,70,100,20);
        add(lblpassword);
        tfpassword=new JPasswordField();
        tfpassword.setBounds(150,74,150,20);
        add(tfpassword);



        login=new JButton("LOGIN");
        login.setBounds(50,140,120,30);
        login.setBackground(Color.ORANGE);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("serif",Font.BOLD,16));
        add(login);

        cancel=new JButton("CANCEL");
        cancel.setBounds(180,140,120,30);
        cancel.setBackground(Color.ORANGE);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif",Font.BOLD,16));
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/otp.png"));
        Image i2=i1.getImage().getScaledInstance(270, 210, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,10,150,150);
        add(image);



        setSize(600,300);
        setLocation(500,250);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            String username= tfusername.getText();
            String password=tfpassword.getText();

            String query="select * from login where username='"+username+"' and password ='"+password+"'";
            try {
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Project();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Username and Password");
                }
                c.s.close();
            }catch (Exception e1){
               e1.printStackTrace();
            }

        }else if(e.getSource()==cancel){
            setVisible(false);
        }

    }
    public static void main(String[] args)
    {
        new Login();
    }


}
