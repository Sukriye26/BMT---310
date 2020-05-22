package apriori;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class girisYapGUI extends JFrame {

	private JPanel contentPane;
	private JTextField kAditext;
	private JPasswordField sifretxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					girisYapGUI frame = new girisYapGUI();
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
	public girisYapGUI() {
		setTitle("G\u0130R\u0130\u015E EKRANI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 Ad\u0131:");
		lblNewLabel.setBounds(115, 124, 107, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u015Eifre:");
		lblNewLabel_1.setBounds(115, 169, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		kAditext = new JTextField();
		kAditext.setBounds(234, 121, 116, 22);
		contentPane.add(kAditext);
		kAditext.setColumns(10);
		
		JButton girisYap = new JButton("Giri\u015F Yap");
		girisYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String kullanici=kAditext.getText();
				String sfre=String.valueOf(sifretxt.getPassword());
				Musteri musteri=DAO.getInstance().girisYap(kullanici,sfre);
				if(musteri!=null) {
					JOptionPane.showMessageDialog(null, "Giriþ Baþarýlý!");
					Oneri form = new Oneri();
					form.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Kullanýcý Adý veya Þifre Hatalý!");
				}
			}
		});
		girisYap.setBounds(172, 215, 97, 25);
		contentPane.add(girisYap);
		
		sifretxt = new JPasswordField();
		sifretxt.setBounds(234, 166, 116, 22);
		contentPane.add(sifretxt);
		
		
		JLabel lblNewLabel1= new JLabel();
		lblNewLabel1.setIcon(new ImageIcon(getClass().getResource("/yeni.jpg")));
		lblNewLabel1.setBounds(0, 0, 487, 631);
		contentPane.add(lblNewLabel1);
	}
}
