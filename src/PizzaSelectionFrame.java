
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

// class start
public class PizzaSelectionFrame extends JFrame {
    
    //initialize variables for elements
    private final JLabel pictureLabel;
    private final JComboBox <String> pizzaList;
    private final JLabel selectSizeLabel;
    private final JRadioButton smallButton;
    private final JRadioButton mediumButton;
    private final JRadioButton largeButton;
    private final ButtonGroup buttonGroup;
    private final JLabel selectToppingsLabel;
    private final JCheckBox mushroomButton;
    private final JCheckBox baconButton;
    private final JButton submitButton;
    
    //string array for pictures filenames
    private final String [] names = {
        "chicken.PNG", "pepperoni.PNG", "veggie.PNG"
    };
    //icon array for picture files
    private final Icon [] icons = {
        
        new ImageIcon(getClass().getResource(names[0])),
        new ImageIcon(getClass().getResource(names[1])),
        new ImageIcon(getClass().getResource(names[2]))
    };
    
    //string array with pizza names
    private final String [] pizzaType = {
        "Chicken pizza", "Pepperoni pizza", "Veggie Pizza"
    };
    
    
    //start constructor
    public PizzaSelectionFrame() {
        
        super("Order Pizza");
        
        //create objects of each element in the layout
        setLayout(new FlowLayout());
        
        pictureLabel = new JLabel(icons[0]);
        
        pizzaList = new JComboBox <String> (pizzaType);
        pizzaList.setMaximumRowCount(3);
        
        //item listener for pictures
        pizzaList.addItemListener(
            new ItemListener() { //anonymous inner class
            
                @Override
                public void itemStateChanged (ItemEvent event) {
                    
                    if (event.getStateChange() == ItemEvent.SELECTED)
                        pictureLabel.setIcon(icons[pizzaList.getSelectedIndex()]);
                }
                
            } //end anonymous inner class
        ); //end call to addItemListener
        
        selectSizeLabel = new JLabel("Select Size: ");
        
        smallButton = new JRadioButton("Small", true);
        
        mediumButton = new JRadioButton("Medium", false);
        
        largeButton = new JRadioButton("Large", false);
        
        buttonGroup = new ButtonGroup();
        buttonGroup.add(smallButton);
        buttonGroup.add(mediumButton);
        buttonGroup.add(largeButton);
        
        selectToppingsLabel = new JLabel("Select Topping(s): ");
        
        mushroomButton = new JCheckBox("Mushroom");
        
        baconButton = new JCheckBox("Bacon");
        
        submitButton = new JButton("Submit");
        //action event for submit button
        submitButton.addActionListener(
                new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        
                        //logical options for size and toppings
                        String summary = "Order Summary: ";
                        if(smallButton.isSelected()){
                            summary += "Small size ";
                        }else if(mediumButton.isSelected()){
                            summary += "Medium size ";
                        }else if(largeButton.isSelected()){
                            summary +="Large size ";
                        }
                        summary += pizzaList.getSelectedItem();
                        if(mushroomButton.isSelected() && baconButton.isSelected()){
                            summary += " with mushroom and bacon";
                        }else if(mushroomButton.isSelected()){
                            summary += " with mushroom";
                        }else if(baconButton.isSelected()){
                            summary += " with bacon";
                        }else{
                            summary += " with no topping";
                        }
                        
                        //store ok as int value for payment frame option
                        int value = JOptionPane.showOptionDialog(PizzaSelectionFrame.this,
                        summary, "Confirmation", JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
                        
                        // if user clicked ok start payment window
                        if(value == 0){
                        PaymentFrame paymentFrame = new PaymentFrame();
                        paymentFrame.setVisible(true);
                        
                        }
                    }
                } //acction listener
        
        );
        
        //add elements to frame
        add(pictureLabel);
        add(pizzaList);
        add(selectSizeLabel);
        add(smallButton);
        add(mediumButton);
        add(largeButton);
        add(selectToppingsLabel);
        add(mushroomButton);
        add(baconButton);
        add(submitButton);
        
        
    } //end constructor

} // end class
