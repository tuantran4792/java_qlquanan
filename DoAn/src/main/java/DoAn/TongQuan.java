package DoAn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import Model.GlobalModel;
public class TongQuan extends JFrame {

	private JPanel contentPane;

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
		setBounds(150, 30, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 250, 639);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(270, 11, 451, 511);
		contentPane.add(textArea_1);
		
		JLabel lblXinCho = new JLabel("Xin ch\u00E0o");
		lblXinCho.setBounds(791, 0, 46, 14);
		contentPane.add(lblXinCho);

		GlobalModel data = new GlobalModel();
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(895, 0, 46, 14);
		lblName.setText(data.getUsername());
		contentPane.add(lblName);
	}
}
