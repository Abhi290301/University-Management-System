import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project extends JFrame implements ActionListener {
   Project(){
       setSize(1540,850);



       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/hp_college.jpg"));
       Image i2=i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       add(image);
//NEw INFORMATION
       JMenuBar mb=new JMenuBar();
       JMenu newinformation=new JMenu("New Information");
       newinformation.setForeground(Color.RED);
       mb.add(newinformation);
       JMenuItem facultyInfo=new JMenuItem("New Faculty Information");
       facultyInfo.addActionListener(this);
       facultyInfo.setBackground(Color.WHITE);
       newinformation.add(facultyInfo);

       JMenuItem studentInfo=new JMenuItem("New Student Information");
       studentInfo.addActionListener(this);
       studentInfo.setBackground(Color.WHITE);
       newinformation.add(studentInfo);


       //DETAILS

       JMenu details=new JMenu("View Details");
       details.setForeground(Color.RED);
       mb.add(details);
       JMenuItem facultyDetails=new JMenuItem("Faculty Details");
       facultyDetails.addActionListener(this);
       facultyDetails.setBackground(Color.WHITE);
       details.add(facultyDetails);

       JMenuItem studentDetails=new JMenuItem("Student Details");
       studentDetails.addActionListener(this);
       studentDetails.setBackground(Color.WHITE);
       details.add(studentDetails);
       setJMenuBar(mb);

//Leave
       JMenu leave=new JMenu("Apply Leave");
       leave.setForeground(Color.RED);
       mb.add(leave);
       JMenuItem facultyLeave =new JMenuItem("Faculty Leave");
       facultyLeave.setBackground(Color.WHITE);
       facultyLeave.addActionListener(this);
       leave.add(facultyLeave);

       JMenuItem studentLeave=new JMenuItem("Student Leave");
       studentLeave.addActionListener(this);
       studentLeave.setBackground(Color.WHITE);
       leave.add(studentLeave);

       //Leave Details
       JMenu leavedetails=new JMenu("Leave Details");
       leavedetails.setForeground(Color.RED);
       mb.add(leavedetails);
       JMenuItem facultyLeavedetail =new JMenuItem("Faculty Leave Details");
       facultyLeavedetail.addActionListener(this);
       facultyLeavedetail.setBackground(Color.WHITE);

       leavedetails.add(facultyLeavedetail);

       JMenuItem studentLeaveDetail=new JMenuItem("Student Leave Details");
        studentLeaveDetail.addActionListener(this);
       studentLeaveDetail.setBackground(Color.WHITE);
       leavedetails.add(studentLeaveDetail);


       //Exam
       JMenu exam=new JMenu("Semester Results");
       exam.setForeground(Color.RED);
       mb.add(exam);
       JMenuItem examinationResult =new JMenuItem(" Final Examination Results");
       examinationResult.setBackground(Color.WHITE);
       examinationResult.addActionListener(this);
       exam.add(examinationResult);

       JMenuItem enterMarks=new JMenuItem("Enter Marks");
       enterMarks.setBackground(Color.WHITE);
       enterMarks.addActionListener(this);
      exam.add(enterMarks);
       //MST Results
       JMenu mst=new JMenu("MST Results");
       mst.setForeground(Color.RED);
       mb.add(mst);
       JMenuItem mstResult =new JMenuItem(" MST Results");
       mstResult.setBackground(Color.WHITE);
       mstResult.addActionListener(this);
       mst.add(mstResult);

       JMenuItem enterMstMarks=new JMenuItem("Enter Marks");
       enterMstMarks.setBackground(Color.WHITE);
       enterMstMarks.addActionListener(this);
       mst.add(enterMstMarks);


       //Update Info
       JMenu updateInfo=new JMenu("Update Details");
       updateInfo.setForeground(Color.RED);
       mb.add(updateInfo);
       JMenuItem updatefacultyInfo =new JMenuItem("Update Faculty Information");
      updatefacultyInfo.setBackground(Color.WHITE);
      updatefacultyInfo.addActionListener(this);
       updateInfo.add(updatefacultyInfo);

       JMenuItem updateStudentInfo=new JMenuItem("Update Student Information");
       updateStudentInfo.setBackground(Color.WHITE);
       updateStudentInfo.addActionListener(this);
       updateInfo.add(updateStudentInfo);

       //Fee
       JMenu fee=new JMenu("Fee");
       fee.setForeground(Color.RED);
       mb.add(fee);
       JMenuItem feeStructure =new JMenuItem("Fee Structure");
       feeStructure.setBackground(Color.WHITE);
       feeStructure.addActionListener(this);
       fee.add(feeStructure);

       JMenuItem feeForm=new JMenuItem("Student Fee Form");
      feeForm.setBackground(Color.WHITE);
      feeForm.addActionListener(this);
     fee.add(feeForm);

       //Utility
       JMenu utility=new JMenu("Utilities");
       utility.setForeground(Color.RED);
       mb.add(utility);
       JMenuItem notepad =new JMenuItem("Notepad");
       notepad.setBackground(Color.WHITE);
       notepad.addActionListener(this);
       utility.add(notepad);

       JMenuItem calc=new JMenuItem("Calculator");
       calc.setBackground(Color.WHITE);
       calc.addActionListener(this);
       utility.add(calc);
       JMenuItem msword=new JMenuItem("MSWord");
       msword.setBackground(Color.WHITE);
       msword.addActionListener(this);
       utility.add(msword);


       //About
       //Utility
       JMenu about=new JMenu("About");
      about.setForeground(Color.BLACK);
       mb.add(about);
       JMenuItem abt =new JMenuItem("Developer Info");
       abt.setBackground(Color.WHITE);
       abt.addActionListener(this);
       about.add(abt);

       //Exit
       JMenu exit=new JMenu("Exit");
       exit.setForeground(Color.RED);
       mb.add(exit);

       JMenuItem ex=new JMenuItem("Exit");
       ex.setBackground(Color.WHITE);
       ex.addActionListener(this);
       exit.add(ex);



       setJMenuBar(mb);




       setVisible(true);


   }
    @Override
    public void actionPerformed(ActionEvent e) {
       String msg=e.getActionCommand();
       if(msg.equals("Exit")){
           setVisible(false);
       }else if(msg.equals("Calculator")){
           try{
               Runtime.getRuntime().exec("calc.exe");
           }catch (Exception e1){

           }
       }else if(msg.equals("Notepad")){
           try{
               Runtime.getRuntime().exec("notepad.exe");
           }catch (Exception e1){

           }
       }else if(msg.equals("MSWord")) {
           try {
               Runtime.getRuntime().exec("Winword.exe");
           } catch (Exception e1) {

           }
       }else if(msg.equals("New Faculty Information")){
           new AddTeacher();
       }else if(msg.equals("New Student Information")){
           new AddStudent();
       }
       else if(msg.equals("Faculty Details")){
           new TeacherDetails();
       }
       else if(msg.equals("Student Details")){
           new StudentDetails();
       }else  if(msg.equals("Faculty Leave")){
           new TeacherLeave();

       }else  if(msg.equals("Student Leave")){
        new StudentLeave();
       }else  if(msg.equals("Student Leave Details")){
           new StudentLeaveDetails();
       }else  if(msg.equals("Faculty Leave Details")){
           new TeacherLeaveDetails();
       }else  if(msg.equals("Examination Results")){
           new ExaminationDetails();
       }else  if(msg.equals("Enter Marks")){
           new SemesterMarks();
       }else  if(msg.equals("Update Faculty Information")){
           new UpdateTeacher();
       }else  if(msg.equals("Update Student Information")){
           new UpdateStudent();
       }else  if(msg.equals("Fee Structure")){
           new FeeStructure();
       }else  if(msg.equals("Student Fee Form")){
           new StudentFeeForm();
       }else  if(msg.equals("Developer Info")){
           new About();
       }
    }
   public static void main(String[] args) {
        new Project();
    }
}
