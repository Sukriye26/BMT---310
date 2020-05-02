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
		setBounds(100, 100, 499, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00FC\u015Fteri ID:");
		lblNewLabel.setBounds(0, 79, 87, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Birinci \u00DCr\u00FCn:");
		lblNewLabel_1.setBounds(0, 108, 100, 16);
		contentPane.add(lblNewLabel_1);
	    
		JLabel label1 = new JLabel("\u00D6nerilen \u00DCr\u00FCn");
		label1.setBounds(303, 33, 163, 16);
		contentPane.add(label1);
		
		liste1=new JList();
		liste1.setBounds(255, 62, 218, 133);
		contentPane.add(liste1);
		
		
		idtext = new JTextField();
		idtext.setBounds(112, 76, 116, 22);
		contentPane.add(idtext);
		idtext.setColumns(10);
		
		uruntext = new JTextField();
		uruntext.setBounds(112, 105, 116, 22);
		contentPane.add(uruntext);
		uruntext.setColumns(10);
		
		JButton ara = new JButton("ARA");
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
				}
				else  {
		
					urunListele(DAO.getInstance().urunOner());
					
				}
				label1.setText("Önerilen Ürün--->");
				//oneri_label.setText(urun2);
			  
				
			}

			

			
		});
		ara.setBounds(58, 152, 97, 25);
		contentPane.add(ara);
		
		JLabel lblNewLabel_2 = new JLabel("");
		
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/yeni.jpg")));
		lblNewLabel_2.setBounds(0, 0, 509, 630);
		contentPane.add(lblNewLabel_2);
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
