package DoAn;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ThemKhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaKH, txtTenKH, txtSDT, txtDiaChi;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemKhachHang frame = new ThemKhachHang();
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
	public ThemKhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(dimension.width / 3, dimension.height / 5, 430, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblThemKH = new JLabel("Thêm Khách Hàng");
		lblThemKH.setFont(new Font("UTM Aristote", Font.PLAIN, 26));
		lblThemKH.setBounds(65, 0, 307, 62);
		contentPane.add(lblThemKH);
		
		JLabel lblMaKH = new JLabel("Mã khách hàng:");
		lblMaKH.setBounds(27, 73, 85, 14);
		contentPane.add(lblMaKH);
		
		txtMaKH = new JTextField();
		txtMaKH.setHorizontalAlignment(SwingConstants.LEFT);
		txtMaKH.setBounds(163, 69, 224, 20);
		contentPane.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		JLabel lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setBounds(27, 113, 85, 14);
		contentPane.add(lblTenKH);
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(163, 109, 224, 20);
		contentPane.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setBounds(28, 153, 84, 14);
		contentPane.add(lblNgaySinh);

		JComboBox cbxNhomHang = new JComboBox();
		cbxNhomHang.setBounds(164, 149, 148, 20);
		contentPane.add(cbxNhomHang);
		
		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setBounds(27, 193, 85, 14);
		contentPane.add(lblSDT);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(163, 189, 224, 20);
		contentPane.add(txtSDT);
		txtSDT.setColumns(10);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setBounds(27, 233, 85, 14);
		contentPane.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(163, 229, 224, 20);
		contentPane.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblNDGDN = new JLabel("Ngày đến gần đây nhất:");
		lblNDGDN.setBounds(27, 273, 135, 14);
		contentPane.add(lblNDGDN);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThem.setBounds(164, 309, 100, 40);
		contentPane.add(btnThem);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThoat.setBounds(287, 309, 100, 40);
		contentPane.add(btnThoat);
		
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
	}
}
