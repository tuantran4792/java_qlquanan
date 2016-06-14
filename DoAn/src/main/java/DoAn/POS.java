package DoAn;

import java.awt.BorderLayout;
import java.awt.Button;
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
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.AncestorEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

import Dao.OrderDAO;
import Dao.ProductDAO;
import Model.OrderTableModel;
import Model.ProductItemModel;
import POJO_entities.BaseProduct;
import antlr.collections.List;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Console;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
public class POS extends JFrame {

	private JPanel contentPane;
	private JTextField txtKhachHang;
	private ProductDAO bllProduct;
	private OrderDAO bllOrder;
	private JTable OrderList;
	/**
	 * Launch the application.
	 */
	private JButton[] createLabels(){
			bllProduct = new ProductDAO();	

			int x = 75;
			int y = 75;
			java.util.List<BaseProduct> products = bllProduct.getProducts(null, 0);

	        JButton[] labels = new JButton[products.size()];
            int xtemp = x;
            int ytemp = y;
	        for (int i=0; i< labels.length;i++){

	            if(i%5 == 0)
	            {
	            	xtemp = x;
	            	ytemp = (i/5 + 1) * y;
	            }
	            else
	            {
	            	xtemp = (i%5 +1 ) * x;
	            }
	            
	        	labels[i]=new JButton();
	        	labels[i].setName(products.get(i).getProductId().toString());
	        	labels[i].setText(String.valueOf(products.get(i).getBarCode()) + "-" + products.get(i).getProductName());

	            //labels[i].setIcon(new ImageIcon(POS.class.getResource("/javax/swing/plaf/basic/icons/image-delayed.png")));

	            labels[i].setBounds( xtemp, ytemp , 70 , 50 );
	        }
	        return labels;
	    }

	private JButton[] createTables(){

		int x = 75;
		int y = 75;
		java.util.List<Integer> tables = new ArrayList<Integer>();
		for (int i = 0; i < 6; i++) {
			tables.add(i);
		}
	
        JButton[] labels = new JButton[tables.size()];
        int xtemp = x;
        int ytemp = y;
        for (int i=0; i< labels.length;i++){

            if(i%3 == 0)
            {
            	xtemp = x;
            	ytemp = (i/3 + 1) * y;
            }
            else
            {
            	xtemp = (i%3 +1 ) * x;
            }
            
        	labels[i]=new JButton();
        	labels[i].setName(tables.get(i).toString());
        	labels[i].setText("Bàn " + (tables.get(i) + 1));

            //labels[i].setIcon(new ImageIcon(POS.class.getResource("/javax/swing/plaf/basic/icons/image-delayed.png")));

            labels[i].setBounds( xtemp, ytemp , 70 , 50 );
        }
        return labels;
    }
	
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
		bllOrder = new OrderDAO();
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
		
		JLabel lblSoDoBan = new JLabel("SÆ¡  Ä�á»“  BĂ n");
		lblSoDoBan.setFont(new Font("UTM French Vanilla", Font.PLAIN, 30));
		lblSoDoBan.setBounds(73, 47, 157, 38);
		pPOS.add(lblSoDoBan);
		


		
		JLabel lblHoaDon = new JLabel("HĂ³a  Ä�Æ¡n");
		lblHoaDon.setFont(new Font("UTM French Vanilla", Font.PLAIN, 30));
		lblHoaDon.setBounds(425, 47, 129, 38);
		pPOS.add(lblHoaDon);
		
		JPanel pTTHoaDon = new JPanel();
		pTTHoaDon.setBounds(320, 86, 343, 558);
		pTTHoaDon.setBorder(BorderFactory.createTitledBorder("ThĂ´ng tin hĂ³a Ä‘Æ¡n"));
		pPOS.add(pTTHoaDon);
		pTTHoaDon.setLayout(null);
		
		JLabel lblSoHoaDon = new JLabel("Sá»‘ hĂ³a Ä‘Æ¡n:");
		lblSoHoaDon.setBounds(10, 31, 68, 14);
		pTTHoaDon.add(lblSoHoaDon);
		
		JLabel lblBan = new JLabel("New label");

		lblBan.setBounds(245, 31, 77, 14);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String date = formatter.format(new Date());
		lblBan.setText(date);
		pTTHoaDon.add(lblBan);
		
		JLabel lblNgay = new JLabel("NgĂ y:");
		lblNgay.setBounds(198, 31, 45, 14);
		pTTHoaDon.add(lblNgay);
		
		JLabel lblSHD = new JLabel("New label");
		lblSHD.setBounds(88, 31, 100, 14);
		
		lblSHD.setText("Hệ Thống tự sinh");
		pTTHoaDon.add(lblSHD);
		
		JLabel lblSoBan = new JLabel("Sá»‘ bĂ n:");
		lblSoBan.setBounds(10, 68, 68, 14);
		pTTHoaDon.add(lblSoBan);
		
		final JLabel lblSB = new JLabel("New label");
		lblSB.setBounds(89, 68, 77, 14);
		pTTHoaDon.add(lblSB);
		
		JTextArea tarSoDoBan = new JTextArea();
		JButton[] tables = createTables();
		lblSB.setText(String.valueOf(1));
		for (int i = 0; i < tables.length; i++) {
			tarSoDoBan.add(tables[i]);
			tables[i].addMouseListener(new MouseAdapter() {	
    			@Override
    			public void mouseClicked(MouseEvent e) {	
    				Object o = e.getSource();
    				   JButton b = null;
    				   String buttonName = "";
    				   if(o instanceof JButton)
    				     b = (JButton)o;

    				   if(b != null)
    				   {
    				     buttonName = b.getName();
    				     b.setBackground(Color.RED);
    				     //b.setEnabled(false);
    				   }
    				   bllOrder.SetNewOrder(Integer.parseInt( b.getName()));
    				   int newTableId = Integer.parseInt( b.getName()) + 1;
    				   lblSB.setText(String.valueOf( newTableId));
    			}
    		});
		}
		tarSoDoBan.setBounds(10, 88, 300, 558);
		tarSoDoBan.setEditable(false);
		pPOS.add(tarSoDoBan);
		
		JLabel lblKhachHang = new JLabel("KhĂ¡ch hĂ ng:");
		lblKhachHang.setBounds(10, 104, 68, 14);
		pTTHoaDon.add(lblKhachHang);
		
		txtKhachHang = new JTextField();
		txtKhachHang.setBounds(89, 101, 197, 20);
		pTTHoaDon.add(txtKhachHang);
		txtKhachHang.setColumns(10);
		
		JButton btnTKKhachHang = new JButton("New button");
		btnTKKhachHang.setBounds(297, 100, 25, 23);
		pTTHoaDon.add(btnTKKhachHang);
		
		JLabel lblNhanVien = new JLabel("NhĂ¢n viĂªn:");
		lblNhanVien.setBounds(10, 145, 68, 14);
		pTTHoaDon.add(lblNhanVien);
		
		JLabel lblTenNhanVien = new JLabel("New label");
		lblTenNhanVien.setBounds(89, 145, 197, 14);
		pTTHoaDon.add(lblTenNhanVien);
		
		JLabel lblTongTien = new JLabel("Tá»•ng tiá»�n:");
		lblTongTien.setBounds(58, 433, 58, 14);
		pTTHoaDon.add(lblTongTien);
		
		final JLabel lblTT = new JLabel("New label");
		lblTT.setForeground(Color.RED);
		lblTT.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTT.setBounds(126, 425, 160, 25);
		lblTT.setText("0");
		pTTHoaDon.add(lblTT);
		
		JLabel lblDonViTinh = new JLabel("VNÄ�");
		lblDonViTinh.setBounds(288, 432, 45, 14);
		pTTHoaDon.add(lblDonViTinh);
		
		JButton btnThanhToan = new JButton("Thanh ToĂ¡n");
		btnThanhToan.setBounds(244, 515, 89, 32);
		pTTHoaDon.add(btnThanhToan);
		
		JLabel lblTienNhan = new JLabel("Tiá»�n nháº­n:");
		lblTienNhan.setBounds(58, 468, 58, 14);
		pTTHoaDon.add(lblTienNhan);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(126, 461, 77, 23);
		pTTHoaDon.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 181, 323, 240);
		pTTHoaDon.add(scrollPane);
		

		OrderList = new JTable();
		String[] columnOrders = new String[]{"MĂ£",
                "TĂªn hĂ ng hĂ³a",
                "Sá»‘ lÆ°á»£ng",
                "GiĂ¡ bĂ¡n",
                ""};
	    final DefaultTableModel tblOrder = new DefaultTableModel(columnOrders, 0);
	    OrderList.setModel(tblOrder);
		scrollPane.setViewportView(OrderList);

		OrderList.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		//scrollPane.setColumnHeaderView(OrderList);
		
		JLabel lblThucDon = new JLabel("Thá»±c  Ä�Æ¡n");
		lblThucDon.setFont(new Font("UTM French Vanilla", Font.PLAIN, 30));
		lblThucDon.setBounds(777, 47, 129, 38);
		pPOS.add(lblThucDon);
		

		
		JTextArea tarThucDon = new JTextArea();
		tarThucDon.setEditable(false);
		tarThucDon.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		tarThucDon.setBounds(673, 122, 485, 482);
		pPOS.add(tarThucDon);
		bllOrder.Init();
		JButton[] labels=createLabels();
        for (int i=0;i<labels.length;i++){
        	tarThucDon.add(labels[i]);
    		labels[i].addMouseListener(new MouseAdapter() {
    			@Override
    			public void mouseClicked(MouseEvent e) {
    				
    				Object o = e.getSource();
    				   JButton b = null;
    				   String buttonText = "";
    				   String buttonName = "";

    				   if(o instanceof JButton)
    				     b = (JButton)o;

    				   if(b != null)
    				   {
    				     buttonText = b.getText();
    				     buttonName = b.getName();
    				   }
    				ProductItemModel item = new ProductItemModel();
    				item.setName(buttonText);
    				item.setProductId(Long.valueOf(buttonName));
    				item.setQty(1);
    				
    				java.util.List<OrderTableModel> model = new ArrayList<OrderTableModel>();
    				
    				int IndexTable = 0;
    				
    				if(lblSB.getText() == null)
    				{
    					lblSB.setText("0");
    					IndexTable = bllOrder.GetCurentObject(0);
    				}
    				else 
    				{
    					IndexTable = bllOrder.GetCurentObject(Integer.parseInt(lblSB.getText()));
    					if(IndexTable == -1)
    						IndexTable = bllOrder.SetNewOrderAndGetIndex(Integer.parseInt(lblSB.getText()));
    				}
    			    model = bllOrder.addOrUpdateItem(IndexTable, item);
    				tblOrder.setRowCount(0);
    				BigDecimal totalPrice = new BigDecimal(0);
    				for (ProductItemModel item1 : model.get(IndexTable).items) {
    					
    					BigDecimal itemCost  = BigDecimal.ZERO;
    					itemCost  = item1.Price.multiply(new BigDecimal(item1.Qty));
    					totalPrice = totalPrice.add(itemCost);
    					
        				Object[] row = { item1.getProductId(), item1.Name , item1.Qty, item1.Price.add(totalPrice)};
        				tblOrder.addRow(row);
					}

    				OrderList.setModel(tblOrder);
    				OrderList.repaint();
    				totalPrice = totalPrice.setScale(0, BigDecimal.ROUND_HALF_UP);
    			
    				lblTT.setText(bllOrder.formatNumber(totalPrice));
    			}
    		});
        }
        
        
	}
}
