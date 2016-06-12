package DoAn;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import DoAn.TongQuan;
import Model.GlobalModel;
import Dao.ProductDAO;
import POJO_entities.BaseProduct;


public class ThemHang extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaHang, txtTenHang, txtNCC, txtDonGia, txtVAT;
	ProductDAO model  = new ProductDAO();;
	GlobalModel global;
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
		global = new GlobalModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(dimension.width / 3, dimension.height / 5, 405, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThemHang = new JLabel("Thêm Hàng");
		lblThemHang.setFont(new Font("UTM Aristote", Font.PLAIN, 26));
		lblThemHang.setBounds(101, 8, 188, 45);
		contentPane.add(lblThemHang);
		
		JLabel lblMaHang = new JLabel("Mã hàng:");
		lblMaHang.setBounds(27, 73, 85, 14);
		contentPane.add(lblMaHang);
		
		txtMaHang = new JTextField();
		txtMaHang.setToolTipText("nhập mã hàng");
		txtMaHang.setHorizontalAlignment(SwingConstants.LEFT);
		txtMaHang.setBounds(132, 69, 224, 20);
		contentPane.add(txtMaHang);
		txtMaHang.setColumns(10);
		
		JLabel lblTenHang = new JLabel("Tên hàng:");
		lblTenHang.setBounds(27, 113, 85, 14);
		contentPane.add(lblTenHang);
		
		txtTenHang = new JTextField();
		txtTenHang.setBounds(132, 109, 224, 20);
		contentPane.add(txtTenHang);
		txtTenHang.setColumns(10);
		
		JLabel lblNhomHang = new JLabel("Nhóm hàng:");
		lblNhomHang.setBounds(28, 153, 84, 14);
		contentPane.add(lblNhomHang);
		
		JComboBox cbxNhomHang = new JComboBox();
		cbxNhomHang.setBounds(133, 149, 148, 20);
		contentPane.add(cbxNhomHang);
		
		JLabel lblNhaCungCap = new JLabel("Nhà cung cấp:");
		lblNhaCungCap.setBounds(27, 193, 85, 14);
		contentPane.add(lblNhaCungCap);
		
		txtNCC = new JTextField();
		txtNCC.setBounds(132, 189, 224, 20);
		contentPane.add(txtNCC);
		txtNCC.setColumns(10);
		
		JLabel lblDonGia = new JLabel("Đơn giá:");
		lblDonGia.setBounds(27, 233, 85, 14);
		contentPane.add(lblDonGia);
		
		txtDonGia = new JTextField();
		txtDonGia.setBounds(132, 229, 149, 20);
		contentPane.add(txtDonGia);
		txtDonGia.setColumns(10);
		
		JComboBox cbxDVT = new JComboBox();
		cbxDVT.setBounds(297, 226, 59, 24);
		contentPane.add(cbxDVT);
		
		JLabel lblVAT = new JLabel("VAT:");
		lblVAT.setBounds(27, 273, 85, 14);
		contentPane.add(lblVAT);
		
		txtVAT = new JTextField();
		txtVAT.setBounds(132, 269, 224, 20);
		contentPane.add(txtVAT);
		txtVAT.setColumns(10);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaseProduct item = new BaseProduct();
				item.setBarCode(txtMaHang.getText());
				item.setProductName(txtTenHang.getText());
				item.setRetailPrice(new BigDecimal( txtDonGia.getText()));
				item.setCategoryId(Long.valueOf(1));
			
			Long ProductId =  model.addProduct(item, 0);
				if(ProductId > 0)
				{
					dispose();
				}
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThem.setBounds(133, 310, 100, 40);
		contentPane.add(btnThem);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThoat.setBounds(256, 310, 100, 40);
		contentPane.add(btnThoat);
		
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
	}
}
