package windowbuilder;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class StartGame extends JFrame {

	private JPanel contentPane;
	private static StartGame frame;
	//private final Action action = new SwingAction();
	ImageIcon back;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new StartGame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartGame() {
		setTitle("HandongRPG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		
		BufferedImage backGround = null;
		try {
			backGround = ImageIO.read(this.getClass().getResource("/res/img/logo.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image img = backGround.getScaledInstance(88, 78, Image.SCALE_SMOOTH);
		back = new ImageIcon(img);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "name_86213402417667");
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New Game");
		//btnNewButton.setAction(action);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnterName.getUserName();
			}
		});
		btnNewButton.setBounds(153, 135, 117, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Resume");
		btnNewButton_1.setBounds(153, 176, 117, 29);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("End");
		btnNewButton_2.setBounds(153, 217, 117, 29);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(179, 51, 61, 16);
		panel.add(lblNewLabel);
		
		
	}
	public static void quitFrame() {
		frame.setVisible(false);
	}
}
