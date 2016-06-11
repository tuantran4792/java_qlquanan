package DoAn;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.math.BigDecimal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import POJO_entities.BaseProduct;
import antlr.collections.List;
import Dao.ProductDAO;
import Dao.UserDAO;
import javax.swing.JTable;

public class HangHoa extends JFrame {

	private JPanel contentPane;
	private JTextField txtTimKiem;
	ProductDAO bllProduct;
	private JTable tbDSHangHoa;
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
		bllProduct = new ProductDAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 30, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
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
		
		
		String[] columnNames = new String[]{"Mã",
                "Tên hàng hó",
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
		
		tbDSHangHoa = new JTable(tblModel);
		tbDSHangHoa.setBounds(49, 119, 821, 276);
		contentPane.add(tbDSHangHoa);
	}
}
