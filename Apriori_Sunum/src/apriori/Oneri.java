package apriori;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Label;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Font;

public class Oneri extends JFrame {
	
    Musteri musteri ;
	DefaultListModel listModel; 
	private JPanel contentPane;
	private JTextField idtext;
	private JTextField uruntext;
	private JList<String> liste1;
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Oneri frame = new Oneri();
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
	public Oneri() {
		
		
		setTitle("\u00DCR\u00DCN \u00D6NER\u0130 EKRANI");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00FC\u015Fteri ID:");
		lblNewLabel.setBounds(12, 104, 87, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Birinci \u00DCr\u00FCn:");
		lblNewLabel_1.setBounds(12, 133, 100, 16);
		contentPane.add(lblNewLabel_1);
	    
		JLabel label1 = new JLabel("\u00D6nerilen \u00DCr\u00FCn");
		label1.setBounds(400, 33, 163, 16);
		contentPane.add(label1);
		
		liste1=new JList();
		liste1.setBounds(315, 62, 378, 199);
		contentPane.add(liste1);
		
		
		idtext = new JTextField();
		idtext.setBounds(124, 101, 163, 22);
		contentPane.add(idtext);
		idtext.setColumns(10);
		
		uruntext = new JTextField();
		uruntext.setBounds(124, 130, 163, 22);
		contentPane.add(uruntext);
		uruntext.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setForeground(new Color(0, 0, 139));
		lblNewLabel_3.setBounds(25, 248, 521, 60);
		contentPane.add(lblNewLabel_3);
		
		JButton ara = new JButton("\u00D6NER\u0130 BUL");
		ara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id=Integer.parseInt(idtext.getText());
				String urun=uruntext.getText();
				musteri=DAO.getInstance().idbul(id);
				idtext.setText("");
				uruntext.setText("");
				liste1.removeAll();
				if(musteri != null) {
					
					//System.out.println(musteri.getID());
					urunListele(DAO.getInstance().urunBul(id, urun));
					lblNewLabel_3.setText("Önerilen ürünü %10 indirimli olarak alabilirsiniz.");
				}
				else  {
		
					urunListele(DAO.getInstance().urunOner());
					lblNewLabel_3.setText("Önerilen ürünleri %10 indirimli olarak alabilirsiniz.");
					
				}
				label1.setText("Önerilen Ürün");
				//oneri_label.setText(urun2);
			  
				
			}

			

			
		});
		ara.setBounds(108, 179, 97, 25);
		contentPane.add(ara);
		
		JLabel lblNewLabel_2 = new JLabel("");
		
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/yeni.jpg")));
		lblNewLabel_2.setBounds(0, 0, 487, 630);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(getClass().getResource("/deneme.png")));
		lblNewLabel_4.setBounds(478, 0, 238, 630);
		contentPane.add(lblNewLabel_4);
		
		
	}
	
	private void urunListele(ArrayList<String> urunler) { 
		DefaultListModel<String> listModel = new DefaultListModel<String>() {
			private static final long serialVersionUID = 2286396296976137666L;

			public int getSize() {
				return urunler.size();
			}

			public String getElementAt(int i) {
				return urunler.get(i);
			}
		};
		liste1.setModel(listModel);
		
	}
}
