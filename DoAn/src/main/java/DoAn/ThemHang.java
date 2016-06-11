package DoAn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ThemHang extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenHang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemHang frame = new ThemHang();
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
	public ThemHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 30, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTnHng = new JLabel("T\u00EAn h\u00E0ng:");
		lblTnHng.setBounds(22, 52, 58, 14);
		contentPane.add(lblTnHng);
		
		txtTenHang = new JTextField();
		txtTenHang.setBounds(105, 49, 86, 20);
		contentPane.add(txtTenHang);
		txtTenHang.setColumns(10);
		
		JLabel lblNhmHng = new JLabel("Nh\u00F3m h\u00E0ng:");
		lblNhmHng.setBounds(22, 94, 58, 14);
		contentPane.add(lblNhmHng);
		
		JComboBox cbxNhomHang = new JComboBox();
		cbxNhomHang.setBounds(105, 91, 86, 20);
		contentPane.add(cbxNhomHang);
	}
}
