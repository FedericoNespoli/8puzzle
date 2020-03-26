import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;

public class userInterface {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userInterface window = new userInterface();
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
	public userInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JButton button1 = new JButton("New button");
		GridBagConstraints gbc_button1 = new GridBagConstraints();
		gbc_button1.insets = new Insets(0, 0, 5, 5);
		gbc_button1.gridx = 4;
		gbc_button1.gridy = 4;
		frame.getContentPane().add(button1, gbc_button1);
		
		JButton button2 = new JButton("New button");
		GridBagConstraints gbc_button2 = new GridBagConstraints();
		gbc_button2.insets = new Insets(0, 0, 5, 5);
		gbc_button2.gridx = 5;
		gbc_button2.gridy = 4;
		frame.getContentPane().add(button2, gbc_button2);
		
		JButton button3 = new JButton("New button");
		GridBagConstraints gbc_button3 = new GridBagConstraints();
		gbc_button3.insets = new Insets(0, 0, 5, 5);
		gbc_button3.gridx = 6;
		gbc_button3.gridy = 4;
		frame.getContentPane().add(button3, gbc_button3);
		
		JButton button4 = new JButton("New button");
		GridBagConstraints gbc_button4 = new GridBagConstraints();
		gbc_button4.insets = new Insets(0, 0, 5, 5);
		gbc_button4.gridx = 4;
		gbc_button4.gridy = 5;
		frame.getContentPane().add(button4, gbc_button4);
		
		JButton button5 = new JButton("New button");
		GridBagConstraints gbc_button5 = new GridBagConstraints();
		gbc_button5.insets = new Insets(0, 0, 5, 5);
		gbc_button5.gridx = 5;
		gbc_button5.gridy = 5;
		frame.getContentPane().add(button5, gbc_button5);
		
		JButton button6 = new JButton("New button");
		GridBagConstraints gbc_button6 = new GridBagConstraints();
		gbc_button6.insets = new Insets(0, 0, 5, 5);
		gbc_button6.gridx = 6;
		gbc_button6.gridy = 5;
		frame.getContentPane().add(button6, gbc_button6);
		
		JButton button7 = new JButton("New button");
		GridBagConstraints gbc_button7 = new GridBagConstraints();
		gbc_button7.insets = new Insets(0, 0, 0, 5);
		gbc_button7.gridx = 4;
		gbc_button7.gridy = 6;
		frame.getContentPane().add(button7, gbc_button7);
		
		JButton button8 = new JButton("New button");
		GridBagConstraints gbc_button8 = new GridBagConstraints();
		gbc_button8.insets = new Insets(0, 0, 0, 5);
		gbc_button8.gridx = 5;
		gbc_button8.gridy = 6;
		frame.getContentPane().add(button8, gbc_button8);
		
		JButton button9 = new JButton("New button");
		GridBagConstraints gbc_button9 = new GridBagConstraints();
		gbc_button9.insets = new Insets(0, 0, 0, 5);
		gbc_button9.gridx = 6;
		gbc_button9.gridy = 6;
		frame.getContentPane().add(button9, gbc_button9);
	
	}

}
