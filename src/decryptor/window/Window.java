package decryptor.window;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import decryptor.analysis.Frequency;
import decryptor.decrypt.Decrypt;

public class Window extends JPanel {
	JButton analysis, decryption, clear;
	private JTextArea f;
	private JTextArea r;
	GridBagConstraints gbc = new GridBagConstraints();
	HashMap<String, Integer> list = new HashMap<>();
	Frequency fr;
	Decrypt dec;
	
	public Window() {
		setLayout(new GridBagLayout());
		
		f = new JTextArea(20, 25);
		f.setLineWrap(true);
		f.setWrapStyleWord(true);
		f.setFont(new Font("Arial", Font.PLAIN, 12));
		JScrollPane scroll = new JScrollPane(f);
		gbc.gridx = 0; //coordinates
		gbc.gridy = 0; 
		gbc.gridwidth = 4; //blocks
		gbc.gridheight = 1; 
		gbc.weightx = 0.0; //resizable
		gbc.weighty = 0.0;
		gbc.anchor = GridBagConstraints.NORTH; //disposition
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 5, 5, 5); //top left bottom right
		gbc.ipadx = 0; //size
		gbc.ipady = 0;
		add(scroll, gbc);
		
		r = new JTextArea(20, 25);
		r.setLineWrap(true);
		r.setWrapStyleWord(true);
		r.setFont(new Font("Arial", Font.PLAIN, 12));
		JScrollPane rScroll = new JScrollPane(r);
		gbc.gridx = 6; //coordinates
		gbc.gridy = 0; 
		gbc.gridwidth = 2; //blocks
		gbc.gridheight = 1; 
		gbc.weightx = 0.0; //resizable
		gbc.weighty = 0.0;
		gbc.anchor = GridBagConstraints.NORTH; //disposition
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 5, 5, 5); //top left bottom right
		gbc.ipadx = 0; //size
		gbc.ipady = 0;
		add(rScroll, gbc);
		
		//shorter
		analysis = new JButton("Analysis");
		add(analysis, new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 
				0, 0));
		
		analysis.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String text = f.getText();
				fr = new Frequency(text);
				list = fr.count();
				String str = new String();
				for (Map.Entry entry : list.entrySet()) {
				   str += entry.getKey() + " = "+ entry.getValue() + "\n";
				}
				setDisplayValue(str);
			}	
		});
		
		decryption = new JButton("Decryption");
		add(decryption, new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 
				0, 0));
		
		decryption.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String cipher = f.getText();
				fr = new Frequency(cipher);
				HashMap<String, Integer> cipherList = fr.count();
				dec = new Decrypt(cipher, list, cipherList);
				String str = new String();
				
				setDisplayValue(str);
			}	
		});
		
		clear = new JButton("Clear");
		add(clear, new GridBagConstraints(2, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 
				0, 0));
		
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String clear = "";
				r.setText(clear);
				f.setText(clear);
			}
		});	
	}
	
	public void setDisplayValue(String str) {
		r.setText(str);
	}
	
	public String getDisplayValue(){
		return f.getText();
	}
	
	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		Window w = new Window();
		JFrame jf = new JFrame("Decryptor");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.add(w);
		jf.setSize(800, 700);
		jf.setResizable(false);
		jf.setVisible(true);
		jf.pack();	
	}
}

