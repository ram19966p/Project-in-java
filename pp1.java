import javax.swing.JFrame ;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

class MyFr1 extends JFrame implements ActionListener,ItemListener
{
  
  JLabel l1,l2,l3 ;
  JTextField  tf1 , tf2,tf3  ;
  JButton  b1;
 JCheckBox cb1 ,cb2, cb3, cb4;
 JComboBox  jc1;
JRadioButton jb1,jb2,jb3;
 String s1;

ButtonGroup bg1 = new ButtonGroup();
 
   MyFr1()

{
super("Ramalakhan ") ;

setLayout(new FlowLayout());

jb1 =new JRadioButton("Male");
jb2 =new JRadioButton("Female" );
jb3 =new JRadioButton("outher" );

bg1.add(jb1);
bg1.add(jb2);
bg1.add(jb3);

 jb1.addActionListener(this);
 jb2.addActionListener(this);
 jb3.addActionListener(this);




jc1=new JComboBox();

jc1.addItem("Bhopal");
jc1.addItem("Indore");
jc1.addItem("America");
jc1.addItem("Rajsthan");

jc1.addItemListener(this);


cb1=new JCheckBox("Samosa");
cb2=new JCheckBox( "Kachori");
cb3=new JCheckBox( "Jlebi");
cb4=new JCheckBox("Bramha Bhojan");


cb1.addItemListener(this);
cb2.addItemListener(this);
cb3.addItemListener(this);
cb4.addItemListener(this);

 l1=new JLabel(" Enter name" );
 l2=new JLabel(" Enter sir name");
l3=new JLabel("Select your gender");
 tf1=new JTextField(20);

  tf2=new JTextField(20);
  tf3=new JTextField(20);

  b1=new JButton("ok" );
  b1.addActionListener(this);


 add(jc1);


  add(l1);
 add(tf1);
 add(l2);
 add(tf2);
add(b1);


add(l3);
add(jb1);
add(jb2);
add(jb3);



add(cb1);
add(cb2);
add(cb3);
add(cb4);


add(tf3); 
  }
  public void actionPerformed(ActionEvent ae)
{
String t1, r1,r2,r3,s1,s2,s3=" ";
s1=tf1.getText();
s2=tf2.getText();
s3=s1+"  "+s2; 


 if(ae.getSource()==jb1)
{
    r1=" mr" ;
}
else
{
  r1="";
}
 if(ae.getSource()==jb2)
    {
        r2 = " miss" ;
     }
      else
          {
             r2="";
          }
          if(ae.getSource()==jb3)
             {
               r3= "outher" ;
               }
               else
             	{
		 r3="";
 		}
tf3.setText(r1+r2+r3+"  "+s3);
 

}
public void itemStateChanged(ItemEvent ae)
{
 
 JOptionPane.showMessageDialog(null,"you select"+" "+ jc1.getSelectedItem()+" city ");

String s1,s2,s3,s4,s5,s6,r1,r2,s=" ";
s5=tf1.getText();
s6=tf2.getText();
s=s5+" "+s6;
 
  

 
  if(cb1.isSelected())
{
     s1 = " samosa ";
}
else
{
   s1=""; 
}
 if(cb2.isSelected())
{
   s2 = "kachori ";

}
else
{
  s2="";
}
if(cb3.isSelected())
{
   s3 = " Jalebi ";
}
else
{
 s3=" ";
}
if(cb4.isSelected())
{
  s4 = " BramhaBhojan ";
}
else
{
 s4=" ";
}
 tf3.setText(s+s1+s2+s3+s4);

}
}