package apriori;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class kayitOl extends JFrame {
	static kayitOl frame ;
   JFrame kayitOlekran;
	private JPanel contentPane;
	private JTextField kullanicitext;
	private JPasswordField sifreekr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new kayitOl();
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
	public kayitOl() {
		setTitle("KAYIT OLMA EKRANI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel kullanicitxt = new JLabel("Kullan\u0131c\u0131 Ad\u0131:");
		kullanicitxt.setBounds(103, 76, 81, 16);
		contentPane.add(kullanicitxt);
		
		JLabel sifretxt = new JLabel("\u015Eifre:");
		sifretxt.setBounds(103, 120, 56, 16);
		contentPane.add(sifretxt);
		
		JButton kayit = new JButton("Kay\u0131t Ol");
		kayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isim=kullanicitext.getText();
				String sifre=String.valueOf(sifreekr.getPassword());
				boolean giris=DAO.getInstance().kayitOl(isim, sifre);
				if(giris==true) {
					
					int id=DAO.getInstance().IDbul(isim, sifre);
					JOptionPane.showMessageDialog(null, "Kullanýcý Kaydý Baþarýlý! \n \t Müþteri Numaranýz: "+ id);
					Oneri form= new Oneri();
					form.setVisible(true);
					//frame.dispose();
				}
				
			}
		});
		kayit.setBounds(182, 184, 116, 48);
		contentPane.add(kayit);
		
		kullanicitext = new JTextField();
		kullanicitext.setBounds(218, 73, 116, 22);
		contentPane.add(kullanicitext);
		kullanicitext.setColumns(10);
		
		sifreekr = new JPasswordField();
		sifreekr.setBounds(218, 117, 116, 22);
		contentPane.add(sifreekr);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/yeni.jpg")));
		lblNewLabel.setBounds(0, 0, 481, 593);
		contentPane.add(lblNewLabel);
		

	}
}
