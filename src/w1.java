import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;

public class w1 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					w1 window = new w1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public w1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(126, 67, 176, 41);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(23, 11, 385, 45);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 118, 414, 41);
		frame.getContentPane().add(editorPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 170, 414, 80);
		frame.getContentPane().add(textPane);
	}
}
