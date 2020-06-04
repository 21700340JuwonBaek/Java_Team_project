package windowbuilder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import main.Main;

public class EnterName extends JFrame {

	private JPanel contentPane;
	private static JTextField textField;
	static JButton btnNewButton;
	private static String name;
	static EnterName frame;

	/**
	 * Create the frame.
	 */
	public EnterName() {
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setTitle("Name");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(180, 180, 250, 200);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(5, 5, 440, 1);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(62, 59, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Enter");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					name = textField.getText();
					Main main = new Main(name);
					frame.setVisible(false);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = textField.getText();
			}
		});
		btnNewButton.setBounds(103, 96, 61, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Enter Your name");
		lblNewLabel.setBounds(79, 31, 110, 16);
		contentPane.add(lblNewLabel);
	}
	
	public static void getUserName() {
		try {
			frame = new EnterName();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void quitFrame() {
		frame.setVisible(false);
	}
}
