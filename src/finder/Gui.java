package finder;

import java.awt.Font;
import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.*;

public class Gui {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Password Finder");
		
		Reader reader = new Reader();
		
		frame.setSize(800, 400);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JTextField password = new JTextField();
		password.setBounds(15,40,750,25);
		
		JLabel passLabel = new JLabel();
		passLabel.setText("Type your password below to verify:");
		passLabel.setBounds(15,20,500,25);
		
		JButton verifyButton = new JButton("Verify");
		verifyButton.setBounds(15,100,750,100);
		verifyButton.setFont(new Font("Arial", Font.PLAIN, 40));
		verifyButton.addActionListener(e -> {
			System.out.println("password: " + password.getText());
		});
		
		// adding items to the frame
		frame.add(password);
		frame.add(passLabel);
		frame.add(verifyButton);
		
		// verifying the password
		verifyButton.addActionListener(e -> {
			try {
				if(reader.reader(password.getText()) == 0) {
					JOptionPane.showMessageDialog(frame, "Your password has been found in the wordlist! Change it to a more secure password.", "Warning!", JOptionPane.WARNING_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(frame, "Nice! Your password is not in the wordlist.", "Verification Complete!", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (HeadlessException | IOException e1) {
				e1.printStackTrace();
			}
		});
	}
}
