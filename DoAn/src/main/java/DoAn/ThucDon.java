package DoAn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ThucDon extends JFrame {

	private JPanel contentPane;
	private JTextField textTimKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThucDon frame = new ThucDon();
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
	public ThucDon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 30, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList lstThucDon = new JList();
		lstThucDon.setBounds(28, 114, 926, 525);
		contentPane.add(lstThucDon);
		
		textTimKiem = new JTextField();
		textTimKiem.setText("Nh\u1EADp t\u00EAn m\u00F3n c\u1EA7n t\u00ECm ...");
		textTimKiem.setBounds(28, 26, 558, 20);
		contentPane.add(textTimKiem);
		textTimKiem.setColumns(10);
		
		JComboBox cbxNhomThucDon = new JComboBox();
		cbxNhomThucDon.setModel(new DefaultComboBoxModel(new String[] {"Nh\u00F3m th\u1EF1c \u0111\u01A1n"}));
		cbxNhomThucDon.setBounds(607, 26, 123, 20);
		contentPane.add(cbxNhomThucDon);
	}
}
