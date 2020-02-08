import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CeaserEncry {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static final String ALPHA ="abcdefghijklmnopqrstuvwxyz";
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CeaserEncry window = new CeaserEncry();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CeaserEncry() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.MAGENTA);
		frame.setBounds(100, 100, 640, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPlainText = new JLabel("Plain Text");
		lblPlainText.setBounds(45, 139, 76, 22);
		frame.getContentPane().add(lblPlainText);
		
		JLabel lblKey = new JLabel("Encrypted Key");
		lblKey.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKey.setBounds(10, 183, 102, 17);
		frame.getContentPane().add(lblKey);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			}
		});
		textField.setBounds(137, 140, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(137, 182, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnEncrpty = new JButton("Encrpty");
		btnEncrpty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String pt;
				String k;
				pt=textField.getText();
				k=textField_1.getText();
				int key=Integer.parseInt(k);
				String ct = encrypt(pt,key);
				textField_2.setText(ct);
				
				
				
			}
			public String encrypt(String pt,int key)
			{
				String ct="";
			for (int i = 0; i<pt.length(); i++)
			{
				int pos=ALPHA.indexOf(pt.charAt(i));

				int ck = (pos+key)%26;
				char ch = ALPHA.charAt(ck);
				ct = ct+ch;
			}
				return(ct);
			}
			
		});
		
		
		
		btnEncrpty.setBounds(137, 224, 89, 23);
		frame.getContentPane().add(btnEncrpty);
		
		textField_2 = new JTextField();
		textField_2.setBounds(140, 274, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCipherText = new JLabel("Cipher Text");
		lblCipherText.setBounds(45, 276, 76, 17);
		frame.getContentPane().add(lblCipherText);
		
		JLabel lblEncryption = new JLabel("Encryption");
		lblEncryption.setForeground(Color.YELLOW);
		lblEncryption.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEncryption.setBounds(97, 55, 102, 22);
		frame.getContentPane().add(lblEncryption);
		
		JLabel lblDecryption = new JLabel("Decryption");
		lblDecryption.setForeground(Color.YELLOW);
		lblDecryption.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDecryption.setBounds(376, 62, 102, 22);
		frame.getContentPane().add(lblDecryption);
		
		JLabel lblCipherText_1 = new JLabel("Cipher Text");
		lblCipherText_1.setBounds(330, 139, 76, 22);
		frame.getContentPane().add(lblCipherText_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(422, 140, 86, 20);
		frame.getContentPane().add(textField_3);
		
		JLabel lblDecryptKey = new JLabel("Decrypt Key");
		lblDecryptKey.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDecryptKey.setBounds(320, 181, 86, 22);
		frame.getContentPane().add(lblDecryptKey);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(422, 182, 86, 20);
		frame.getContentPane().add(textField_4);
		
		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ct;
				String k;
				ct=textField_3.getText();
				k=textField_4.getText();
				int key=Integer.parseInt(k);
				String pt = decrypt(ct,key);
				textField_5.setText(pt);
			}
			public String decrypt(String ct,int key)
			{
				String pt="";
			for (int i = 0; i<ct.length(); i++)
			{
				int pos=ALPHA.indexOf(ct.charAt(i));

				int ck = (pos-key)%26;
				char ch = ALPHA.charAt(ck);
				pt = pt+ch;
			}
				return(pt);
			}
		});
		btnDecrypt.setBounds(422, 224, 89, 23);
		frame.getContentPane().add(btnDecrypt);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(425, 274, 86, 20);
		frame.getContentPane().add(textField_5);
		
		JLabel lblPlaiinText = new JLabel("Plaiin Text");
		lblPlaiinText.setBounds(330, 276, 76, 17);
		frame.getContentPane().add(lblPlaiinText);
		
		JLabel lblCeaserCipher = new JLabel("Ceaser Cipher");
		lblCeaserCipher.setForeground(Color.YELLOW);
		lblCeaserCipher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCeaserCipher.setBounds(243, 21, 149, 22);
		frame.getContentPane().add(lblCeaserCipher);
	}

}
