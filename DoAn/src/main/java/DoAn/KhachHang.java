package DoAn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class KhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField txtTimKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHang frame = new KhachHang();
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
	public KhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 30, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setText("Nh\u1EADp t\u00EAn kh\u00E1ch h\u00E0ng c\u1EA7n t\u00ECm ...");
		txtTimKiem.setBounds(32, 34, 414, 20);
		contentPane.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JList lstKhachHang = new JList();
		lstKhachHang.setBounds(32, 84, 907, 543);
		contentPane.add(lstKhachHang);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ng\u00E0y/Th\u00E1ng/N\u0103m"}));
		comboBox.setBounds(475, 34, 124, 20);
		contentPane.add(comboBox);
	}
}
