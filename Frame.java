import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFr1 extends JFrame implements ActionListener {

    JLabel l1, l2;
    JTextField tf1, tf2, tf3;
    JButton b1;

    MyFr1() {
        super("My first Frame");
        setLayout(new FlowLayout());

        l1 = new JLabel("Enter name");
        l2 = new JLabel("Enter sir name");
        tf1 = new JTextField(20);
        tf2 = new JTextField(20);
        tf3 = new JTextField(20);
        b1 = new JButton("OK");
        b1.addActionListener(this);

        // Set text color
        l1.setForeground(Color.BLUE);
        l2.setForeground(Color.RED);
        b1.setForeground(Color.GREEN);
        tf3.setForeground(Color.BLACK);

        add(l1);
        add(tf1);
        add(l2);
        add(tf2);
        add(b1);
        add(tf3);
    }

    public void actionPerformed(ActionEvent ae) {
        String s1, s2, s3;
        s1 = tf1.getText();
        s2 = tf2.getText();
        s3 = s1 + " " + s2;
        tf3.setText(s3);
    }

    public static void main(String[] args) {
        MyFr1 frame = new MyFr1();
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
