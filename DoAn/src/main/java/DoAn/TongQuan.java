package DoAn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import Model.GlobalModel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
public class TongQuan extends JFrame {

	private JPanel contentPane;
	private JTextField txtTKHangHoa, txtTKLichLV, txtTKKhachHang;
	private JTextField txtKhachHang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					TongQuan frame = new TongQuan();
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
	public TongQuan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(40, 35, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		GlobalModel data = new GlobalModel();
		
		//POS
		final JPanel pPOS = new JPanel();
		pPOS.setBounds(166, 11, 1008, 639);
		contentPane.add(pPOS);
		pPOS.setLayout(null);
		pPOS.setVisible(true);
		
		JLabel lblSoDoBan = new JLabel("Sơ  Đồ  Bàn");
		lblSoDoBan.setFont(new Font("UTM French Vanilla", Font.PLAIN, 30));
		lblSoDoBan.setBounds(73, 1, 157, 38);
		pPOS.add(lblSoDoBan);
		
		JTextArea tarSoDoBan = new JTextArea();
		tarSoDoBan.setBounds(10, 42, 283, 558);
		pPOS.add(tarSoDoBan);
		
		JLabel lblHoaDon = new JLabel("Hóa  Đơn");
		lblHoaDon.setFont(new Font("UTM French Vanilla", Font.PLAIN, 30));
		lblHoaDon.setBounds(408, 1, 129, 38);
		pPOS.add(lblHoaDon);
		
		JPanel pTTHoaDon = new JPanel();
		pTTHoaDon.setBounds(303, 40, 343, 558);
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
		lblThucDon.setBounds(777, 1, 129, 38);
		pPOS.add(lblThucDon);
		
		JTextArea tarThucDon = new JTextArea();
		tarThucDon.setBounds(656, 42, 337, 482);
		pPOS.add(tarThucDon);
		
		//Dashboard
		final JPanel pDashboard = new JPanel();
		pDashboard.setBounds(166, 11, 1008, 639);
		contentPane.add(pDashboard);
		pDashboard.setLayout(null);
		pDashboard.setVisible(false);
		
		JPanel pDBHomNay = new JPanel();
		pDBHomNay.setBounds(10, 15, 990, 200);
		pDBHomNay.setBorder(BorderFactory.createTitledBorder("Hôm nay"));
		pDashboard.add(pDBHomNay);
		
				
		//Hang hoa
		final JPanel pHangHoa = new JPanel();
		pHangHoa.setBounds(166, 11, 1008, 639);
		contentPane.add(pHangHoa);
		pHangHoa.setLayout(null);
		pHangHoa.setVisible(false);
		
		JList lstHangHoa = new JList();
		lstHangHoa.setBounds(10, 51, 896, 550);
		pHangHoa.add(lstHangHoa);
		
		txtTKHangHoa = new JTextField();
		txtTKHangHoa.setText("Nhập tên hàng cần tìm ...");
		txtTKHangHoa.setColumns(10);
		txtTKHangHoa.setBounds(10, 11, 562, 20);
		pHangHoa.add(txtTKHangHoa);
		
		JComboBox cbxNhomHang = new JComboBox();
		cbxNhomHang.setToolTipText("");
		cbxNhomHang.setBounds(582, 11, 146, 20);
		pHangHoa.add(cbxNhomHang);
		
		JButton btnThemHang = new JButton("Thêm Hàng");
		btnThemHang.setBounds(740, 11, 89, 23);
		pHangHoa.add(btnThemHang);
		btnThemHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new  NhapHang().setVisible(true);
				setEnabled(false);
			}
		});
		
		//Lich lam viec
		final JPanel pLichLamViec = new JPanel();
		pLichLamViec.setBounds(166, 11, 1008, 639);
		contentPane.add(pLichLamViec);
		pLichLamViec.setLayout(null);
		pLichLamViec.setVisible(false);
		
		JList lstLichLamViec = new JList();
		lstLichLamViec.setBounds(10, 51, 896, 550);
		pLichLamViec.add(lstLichLamViec);
		
		txtTKLichLV = new JTextField();
		txtTKLichLV.setText("Nhập tên nhân viên ...");
		txtTKLichLV.setColumns(10);
		txtTKLichLV.setBounds(10, 11, 562, 20);
		pLichLamViec.add(txtTKLichLV);
		
		JComboBox cbxLLVNgayBD = new JComboBox();
		cbxLLVNgayBD.setToolTipText("");
		cbxLLVNgayBD.setBounds(582, 11, 146, 20);
		pLichLamViec.add(cbxLLVNgayBD);
		
		JComboBox cbxLLVNgayKT = new JComboBox();
		cbxLLVNgayKT.setToolTipText("");
		cbxLLVNgayKT.setBounds(740, 11, 146, 20);
		pLichLamViec.add(cbxLLVNgayKT);
		
		JButton btnThemLich = new JButton("Thêm Lịch");
		btnThemLich.setBounds(900, 11, 89, 23);
		pLichLamViec.add(btnThemLich);
		
		//Lich lam viec
		final JPanel pKhachHang = new JPanel();
		pKhachHang.setBounds(166, 11, 1008, 639);
		contentPane.add(pKhachHang);
		pKhachHang.setLayout(null);
		pKhachHang.setVisible(false);
		
		JList lstKhachHang = new JList();
		lstKhachHang.setBounds(10, 51, 896, 550);
		pKhachHang.add(lstKhachHang);
		
		txtTKKhachHang = new JTextField();
		txtTKKhachHang.setText("Nhập tên hoặc SĐT khách hàng ...");
		txtTKKhachHang.setColumns(10);
		txtTKKhachHang.setBounds(10, 11, 562, 20);
		pKhachHang.add(txtTKKhachHang);
		
		JComboBox cbxKHNgayBD = new JComboBox();
		cbxKHNgayBD.setToolTipText("");
		cbxKHNgayBD.setBounds(582, 11, 146, 20);
		pKhachHang.add(cbxKHNgayBD);
		
		JComboBox cbxKHNgayKT = new JComboBox();
		cbxKHNgayKT.setToolTipText("");
		cbxKHNgayKT.setBounds(740, 11, 146, 20);
		pKhachHang.add(cbxKHNgayKT);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(900, 11, 89, 23);
		pKhachHang.add(btnTimKiem);
				
				
		JButton btnPOS = new JButton("POS");
		btnPOS.setBounds(10, 28, 102, 33);
		contentPane.add(btnPOS);
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(10, 70, 102, 34);
		contentPane.add(btnDashboard);
		
		JButton btnHangHoa = new JButton("Hàng hóa");
		btnHangHoa.setBounds(10, 115, 102, 33);
		contentPane.add(btnHangHoa);
		
		JButton btnLichLamViec = new JButton("Lịch làm việc");
		btnLichLamViec.setBounds(10, 159, 102, 33);
		contentPane.add(btnLichLamViec);
		
		JButton btnKhachHang = new JButton("Khách hàng");
		btnKhachHang.setBounds(10, 203, 102, 33);
		contentPane.add(btnKhachHang);
		
		
		btnPOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pPOS.setVisible(true);
				pDashboard.setVisible(false);
				pHangHoa.setVisible(false);
				pLichLamViec.setVisible(false);
				pKhachHang.setVisible(false);
			}
		});
		
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pDashboard.setVisible(true);
				pPOS.setVisible(false);
				pHangHoa.setVisible(false);
				pLichLamViec.setVisible(false);
				pKhachHang.setVisible(false);
			}
		});
		
		btnHangHoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pHangHoa.setVisible(true);
				pPOS.setVisible(false);
				pDashboard.setVisible(false);
				pLichLamViec.setVisible(false);
				pKhachHang.setVisible(false);
			}
		});
		
		btnLichLamViec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pLichLamViec.setVisible(true);
				pPOS.setVisible(false);
				pDashboard.setVisible(false);
				pHangHoa.setVisible(false);
				pKhachHang.setVisible(false);
			}
		});
		
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pKhachHang.setVisible(true);
				pPOS.setVisible(false);
				pDashboard.setVisible(false);
				pHangHoa.setVisible(false);
				pLichLamViec.setVisible(false);
			}
		});
	}
}
