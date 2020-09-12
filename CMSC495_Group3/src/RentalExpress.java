import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class RentalExpress {
  
  private String fName, lName, addr1, addr2, email, user, pass, month;
  private int day, year;
  
  private String pickupLoc, pickupMonth, dropoffLoc, dropoffMonth;
  private int pickupDay, pickupYear, dropoffDay, dropoffYear;

  Customer c = new Customer();
  
  boolean acctMade = false;
  boolean carSelected = false;
  
  private String whichCar = "";
  private int carPrice;
  private int totalPrice;
  private int numRentalDays;
  
  JFrame frame = new JFrame("Rental Express");
  
  JPanel buttonPanel = new JPanel();
  JPanel cardPanel = new JPanel();
  
  JPanel acctPanel = new JPanel();
  JPanel pickupPanel = new JPanel();
  JPanel carPanel = new JPanel();
  JPanel finalPanel = new JPanel();
  
  JScrollPane carJSPanel = new JScrollPane(carPanel);
  
  JPanel acctGrid1 = new JPanel();
  JPanel acctGrid2 = new JPanel();
  JPanel acctGrid3 = new JPanel();
  JPanel acctGrid4 = new JPanel();
  JPanel acctGrid5 = new JPanel();
  JPanel acctGrid6 = new JPanel();
  JPanel acctGrid7 = new JPanel();
  JPanel acctGrid8 = new JPanel();
  JPanel acctGrid9 = new JPanel();
  JPanel acctGrid10 = new JPanel();
  JPanel acctGrid11 = new JPanel();
  JPanel acctGrid12 = new JPanel();
  JPanel acctGrid13 = new JPanel();
  JPanel acctGrid14 = new JPanel();
  JPanel acctGrid15 = new JPanel();
  JPanel acctGrid16 = new JPanel();
  JPanel acctGrid17 = new JPanel();
  
  // Account panel items
  JButton accBtn = new JButton("<html><center>"+"Create Account / Log In"+"</html></center>");
  JButton pickupBtn = new JButton("<html><center>"+"Pick-Up Location and Date"+"</html></center>");
  JButton carBtn = new JButton("Select Car");
  JButton finalBtn = new JButton("Checkout");
  
  JButton regBtn = new JButton("Register Account");
  
  JLabel fNameLabel = new JLabel("First Name: ", SwingConstants.CENTER);
  JLabel lNameLabel = new JLabel("Last Name: ", SwingConstants.CENTER);
  JLabel addressLabel = new JLabel("Address: ", SwingConstants.CENTER);
  JLabel emailLabel = new JLabel("Email Address: ", SwingConstants.CENTER);
  JLabel userLabel = new JLabel("Username: ", SwingConstants.CENTER);
  JLabel passLabel = new JLabel("Password: ", SwingConstants.CENTER);
  JLabel creditLabel = new JLabel("Credit Card # (No Spaces): ", SwingConstants.CENTER);
  JLabel bdayLabel = new JLabel("Birthday: ", SwingConstants.CENTER);
  
  String[] bMJCB = {"January", "February", "March", "April", "May", "June", "July", "August", 
      "September", "October", "November", "December"};
  JComboBox birthMonthJCB = new JComboBox(bMJCB);
  Integer[] bDJCB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
      21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
  JComboBox birthDayJCB = new JComboBox(bDJCB);
  Integer[] bYJCB = {2020, 2019, 2018, 2017, 2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007, 2006,
      2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997, 1996, 1995, 1994, 1993, 1992, 1991,
      1990, 1989, 1988, 1987, 1986, 1985, 1984, 1983, 1982, 1981, 1980, 1979, 1978, 1977, 1976,
      1975, 1974, 1973, 1972, 1971, 1970, 1969, 1968, 1967, 1966, 1965, 1964, 1963, 1962, 1961,
      1960, 1959, 1958, 1957, 1956, 1955, 1954, 1953, 1952, 1951, 1950, 1949, 1948, 1947, 1946,
      1945, 1944, 1943, 1942, 1941, 1940, 1939, 1938, 1937, 1936, 1935, 1934, 1933, 1932, 1931,
      1930, 1929, 1928, 1927, 1926, 1925, 1924, 1923, 1922, 1921, 1920, 1919, 1918, 1917, 1916,
      1915, 1914, 1913, 1912, 1911, 1910, 1909, 1908, 1907, 1906, 1905, 1904, 1903, 1902, 1901,
      1900};
  JComboBox birthYearJCB = new JComboBox(bYJCB);
  
  JTextField fNameText = new JTextField(" First Name ");
  JTextField lNameText = new JTextField(" Last Name ");
  JTextField addrText1 = new JTextField(" House/Apt # & Street ");
  JTextField addrText2 = new JTextField(" City, State, Zip ");
  JTextField emailText = new JTextField(" Email Address ");
  JTextField userText = new JTextField(" Username ");
  JTextField passText = new JTextField(" Password ");
  
  // location & car panel items
  JLabel pickUpLocLabel = new JLabel("Pick-Up Location: ", SwingConstants.CENTER);
  JLabel dropOffLocLabel = new JLabel("Drop-Off Location: ", SwingConstants.CENTER);
  JLabel dropOffDayLabel = new JLabel("Drop-Off Date: ");
  JLabel pickUpDayLabel = new JLabel("Pick-Up Date: ");
  
  String[] puJCB = {"Alexandria, VA", "Centreville, VA", "Chantilly, VA", "Culpeper, VA", "Falls Church, VA", "Fairfax, VA"};
  String[] doJCB = {"Alexandria, VA", "Centreville, VA", "Chantilly, VA", "Culpeper, VA", "Falls Church, VA", "Fairfax, VA"};
  JComboBox pickUpJCB = new JComboBox(puJCB);
  JComboBox dropOffJCB = new JComboBox(doJCB);
  
  Integer[] doDJCB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
      21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
  String[] doMJCB = {"January", "February", "March", "April", "May", "June", "July", "August", 
      "September", "October", "November", "December"};
  Integer[] doYJCB = {2020, 2021};
  JComboBox doDayJCB = new JComboBox(doDJCB);
  JComboBox doMonthJCB = new JComboBox(doMJCB);
  JComboBox doYearJCB = new JComboBox(doYJCB);
  
  Integer[] puDJCB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
      21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
  String[] puMJCB = {"January", "February", "March", "April", "May", "June", "July", "August", 
      "September", "October", "November", "December"};
  Integer[] puYJCB = {2020, 2021};
  JComboBox puYearJCB = new JComboBox(puYJCB);
  JComboBox puDayJCB = new JComboBox(puDJCB);
  JComboBox puMonthJCB = new JComboBox(puMJCB);
  
  
  
  
  
  JSplitPane sp = new JSplitPane(SwingConstants.VERTICAL, buttonPanel, cardPanel);
  
  CardLayout card = new CardLayout();
  
  public RentalExpress() {
    
    frame.setSize(900, 600);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    
    sp.setOneTouchExpandable(false);
    sp.setDividerLocation(150);
    
    buttonPanel.setLayout(new GridLayout(4, 1));
    accBtn.setFocusPainted(false);
    pickupBtn.setFocusPainted(false);
    carBtn.setFocusPainted(false);
    finalBtn.setFocusPainted(false);
    buttonPanel.add(accBtn);
    buttonPanel.add(pickupBtn);
    buttonPanel.add(carBtn);
    buttonPanel.add(finalBtn);
    //buttonPanel.add(carJSPanel);
    
    cardPanel.setLayout(card);
    cardPanel.add(acctPanel, "p1");
    cardPanel.add(pickupPanel, "p2");
    cardPanel.add(carJSPanel, "p3");
    cardPanel.add(finalPanel, "p4");
    
    // Account panel
    fNameText.setHorizontalAlignment(JTextField.CENTER);
    lNameText.setHorizontalAlignment(JTextField.CENTER);
    addrText1.setHorizontalAlignment(JTextField.CENTER);
    addrText2.setHorizontalAlignment(JTextField.CENTER);
    emailText.setHorizontalAlignment(JTextField.CENTER);
    userText.setHorizontalAlignment(JTextField.CENTER);
    passText.setHorizontalAlignment(JTextField.CENTER);
    
    regBtn.setFocusPainted(false);
    
    acctPanel.setLayout(new GridLayout(18, 1));
    acctPanel.add(acctGrid1);
    acctGrid1.setLayout(new GridLayout(1, 4));
    acctPanel.add(acctGrid2);
    acctGrid2.setLayout(new GridLayout(1, 4));
    acctPanel.add(acctGrid3);
    acctGrid3.setLayout(new GridLayout(1, 4));
    acctPanel.add(acctGrid4);
    acctGrid4.setLayout(new GridLayout(1, 4));
    acctPanel.add(acctGrid5);
    acctGrid5.setLayout(new GridLayout(1, 4));
    acctPanel.add(acctGrid6);
    acctGrid6.setLayout(new GridLayout(1, 4));
    acctPanel.add(acctGrid7);
    acctGrid7.setLayout(new GridLayout(1, 4));
    acctPanel.add(acctGrid8);
    acctGrid8.setLayout(new GridLayout(1, 4));
    acctPanel.add(acctGrid9);
    acctGrid9.setLayout(new GridLayout(1, 4));
    acctPanel.add(acctGrid10);
    acctGrid10.setLayout(new GridLayout(1, 4));
    acctPanel.add(acctGrid11);
    acctGrid11.setLayout(new GridLayout(1, 4));
    acctPanel.add(acctGrid12);
    acctGrid12.setLayout(new GridLayout(1, 4));
    acctPanel.add(acctGrid13);
    acctGrid13.setLayout(new GridLayout(1, 4));
    acctPanel.add(acctGrid14);
    acctGrid14.setLayout(new GridLayout(1, 4));
    acctPanel.add(acctGrid15);
    acctGrid15.setLayout(new GridLayout(1, 4));
    acctPanel.add(acctGrid16);
    acctGrid16.setLayout(new GridLayout(1, 4));
    acctPanel.add(acctGrid17);
    acctGrid17.setLayout(new GridLayout(1, 2));
    
    acctGrid1.add(fNameLabel);
    acctGrid1.add(fNameText);
    acctGrid1.add(lNameLabel);
    acctGrid1.add(lNameText);
    acctGrid3.add(addressLabel);
    addressLabel.setHorizontalAlignment(JLabel.LEFT);
    acctGrid4.add(addrText1);
    acctGrid5.add(addrText2);
    acctGrid7.add(emailLabel);
    acctGrid7.add(emailText);
    acctGrid8.add(userLabel);
    acctGrid8.add(userText);
    acctGrid9.add(passLabel);
    acctGrid9.add(passText);
    acctGrid11.add(bdayLabel);
    acctGrid11.add(birthMonthJCB);
    acctGrid11.add(birthDayJCB);
    acctGrid11.add(birthYearJCB);
    acctGrid17.add(regBtn);
    
    // Pick-Up Drop-Off Panel
    pickupPanel.setLayout(null);
    
    //---------------------------- Pick Up
    
    pickUpDayLabel.setBounds(70, 50, 80, 50);
    pickupPanel.add(pickUpDayLabel);
       
    puMonthJCB.setBounds(160, 60, 85, 35);
    pickupPanel.add(puMonthJCB);
    
    puDayJCB.setBounds(250, 60, 50, 35);
    pickupPanel.add(puDayJCB);
      
    puYearJCB.setBounds(305, 60, 60, 35);
    pickupPanel.add(puYearJCB);
    
    pickUpLocLabel.setBounds(42, 105, 110, 50);
    pickupPanel.add(pickUpLocLabel);
    
    pickUpJCB.setBounds(160, 115, 165, 35);
    pickupPanel.add(pickUpJCB);
    
    //---------------------------- Drop Off
    
    dropOffDayLabel.setBounds(66, 205, 85, 50);
    pickupPanel.add(dropOffDayLabel);
    
    doMonthJCB.setBounds(160, 215, 85, 35);
    pickupPanel.add(doMonthJCB);
    
    doDayJCB.setBounds(250, 215, 50, 35);
    pickupPanel.add(doDayJCB);
    
    doYearJCB.setBounds(305, 215, 60, 35);
    pickupPanel.add(doYearJCB);
    
    dropOffLocLabel.setBounds(41, 260, 110, 50);
    pickupPanel.add(dropOffLocLabel);
    
    dropOffJCB.setBounds(160, 270, 165,35);
    pickupPanel.add(dropOffJCB);
    
    //------------------------------ Car Model Panel
    
    GridLayout carLayout = new GridLayout(5, 3);
    carPanel.setLayout(carLayout);
    carLayout.setHgap(5);
    carLayout.setVgap(5);
    Border padding = BorderFactory.createEmptyBorder(5, 5, 5, 5);
    carPanel.setBorder(padding);
    carJSPanel.getVerticalScrollBar().setUnitIncrement(15);
    
    ImageIcon hellcat = new ImageIcon("src/resources/hellcat.jpg");
    JToggleButton hellcatBtn = new JToggleButton("<html><center>2017 Dodge Challenger Hellcat<br> $158/day </center></html>", hellcat);
    hellcatBtn.setRolloverEnabled(true);
//    hellcatBtn.setBounds(10, 10, 220, 210);
    hellcatBtn.setBackground(Color.WHITE);
    hellcatBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    hellcatBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    hellcatBtn.setFocusPainted(false);
    carPanel.add(hellcatBtn);
    
    ImageIcon camrytrd = new ImageIcon("src/resources/camrytrd.jpg");
    JToggleButton camryTRDBtn = new JToggleButton("<html><center>2020 Toyota Camry TRD<br> $96/day </center></html>", camrytrd);
    camryTRDBtn.setRolloverEnabled(true);
//    camryTRDBtn.setBounds(240, 10, 220, 210);
    camryTRDBtn.setBackground(Color.WHITE);
    camryTRDBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    camryTRDBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    camryTRDBtn.setFocusPainted(false);
    camryTRDBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    carPanel.add(camryTRDBtn);
    
    ImageIcon corvette = new ImageIcon("src/resources/corvette.jpg");
    JToggleButton corvetteBtn = new JToggleButton("<html><center>2020 Chevrolet Corvette<br> $135/day </center></html>", corvette);
    corvetteBtn.setRolloverEnabled(true);
//    corvetteBtn.setBounds(470, 10, 220, 210);
    corvetteBtn.setBackground(Color.WHITE);
    corvetteBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    corvetteBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    corvetteBtn.setFocusPainted(false);
    carPanel.add(corvetteBtn);
    
    ImageIcon jeep = new ImageIcon("src/resources/jeep.jpg");
    JToggleButton jeepBtn = new JToggleButton("<html><center>2020 Jeep Wrangler<br> $85/day </center></html>", jeep);
    jeepBtn.setRolloverEnabled(true);
//    jeepBtn.setBounds(10, 230, 220, 210);
    jeepBtn.setBackground(Color.WHITE);
    jeepBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    jeepBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    jeepBtn.setFocusPainted(false);
    carPanel.add(jeepBtn);
    
    ImageIcon f150 = new ImageIcon("src/resources/f150.jpg");
    JToggleButton f150Btn = new JToggleButton("<html><center>2020 Ford F-150<br> $92/day </center></html>", f150);
    f150Btn.setRolloverEnabled(true);
//    f150Btn.setBounds(240, 230, 220, 210);
    f150Btn.setBackground(Color.WHITE);
    f150Btn.setVerticalTextPosition(SwingConstants.BOTTOM);
    f150Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    f150Btn.setFocusPainted(false);
    carPanel.add(f150Btn);
    
    ImageIcon crv = new ImageIcon("src/resources/crv.jpg");
    JToggleButton crvBtn = new JToggleButton("<html><center>2020 Honda CRV<br> $73/day </center></html>", crv);
    crvBtn.setRolloverEnabled(true);
//    crvBtn.setBounds(470, 230, 220, 210);
    crvBtn.setBackground(Color.WHITE);
    crvBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    crvBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    crvBtn.setFocusPainted(false);
    carPanel.add(crvBtn);
    
    ImageIcon typeR = new ImageIcon("src/resources/typer.jpg");
    JToggleButton typeRBtn = new JToggleButton("<html><center>2020 Honda Civic Type R<br> $104/day </center></html>", typeR);
    typeRBtn.setRolloverEnabled(true);
//    typeRBtn.setBounds(10, 460, 220, 210);
    typeRBtn.setBackground(Color.WHITE);
    typeRBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    typeRBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    typeRBtn.setFocusPainted(false);
    carPanel.add(typeRBtn);
    
    ImageIcon camry = new ImageIcon("src/resources/camry.jpg");
    JToggleButton camryBtn = new JToggleButton("<html><center>2020 Toyota Camry<br> $72/day </center></html>", camry);
    camryBtn.setRolloverEnabled(true);
//    camryBtn.setBounds(10, 460, 220, 210);
    camryBtn.setBackground(Color.WHITE);
    camryBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    camryBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    camryBtn.setFocusPainted(false);
    carPanel.add(camryBtn);
    
    ImageIcon corolla = new ImageIcon("src/resources/corolla.jpg");
    JToggleButton corollaBtn = new JToggleButton("<html><center>2020 Toyota Corolla<br> $57/day </center></html>", corolla);
    corollaBtn.setRolloverEnabled(true);
//    corollaBtn.setBounds(10, 460, 220, 210);
    corollaBtn.setBackground(Color.WHITE);
    corollaBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    corollaBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    corollaBtn.setFocusPainted(false);
    carPanel.add(corollaBtn);
    
    ImageIcon elantra = new ImageIcon("src/resources/elantra.jpg");
    JToggleButton elantraBtn = new JToggleButton("<html><center>2020 Hyundai Elantra <br> $52/day </center></html>", elantra);
    elantraBtn.setRolloverEnabled(true);
//    elantraBtn.setBounds(10, 460, 220, 210);
    elantraBtn.setBackground(Color.WHITE);
    elantraBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    elantraBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    elantraBtn.setFocusPainted(false);
    carPanel.add(elantraBtn);
    
    ImageIcon explorer = new ImageIcon("src/resources/explorer.jpg");
    JToggleButton explorerBtn = new JToggleButton("<html><center>2020 Ford Explorer <br> $85/day </center></html>", explorer);
    explorerBtn.setRolloverEnabled(true);
//    explorerBtn.setBounds(10, 460, 220, 210);
    explorerBtn.setBackground(Color.WHITE);
    explorerBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    explorerBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    explorerBtn.setFocusPainted(false);
    carPanel.add(explorerBtn);
    
    ImageIcon mazda3 = new ImageIcon("src/resources/mazda3.jpg");
    JToggleButton mazda3Btn = new JToggleButton("<html><center>2020 Mazda 3 Sedan <br> $51/day </center></html>", mazda3);
    mazda3Btn.setRolloverEnabled(true);
//    mazda3Btn.setBounds(10, 460, 220, 210);
    mazda3Btn.setBackground(Color.WHITE);
    mazda3Btn.setVerticalTextPosition(SwingConstants.BOTTOM);
    mazda3Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    mazda3Btn.setFocusPainted(false);
    carPanel.add(mazda3Btn);
    
    ImageIcon highlander = new ImageIcon("src/resources/highlander.jpg");
    JToggleButton highlanderBtn = new JToggleButton("<html><center>2020 Toyota Highaldner <br> $82/day </center></html>", highlander);
    highlanderBtn.setRolloverEnabled(true);
//    highlanderBtn.setBounds(10, 460, 220, 210);
    highlanderBtn.setBackground(Color.WHITE);
    highlanderBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    highlanderBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    highlanderBtn.setFocusPainted(false);
    carPanel.add(highlanderBtn);
    
    ImageIcon supra = new ImageIcon("src/resources/supra.jpg");
    JToggleButton supraBtn = new JToggleButton("<html><center>2020 Toyota Supra <br> $74/day </center></html>", supra);
    supraBtn.setRolloverEnabled(true);
//    supraBtn.setBounds(10, 460, 220, 210);
    supraBtn.setBackground(Color.WHITE);
    supraBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    supraBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    supraBtn.setFocusPainted(false);
    carPanel.add(supraBtn);
    
    ImageIcon wrx = new ImageIcon("src/resources/wrx.jpg");
    JToggleButton wrxBtn = new JToggleButton("<html><center>2020 Subaru WRX <br> $97/day </center></html>", wrx);
    wrxBtn.setRolloverEnabled(true);
//    wrxBtn.setBounds(10, 460, 220, 210);
    wrxBtn.setBackground(Color.WHITE);
    wrxBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    wrxBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    wrxBtn.setFocusPainted(false);
    carPanel.add(wrxBtn);
    
    
    
    
    
    ButtonGroup carGroup = new ButtonGroup();
    carGroup.add(hellcatBtn);
    carGroup.add(camryTRDBtn);
    carGroup.add(corvetteBtn);
    carGroup.add(jeepBtn);
    carGroup.add(f150Btn);
    carGroup.add(crvBtn);
    carGroup.add(typeRBtn);
    carGroup.add(corollaBtn);
    carGroup.add(camryBtn);
    carGroup.add(elantraBtn);
    carGroup.add(explorerBtn);
    carGroup.add(mazda3Btn);
    carGroup.add(wrxBtn);
    carGroup.add(supraBtn);
    carGroup.add(highlanderBtn);

    // ------------------------------------- Checkout Panel
    
    JTextArea jt = new JTextArea("Test area");
    
    finalPanel.setBackground(Color.white);
    finalPanel.add(jt);
    
    
    // ActionListener for Checkout Button
    
    finalBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jt.setText("");
        
        totalPrice = 0;
        
        if (carSelected) {
          if (acctMade) {

            checkCustomer();

            numRentalDays = getRentalDays();
            
            pickupLoc = (String) pickUpJCB.getSelectedItem();
            pickupDay = (Integer) puDayJCB.getSelectedItem();
            pickupMonth = (String) puMonthJCB.getSelectedItem();
            pickupYear = (Integer) puYearJCB.getSelectedItem();
            dropoffLoc = (String) dropOffJCB.getSelectedItem();
            dropoffDay = (Integer) doDayJCB.getSelectedItem();
            dropoffMonth = (String) doMonthJCB.getSelectedItem();
            dropoffYear = (Integer) doYearJCB.getSelectedItem();

            jt.append("Customer Name: " + c.getFirstName() + " " + c.getLastName() + "\n");
            jt.append("Contact Info: " + c.getEmail() + "\n\n");
            jt.append("Rental Car: " + whichCar + "\n");
            jt.append("Price per day: $" + carPrice + "\n");
            jt.append("Pickup Location: " + pickupLoc + " on " + pickupMonth + " " + pickupDay + ", " + pickupYear + "\n");
            jt.append("Dropoff Location: " + dropoffLoc + " on " + dropoffMonth + " " + dropoffDay + ", " + dropoffYear
                + "\n");
            jt.append("Number of Days: " + numRentalDays + "\n\n");
            
            if (pickupLoc != dropoffLoc) {
              jt.append("Surcharge for dropping vehicle off at a different location: $50\n");
              totalPrice += 50;
            }
            totalPrice += carPrice * numRentalDays;
            jt.append(whichCar + " for " + numRentalDays + " days: " + "$" + 
              totalPrice + "\n");
            //double salesTax = Math.round(((totalPrice * .053) * 100.0)/ 100.0);
            double salesTaxRaw = totalPrice * .053;
            double salesTax = round(salesTaxRaw, 2);
            //BigDecimal salesTax = BigDecimal.valueOf(salesTaxRaw);
            //salesTax = salesTax.setScale(2, RoundingMode.HALF_UP);
            jt.append("VA Sales Tax: $" + salesTax + "\n");
            jt.append("Total: $" + (salesTax + totalPrice));
            
          } else {
            card.show(cardPanel,  "p1");
            JOptionPane.showMessageDialog(null, "Please create a customer account");
          }
        } else {
          card.show(cardPanel,  "p3");
          JOptionPane.showMessageDialog(null, "Please select a car");
        }
      }
    });
    
    // ActionListeners for Cars
    
    hellcatBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        whichCar = "2020 Dodge Challenger Hellcat";
        carSelected = true;
        carPrice = 158;
      }
    });
    
    camryTRDBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        whichCar = "2020 Toyota Camry TRD";
        carSelected = true;
        carPrice = 96;
      }
    });
    
    corvetteBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        whichCar = "2020 Chevrolet Corvette";
        carSelected = true;
        carPrice = 135;
      }
    });
    
    jeepBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        whichCar = "2020 Jeep Wrangler";
        carSelected = true;
        carPrice = 85;
      }
    });
    
    f150Btn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        whichCar = "2020 Ford F-150";
        carSelected = true;
        carPrice = 92;
      }
    });
    
    crvBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        whichCar = "2020 Honda CR-V";
        carSelected = true;
        carPrice = 73;
      }
    });
    
    typeRBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        whichCar = "2020 Honda Civic Type R";
        carSelected = true;
        carPrice = 104;
      }
    });
    
    corollaBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        whichCar = "2020 Toyota Corolla";
        carSelected = true;
        carPrice = 72;
      }
    });
    
    camryBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        whichCar = "2020 Toyota Camry";
        carSelected = true;
        carPrice = 57;
      }
    });
    
    elantraBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        whichCar = "2020 Hyundai Elantra";
        carSelected = true;
        carPrice = 52;
      }
    });
    
    explorerBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        whichCar = "2020 Ford Explorer";
        carSelected = true;
        carPrice = 85;
      }
    });
    
    mazda3Btn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        whichCar = "2020 Mazda 3";
        carSelected = true;
        carPrice = 51;
      }
    });
    
    wrxBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        whichCar = "2020 Subaru WRX";
        carSelected = true;
        carPrice = 97;
      }
    });
    
    supraBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        whichCar = "2020 Toyota Supra";
        carSelected = true;
        carPrice = 74;
      }
    });
    
    highlanderBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        whichCar = "2020 Toyota Highlander";
        carSelected = true;
        carPrice = 82;
      }
    });
    
    // MouseListeners to clear text when JTextField is clicked
    
    fNameText.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        fNameText.setText("");
        fNameText.setForeground(Color.black);
      }
    });
    
    lNameText.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        lNameText.setText("");
        lNameText.setForeground(Color.black);
      }
    });
    
    addrText1.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        addrText1.setText("");
        addrText1.setForeground(Color.black);
      }
    });
    
    addrText2.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        addrText2.setText("");
        addrText2.setForeground(Color.black);
      }
    });
    
    emailText.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        emailText.setText("");
        emailText.setForeground(Color.black);
      }
    });
    
    userText.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        userText.setText("");
        userText.setForeground(Color.black);
      }
    });
    
    passText.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        passText.setText("");
        passText.setForeground(Color.black);
      }
    });
    
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
    
    regBtn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        
        if (checkCustomer()) {
        
        fName = fNameText.getText();
        lName = lNameText.getText();
        addr1 = addrText1.getText();
        addr2 = addrText2.getText();
        email = emailText.getText();
        user = userText.getText();
        pass = passText.getText();
        month = (String) birthMonthJCB.getSelectedItem();
        day = (Integer) birthDayJCB.getSelectedItem();
        year = (Integer) birthYearJCB.getSelectedItem();
        
        c.setFirstName(fName);
        c.setLastName(lName);
        c.setAddress1(addr1);
        c.setAddress2(addr2);
        c.setEmail(email);
        c.setUsername(user);
        c.setPassword(pass);
        c.setMonth(month);
        c.setDay(day);
        c.setYear(year);
        
        card.show(cardPanel, "p2");
        
        }
        
      }
    });
    
    
    frame.add(sp);
    frame.setVisible(true);
    frame.setResizable(false);
  }
  
  public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    BigDecimal bd = BigDecimal.valueOf(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
  }
  
  public Integer getRentalDays() {
    
    if (checkRentalDays()) {
      
      int pickupNum = 0;
      int dropoffNum = 0;
      
      pickupDay = (Integer) puDayJCB.getSelectedItem();
      pickupMonth = (String) puMonthJCB.getSelectedItem();
      pickupYear = (Integer) puYearJCB.getSelectedItem();
      dropoffDay = (Integer) doDayJCB.getSelectedItem();
      dropoffMonth = (String) doMonthJCB.getSelectedItem();
      dropoffYear = (Integer) doYearJCB.getSelectedItem();
      
      switch (pickupMonth) {
        case "January" :
          pickupNum = 1;
          break;
        case "February" :
          pickupNum = 2;
          break;
        case "March" :
          pickupNum = 3;
          break;
        case "April" :
          pickupNum = 4;
          break;
        case "May" :
          pickupNum = 5;
          break;
        case "June" :
          pickupNum = 6;
          break;
        case "July" :
          pickupNum = 7;
          break;
        case "August" :
          pickupNum = 8;
          break;
        case "September" :
          pickupNum = 9;
          break;
        case "October" :
          pickupNum = 10;
          break;
        case "November" :
          pickupNum = 11;
          break;
        case "December" :
          pickupNum = 12;
          break;
      }
      
      switch (dropoffMonth) {
        case "January" :
          dropoffNum = 1;
          break;
        case "February" :
          dropoffNum = 2;
          break;
        case "March" :
          dropoffNum = 3;
          break;
        case "April" :
          dropoffNum = 4;
          break;
        case "May" :
          dropoffNum = 5;
          break;
        case "June" :
          dropoffNum = 6;
          break;
        case "July" :
          dropoffNum = 7;
          break;
        case "August" :
          dropoffNum = 8;
          break;
        case "September" :
          dropoffNum = 9;
          break;
        case "October" :
          dropoffNum = 10;
          break;
        case "November" :
          dropoffNum = 11;
          break;
        case "December" :
          dropoffNum = 12;
          break;
      }
      
      int numMonths = dropoffNum - pickupNum;
      int numDays = 0;
      
      
      if (dropoffYear > pickupYear) {
        numMonths = dropoffNum + (11 - pickupNum);
        numDays = (30 - pickupDay) + dropoffDay + (numMonths * 30);
        System.out.println(numMonths);
        return numDays;
      }
      if (dropoffNum - pickupNum == 0){
        numDays = dropoffDay - pickupDay;
        return numDays;
//        numMonths = dropoffNum - pickupNum;
//        if (numMonths > 0) {
//          numDays = (30 - pickupDay) + dropoffDay + (numMonths * 30);
//          return numDays;
      }
      if (numMonths == 1) {
        numDays = (30 - pickupDay) + dropoffDay;
        return numDays;
      }
      else {
        numMonths = (dropoffNum - pickupNum) - 1;
        numDays = (30 - pickupDay) + dropoffDay + (numMonths * 30);
        System.out.println(dropoffNum);
        System.out.println(pickupNum);
        System.out.println(numMonths);
        return numDays;
      }
//        numDays = (30 - pickupDay) + dropoffDay;
//        System.out.println(numMonths);
//        return numDays;
    } else {
      return 0;
    }
  }
  
  public boolean checkRentalDays() {
    
    int pickupNum = 0;
    int dropoffNum = 0;
    
    pickupDay = (Integer) puDayJCB.getSelectedItem();
    pickupMonth = (String) puMonthJCB.getSelectedItem();
    pickupYear = (Integer) puYearJCB.getSelectedItem();
    dropoffDay = (Integer) doDayJCB.getSelectedItem();
    dropoffMonth = (String) doMonthJCB.getSelectedItem();
    dropoffYear = (Integer) doYearJCB.getSelectedItem();
    
    if (dropoffYear < pickupYear) {
      card.show(cardPanel,  "p2");
      JOptionPane.showMessageDialog(null, "Please enter a valid pick-up and drop-off date");
      return false;
    }
    
    switch (pickupMonth) {
      case "January" :
        pickupNum = 1;
        break;
      case "February" :
        pickupNum = 2;
        break;
      case "March" :
        pickupNum = 3;
        break;
      case "April" :
        pickupNum = 4;
        break;
      case "May" :
        pickupNum = 5;
        break;
      case "June" :
        pickupNum = 6;
        break;
      case "July" :
        pickupNum = 7;
        break;
      case "August" :
        pickupNum = 8;
        break;
      case "September" :
        pickupNum = 9;
        break;
      case "October" :
        pickupNum = 10;
        break;
      case "November" :
        pickupNum = 11;
        break;
      case "December" :
        pickupNum = 12;
        break;
    }
    
    switch (dropoffMonth) {
      case "January" :
        dropoffNum = 1;
        break;
      case "February" :
        dropoffNum = 2;
        break;
      case "March" :
        dropoffNum = 3;
        break;
      case "April" :
        dropoffNum = 4;
        break;
      case "May" :
        dropoffNum = 5;
        break;
      case "June" :
        dropoffNum = 6;
        break;
      case "July" :
        dropoffNum = 7;
        break;
      case "August" :
        dropoffNum = 8;
        break;
      case "September" :
        dropoffNum = 9;
        break;
      case "October" :
        dropoffNum = 10;
        break;
      case "November" :
        dropoffNum = 11;
        break;
      case "December" :
        dropoffNum = 12;
        break;
    }
    
    if (pickupNum > dropoffNum) {
      card.show(cardPanel,  "p2");
      JOptionPane.showMessageDialog(null, "Please enter a valid pick-up and drop-off date");
      return false;
    }
    
    if (pickupNum == dropoffNum) {
      if (pickupDay > dropoffDay) {
        card.show(cardPanel,  "p2");
        JOptionPane.showMessageDialog(null, "Please enter a valid pick-up and drop-off date");
        return false;
      }
    }
    
    
    return true;
  }
  
  public boolean checkCustomer() {
    if (fNameText.getText().equals(" First Name ") || fNameText.getText().equals("")) {
      card.show(cardPanel,  "p1");
      fNameText.setText("**Required**");
      fNameText.setForeground(Color.RED);
      JOptionPane.showMessageDialog(null, "Please complete all fields");
      return false;
    }
    else if (lNameText.getText().equals(" Last Name ") || lNameText.getText().equals("")) {
      card.show(cardPanel,  "p1");
      lNameText.setText("**Required**");
      lNameText.setForeground(Color.RED);
      JOptionPane.showMessageDialog(null, "Please complete all fields");
      return false;
    }
    else if (addrText1.getText().equals(" House/Apt # & Street ") || addrText1.getText().equals("")) {
      card.show(cardPanel,  "p1");
      addrText1.setText("**Required**");
      addrText1.setForeground(Color.RED);
      JOptionPane.showMessageDialog(null, "Please complete all fields");
      return false;
    }
    else if (addrText2.getText().equals(" City, State, Zip ") || addrText2.getText().equals("")) {
      card.show(cardPanel,  "p1");
      addrText2.setText("**Required**");
      addrText2.setForeground(Color.RED);
      JOptionPane.showMessageDialog(null, "Please complete all fields");
      return false;
    }
    else if (emailText.getText().equals(" Email Address ") || emailText.getText().equals("")) {
      card.show(cardPanel,  "p1");
      emailText.setText("**Required**");
      emailText.setForeground(Color.RED);
      JOptionPane.showMessageDialog(null, "Please complete all fields");
      return false;
    }
    else if (userText.getText().equals(" Username ") || userText.getText().equals("")) {
      card.show(cardPanel,  "p1");
      userText.setText("**Required**");
      userText.setForeground(Color.RED);
      JOptionPane.showMessageDialog(null, "Please complete all fields");
      return false;
    }
    else if (passText.getText().equals(" Password ") || passText.getText().equals("")) {
      card.show(cardPanel,  "p1");
      passText.setText("**Required**");
      passText.setForeground(Color.RED);
      JOptionPane.showMessageDialog(null, "Please complete all fields");
      return false;
    }
    else {
      acctMade = true;
      return true;
    }
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
