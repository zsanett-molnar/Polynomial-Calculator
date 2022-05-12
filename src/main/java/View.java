import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

public class View extends JFrame{
    private JFrame frame = new JFrame("Polynomial Calculator");
    private JTextField tf1 = new JTextField("",20);
    private JTextField tf2 = new JTextField("",20);
    private JTextField tf3 = new JTextField("",20);
    private JTextField tf4 = new JTextField("", 20);
    public JButton adunare = new JButton("+");
    public JButton scadere = new JButton("-");
    public JButton inmultire = new JButton("x");
    public JButton impartire = new JButton("/");
    public JButton derivare = new JButton("'");
    public JButton integrare = new JButton("∫");
    public JButton clear = new JButton("C");

    Controller controller = new Controller(this);

    public View() {
        adunare .addActionListener(controller);
        scadere .addActionListener(controller);
        inmultire .addActionListener(controller);
        impartire .addActionListener(controller);
        derivare .addActionListener(controller);
        integrare .addActionListener(controller);
        clear.addActionListener(controller);


        //JFrame frame = new JFrame("Polynomial Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        JPanel p = new JPanel();

//polinom1
        JPanel panel1 = new JPanel();
        JLabel label0 = new JLabel("Polynom 1:");
        panel1.add(label0);
        panel1.add(tf1);

//polinom2
        JPanel panel2 = new JPanel();
        JLabel label4 = new JLabel("Polynom 2:");
        panel2.add(label4);
        panel2.add(tf2);

//operatii
        JPanel panel3 = new JPanel();
        panel3.add(adunare);
        panel3.add(scadere);
        panel3.add(inmultire);
        panel3.add(impartire);
        panel3.add(derivare);
        panel3.add(integrare);
        panel3.add(clear);
        clear.setBackground(Color.YELLOW);

//rezultat
        JPanel panel4 = new JPanel();
        JLabel label5 = new JLabel("Result:");
        panel4.add(label5);
        panel4.add(tf3);

//rest
        JPanel panel5 = new JPanel();
        JLabel label6 = new JLabel("Rest:");
        panel5.add(label6);
        panel5.add(tf4);


        p.add(panel1);
        p.add(panel2);
        p.add(panel3);
        p.add(panel4);
        p.add(panel5);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        frame.setVisible(true);
        frame.setContentPane(p);

    }

    public String getFirstPolynom() {
        return tf1.getText();

    }

    public String getSecondPolynom() {
        return tf2.getText();
    }

    public void setResult(String result) {
        tf3.setText(result);
    }

    public void setRest(String result) {tf4.setText(result);
    }

    public void clearTextField() {
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        tf4.setText("");
    }
}
