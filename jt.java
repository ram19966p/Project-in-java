import javax.swing.JFrame ;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;



class MyFr2 extends JFrame implements MouseListener,MouseMotionListener
{
JTextField tf1 , tf2;
int x, y;
String ss;
MyFr2(String s)
{
 super( s);
setLayout(new FlowLayout());
addMouseListener(this);
addMouseMotionListener(this);
tf1 =new JTextField(20);

add(tf1);
}
public void mouseClicked(MouseEvent me)
{
  
   x=me.getX();
   y=me.getY();
  int c;
c=me.getClickCount();
if(c==1)
  { 
     ss="Single clicked" ;
   }
else
{
  ss = "Double clicked" ;
}
showMessage(ss);
}
public void mouseEntered(MouseEvent me)
{
   x=me.getX();
   y=me.getY();
ss="Mouse Entered";
showMessage(ss);
}
public void mouseExited(MouseEvent me)
{
 x=me.getX();
   y=me.getY();
ss="Mouse Exited";
showMessage(ss);
}
public void mousePressed(MouseEvent me)
{
 x=me.getX();
   y=me.getY();
ss="Mouse Preseed";
showMessage(ss);
}
public void mouseReleased(MouseEvent me)
{
 x=me.getX();
   y=me.getY();
ss="Mouse Reeleased";
showMessage(ss);
}
public void mouseMoved( MouseEvent me)
{
 x=me.getX();
   y=me.getY();
ss="Mouse Moved";
showMessage(ss);
}
public void mouseDragged(MouseEvent me)
{
 x=me.getX();
   y=me.getY();
ss="Mouse RAM";
showMessage(ss);
}
public void showMessage(String s)
{
     tf1.setText(s+", "+ x+","+ y);
}
}