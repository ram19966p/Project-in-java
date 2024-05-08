import 	javax.swing.JFrame;
import  javax.swing.JDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;;
import java.awt.event.ActionListener;
import  javax.swing.JTextField;
import javax.swing.JButton;
class Mp12 extends JDialog implements ActionListener
{
  String s="";
 JTextField  j1,j2;
 JButton  b1;
  public Mp12(MyFr2 ob  )
  {
 super(ob,true);

  setSize(400,400);
  setVisible(true);
 setLayout(new FlowLayout());

    j1=new JTextField(20);
    j2 = new JTextField(20);
    b1=new JButton("Press");
    b1.addActionListener(this);
    add(j1);
  add(b1);
  add(j2);
    
    }
 
  public void actionPerformed(ActionEvent ae)
{
   j1.setText("**********");
  
 }

}
  
     
