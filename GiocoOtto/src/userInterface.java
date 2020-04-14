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
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class userInterface {

	private JFrame frame;
	private JTextField textField00;
	private JTextField textField10;
	private JTextField textField20;
	private JTextField textField30;
	private JTextField textField01;
	private JTextField textField11;
	private JTextField textField21;
	private JTextField textField31;
	private JTextField textField02;
	private JTextField textField12;
	private JTextField textField22;
	private JTextField textField32;
	private JTextField textField03;
	private JTextField textField13;
	private JTextField textField23;
	private JTextField textField33;

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
		frame.setBounds(100, 100, 528, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(splitPane);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_1.setLeftComponent(splitPane_2);
		
		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_2.setRightComponent(splitPane_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		splitPane_3.setRightComponent(panel_3);
		
		JPanel panel_4 = new JPanel();
		splitPane_3.setLeftComponent(panel_4);
		
		JSplitPane splitPane_4 = new JSplitPane();
		panel_4.add(splitPane_4);
		
		JSplitPane splitPane_5 = new JSplitPane();
		splitPane_4.setLeftComponent(splitPane_5);
		
		JSplitPane splitPane_7 = new JSplitPane();
		splitPane_7.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_5.setLeftComponent(splitPane_7);
		
		JSplitPane splitPane_8 = new JSplitPane();
		splitPane_8.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_7.setLeftComponent(splitPane_8);
		
		textField00 = new JTextField();
		textField00.setColumns(10);
		splitPane_8.setLeftComponent(textField00);
		
		textField10 = new JTextField();
		textField10.setColumns(10);
		splitPane_8.setRightComponent(textField10);
		
		JSplitPane splitPane_9 = new JSplitPane();
		splitPane_9.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_7.setRightComponent(splitPane_9);
		
		textField20 = new JTextField();
		textField20.setColumns(10);
		splitPane_9.setLeftComponent(textField20);
		
		textField30 = new JTextField();
		textField30.setColumns(10);
		splitPane_9.setRightComponent(textField30);
		
		JSplitPane splitPane_10 = new JSplitPane();
		splitPane_10.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_5.setRightComponent(splitPane_10);
		
		JSplitPane splitPane_12 = new JSplitPane();
		splitPane_12.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_10.setLeftComponent(splitPane_12);
		
		textField01 = new JTextField();
		textField01.setText("");
		textField01.setColumns(10);
		splitPane_12.setLeftComponent(textField01);
		
		textField11 = new JTextField();
		textField11.setColumns(10);
		splitPane_12.setRightComponent(textField11);
		
		JSplitPane splitPane_11 = new JSplitPane();
		splitPane_11.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_10.setRightComponent(splitPane_11);
		
		textField21 = new JTextField();
		textField21.setText("");
		textField21.setColumns(10);
		splitPane_11.setLeftComponent(textField21);
		
		textField31 = new JTextField();
		textField31.setColumns(10);
		splitPane_11.setRightComponent(textField31);
		
		JSplitPane splitPane_6 = new JSplitPane();
		splitPane_4.setRightComponent(splitPane_6);
		
		JSplitPane splitPane_13 = new JSplitPane();
		splitPane_13.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_6.setLeftComponent(splitPane_13);
		
		JSplitPane splitPane_15 = new JSplitPane();
		splitPane_15.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_13.setLeftComponent(splitPane_15);
		
		textField02 = new JTextField();
		textField02.setColumns(10);
		splitPane_15.setLeftComponent(textField02);
		
		textField12 = new JTextField();
		textField12.setColumns(10);
		splitPane_15.setRightComponent(textField12);
		
		JSplitPane splitPane_14 = new JSplitPane();
		splitPane_14.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_13.setRightComponent(splitPane_14);
		
		textField22 = new JTextField();
		textField22.setColumns(10);
		splitPane_14.setLeftComponent(textField22);
		
		textField32 = new JTextField();
		textField32.setColumns(10);
		splitPane_14.setRightComponent(textField32);
		
		JSplitPane splitPane_16 = new JSplitPane();
		splitPane_16.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_6.setRightComponent(splitPane_16);
		
		JSplitPane splitPane_17 = new JSplitPane();
		splitPane_17.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_16.setLeftComponent(splitPane_17);
		
		textField03 = new JTextField();
		textField03.setColumns(10);
		splitPane_17.setLeftComponent(textField03);
		
		textField13 = new JTextField();
		textField13.setColumns(10);
		splitPane_17.setRightComponent(textField13);
		
		JSplitPane splitPane_18 = new JSplitPane();
		splitPane_18.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_16.setRightComponent(splitPane_18);
		
		textField23 = new JTextField();
		textField23.setColumns(10);
		splitPane_18.setLeftComponent(textField23);
		
		textField33 = new JTextField();
		textField33.setColumns(10);
		splitPane_18.setRightComponent(textField33);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		splitPane_2.setLeftComponent(panel_1);
		
		JSplitPane splitPane_19 = new JSplitPane();
		splitPane_19.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setRightComponent(splitPane_19);
		
		JSplitPane splitPane_20 = new JSplitPane();
		splitPane_19.setRightComponent(splitPane_20);
		
		JSplitPane splitPane_21 = new JSplitPane();
		splitPane_20.setRightComponent(splitPane_21);
		
		JPanel panel_5 = new JPanel();
		splitPane_21.setLeftComponent(panel_5);
		
		JPanel panel_7 = new JPanel();
		splitPane_21.setRightComponent(panel_7);
		
		JPanel panel_6 = new JPanel();
		splitPane_20.setLeftComponent(panel_6);
		
		JButton btnNewButton = new JButton("New button");
		panel_6.add(btnNewButton);
		
		JPanel panel = new JPanel();
		splitPane_19.setLeftComponent(panel);
		
		JPanel panel_2 = new JPanel();
		splitPane.setLeftComponent(panel_2);
	
	}

}
