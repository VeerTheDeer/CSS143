import java.awt.event.*;
import javax.swing.*;

public class Application extends JFrame implements ActionListener {
	JButton customButton = new JButton("Click Me");

	public Application() {
		super("Custom Window");

		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		customButton.setEnabled(true);
		customButton.setBounds(75, 120, 150, 30);
		this.add(customButton);

		customButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Button Clicked!");
	}

	public static void main(String[] args) {
		JFrame customApp = new Application();
	}
}
