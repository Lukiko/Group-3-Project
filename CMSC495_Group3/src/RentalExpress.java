import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    //carPanel.setLayout(null);
    //carJSPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    //carJSPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    //carJSPanel.setPreferredSize(600, 1000);
    //carJSPanel.setPreferredSize(new Dimension(600, 1000));
    //carJSPanel.getViewport().add(carPanel);
    
    ImageIcon hellcat = new ImageIcon("src/resources/hellcat.jpg");
    JToggleButton hellcatBtn = new JToggleButton("<html><center>2017 Dodge Challenger Hellcat<br> $158/day </center></html>", hellcat);
    hellcatBtn.setRolloverEnabled(true);
    hellcatBtn.setBounds(10, 10, 220, 210);
    hellcatBtn.setBackground(Color.WHITE);
    hellcatBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    hellcatBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    hellcatBtn.setFocusPainted(false);
    carPanel.add(hellcatBtn);
    
    ImageIcon camrytrd = new ImageIcon("src/resources/camrytrd.jpg");
    JToggleButton camryTRDBtn = new JToggleButton("<html><center>2020 Toyota Camry TRD<br> $96/day </center></html>", camrytrd);
    camryTRDBtn.setRolloverEnabled(true);
    camryTRDBtn.setBounds(240, 10, 220, 210);
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
    corvetteBtn.setBounds(470, 10, 220, 210);
    corvetteBtn.setBackground(Color.WHITE);
    corvetteBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    corvetteBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    corvetteBtn.setFocusPainted(false);
    carPanel.add(corvetteBtn);
    
    ImageIcon jeep = new ImageIcon("src/resources/jeep.jpg");
    JToggleButton jeepBtn = new JToggleButton("<html><center>2020 Jeep Wrangler<br> $85/day </center></html>", jeep);
    jeepBtn.setRolloverEnabled(true);
    jeepBtn.setBounds(10, 230, 220, 210);
    jeepBtn.setBackground(Color.WHITE);
    jeepBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    jeepBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    jeepBtn.setFocusPainted(false);
    carPanel.add(jeepBtn);
    
    ImageIcon f150 = new ImageIcon("src/resources/f150.jpg");
    JToggleButton f150Btn = new JToggleButton("<html><center>2020 Ford F-150<br> $92/day </center></html>", f150);
    f150Btn.setRolloverEnabled(true);
    f150Btn.setBounds(240, 230, 220, 210);
    f150Btn.setBackground(Color.WHITE);
    f150Btn.setVerticalTextPosition(SwingConstants.BOTTOM);
    f150Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    f150Btn.setFocusPainted(false);
    carPanel.add(f150Btn);
    
    ImageIcon crv = new ImageIcon("src/resources/crv.jpg");
    JToggleButton crvBtn = new JToggleButton("<html><center>2020 Honda CRV<br> $73/day </center></html>", crv);
    crvBtn.setRolloverEnabled(true);
    crvBtn.setBounds(470, 230, 220, 210);
    crvBtn.setBackground(Color.WHITE);
    crvBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    crvBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    crvBtn.setFocusPainted(false);
    carPanel.add(crvBtn);
    
    ImageIcon typeR = new ImageIcon("src/resources/typer.jpg");
    JToggleButton typeRBtn = new JToggleButton("<html><center>2020 Honda Civic Type R<br> $104/day </center></html>", typeR);
    typeRBtn.setRolloverEnabled(true);
    typeRBtn.setBounds(10, 460, 220, 210);
    typeRBtn.setBackground(Color.WHITE);
    typeRBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    typeRBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    typeRBtn.setFocusPainted(false);
    carPanel.add(typeRBtn);
    
    ImageIcon camry = new ImageIcon("src/resources/camry.jpg");
    JToggleButton camryBtn = new JToggleButton("<html><center>2020 Toyota Camry<br> $72/day </center></html>", camry);
    camryBtn.setRolloverEnabled(true);
    camryBtn.setBounds(10, 460, 220, 210);
    camryBtn.setBackground(Color.WHITE);
    camryBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    camryBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    camryBtn.setFocusPainted(false);
    carPanel.add(camryBtn);
    
    ImageIcon corolla = new ImageIcon("src/resources/corolla.jpg");
    JToggleButton corollaBtn = new JToggleButton("<html><center>2020 Toyota Corolla<br> $57/day </center></html>", corolla);
    corollaBtn.setRolloverEnabled(true);
    corollaBtn.setBounds(10, 460, 220, 210);
    corollaBtn.setBackground(Color.WHITE);
    corollaBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    corollaBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    corollaBtn.setFocusPainted(false);
    carPanel.add(corollaBtn);
    
    ImageIcon elantra = new ImageIcon("src/resources/elantra.jpg");
    JToggleButton elantraBtn = new JToggleButton("<html><center>2020 Hyundai Elantra <br> $52/day </center></html>", elantra);
    elantraBtn.setRolloverEnabled(true);
    elantraBtn.setBounds(10, 460, 220, 210);
    elantraBtn.setBackground(Color.WHITE);
    elantraBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    elantraBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    elantraBtn.setFocusPainted(false);
    carPanel.add(elantraBtn);
    
    ImageIcon explorer = new ImageIcon("src/resources/explorer.jpg");
    JToggleButton explorerBtn = new JToggleButton("<html><center>2020 Ford Explorer <br> $85/day </center></html>", explorer);
    explorerBtn.setRolloverEnabled(true);
    explorerBtn.setBounds(10, 460, 220, 210);
    explorerBtn.setBackground(Color.WHITE);
    explorerBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    explorerBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    explorerBtn.setFocusPainted(false);
    carPanel.add(explorerBtn);
    
    ImageIcon mazda3 = new ImageIcon("src/resources/mazda3.jpg");
    JToggleButton mazda3Btn = new JToggleButton("<html><center>2020 Mazda 3 Sedan <br> $51/day </center></html>", mazda3);
    mazda3Btn.setRolloverEnabled(true);
    mazda3Btn.setBounds(10, 460, 220, 210);
    mazda3Btn.setBackground(Color.WHITE);
    mazda3Btn.setVerticalTextPosition(SwingConstants.BOTTOM);
    mazda3Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    mazda3Btn.setFocusPainted(false);
    carPanel.add(mazda3Btn);
    
    ImageIcon highlander = new ImageIcon("src/resources/highlander.jpg");
    JToggleButton highlanderBtn = new JToggleButton("<html><center>2020 Mazda 3 Sedan <br> $51/day </center></html>", highlander);
    highlanderBtn.setRolloverEnabled(true);
    highlanderBtn.setBounds(10, 460, 220, 210);
    highlanderBtn.setBackground(Color.WHITE);
    highlanderBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    highlanderBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    highlanderBtn.setFocusPainted(false);
    carPanel.add(highlanderBtn);
    
    ImageIcon supra = new ImageIcon("src/resources/supra.jpg");
    JToggleButton supraBtn = new JToggleButton("<html><center>2020 Mazda 3 Sedan <br> $51/day </center></html>", supra);
    supraBtn.setRolloverEnabled(true);
    supraBtn.setBounds(10, 460, 220, 210);
    supraBtn.setBackground(Color.WHITE);
    supraBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
    supraBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    supraBtn.setFocusPainted(false);
    carPanel.add(supraBtn);
    
    ImageIcon wrx = new ImageIcon("src/resources/wrx.jpg");
    JToggleButton wrxBtn = new JToggleButton("<html><center>2020 Mazda 3 Sedan <br> $51/day </center></html>", wrx);
    wrxBtn.setRolloverEnabled(true);
    wrxBtn.setBounds(10, 460, 220, 210);
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

    
    // MouseListeners to clear text when JTextField is clicked
    
    fNameText.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        fNameText.setText("");
      }
    });
    
    lNameText.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        lNameText.setText("");
      }
    });
    
    addrText1.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        addrText1.setText("");
      }
    });
    
    addrText2.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        addrText2.setText("");
      }
    });
    
    emailText.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        emailText.setText("");
      }
    });
    
    userText.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        userText.setText("");
      }
    });
    
    passText.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        passText.setText("");
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
        
        
        Customer c = new Customer(fName, lName, addr1, addr2, email, user, pass, month, day, year);
        
        card.show(cardPanel, "p2");
        
        c.display();
        
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
