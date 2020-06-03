package windowbuilder;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import character.Me;
import inventory.Inventory;
import main.Main;

public class Info extends JFrame {

	private JPanel contentPane;
	public static JLabel lblNewLabel;
	private static Me me;
	private Inventory inv;

	/**
	 * Launch the application.
	 */
	public void run(Me me,String str,Inventory invent) {
		try {
			Info frame = new Info(me,str,invent);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Info(Me me,String str,Inventory invent) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("던전가기");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectDungeon sel= new selectDungeon(me,invent);
				sel.run(me,invent);
			}
		});
		btnNewButton.setBounds(43, 135, 117, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("저장하기");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.selSave(me,invent);
				//
			}
		});
		btnNewButton_1.setBounds(43, 166, 117, 29);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("불러오기");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.selLoad(me, invent);
			}
		});
		btnNewButton_2.setBounds(43, 197, 117, 29);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("상점");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.selShop(me, invent);
			}
		});
		btnNewButton_3.setBounds(43, 227, 117, 29);
		panel.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(230, 130, 200, 130);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel(str);
		lblNewLabel.setBounds(6, 6, 200, 130);
		panel_1.add(lblNewLabel);
		
		this.me = me;
		inv = invent;
	}
	
	public static void updateInfo() {
		String str;
	     // while(true) {
    	str = "<html>";
    	str += "Name : "+me.getName()+"<br/>";
		//System.out.println(me.getHp());
		str += "HP : "+me.getHp()+"<br/>";
		//System.out.println(me.getGold());
		str += "Gold : "+me.getGold()+"<br/>";
		//System.out.println(me.getMp());
		str += "MP : "+me.getMp()+"<br/>";
		//System.out.println(me.get_clear_major_require());
		str += "Clear Major Require : "+me.get_clear_major_require()+"<br/>";
		
		lblNewLabel.setText(str);
	}
}
