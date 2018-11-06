package de.wwu.controlstructures;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ControlStructuresUI extends JFrame {

	public ControlStructuresUI() {
		super("Number Converter");
		
		ControlStructures converter = new ControlStructures();
		
		setLayout(new FlowLayout());
		
		JTextField inputField = new JTextField(20);
		JTextField outputField = new JTextField(30);
		outputField.setEditable(false);
		
		inputField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				call();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				call();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				call();
			}
			
			private void call() {
				try {
					if (inputField.getText() != null && !inputField.getText().isEmpty()) {
						outputField.setText(converter.numberToString(Integer.parseInt(inputField.getText())));
					} else {
						outputField.setText("No number given.");
					}
				} catch (NumberFormatException e) {
					outputField.setText("Invalid number format!");
				}	
			}
			
		});
		
		getContentPane().add(inputField);
		getContentPane().add(outputField);
		
		pack();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ControlStructuresUI();
	}
	
}
