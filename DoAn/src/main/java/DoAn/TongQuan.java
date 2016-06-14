package DoAn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hibernate.type.CustomCollectionType;
import org.jdesktop.swingx.JXDatePicker;

import Dao.CustomerDAO;
import Dao.ProductDAO;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import Model.CommonTableModel;
import Model.GlobalModel;
import POJO_entities.BaseProduct;
import POJO_entities.CusCustomers;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
public class TongQuan extends JFrame {

	private JPanel contentPane, contentTH, contentTKH, contentNB;
	private JTextField txtTKHangHoa, txtTKLichLV, txtTKKhachHang, txtTKLich;
	private JTextField txtMaHang, txtTenHang, txtNCC, txtDonGia, txtVAT;
	private JTextField txtMaKH, txtTenKH, txtSDT, txtDiaChi, txtEmail;
	private JXDatePicker dtNgaySinh;
	private JTable tbDSHangHoa, tbDSKhachHang;
	private static JFrame fThemHang, fThemKH;
	/*private String[] headers = new String[] {
            "ID",
            "Code",
            "Tên khách hàng",
            "Điện thoại",
            "Địa chỉ",
            "Ngày sinh",
            "Email",
            "Xóa",
            "Ngày tạo",
            "Người tạo",
            "Ngày cập nhật",
            "Người cập nhật",
            "Ngày xóa",
            "Người xóa"};*/
	String[] cNameKH = new String[]{"Mã",
            "Tên khách hàng",
            "Ngày sinh",
            "Số điện thoại",
            "Địa chỉ",
            "Email"};
	ProductDAO bllProduct, model;

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
	//	GlobalModel global = new GlobalModel();
		bllProduct = new ProductDAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(40, 35, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//POS
		JButton btnPOS = new JButton("POS");
		btnPOS.setBounds(10, 28, 102, 33);
		contentPane.add(btnPOS);
		
		
		//Dashboard
		final JPanel pDashboard = new JPanel();
		pDashboard.setBounds(166, 11, 1008, 639);
		contentPane.add(pDashboard);
		pDashboard.setLayout(null);
		
		JPanel pDBHomNay = new JPanel();
		pDBHomNay.setBounds(10, 15, 990, 200);
		pDBHomNay.setBorder(BorderFactory.createTitledBorder("Hôm nay"));
		pDashboard.add(pDBHomNay);
		pDBHomNay.setLayout(null);
		
		JLabel lblDoanhThu = new JLabel("Doanh thu: ");
		lblDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDoanhThu.setBounds(59, 86, 79, 21);
		pDBHomNay.add(lblDoanhThu);
		
		JLabel lblTongDT = new JLabel("10.000.000");
		lblTongDT.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTongDT.setBounds(148, 86, 86, 18);
		pDBHomNay.add(lblTongDT);
		
		JLabel lblSoDonHang = new JLabel("Số đơn hàng: ");
		lblSoDonHang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSoDonHang.setBounds(361, 86, 79, 21);
		pDBHomNay.add(lblSoDonHang);
		
		JLabel lblTongSDH = new JLabel("10");
		lblTongSDH.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTongSDH.setBounds(450, 86, 86, 18);
		pDBHomNay.add(lblTongSDH);
		
		JLabel lblSoBanDCK = new JLabel("Số bàn đang có khách: ");
		lblSoBanDCK.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSoBanDCK.setBounds(634, 86, 153, 21);
		pDBHomNay.add(lblSoBanDCK);
		
		JLabel lblTongSBDCK = new JLabel("5");
		lblTongSBDCK.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTongSBDCK.setBounds(797, 86, 86, 18);
		pDBHomNay.add(lblTongSBDCK);
		
		JPanel pDBXemTheo = new JPanel();
		pDBXemTheo.setBounds(10, 230, 990, 400);
		pDBXemTheo.setBorder(BorderFactory.createTitledBorder("Xem theo"));
		pDashboard.add(pDBXemTheo);
		pDBXemTheo.setLayout(null);
		
		JRadioButton rbnXTTuan = new JRadioButton("Tuần");
		rbnXTTuan.setBounds(16, 25, 70, 23);
		pDBXemTheo.add(rbnXTTuan);
		rbnXTTuan.setSelected(true);
		
		JRadioButton rbnXTThang = new JRadioButton("Tháng");
		rbnXTThang.setBounds(100, 25, 70, 23);
		pDBXemTheo.add(rbnXTThang);
		
		JRadioButton rbnXTQuy = new JRadioButton("Quý");
		rbnXTQuy.setBounds(187, 25, 70, 23);
		pDBXemTheo.add(rbnXTQuy);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbnXTTuan);
		group.add(rbnXTThang);
		group.add(rbnXTQuy);
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(10, 70, 102, 34);
		contentPane.add(btnDashboard);
		
		
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
		
		JButton btnHangHoa = new JButton("Hàng hóa");
		btnHangHoa.setBounds(10, 115, 102, 33);
		contentPane.add(btnHangHoa);
		
		
		//Lich lam viec
		final JPanel pLichLamViec = new JPanel();
		pLichLamViec.setBounds(166, 11, 1008, 639);
		contentPane.add(pLichLamViec);
		pLichLamViec.setLayout(null);
		pLichLamViec.setVisible(false);
		
		JButton btnLichLamViec = new JButton("Lịch làm việc");
		btnLichLamViec.setBounds(10, 159, 102, 33);
		contentPane.add(btnLichLamViec);
		
		
		//KH
		final JPanel pKhachHang = new JPanel();
		pKhachHang.setBounds(166, 11, 1008, 639);
		contentPane.add(pKhachHang);
		pKhachHang.setLayout(null);
		pKhachHang.setVisible(false);
	
		JButton btnKhachHang = new JButton("Khách hàng");
		btnKhachHang.setBounds(10, 203, 102, 33);
		contentPane.add(btnKhachHang);
		
		
		//NhaBep
		final JPanel pNhaBep = new JPanel();
		pNhaBep.setBounds(166, 11, 1008, 639);
		contentPane.add(pNhaBep);
		pNhaBep.setLayout(null);
		pNhaBep.setVisible(false);
	
		JButton btnNhaBep = new JButton("Nhà bếp");
		btnNhaBep.setBounds(10, 247, 102, 33);
		contentPane.add(btnNhaBep);
				
				
		//DoanhThu
		final JPanel pDoanhThu = new JPanel();
		pDoanhThu.setBounds(166, 11, 1008, 639);
		contentPane.add(pDoanhThu);
		pDoanhThu.setLayout(null);
		pDoanhThu.setVisible(false);
	
		JButton btnDoanhThu = new JButton("Doanh thu");
		btnDoanhThu.setBounds(10, 291, 102, 33);
		contentPane.add(btnDoanhThu);
				
				
		
		
		//Button Dashboard
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pDashboard.setVisible(true);
				pHangHoa.setVisible(false);
				pLichLamViec.setVisible(false);
				pKhachHang.setVisible(false);
				pDoanhThu.setVisible(false);
				pNhaBep.setVisible(false);
			}
		});
		
		//Button HangHoa
		btnHangHoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pHangHoa.setVisible(true);
				pLichLamViec.setVisible(false);
				pDashboard.setVisible(false);
				pKhachHang.setVisible(false);
				pDoanhThu.setVisible(false);
				pNhaBep.setVisible(false);
				bllProduct = new ProductDAO();

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
				
				//Frame ThemHangHoa
				btnThemHang.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						fThemHang = new JFrame();
						fThemHang.setVisible(true);
						model = new ProductDAO();
						fThemHang.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
						fThemHang.setBounds(dimension.width / 3, dimension.height / 5, 405, 410);
						contentTH = new JPanel();
						contentTH.setBorder(new EmptyBorder(5, 5, 5, 5));
						fThemHang.setContentPane(contentTH);
						contentTH.setLayout(null);
						
						JLabel lblThemHang = new JLabel("Thêm Hàng");
						lblThemHang.setFont(new Font("UTM Aristote", Font.PLAIN, 26));
						lblThemHang.setBounds(101, 8, 188, 45);
						contentTH.add(lblThemHang);
						
						JLabel lblMaHang = new JLabel("Mã hàng:");
						lblMaHang.setBounds(27, 73, 85, 14);
						contentTH.add(lblMaHang);
						
						txtMaHang = new JTextField();
						txtMaHang.setToolTipText("Nhập mã hàng");
						txtMaHang.setHorizontalAlignment(SwingConstants.LEFT);
						txtMaHang.setBounds(132, 69, 224, 20);
						contentTH.add(txtMaHang);
						txtMaHang.setColumns(10);
						
						JLabel lblTenHang = new JLabel("Tên hàng:");
						lblTenHang.setBounds(27, 113, 85, 14);
						contentTH.add(lblTenHang);
						
						txtTenHang = new JTextField();
						txtTenHang.setBounds(132, 109, 224, 20);
						contentTH.add(txtTenHang);
						txtTenHang.setColumns(10);
						
						JLabel lblNhomHang = new JLabel("Nhóm hàng:");
						lblNhomHang.setBounds(28, 153, 84, 14);
						contentPane.add(lblNhomHang);
						
						JComboBox cbxNhomHang = new JComboBox();
						cbxNhomHang.setBounds(133, 149, 148, 20);
						contentTH.add(cbxNhomHang);
						
						JLabel lblNhaCungCap = new JLabel("Nhà cung cấp:");
						lblNhaCungCap.setBounds(27, 193, 85, 14);
						contentTH.add(lblNhaCungCap);
						
						txtNCC = new JTextField();
						txtNCC.setBounds(132, 189, 224, 20);
						contentTH.add(txtNCC);
						txtNCC.setColumns(10);
						
						JLabel lblDonGia = new JLabel("Đơn giá:");
						lblDonGia.setBounds(27, 233, 85, 14);
						contentTH.add(lblDonGia);
						
						txtDonGia = new JTextField();
						txtDonGia.setBounds(132, 229, 149, 20);
						contentTH.add(txtDonGia);
						txtDonGia.setColumns(10);
						
						JComboBox cbxDVT = new JComboBox();
						cbxDVT.setBounds(297, 226, 59, 24);
						contentTH.add(cbxDVT);
						
						JLabel lblVAT = new JLabel("VAT:");
						lblVAT.setBounds(27, 273, 85, 14);
						contentTH.add(lblVAT);
						
						txtVAT = new JTextField();
						txtVAT.setBounds(132, 269, 224, 20);
						contentTH.add(txtVAT);
						txtVAT.setColumns(10);
						
						JButton btnThemHH = new JButton("Thêm");
						btnThemHH.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								BaseProduct item = new BaseProduct();
								item.setBarCode(txtMaHang.getText());
								item.setProductName(txtTenHang.getText());
								item.setRetailPrice(new BigDecimal( txtDonGia.getText()));
								item.setCategoryId(Long.valueOf(1));
							
							int ProductId =  model.addProduct(item, 0);
							if(ProductId > 0)
								{
								dispose();
								}
							}
						});
						btnThemHH.setFont(new Font("Tahoma", Font.BOLD, 13));
						btnThemHH.setBounds(133, 310, 100, 40);
						contentTH.add(btnThemHH);
						
						JButton btnThoatHH = new JButton("Thoát");
						btnThoatHH.setFont(new Font("Tahoma", Font.BOLD, 13));
						btnThoatHH.setBounds(256, 310, 100, 40);
						contentTH.add(btnThoatHH);
						
						btnThoatHH.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								fThemHang.dispose();
							}
						});
					}
				});
				
				String[] columnNames = new String[]{"Mã",
		                "Tên hàng hóa",
		                "Nhóm hàng",
		                "Giá bán",
		                "Số lượng"};
				
				java.util.List<BaseProduct> products = bllProduct.getProducts(null, 0);
			    DefaultTableModel tblModel = new DefaultTableModel(columnNames, 0);

				for (int i = 0; i < products.size(); i++){
					   long ProductId = products.get(i).getProductId();
					   String Barcode = products.get(i).getBarCode();
					   String ProductName = products.get(i).getProductName();
					   long CategoryId = products.get(i).getCategoryId();
					   BigDecimal Price = products.get(i).getRetailPrice();
					   BigDecimal Quantity = products.get(i).getQtyAvailable();
					   Object[] row = { Barcode, ProductName, CategoryId, Price, Quantity};
					   tblModel.addRow(row);
					}
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(49, 50, 837, 588);
				pHangHoa.add(scrollPane);
				
				tbDSHangHoa = new JTable(tblModel);
				scrollPane.setViewportView(tbDSHangHoa);
				
			}
		});
		
		//Button LichLamViec
		btnLichLamViec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pLichLamViec.setVisible(true);
				pHangHoa.setVisible(false);
				pKhachHang.setVisible(false);
				pDashboard.setVisible(false);
				pDoanhThu.setVisible(false);
				pNhaBep.setVisible(false);
				
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

			}
		});
		
		//Button KhachHang
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pKhachHang.setVisible(true);
				pDashboard.setVisible(false);
				pHangHoa.setVisible(false);
				pLichLamViec.setVisible(false);
				pDoanhThu.setVisible(false);
				pNhaBep.setVisible(false);
				
				txtTKKhachHang = new JTextField();
				txtTKKhachHang.setText("Nhập tên hoặc SĐT khách hàng ...");
				txtTKKhachHang.setColumns(10);
				txtTKKhachHang.setBounds(10, 11, 602, 22);
				pKhachHang.add(txtTKKhachHang);
				
				tbDSKhachHang = new JTable();
				tbDSKhachHang.setBounds(10, 51, 896, 550);
				tbDSKhachHang.setVisible(true);
				pKhachHang.add(tbDSKhachHang);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(49, 50, 837, 588);
				scrollPane.setViewportView(tbDSKhachHang);
				pKhachHang.add(scrollPane);
				
				JButton btnThemKhachHang = new JButton("Thêm khách hàng");
				btnThemKhachHang.setBounds(700, 2, 140, 35);
				pKhachHang.add(btnThemKhachHang);
				
				//Frame ThemKhachHang
				btnThemKhachHang.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//ThemKhachHang
						CusCustomers _cus = new CusCustomers();
						ThemKH(_cus);
						
					}
				});
				
				txtTKKhachHang.addMouseListener(new MouseListener(){
					public void mouseClicked(MouseEvent e) {
						txtTKKhachHang.setText("");;
				    }

				    public void mousePressed(MouseEvent e) {

				    }

				    public void mouseReleased(MouseEvent e) {

				    }

				    public void mouseEntered(MouseEvent e) {

				    }

				    public void mouseExited(MouseEvent e) {

				    }

				});
				
				KeyListener keyListener = new KeyListener() {
				      public void keyPressed(KeyEvent keyEvent) {
				    	  
				      }

					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}

					public void keyReleased(KeyEvent e) {
						String txtSearch = txtTKKhachHang.getText();
						CustomerDAO _cusDAO = new CustomerDAO();
						List<CusCustomers> _listCus = _cusDAO.searchCustomer(txtSearch);
						LoadCustomer(cNameKH, _listCus, tbDSKhachHang);
					}
					
			    };
				txtTKKhachHang.addKeyListener(keyListener);
				
				tbDSKhachHang.setModel(new javax.swing.table.DefaultTableModel(
			            new Object [][] {
			                {},
			                {},
			                {},
			                {}
			            },
			            new String [] {

			            }
			        ));
				
				CustomerDAO _cusDAO = new CustomerDAO();
				List<CusCustomers> _listCus = _cusDAO.getAllCustomer();
				LoadCustomer(cNameKH, _listCus, tbDSKhachHang);
				tbDSKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
				    @Override
				    public void mouseClicked(java.awt.event.MouseEvent evt) {
				    	CusCustomers _cus = new CusCustomers();
			        	
			        	SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
			        	java.util.Date date= new java.util.Date();
						try {
							date = sdf1.parse(tbDSKhachHang.getValueAt(tbDSKhachHang.getSelectedRow(), 2).toString());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        	java.sql.Date sqlBirthday = new Date(date.getTime()); 
			        	
						java.util.Date _d = new java.util.Date();
						java.sql.Date today = new java.sql.Date(_d.getTime());
						
			        	_cus.setAddress(tbDSKhachHang.getValueAt(tbDSKhachHang.getSelectedRow(), 4).toString());
						_cus.setBirthday(sqlBirthday);
						_cus.setCode("1");
						_cus.setCustomerName(tbDSKhachHang.getValueAt(tbDSKhachHang.getSelectedRow(), 1).toString());
						_cus.setEmail(tbDSKhachHang.getValueAt(tbDSKhachHang.getSelectedRow(), 5).toString());
						_cus.setPhone(tbDSKhachHang.getValueAt(tbDSKhachHang.getSelectedRow(), 3).toString());
						//_cus.setCreatedDate(today);
						_cus.setCreatedUser(GlobalModel.UserId);
						Long id = Long.parseLong(tbDSKhachHang.getValueAt(tbDSKhachHang.getSelectedRow(), 0).toString());
						_cus.setId(id);
			        	
						ThemKH(_cus);
				    }
				});
			}
		});
		
		//Button NhaBep
		btnNhaBep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pNhaBep.setVisible(true);
				pDashboard.setVisible(false);
				pHangHoa.setVisible(false);
				pLichLamViec.setVisible(false);
				pDoanhThu.setVisible(false);
				pKhachHang.setVisible(false);

				contentNB = new JPanel();
				contentNB.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentNB.setLayout(new BorderLayout(0, 0));
				contentNB.setBounds(10, 11, 1008, 600);
				pNhaBep.add(contentNB);
				
				JPanel pABC = new JPanel();
		        JScrollPane scrollPaneNB = new JScrollPane(pABC);
		        scrollPaneNB.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		        pABC.setPreferredSize(new Dimension(2008, 600));
		        pABC.setLayout(null);
		        
		        final JPanel pPhieuNB = new JPanel();
		        pPhieuNB.setBounds(10, 10, 300, 590);
		        pABC.add(pPhieuNB);
				pPhieuNB.setLayout(null);
				pPhieuNB.setBackground(Color.white);
				pPhieuNB.setForeground(Color.white);
				
				JLabel lblTenMonAn = new JLabel("Tên món ăn:");
				lblTenMonAn.setBounds(10, 10, 85, 14);
				pPhieuNB.add(lblTenMonAn);
				
				final JPanel pPhieuNB2 = new JPanel();
				pPhieuNB2.setBounds(500, 10, 300, 590);
				pABC.add(pPhieuNB2);
		        pPhieuNB2.setLayout(null);
		        pPhieuNB2.setBackground(Color.white);
		        pPhieuNB2.setForeground(Color.white);
				
				JLabel lblTenMonAn2 = new JLabel("Tên món ăn:");
				lblTenMonAn2.setBounds(10, 10, 85, 14);
				pPhieuNB2.add(lblTenMonAn2);
				
				final JPanel pPhieuNB3 = new JPanel();
				pPhieuNB3.setBounds(1000, 10, 300, 590);
				pABC.add(pPhieuNB3);
		        pPhieuNB3.setLayout(null);
		        pPhieuNB3.setBackground(Color.white);
		        pPhieuNB3.setForeground(Color.white);
				
				JLabel lblTenMonAn3 = new JLabel("Tên món ăn:");
				lblTenMonAn3.setBounds(10, 10, 85, 14);
				pPhieuNB3.add(lblTenMonAn3);
				
				contentNB.add(scrollPaneNB);
			}
		});
				
		//Button DoanhThu
		btnDoanhThu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pDoanhThu.setVisible(true);
				pDashboard.setVisible(false);
				pHangHoa.setVisible(false);
				pLichLamViec.setVisible(false);
				pKhachHang.setVisible(false);
				pNhaBep.setVisible(false);
		
				JRadioButton rbnTNguoiBan = new JRadioButton("Theo người bán");
				rbnTNguoiBan.setBounds(10, 10, 120, 23);
				pDoanhThu.add(rbnTNguoiBan);
				rbnTNguoiBan.setSelected(true);
				
				JRadioButton rbnTCuaHang = new JRadioButton("Theo cửa hàng");
				rbnTCuaHang.setBounds(150, 10, 120, 23);
				pDoanhThu.add(rbnTCuaHang);
				
				ButtonGroup group = new ButtonGroup();
				group.add(rbnTNguoiBan);
				group.add(rbnTCuaHang);
				
				//TheoNguoiBan
				final JPanel pTNguoiBan = new JPanel();
				pTNguoiBan.setBounds(10, 60, 1000, 600);
				pDoanhThu.add(pTNguoiBan);
				pTNguoiBan.setLayout(null);
				pTNguoiBan.setVisible(true);
				
				JComboBox cbxTuNgay = new JComboBox();
				cbxTuNgay.setModel(new DefaultComboBoxModel(new String[] {"Từ ngày"}));
				cbxTuNgay.setToolTipText("");
				cbxTuNgay.setBounds(10, 10, 146, 20);
				pTNguoiBan.add(cbxTuNgay);
				
				JComboBox cbxDenNgay = new JComboBox();
				cbxDenNgay.setModel(new DefaultComboBoxModel(new String[] {"Đến ngày"}));
				cbxDenNgay.setToolTipText("");
				cbxDenNgay.setBounds(170, 10, 146, 20);
				pTNguoiBan.add(cbxDenNgay);
				
				JButton btnTTuan = new JButton("Tuần");
				btnTTuan.setBounds(330, 6, 80, 30);
				pTNguoiBan.add(btnTTuan);
				
				JButton btnTThang = new JButton("Tháng");
				btnTThang.setBounds(430, 6, 80, 30);
				pTNguoiBan.add(btnTThang);
				
				JButton btnTQuy = new JButton("Quý");
				btnTQuy.setBounds(525, 6, 80, 30);
				pTNguoiBan.add(btnTQuy);
				
				//TheoCuaHang
				final JPanel pTCuaHang = new JPanel();
				pTCuaHang.setBounds(10, 60, 1000, 600);
				pDoanhThu.add(pTCuaHang);
				pTCuaHang.setLayout(null);
				pTCuaHang.setVisible(false);
				
				
				rbnTNguoiBan.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pTNguoiBan.setVisible(true);
						pTCuaHang.setVisible(false);
					}
				});
				
				rbnTCuaHang.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pTNguoiBan.setVisible(false);
						pTCuaHang.setVisible(true);
					}
				});
			}
		});
	}
	
	public static String[][] Convert(List<CusCustomers> _list){
		CustomerDAO _cusDAO = new CustomerDAO();
        String[][] arrayToReturn = new String[_list.size()][6];
        for (int i = 0; i < (_list.size()); i++) {
            arrayToReturn[i] = _cusDAO.convertCustomerRowToArray(_list.get(i));
        }
        return arrayToReturn;
    }
	
	public static void LoadCustomer(String[] cNameKH, List<CusCustomers> _listCus, JTable jtable){
		CommonTableModel customerTableModel = new CommonTableModel(cNameKH, Convert(_listCus));
		jtable.setModel(customerTableModel);
	}
	
	public static String formatDate (String date, String initDateFormat, String endDateFormat) throws ParseException {
	    Date initDate = (Date) new SimpleDateFormat(initDateFormat).parse(date);
	    SimpleDateFormat formatter = new SimpleDateFormat(endDateFormat);
	    String parsedDate = formatter.format(initDate);

	    return parsedDate;
	}
	
	
	//Ham ThemKhachHang
	public void ThemKH(CusCustomers _cus){
		fThemKH = new JFrame();
		fThemKH.setVisible(true);
		fThemKH.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		fThemKH.setBounds(dimension.width / 3, dimension.height / 5, 430, 410);
		contentTKH = new JPanel();
		contentTKH.setBorder(new EmptyBorder(5, 5, 5, 5));
		fThemKH.setContentPane(contentTKH);
		contentTKH.setLayout(null);
		
		JLabel lblThemKH = new JLabel("Thêm Khách Hàng");
		lblThemKH.setFont(new Font("UTM Aristote", Font.PLAIN, 26));
		lblThemKH.setBounds(65, 0, 307, 62);
		contentTKH.add(lblThemKH);
		
		JLabel lblMaKH = new JLabel("Mã khách hàng:");
		lblMaKH.setBounds(27, 73, 85, 14);
		contentTKH.add(lblMaKH);
		
		txtMaKH = new JTextField();
		txtMaKH.setHorizontalAlignment(SwingConstants.LEFT);
		txtMaKH.setBounds(163, 69, 224, 20);
		contentTKH.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		JLabel lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setBounds(27, 113, 85, 14);
		contentTKH.add(lblTenKH);
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(163, 109, 224, 20);
		contentTKH.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setBounds(28, 153, 84, 14);
		contentTKH.add(lblNgaySinh);

		dtNgaySinh  = new JXDatePicker();
		dtNgaySinh.setDate(Calendar.getInstance().getTime());
		dtNgaySinh.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
		dtNgaySinh.setBounds(164, 149, 148, 20);
		contentTKH.add(dtNgaySinh);
		
		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setBounds(27, 193, 85, 14);
		contentTKH.add(lblSDT);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(163, 189, 224, 20);
		contentTKH.add(txtSDT);
		txtSDT.setColumns(10);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setBounds(27, 233, 85, 14);
		contentTKH.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(163, 229, 224, 20);
		contentTKH.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(27, 273, 135, 14);
		contentTKH.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(163, 269, 224, 20);
		contentTKH.add(txtEmail);
		txtEmail.setColumns(10);
		
		final JButton btnThemKH = new JButton("Thêm");
		btnThemKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThemKH.setBounds(164, 309, 100, 40);
		contentTKH.add(btnThemKH);
		
		JButton btnThoatKH = new JButton("Thoát");
		btnThoatKH.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThoatKH.setBounds(287, 309, 100, 40);
		contentTKH.add(btnThoatKH);
		
		btnThoatKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fThemKH.dispose();
			}
		});	
		
		if(_cus.getId() != null ){
			txtMaKH.setText(_cus.getId().toString());
			txtDiaChi.setText(_cus.getAddress());
			txtSDT.setText(_cus.getPhone());
			txtEmail.setText(_cus.getEmail());
			txtTenKH.setText(_cus.getCustomerName());
			dtNgaySinh.setDate(_cus.getBirthday());
			
			btnThemKH.setText("Sửa");
		}
		
		
		btnThemKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//String dateString2 = new SimpleDateFormat("yyyy-MM-dd").format(dtNgaySinh.getDate());
				java.util.Date date = dtNgaySinh.getDate();
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				java.util.Date _d = new java.util.Date();
				java.sql.Date today = new java.sql.Date(_d.getTime());
				//JOptionPane.showMessageDialog(null,today , "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
				CusCustomers _cus = new CusCustomers();
				_cus.setAddress(txtDiaChi.getText());
				_cus.setBirthday(sqlDate);
				_cus.setCode("1");
				_cus.setCustomerName(txtTenKH.getText());
				_cus.setEmail(txtEmail.getText());
				_cus.setPhone(txtSDT.getText());
				
				CustomerDAO _cusDAO = new CustomerDAO();
				if(btnThemKH.getText() == "Sửa"){
					_cus.setId(Long.parseLong(txtMaKH.getText()));
					_cusDAO.updateCustomer(_cus, GlobalModel.UserId);
					JOptionPane.showMessageDialog(null,"Sửa thành công!!" , "Thông báo ", JOptionPane.INFORMATION_MESSAGE);
					fThemKH.dispose();
				}else{
					_cus.setCreatedDate(today);
					_cus.setCreatedUser(GlobalModel.UserId);
					_cusDAO.createCustomer(_cus);
					
					JOptionPane.showMessageDialog(null,"Thêm thành công!!" , "Thông báo ", JOptionPane.INFORMATION_MESSAGE);
					fThemKH.dispose();
				}
			}
		});
	}
}
