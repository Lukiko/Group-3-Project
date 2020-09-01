import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class RentalExpress {

  JFrame frame = new JFrame("Rental Express");
  
  JPanel buttonPanel = new JPanel();
  JPanel cardPanel = new JPanel();
  
  JPanel acctPanel = new JPanel();
  JPanel pickupPanel = new JPanel();
  JPanel carPanel = new JPanel();
  JPanel finalPanel = new JPanel();
  
  JButton accBtn = new JButton("<html><center>"+"Create Account / Log In"+"</html></center>");
  JButton pickupBtn = new JButton("<html><center>"+"Pick-Up Location and Date"+"</html></center>");
  JButton carBtn = new JButton("Select Car");
  JButton finalBtn = new JButton("Checkout");
  
  JTextArea t1 = new JTextArea(10, 10);
  JTextArea t2 = new JTextArea(10, 10);
  JTextArea t3 = new JTextArea(10, 10);
  JTextArea t4 = new JTextArea(10, 10);
  
  JSplitPane sp = new JSplitPane(SwingConstants.VERTICAL, buttonPanel, cardPanel);
  
  CardLayout card = new CardLayout();
  
  public RentalExpress() {
    
    frame.setSize(900, 600);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    
    sp.setOneTouchExpandable(false);
    sp.setDividerLocation(150);
    
    buttonPanel.setLayout(new GridLayout(4, 1));
    buttonPanel.add(accBtn);
    buttonPanel.add(pickupBtn);
    buttonPanel.add(carBtn);
    buttonPanel.add(finalBtn);
    
    cardPanel.setLayout(card);
    cardPanel.add(acctPanel, "p1");
    cardPanel.add(pickupPanel, "p2");
    cardPanel.add(carPanel, "p3");
    cardPanel.add(finalPanel, "p4");
    
    t1.setText("Test account Panel");
    t2.setText("Test pickup Panel");
    t3.setText("Test car Panel");
    t4.setText("Test final Panel");
    
    acctPanel.add(t1);
    pickupPanel.add(t2);
    carPanel.add(t3);
    finalPanel.add(t4);
    
    accBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        card.show(cardPanel,  "p1");
      }
    });
    
    pickupBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        card.show(cardPanel,  "p2");
      }
    });
    
    carBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        card.show(cardPanel,  "p3");
      }
    });
    
    finalBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        card.show(cardPanel,  "p4");
      }
    });
    
    
    frame.add(sp);
    frame.setVisible(true);
    frame.setResizable(false);
  }
  
  
  
  
  
  public static void main(String[] args) {
    new RentalExpress();

  }





//  @Override
//  public void actionPerformed(ActionEvent event) {
//    
//    if (event.getSource().equals(accBtn)) {
//      
//      card.show(cardPanel, "p1");
//    }
//    
//    if (event.getSource().equals(pickupBtn)) {
//      
//      card.show(cardPanel, "p2");
//    }
//    
//    
//  }

}
