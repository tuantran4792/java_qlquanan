package DoAn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class HangHoa extends JFrame {

	private JPanel contentPane;
	private JTextField txtTimKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HangHoa frame = new HangHoa();
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
	public HangHoa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 30, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList lstDSHangHoa = new JList();
		lstDSHangHoa.setBounds(49, 105, 896, 510);
		contentPane.add(lstDSHangHoa);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setText("Nhập tên hàng cần tìm ...");
		txtTimKiem.setBounds(49, 46, 562, 20);
		contentPane.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JComboBox cbxNhomHang = new JComboBox();
		cbxNhomHang.setModel(new DefaultComboBoxModel(new String[] {"Nhóm hàng"}));
		cbxNhomHang.setToolTipText("");
		cbxNhomHang.setBounds(646, 46, 146, 20);
		contentPane.add(cbxNhomHang);
		
		JButton btnNhapHang = new JButton("Nhập Hàng");
		btnNhapHang.setBounds(856, 45, 89, 23);
		contentPane.add(btnNhapHang);
	}
}
