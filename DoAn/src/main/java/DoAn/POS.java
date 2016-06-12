package DoAn;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class POS extends JFrame {

	private JPanel contentPane;
	private JTextField txtKhachHang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					POS frame = new POS();
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
	public POS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1260, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pPOS = new JPanel();
		pPOS.setBounds(0, 15, 1260, 700);
		contentPane.add(pPOS);
		pPOS.setLayout(null);
		pPOS.setVisible(true);
		
		JLabel lblSoDoBan = new JLabel("Sơ  Đồ  Bàn");
		lblSoDoBan.setFont(new Font("UTM French Vanilla", Font.PLAIN, 30));
		lblSoDoBan.setBounds(73, 47, 157, 38);
		pPOS.add(lblSoDoBan);
		
		JTextArea tarSoDoBan = new JTextArea();
		tarSoDoBan.setBounds(10, 88, 300, 558);
		tarSoDoBan.setEditable(false);
		pPOS.add(tarSoDoBan);
		
		JLabel lblHoaDon = new JLabel("Hóa  Đơn");
		lblHoaDon.setFont(new Font("UTM French Vanilla", Font.PLAIN, 30));
		lblHoaDon.setBounds(425, 47, 129, 38);
		pPOS.add(lblHoaDon);
		
		JPanel pTTHoaDon = new JPanel();
		pTTHoaDon.setBounds(320, 86, 343, 558);
		pTTHoaDon.setBorder(BorderFactory.createTitledBorder("Thông tin hóa đơn"));
		pPOS.add(pTTHoaDon);
		pTTHoaDon.setLayout(null);
		
		JLabel lblSoHoaDon = new JLabel("Số hóa đơn:");
		lblSoHoaDon.setBounds(10, 31, 68, 14);
		pTTHoaDon.add(lblSoHoaDon);
		
		JLabel lblBan = new JLabel("New label");
		lblBan.setBounds(89, 31, 77, 14);
		pTTHoaDon.add(lblBan);
		
		JLabel lblNgay = new JLabel("Ngày:");
		lblNgay.setBounds(187, 31, 45, 14);
		pTTHoaDon.add(lblNgay);
		
		JLabel lblSHD = new JLabel("New label");
		lblSHD.setBounds(242, 31, 91, 14);
		pTTHoaDon.add(lblSHD);
		
		JLabel lblSoBan = new JLabel("Số bàn:");
		lblSoBan.setBounds(10, 68, 68, 14);
		pTTHoaDon.add(lblSoBan);
		
		JLabel lblSB = new JLabel("New label");
		lblSB.setBounds(89, 68, 77, 14);
		pTTHoaDon.add(lblSB);
		
		JLabel lblKhachHang = new JLabel("Khách hàng:");
		lblKhachHang.setBounds(10, 104, 68, 14);
		pTTHoaDon.add(lblKhachHang);
		
		txtKhachHang = new JTextField();
		txtKhachHang.setBounds(89, 101, 197, 20);
		pTTHoaDon.add(txtKhachHang);
		txtKhachHang.setColumns(10);
		
		JButton btnTKKhachHang = new JButton("New button");
		btnTKKhachHang.setBounds(297, 100, 25, 23);
		pTTHoaDon.add(btnTKKhachHang);
		
		JLabel lblNhanVien = new JLabel("Nhân viên:");
		lblNhanVien.setBounds(10, 145, 68, 14);
		pTTHoaDon.add(lblNhanVien);
		
		JLabel lblTenNhanVien = new JLabel("New label");
		lblTenNhanVien.setBounds(89, 145, 197, 14);
		pTTHoaDon.add(lblTenNhanVien);
		
		JList lstDanhSach = new JList();
		lstDanhSach.setBounds(10, 181, 323, 228);
		pTTHoaDon.add(lstDanhSach);
		
		JLabel lblTongTien = new JLabel("Tổng tiền:");
		lblTongTien.setBounds(140, 432, 58, 14);
		pTTHoaDon.add(lblTongTien);
		
		JLabel lblTT = new JLabel("New label");
		lblTT.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTT.setBounds(209, 425, 77, 25);
		pTTHoaDon.add(lblTT);
		
		JLabel lblDonViTinh = new JLabel("VNĐ");
		lblDonViTinh.setBounds(308, 432, 25, 14);
		pTTHoaDon.add(lblDonViTinh);
		
		JButton btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.setBounds(244, 515, 89, 32);
		pTTHoaDon.add(btnThanhToan);
		
		JLabel lblTienNhan = new JLabel("Tiền nhận:");
		lblTienNhan.setBounds(140, 470, 58, 14);
		pTTHoaDon.add(lblTienNhan);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(209, 461, 77, 23);
		pTTHoaDon.add(lblNewLabel);
		
		JLabel lblDVT = new JLabel("VNĐ");
		lblDVT.setBounds(308, 470, 25, 14);
		pTTHoaDon.add(lblDVT);
		
		JLabel lblThucDon = new JLabel("Thực  Đơn");
		lblThucDon.setFont(new Font("UTM French Vanilla", Font.PLAIN, 30));
		lblThucDon.setBounds(777, 47, 129, 38);
		pPOS.add(lblThucDon);
		
		JTextArea tarThucDon = new JTextArea();
		tarThucDon.setBounds(656, 88, 337, 482);
		tarThucDon.setEditable(false);
		pPOS.add(tarThucDon);
	}

}
