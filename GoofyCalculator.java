import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;

import java.lang.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class GoofyCalculator implements ActionListener {

	JFrame frame;
	JTextField textfield1, textfield2, textfield3, textfield4, resfield, errorfield, machtextfield;
	JButton run, mach1, mach2, mach3, mach4, clear, save, get;
	JPanel panel;

	double num1=0, num2=0, result=0, first_num = 0, second_num = 0, third_num = 0, fourth_num, mach_tracker;
	String machvalue = "";
	
	GoofyCalculator(){
		
		textfield1 = new JTextField(); //Create first text field
		textfield1.setBounds(50, 25, 200, 25);

		textfield2 = new JTextField(); //Create second text field
		textfield2.setBounds(50, 75, 200, 25);
		
		textfield3 = new JTextField(); //Create third text field
		textfield3.setBounds(50, 125, 200, 25);
		textfield3.setEditable(false);
		
		textfield4 = new JTextField(); //Create fourth text field
		textfield4.setBounds(50, 175, 200, 25);
		textfield4.setEditable(false);
		
		machtextfield = new JTextField(); //Create Machine text field
		machtextfield.setBounds(50, 225, 200, 25);
		machtextfield.setEditable(false);
		machtextfield.setText("Select Machine"); 

		
		resfield = new JTextField(); //Create result field
		resfield.setBounds(50, 425, 200, 25);
		resfield.setEditable(false);
		
		errorfield = new JTextField(); //Create error field
		errorfield.setBounds(25, 550, 350, 25);
		errorfield.setEditable(false);
		
		run = new JButton("Run"); //Create Run button
		run.setBounds(50, 375, 100, 25);
		run.setFocusable(false);
		run.addActionListener(this);
		
		mach1 = new JButton("Machine 1"); //Create Machine 1 button
		mach1.setBounds(50, 275, 100, 25);
		mach1.setFocusable(false);
		mach1.addActionListener(this);
		
		mach2 = new JButton("Machine 2"); //Create Machine 2 button
		mach2.setBounds(175, 275, 100, 25);
		mach2.setFocusable(false);
		mach2.addActionListener(this);
		
		mach3 = new JButton("Machine 3"); //Create Machine 3 button
		mach3.setBounds(50, 310, 100, 25);
		mach3.setFocusable(false);
		mach3.addActionListener(this);
		
		mach4 = new JButton("Machine 4"); //Create Machine 4 button
		mach4.setBounds(175, 310, 100, 25);
		mach4.setFocusable(false);
		mach4.addActionListener(this);
		
		clear = new JButton("Clear"); //Create Clear button
		clear.setBounds(275, 425, 100, 25);
		clear.setFocusable(false);
		clear.addActionListener(this);
		
		get = new JButton("Get"); //Create Get Button
		get.setBounds(275, 150, 100, 25);
		get.setFocusable(false);
		get.addActionListener(this);

		
		frame = new JFrame("Goofy Calculator"); //Create the GUI
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 650);
		frame.setLayout(null);
        frame.setVisible(true);
        
        //Add the textfields and buttons to the GUI
        frame.add(textfield1);
        frame.add(textfield2);
        frame.add(textfield3);
        frame.add(textfield4);
        frame.add(machtextfield);
        frame.add(resfield); 
        frame.add(run);
        frame.add(mach1);
        frame.add(mach2);
        frame.add(mach3);
        frame.add(mach4);
        frame.add(clear);
        frame.add(get);
        frame.add(errorfield);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create Calculator Object
		GoofyCalculator calc = new GoofyCalculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//Make Run button functional
		if(e.getSource() == run) {
			
			//Display error button if textfields do not have anything in them
			if(String.valueOf(textfield1.getText()).equals("")) {
				errorfield.setText("'ERROR: Enter Value Into Text Field 1'");
				
			} else if(String.valueOf(textfield2.getText()).equals("")) {
				errorfield.setText("'ERROR: Enter Value Into Text Field 2'");
				
			} 
			
			//if nothing is in get text textfields then create new text files
			if(String.valueOf(textfield3.getText()).equals("") || String.valueOf(textfield4.getText()).equals("")) {
				if(String.valueOf(textfield1.getText()).equals("") || String.valueOf(textfield2.getText()).equals("")) {
					errorfield.setText("'ERROR: Enter Values Into Both Text Fields'");
				} else {
					try {
						String desktopPath = System.getProperty("user.home") + "/Desktop";
						
						File file = new File(desktopPath, "Saved Number.txt");
						FileWriter fw = new FileWriter(file);
						PrintWriter pw = new PrintWriter(fw);
						
						pw.println(textfield1.getText());
						pw.println(textfield2.getText());
						pw.close();
						
						errorfield.setText(textfield1.getText().concat(" ").concat("and ").concat(textfield2.getText()).concat(" ").concat(" Saved To Saved Number Text File On Desktop"));
						
						File file2 = new File(desktopPath, "Numbers Log.txt");
						FileWriter fw2 = new FileWriter(file2, true);
						PrintWriter pw2 = new PrintWriter(fw2);
						String cd = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());
						
						pw2.println(cd + ":");
						pw2.println(textfield1.getText());
						pw2.println(textfield2.getText());
						pw2.println("");
						pw2.close();
						
					} catch (IOException ex) {
			            // Handle IOException appropriately (e.g., log or show an error message)
			            ex.printStackTrace();
			            errorfield.setText("ERROR: Failed to save the result");
			        }
					
				}
				
			} else {
				if(String.valueOf(textfield1.getText()).equals("") || String.valueOf(textfield2.getText()).equals("")) {
					errorfield.setText("'ERROR: Enter Values Into Both Text Fields'");
				} else if(String.valueOf(machtextfield.getText()).equals("Select Machine")) {
					errorfield.setText("'ERROR:Please Select Machine'");
				} else {
					try {
						String desktopPath = System.getProperty("user.home") + "/Desktop";
						
						File file = new File(desktopPath, "Saved Number.txt");
						FileWriter fw = new FileWriter(file);
						PrintWriter pw = new PrintWriter(fw);
						
						pw.println(textfield1.getText());
						pw.println(textfield2.getText());
						pw.close();
						
						first_num = Double.parseDouble(textfield1.getText());
						second_num = Double.parseDouble(textfield2.getText());
						third_num = Double.parseDouble(textfield3.getText());
						fourth_num = Double.parseDouble(textfield4.getText());
						
						machvalue = String.valueOf(machtextfield.getText());
						
						if(machvalue.equals("Machine 1")) {
							result = first_num + second_num + third_num + fourth_num;
						}
						
						if(machvalue.equals("Machine 2")) {
							result = (first_num + second_num + third_num + fourth_num) * 2;
						}
						
						if(machvalue.equals("Machine 3")) {
							result = (first_num + second_num + third_num + fourth_num) / 2;
						}
						
						if(machvalue.equals("Machine 4")) {
							result = (first_num + second_num + third_num + fourth_num) * 10;
						}
						
						/*switch(machvalue) {
							case "Machine 1":
								result = first_num + second_num + third_num + fourth_num;
								
							case "Machine 2":
								result = (first_num + second_num + third_num + fourth_num) * 2;
							
							case "Machine 3":
								result = (first_num + second_num + third_num + fourth_num) / 2;
								
							case "Machine 4":
								result = (first_num + second_num + third_num + fourth_num) *100;
						}*/
						
						resfield.setText(String.valueOf(result));
						
						errorfield.setText(textfield1.getText().concat(" ").concat("and ").concat(textfield2.getText()).concat(" ").concat(" Saved To Saved Number Text File On Desktop"));
						
						File file2 = new File(desktopPath, "Numbers Log.txt");
						FileWriter fw2 = new FileWriter(file2, true);
						PrintWriter pw2 = new PrintWriter(fw2);
						String cd = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());
						
						pw2.println(cd + ":");
						pw2.println(textfield1.getText());
						pw2.println(textfield2.getText());
						pw2.println("");
						pw2.close();
						
						
					} catch (IOException ex) {
			            // Handle IOException appropriately (e.g., log or show an error message)
			            ex.printStackTrace();
			            errorfield.setText("ERROR: Failed to save the result");
			        }
					
					
				}
			}
			
			
			
			
			/*else {
				num1 = Double.parseDouble(textfield1.getText());
				num2 = Double.parseDouble(textfield2.getText());
				
				result = num1 + num2;
				resfield.setText(String.valueOf(result));
				errorfield.setText(null);
			} */
		}
		
		//Make clear button functional
		if(e.getSource() == clear) {
			resfield.setText(null);
		}
		
		//Creates the text file with value

		if(e.getSource() == get) {
			try {
				File myObj = new File(System.getProperty("user.home") + "/Desktop/Saved Number.txt");
				Scanner myReader = new Scanner(myObj);
				String num1 = myReader.nextLine();
				String num2 = myReader.nextLine();
				
				textfield3.setText(String.valueOf(num1));
				textfield4.setText(String.valueOf(num2));
				myReader.close();
			} catch (FileNotFoundException e1) {
				errorfield.setText("'ERROR: No Data Found'");
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == mach1) {
			machtextfield.setText("Machine 1");
		}
		
		if(e.getSource() == mach2) {
			machtextfield.setText("Machine 2");
		}
		
		if(e.getSource() == mach3) {
			machtextfield.setText("Machine 3");
		}
		
		if(e.getSource() == mach4) {
			machtextfield.setText("Machine 4");
		}
	}

}
