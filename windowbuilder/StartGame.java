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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import character.Me;
import inventory.Inventory;
import item.Potion;
import main.Main;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		
		BufferedImage backGround = null;
		try {
			backGround = ImageIO.read(this.getClass().getResource("/res/img/start.jpeg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image img = backGround.getScaledInstance(200, 130, Image.SCALE_SMOOTH);
		back = new ImageIcon(img);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, "name_86213402417667");
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New Game");
		//btnNewButton.setAction(action);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnterName.getUserName();
			}
		});
		btnNewButton.setBounds(153, 146, 117, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int result= JOptionPane.showConfirmDialog(null, "종료하시겠습니까?","종료", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(result == 0){
						System.exit(0);
					}
			}
		});
		btnNewButton_2.setBounds(153, 213, 117, 29);
		panel.add(btnNewButton_2);
		
		JButton btnResume = new JButton("Resume");
		btnResume.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Main.selLoad();
			}
		});
		btnResume.setBounds(153, 180, 117, 29);
		panel.add(btnResume);
		
		JLabel lblNewLabel = new JLabel(back);
		lblNewLabel.setBounds(68, 6, 288, 162);
		panel.add(lblNewLabel);
		
		
	}
	public static void quitFrame() {
		frame.setVisible(false);
	}
}
