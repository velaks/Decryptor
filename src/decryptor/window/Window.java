package decryptor.window;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class Window extends JPanel {
	JButton analysis, decryption, clear;
	private JTextArea f;
	private JTextArea r;
	GridBagConstraints gbc = new GridBagConstraints();
	
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
		
		//simpler
		analysis = new JButton("Analysis");
		add(analysis, new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 
				0, 0));
		
		decryption = new JButton("Decryption");
		add(decryption, new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 
				0, 0));
		
		clear = new JButton("Clear");
		add(clear, new GridBagConstraints(2, 10, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 
				0, 0));
		
		
		
	}
	
	public void setDisplayValue(String val) {
		f.setText(val);
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
		jf.add(w);
		jf.setLocationRelativeTo(null);
		jf.setSize(800, 700);
		jf.setResizable(false);
		jf.setVisible(true);
		jf.pack();
		
		
	}
}

