package frontend;

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainFrame1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Harrison's Clothing Inventory");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainPanel1 panel = new MainPanel1();
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				panel.doClose();
			}

		});
	}
}
