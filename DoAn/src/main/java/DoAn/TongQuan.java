package DoAn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dao.ProductDAO;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import Model.GlobalModel;
import POJO_entities.BaseProduct;

import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
public class TongQuan extends JFrame {

	private JPanel contentPane;
	private JTextField txtTKHangHoa, txtTKLichLV, txtTKKhachHang;
	private JTable tbDSHangHoa, tbDSKhachHang;
	ProductDAO bllProduct;

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
		bllProduct = new ProductDAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(40, 35, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		GlobalModel data = new GlobalModel();
		
		
		//Dashboard
		final JPanel pDashboard = new JPanel();
		pDashboard.setBounds(166, 11, 1008, 639);
		contentPane.add(pDashboard);
		pDashboard.setLayout(null);
		pDashboard.setVisible(true);
		
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
		
		txtTKHangHoa = new JTextField();
		txtTKHangHoa.setText("Nhập tên hàng cần tìm ...");
		txtTKHangHoa.setBounds(49, 11, 562, 20);
		pHangHoa.add(txtTKHangHoa);
		txtTKHangHoa.setColumns(10);
		
		JComboBox cbxNhomHang = new JComboBox();
		cbxNhomHang.setModel(new DefaultComboBoxModel(new String[] {"Nhóm hàng"}));
		cbxNhomHang.setToolTipText("");
		cbxNhomHang.setBounds(646, 11, 146, 20);
		pHangHoa.add(cbxNhomHang);
		
		JButton btnThemHang = new JButton("Thêm Hàng");
		btnThemHang.setBounds(800, 11, 89, 23);
		pHangHoa.add(btnThemHang);
		btnThemHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemHang fThemHang = new  ThemHang();
				fThemHang.setVisible(true);
			}
		});
		
		String[] columnNames = new String[]{"Mã",
                "Tên hàng hóa",
                "Nhóm hàng",
                "Giá bán",
                "Số lượng"};
		
		java.util.List<BaseProduct> products = bllProduct.getProducts(null, 0);
	    DefaultTableModel tblModel = new DefaultTableModel(columnNames, 1);

		for (int i = 0; i < products.size(); i++){
			   long ProductId = products.get(i).getProductId();
			   String Barcode = products.get(i).getBarCode();
			   String ProductName = products.get(i).getProductName();
			   long CategoryId = products.get(i).getCategoryId();
			   BigDecimal Price = products.get(i).getRetailPrice();
			   BigDecimal Quantity = products.get(i).getQtyAvailable();
			   Object[] row = {ProductId, Barcode, ProductName, CategoryId, Price, Quantity};
			   tblModel.addRow(row);
			}
		
		JScrollPane scrollPaneHH = new JScrollPane();
		scrollPaneHH.setBounds(49, 50, 837, 588);
		pHangHoa.add(scrollPaneHH);
		
		tbDSHangHoa = new JTable(tblModel);
		scrollPaneHH.setViewportView(tbDSHangHoa);
		
		
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
		
		txtTKKhachHang = new JTextField();
		txtTKKhachHang.setText("Nhập tên hoặc SĐT khách hàng ...");
		txtTKKhachHang.setColumns(10);
		txtTKKhachHang.setBounds(10, 11, 602, 22);
		pKhachHang.add(txtTKKhachHang);
		
		JButton btnThemKhachHang = new JButton("Thêm khách hàng");
		btnThemKhachHang.setBounds(700, 2, 140, 35);
		pKhachHang.add(btnThemKhachHang);
		btnThemKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemKhachHang fThemKH = new  ThemKhachHang();
				fThemKH.setVisible(true);
			}
		});
		
		String[] cNameKH = new String[]{"Mã",
                "Tên khách hàng",
                "Ngày sinh",
                "Số điện thoại",
                "Địa chỉ",
                "Ngày đến gần đây nhất"};
		
		//java.util.List<BaseProduct> guest = bllProduct.getProducts(null, 0);
	    //DefaultTableModel tblModelKH = new DefaultTableModel(cNameKH, 0r);

//		for (int i = 0; i < products.size(); i++){
//			   long ProductId = products.get(i).getProductId();
//			   String Barcode = products.get(i).getBarCode();
//			   String ProductName = products.get(i).getProductName();
//			   long CategoryId = products.get(i).getCategoryId();
//			   BigDecimal Price = products.get(i).getRetailPrice();
//			   BigDecimal Quantity = products.get(i).getQtyAvailable();
//			   Object[] row = {ProductId, Barcode, ProductName, CategoryId, Price, Quantity};
//			   tblModel.addRow(row);
//			}
		
		JScrollPane scrollPaneKH = new JScrollPane();
		scrollPaneKH.setBounds(49, 50, 837, 588);
		pKhachHang.add(scrollPaneKH);
		
		tbDSKhachHang = new JTable(tblModel);
		scrollPaneKH.setViewportView(tbDSKhachHang);
				
		
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
		
		
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pDashboard.setVisible(true);
				pHangHoa.setVisible(false);
				pLichLamViec.setVisible(false);
				pKhachHang.setVisible(false);
			}
		});
		
		btnHangHoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pHangHoa.setVisible(true);
				pDashboard.setVisible(false);
				pLichLamViec.setVisible(false);
				pKhachHang.setVisible(false);
			}
		});
		
		btnLichLamViec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pLichLamViec.setVisible(true);
				pDashboard.setVisible(false);
				pHangHoa.setVisible(false);
				pKhachHang.setVisible(false);
			}
		});
		
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pKhachHang.setVisible(true);
				pDashboard.setVisible(false);
				pHangHoa.setVisible(false);
				pLichLamViec.setVisible(false);
			}
		});
	}
}
