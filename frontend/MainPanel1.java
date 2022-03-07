package frontend;

import java.awt.*;
import backend.Inventory;
import backend.Clothing;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class MainPanel1 extends JPanel {
	private Inventory items;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JScrollPane scrollPane;
	private JComboBox comboBox;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	

	//-----------------------------------------------------------------
	// Sets up the panel, including the timer for the animation.
	//-----------------------------------------------------------------
	public MainPanel1()
	{
		
		items = new Inventory("./inventoryFile.txt");
		System.out.println(items);
		
		setPreferredSize (new Dimension(670, 564));
	    setBackground (Color.lightGray);
		setLayout(null);
		
		
		ArrayList<String> clothes = new ArrayList<String>();
		for(Clothing c : items.retrieveCollection()) {
			clothes.add("Type: " + c.getType() + "  Size:" + c.getSize() + 
					"  Price: " + c.getPrice() + "  Quantity: " + c.getQuantity() + 
					"  ID:" + c.getProduct_num());
		}
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 451, 604, 92);
		add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setText(null);
		String dataStr = "";
		for(String c : clothes) {
			dataStr = dataStr + c.toString() + "\n";
			textArea.setText(dataStr);
			
		}
		
	    
		JLabel lblHarrisonsClosetInventory = new JLabel("Harrison's Closet Inventory");
		lblHarrisonsClosetInventory.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblHarrisonsClosetInventory.setBounds(10, 10, 392, 50);
		add(lblHarrisonsClosetInventory);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> types = new ArrayList<String>();
				for(Clothing c : items.retrieveCollection()) {
					if(comboBox.getSelectedItem().equals(c.getType())) {
						types.add("Type: " + c.getType() + "  Size:" + c.getSize() + 
								"  Price: " + c.getPrice() + "  Quantity: " + c.getQuantity() + 
								"  ID:" + c.getProduct_num());
					}
				}
				String dataStr = "";
				for (String c : types) {
					dataStr = dataStr + c.toString() + "\n";
				}
				
				textArea.setText(dataStr);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"shirt", "hoodie", "sweater", "pants", "shorts"}));
		comboBox.setBounds(32, 127, 182, 33);
		add(comboBox);
		
		JSlider slider = new JSlider();
		slider.setValue(60);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int price = 0;
				ArrayList<String> prices = new ArrayList<String>();
				JSlider source = (JSlider)e.getSource();
				if(!source.getValueIsAdjusting()) {
					price = (int)source.getValue();
				}
				for(Clothing c : items.retrieveCollection()) {
					if(c.getPrice() <= price) {
						prices.add("Type: " + c.getType() + "  Size:" + c.getSize() + 
								"  Price: " + c.getPrice() + "  Quantity: " + c.getQuantity() + 
								"  ID:" + c.getProduct_num());;
					}
				}
				String dataStr = "";
				for (String c : prices) {
					dataStr = dataStr + c.toString() + "\n";
				}
				textArea.setText(dataStr);
			}
		});
		
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMaximum(60);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(5);
		slider.setMinimum(5);
		slider.setBounds(32, 374, 604, 39);
		add(slider);
		
		
		JRadioButton rdbtnSmall = new JRadioButton("Small");
		rdbtnSmall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> smalls = new ArrayList<String>();
				for(Clothing c : items.retrieveCollection()) {
					if(c.getSize().equals("small")) {
						smalls.add("Type: " + c.getType() + "  Size:" + c.getSize() + 
								"  Price: " + c.getPrice() + "  Quantity: " + c.getQuantity() + 
								"  ID:" + c.getProduct_num());;
					}
				}
				String dataStr = "";
				for (String c : smalls) {
					dataStr = dataStr + c.toString() + "\n";
				}
				textArea.setText(dataStr);
				
			}
		});
		buttonGroup.add(rdbtnSmall);
		rdbtnSmall.setBounds(272, 133, 103, 21);
		add(rdbtnSmall);
		
		JRadioButton rdbtnMedium = new JRadioButton("Medium");
		rdbtnMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> mediums = new ArrayList<String>();
				for(Clothing c : items.retrieveCollection()) {
					if(c.getSize().equals("medium")) {
						mediums.add("Type: " + c.getType() + "  Size:" + c.getSize() + 
								"  Price: " + c.getPrice() + "  Quantity: " + c.getQuantity() + 
								"  ID:" + c.getProduct_num());;
					}
				}
				String dataStr = "";
				for (String c : mediums) {
					dataStr = dataStr + c.toString() + "\n";
				}
				textArea.setText(dataStr);
				
			}
		});
		buttonGroup.add(rdbtnMedium);
		rdbtnMedium.setBounds(272, 179, 103, 21);
		add(rdbtnMedium);
		
		JRadioButton rdbtnLarge = new JRadioButton("Large");
		rdbtnLarge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> larges = new ArrayList<String>();
				for(Clothing c : items.retrieveCollection()) {
					if(c.getSize().equals("large")) {
						larges.add("Type: " + c.getType() + "  Size:" + c.getSize() + 
								"  Price: " + c.getPrice() + "  Quantity: " + c.getQuantity() + 
								"  ID:" + c.getProduct_num());;
					}
				}
				String dataStr = "";
				for (String c : larges) {
					dataStr = dataStr + c.toString() + "\n";
				}
				textArea.setText(dataStr);
				
			}
		});
		buttonGroup.add(rdbtnLarge);
		rdbtnLarge.setSelected(true);
		rdbtnLarge.setBounds(272, 226, 103, 21);
		add(rdbtnLarge);
		
		JRadioButton rdbtnExtralarge = new JRadioButton("Extra-Large");
		rdbtnExtralarge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> extraLarges = new ArrayList<String>();
				for(Clothing c : items.retrieveCollection()) {
					if(c.getSize().equals("extra-large")) {
						extraLarges.add("Type: " + c.getType() + "  Size:" + c.getSize() + 
								"  Price: " + c.getPrice() + "  Quantity: " + c.getQuantity() + 
								"  ID:" + c.getProduct_num());;
					}
				}
				String dataStr = "";
				for (String c : extraLarges) {
					dataStr = dataStr + c.toString() + "\n";
				}
				textArea.setText(dataStr);
				
			}
		});
		buttonGroup.add(rdbtnExtralarge);
		rdbtnExtralarge.setBounds(272, 281, 103, 21);
		add(rdbtnExtralarge);
		
		JCheckBox chckbxTops = new JCheckBox("Tops");
		buttonGroup_1.add(chckbxTops);
		chckbxTops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> tops = new ArrayList<String>();
				for(Clothing c : items.retrieveCollection()) {
					if(c.getType().equals("shirt") || (c.getType().equals("hoodie")) || (c.getType().equals("sweater"))) {
						tops.add("Type: " + c.getType() + "  Size:" + c.getSize() + 
								"  Price: " + c.getPrice() + "  Quantity: " + c.getQuantity() + 
								"  ID:" + c.getProduct_num());;
					}
				}
				String dataStr = "";
				for (String c : tops) {
					dataStr = dataStr + c.toString() + "\n";
				}
				textArea.setText(dataStr);
			}
		});
		chckbxTops.setBounds(416, 133, 93, 21);
		add(chckbxTops);
		
		JCheckBox chckbxBottoms = new JCheckBox("Bottoms");
		buttonGroup_1.add(chckbxBottoms);
		chckbxBottoms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> bottoms = new ArrayList<String>();
				for(Clothing c : items.retrieveCollection()) {
					if(c.getType().equals("pants") || (c.getType().equals("shorts"))) {
						bottoms.add("Type: " + c.getType() + "  Size:" + c.getSize() + 
								"  Price: " + c.getPrice() + "  Quantity: " + c.getQuantity() + 
								"  ID:" + c.getProduct_num());;
					}
				}
				String dataStr = "";
				for (String c : bottoms) {
					dataStr = dataStr + c.toString() + "\n";
				}
				textArea.setText(dataStr);
			}
		});
		chckbxBottoms.setBounds(416, 179, 93, 21);
		add(chckbxBottoms);
		
		JTextField field1 = new JTextField();
		JTextField field2 = new JTextField();
		JTextField field3 = new JTextField();
		JTextField field4 = new JTextField();
		JTextField field5 = new JTextField();
		
		Object[] fields = {
				"Type", field1,
				"Size", field2,
				"Price", field3, 
				"Quantity", field4,
				"ID", field5
		};
		
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String type = "";
				String size = "";
				double price = 0.0;
				int quantity = 0;
				String product_num = "";
				
				
				JOptionPane.showConfirmDialog(null, fields, "Adding an item", JOptionPane.OK_CANCEL_OPTION);
				type = field1.getText();
				size = field2.getText();
				price = Double.parseDouble(field3.getText());
				quantity = Integer.parseInt(field4.getText());
				product_num = field5.getText();
			    if (!type.equals("shirt") || !type.equals("hoodie") || !type.equals("sweater") 
			    		|| !type.equals("shorts") || !type.equals("pants") || !size.equals("small") 
			    		|| !size.equals("medium") || !size.equals("large") || !size.equals("extra-large")
			    		|| price < 0.0 || price > 60.0 || quantity < 0 || quantity > 20) {
			    	for(Clothing i : items.retrieveCollection()) {
			    		if(i.getProduct_num().equals(product_num)) {
			    			JOptionPane.showMessageDialog(null, "This ID already exists!");
			    			return;
			    		}
			    	}
			    	Clothing c = new Clothing(type, size, price, quantity, product_num);
					items.add(c);
					clothes.add("Type: " + c.getType() + "  Size:" + c.getSize() + 
							"  Price: " + c.getPrice() + "  Quantity: " + c.getQuantity() + 
							"  ID:" + c.getProduct_num());;
					String dataStr = "";
					for(String s : clothes) {
						dataStr = dataStr + s.toString() + "\n";
					}
					textArea.setText(dataStr);
				}
			    else {
			    	JOptionPane.showMessageDialog(null, "Incorrect option was entered!");
			    }
			}
		});
		btnAddItem.setBounds(32, 225, 137, 23);
		add(btnAddItem);
		
		JButton btnRemoveItemm = new JButton("Remove Item");
		btnRemoveItemm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String product_num = "";
				product_num = JOptionPane.showInputDialog("Enter ID of item you want to remove");
				for(Clothing c : items.retrieveCollection()) {
					if(product_num.equals(c.getProduct_num())) {
						items.remove(c.getProduct_num());
					}
					else {
						JOptionPane.showMessageDialog(null, "ID could not be found");
						break;
					}
				ArrayList<String> clothes = new ArrayList<String>();
				for(Clothing s : items.retrieveCollection()) {
					clothes.add("Type: " + s.getType() + "  Size:" + s.getSize() + 
							"  Price: " + s.getPrice() + "  Quantity: " + s.getQuantity() + 
							"  ID:" + s.getProduct_num());
			}
				textArea.setText(null);
	
				String dataStr = "";
				for (String t : clothes) {
					dataStr = dataStr + t.toString() + "\n";
				}
				textArea.setText(dataStr);
				}
			}
		});
		btnRemoveItemm.setBounds(32, 280, 137, 23);
		add(btnRemoveItemm);
		
		JToggleButton tglbtnShowAll = new JToggleButton("Show all");
		tglbtnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> clothes = new ArrayList<String>();
				textArea.setText(null);
				String dataStr = "";
				
				for(Clothing c : items.retrieveCollection()) {
					clothes.add("Type: " + c.getType() + "  Size:" + c.getSize() + 
							"  Price: " + c.getPrice() + "  Quantity: " + c.getQuantity() + 
							"  ID:" + c.getProduct_num());
				}
				for(String c : clothes) {
					dataStr = dataStr + c.toString() + "\n";
				}
				
				textArea.setText(dataStr);
			}
		});
		tglbtnShowAll.setBounds(537, 132, 123, 23);
		add(tglbtnShowAll);
		
		JLabel lblTypes = new JLabel("Types");
		lblTypes.setBounds(32, 102, 49, 14);
		add(lblTypes);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(283, 349, 49, 14);
		add(lblPrice);
		
		JLabel lblSizes = new JLabel("Sizes");
		lblSizes.setBounds(293, 102, 49, 14);
		add(lblSizes);
		
		
	}
	
	public void doClose() {
		items.doWrite("./inventoryFile.txt");
	}

}
