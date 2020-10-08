
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


//start class
public class PaymentFrame extends JFrame {
    
    //initialize variables for elements
    private final JLabel nameLabel;
    private final JLabel addressLabel;
    private final JLabel creditLabel;
    private final JLabel expireLabel;
    private final JLabel cvcLabel;
    private final JButton payButton;
    private final JTextField nameText;
    private final JTextField addressText;
    private final JTextField creditText;
    private final JTextField expireText;
    private final JTextField cvcText;
    
    //start constructor
    public PaymentFrame () {
        
        //title
        super("Payment");
        
       //grid layout for 6 rows 2 columns, size, color, exit
       setLayout(new GridLayout(6,2,5,5));
       setBackground(Color.LIGHT_GRAY);
       setSize(600,200);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        //create objects of each element in layout
        nameLabel = new JLabel("Name and Surname:");
        
        nameText = new JTextField(20);
        
        addressLabel = new JLabel("Adress:");
        
        addressText = new JTextField(20);
        
        creditLabel = new JLabel("Credit Card Number:");
        
        creditText = new JTextField(20);
        
        expireLabel = new JLabel("Expiration Date:");
        
        expireText = new JTextField(20);
        
        cvcLabel = new JLabel("CVC:");
        
        cvcText = new JTextField(20);
        
        payButton = new JButton("Pay");
        //action event for pay button
        payButton.addActionListener (
        
        new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent event) {
                   //message dialog once user clicks pay
                JOptionPane.showMessageDialog(PaymentFrame.this,
                        "Your order will be delivered in 30 minutes");
               System.exit(0);
                        
            }
        } 
        ); // end action listener
        
        //add elements to frame
        add(nameLabel);
        add(nameText);
        add(addressLabel);
        add(addressText);
        add(creditLabel);
        add(creditText);
        add(expireLabel);
        add(expireText);
        add(cvcLabel);
        add(cvcText);
        add(payButton);
        
    } //end constructor
    
}//end class
