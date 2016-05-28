package DoAn;

import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.SystemColor;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Dao.UserDAO;
import DoAn.TongQuan;
public class DangNhap extends JFrame {

	UserDAO bll;
	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JTextField txtMatKhau;
	private JLabel lblTaiKhoan;
	private JLabel lblMatKhau;
	private JLabel lblPassword;
	private JLabel lblUsername;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
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
	public DangNhap() {
		bll = new UserDAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 30, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Image bg = new ImageIcon(this.getClass().getResource("/Background.jpg")).getImage();
		Image pw = new ImageIcon(this.getClass().getResource("/Password.png")).getImage();
		Image un = new ImageIcon(this.getClass().getResource("/Username.png")).getImage();
		contentPane.setLayout(null);
		
		JButton btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtTaiKhoan.getText();
				String password = txtMatKhau.getText();
				boolean hasAccount = bll.getUser(username, password);
				if(hasAccount) 
				{
					
				}
			}
		});
		btnDangNhap.setBounds(445, 400, 130, 50);
		contentPane.add(btnDangNhap);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTaiKhoan.setBounds(356, 291, 268, 30);
		txtTaiKhoan.setBorder(BorderFactory.createEmptyBorder());
		txtTaiKhoan.setBackground(new Color(250, 255, 163));
		txtTaiKhoan.setColumns(10);
		contentPane.add(txtTaiKhoan);
		
		txtMatKhau = new JTextField();
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMatKhau.setBounds(356, 351, 268, 30);
		txtMatKhau.setBorder(BorderFactory.createEmptyBorder());
		txtMatKhau.setBackground(new Color(250, 255, 163));
		txtMatKhau.setColumns(10);
		contentPane.add(txtMatKhau);
		
		lblUsername = new JLabel();
		lblUsername.setBounds(627, 295, 20, 20);
		lblUsername.setIcon(new ImageIcon(un));
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel();
		lblPassword.setBounds(627, 355, 20, 20);
		lblPassword.setIcon(new ImageIcon(pw));
		contentPane.add(lblPassword);
		
		lblTaiKhoan = new JLabel()
			{@Override
			 protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        Dimension arcs = new Dimension(15,15);
		        int width = getWidth();
		        int height = getHeight();
		        Graphics2D graphics = (Graphics2D) g;
		        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
		        graphics.setColor(new Color(250, 255, 163));
		        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
		        graphics.setColor(new Color(250, 255, 163));
		        graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
		     }};
		lblTaiKhoan.setBounds(350, 290, 301, 31);
		contentPane.add(lblTaiKhoan);
		
		lblMatKhau = new JLabel()
			{@Override
			 protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        Dimension arcs = new Dimension(15,15);
		        int width = getWidth();
		        int height = getHeight();
		        Graphics2D graphics = (Graphics2D) g;
		        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
		        graphics.setColor(new Color(250, 255, 163));
		        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
		        graphics.setColor(new Color(250, 255, 163));
		        graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
		     }};
		lblMatKhau.setBounds(350, 350, 301, 31);
		contentPane.add(lblMatKhau);
		
		JLabel lbDN = new JLabel("Đăng Nhập");
		lbDN.setForeground(Color.BLACK);
		lbDN.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		lbDN.setBounds(428, 220, 160, 39);
		contentPane.add(lbDN);
		
		JLabel lbBackground = new JLabel("");
		lbBackground.setBounds(0, 0, 984, 661);
		lbBackground.setIcon(new ImageIcon(bg));
		contentPane.add(lbBackground);
	}
}
