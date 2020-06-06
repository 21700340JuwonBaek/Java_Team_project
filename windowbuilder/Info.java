package windowbuilder;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import main.Main;

public class Info extends JFrame {
	static Info frame;
	private JPanel contentPane;
	public static JLabel lblNewLabel;
	private static Me me;
	private Inventory inv;
	// ImageIcon b_ground;
	BufferedImage back = null;
	JLabel bgL;

	/**
	 * Launch the application.
	 */
	public void run(Me me, String str, Inventory invent) {
		try {
			frame = new Info(me, str, invent);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Info(Me me, String str, Inventory invent) {
		setTitle("Game Lounge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			back = ImageIO.read(this.getClass().getResource("/res/img/background3.jpeg"));
			// icon = new ImageIcon("/Users/ryumi/Desktop/classroom.jpeg");
			// Image back= icon.getImage();
			Image rim1 = back.getScaledInstance(450, 300, Image.SCALE_SMOOTH);
			// icon = new ImageIcon(rim1);
			ImageIcon icon = new ImageIcon(rim1);
			bgL = new JLabel(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "배경 이미지 읽기 오류", "오류", JOptionPane.ERROR_MESSAGE);
		}
		bgL.setBounds(0, 0, 450, 300);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 440, 268);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("던전가기");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectDungeon sel = new selectDungeon(me, invent);
				sel.run(me, invent);
			}
		});
		btnNewButton.setBounds(43, 130, 117, 29);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("저장하기");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.selSave(me, invent);
				//
			}
		});
		btnNewButton_1.setBounds(43, 160, 117, 29);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("인벤토리");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Main.selLoad(me, invent);
				// StartGame.main(null);
				Main.selInventory(me, invent);
			}
		});
		btnNewButton_2.setBounds(43, 189, 117, 29);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("상점");
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.selShop(me, invent);
			}
		});
		btnNewButton_3.setBounds(43, 217, 117, 29);
		panel.add(btnNewButton_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 245, 238));
		panel_1.setBounds(230, 130, 200, 130);
		panel.add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel = new JLabel(str);
		lblNewLabel.setBounds(6, 26, 200, 98);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("<STATE>");
		lblNewLabel_1.setBounds(69, 6, 61, 16);
		panel_1.add(lblNewLabel_1);

		panel.add(bgL);

		this.me = me;
		inv = invent;
	}

	public static void updateInfo() {
		String str;
		str = "<html>";
		str += "Name : " + me.getName() + "<br/>";
		str += "HP : " + me.getHp() + "<br/>";
		str += "MP : " + me.getMp() + "<br/>";
		str += "Gold : " + me.getGold() + "<br/>";
		str += "Grade : " + me.getGrade() + "<br/>";
		lblNewLabel.setText(str);
	}

	public static void quitFrame() {
		frame.setVisible(false);
	}
}
