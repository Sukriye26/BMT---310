package apriori;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class anasayfaGUI extends JFrame {
	static anasayfaGUI frame ;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new anasayfaGUI();
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
	public anasayfaGUI() {
		setTitle("HO\u015EGELD\u0130N\u0130Z");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton girisYap = new JButton("Giri\u015F Yap");
		girisYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				girisYapGUI  frm2 = new girisYapGUI();
				frm2.setVisible(true);
				frame.dispose();
			}
		});
		girisYap.setBounds(75, 177, 97, 25);
		contentPane.add(girisYap);
		
		JButton kayitOl = new JButton("Kay\u0131t Ol");
		kayitOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kayitOl frame2 = new kayitOl();
				frame2.setVisible(true);
				frame.dispose();
			}
		});
		kayitOl.setBounds(270, 177, 97, 25);
		contentPane.add(kayitOl);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(65, 163, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel1= new JLabel();
		lblNewLabel1.setIcon(new ImageIcon(getClass().getResource("/yeni.jpg")));
		lblNewLabel1.setBounds(0, 0, 487, 631);
		contentPane.add(lblNewLabel1);
	}
}
