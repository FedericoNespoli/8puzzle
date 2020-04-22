import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class executeInterface {

	boolean type;
	int m[][];
	private JFrame frame;
	private JButton button00;
	private JButton button10;
	private JButton button20;
	private JButton button30;
	private JButton button01;
	private JButton button11;
	private JButton button21;
	private JButton button31;
	private JButton button02;
	private JButton button12;
	private JButton button22;
	private JButton button32;
	private JButton button03;
	private JButton button13;
	private JButton button23;
	private JButton button33;

	/**
	 * Launch the application.
	 */

	public executeInterface(int m[][], boolean i) 
	{
		this.m=m;
		type=i;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 728, 446);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JSplitPane splitPane = new JSplitPane();
		setSplit(splitPane);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(splitPane);
		
		JSplitPane splitPane_1 = new JSplitPane();
		setSplit(splitPane_1);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setResizeWeight(0.5);
		setSplit(splitPane_2);
		splitPane_1.setLeftComponent(splitPane_2);
		
		JSplitPane splitPane_3 = new JSplitPane();
		setSplit(splitPane_3);
		splitPane_2.setRightComponent(splitPane_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		splitPane_3.setRightComponent(panel_3);
		
		JPanel panel_4 = new JPanel();
		splitPane_3.setLeftComponent(panel_4);
		
		JSplitPane splitPane_4 = new JSplitPane();
		setSplit(splitPane_4);
		panel_4.add(splitPane_4);
		
		JSplitPane splitPane_5 = new JSplitPane();
		setSplit(splitPane_5);
		splitPane_4.setLeftComponent(splitPane_5);
		
		JSplitPane splitPane_7 = new JSplitPane();
		setSplit(splitPane_7);
		splitPane_7.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_5.setLeftComponent(splitPane_7);
		
		JSplitPane splitPane_8 = new JSplitPane();
		setSplit(splitPane_8);
		splitPane_8.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_7.setLeftComponent(splitPane_8);
		
		button00 = new JButton();
		setText( button00);
		button00.setText(String.valueOf(m[0][0]));
		//button00.setColumns(10);
		splitPane_8.setLeftComponent(button00);
		
		button10 = new JButton();
		//button10.setColumns(10);
		setText( button10);
		button10.setText(String.valueOf(m[1][0]));
		splitPane_8.setRightComponent(button10);
		
		JSplitPane splitPane_9 = new JSplitPane();
		setSplit(splitPane_9);
		splitPane_9.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_7.setRightComponent(splitPane_9);
		
		button20 = new JButton();
		setText( button20);
		button20.setText(String.valueOf(m[2][0]));
		//button20.setColumns(10);
		splitPane_9.setLeftComponent(button20);
		if(type)
		{
			button30 = new JButton();
			button30.setText(String.valueOf(m[3][0]));
			setText( button30);
			splitPane_9.setRightComponent(button30);
		}
		//button30.setColumns(10);
		
		
		JSplitPane splitPane_10 = new JSplitPane();
		setSplit(splitPane_10);
		splitPane_10.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_5.setRightComponent(splitPane_10);
		
		JSplitPane splitPane_12 = new JSplitPane();
		setSplit(splitPane_12);
		splitPane_12.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_10.setLeftComponent(splitPane_12);
		
		button01 = new JButton();
		button01.setText(String.valueOf(m[0][1]));
		setText( button01);
		//button01.setColumns(10);
		splitPane_12.setLeftComponent(button01);
		
		button11 = new JButton();
		button11.setText(String.valueOf(m[1][1]));
		setText( button11);
		//button11.setColumns(10);
		splitPane_12.setRightComponent(button11);
		
		JSplitPane splitPane_11 = new JSplitPane();
		setSplit(splitPane_11);
		splitPane_11.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_10.setRightComponent(splitPane_11);
		
		button21 = new JButton();
		button21.setText(String.valueOf(m[2][1]));
		setText( button21);
		//button21.setText("");
		//button21.setColumns(10);
		splitPane_11.setLeftComponent(button21);
		
		if(type)
		{
			button31 = new JButton();
			button31.setText(String.valueOf(m[3][1]));
			setText( button31);
			//button31.setColumns(10);
			splitPane_11.setRightComponent(button31);
		}
		
		JSplitPane splitPane_6 = new JSplitPane();
		setSplit(splitPane_6);
		splitPane_4.setRightComponent(splitPane_6);
		
		JSplitPane splitPane_13 = new JSplitPane();
		setSplit(splitPane_13);
		splitPane_13.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_6.setLeftComponent(splitPane_13);
		
		JSplitPane splitPane_15 = new JSplitPane();
		setSplit(splitPane_15);
		splitPane_15.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_13.setLeftComponent(splitPane_15);
		
		button02 = new JButton();
		button02.setText(String.valueOf(m[0][2]));
		setText( button02);
		//button02.setColumns(10);
		splitPane_15.setLeftComponent(button02);
		
		button12 = new JButton();
		button12.setText(String.valueOf(m[1][2]));
		setText( button12);
		//button12.setColumns(10);
		splitPane_15.setRightComponent(button12);
		
		JSplitPane splitPane_14 = new JSplitPane();
		setSplit(splitPane_14);
		splitPane_14.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_13.setRightComponent(splitPane_14);
		
		button22 = new JButton();
		button22.setText(String.valueOf(m[2][2]));
		setText( button22);
		//button22.setColumns(10);
		splitPane_14.setLeftComponent(button22);
		
		if(type)
		{
			button32 = new JButton();
			button32.setText(String.valueOf(m[3][2]));
			setText( button32);
			splitPane_14.setRightComponent(button32);
		}

		
		JSplitPane splitPane_16 = new JSplitPane();
		setSplit(splitPane_16);
		splitPane_16.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_6.setRightComponent(splitPane_16);
		
		JSplitPane splitPane_17 = new JSplitPane();
		setSplit(splitPane_17);
		splitPane_17.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_16.setLeftComponent(splitPane_17);
		
		if(type)
		{
			button03 = new JButton();
			button03.setText(String.valueOf(m[0][3]));
			setText( button03);
			splitPane_17.setLeftComponent(button03);
		}
		if(type)
		{
			button13 = new JButton();
			button13.setText(String.valueOf(m[1][3]));
			setText( button13);
			splitPane_17.setRightComponent(button13);
		}
		
		JSplitPane splitPane_18 = new JSplitPane();
		setSplit(splitPane_18);
		splitPane_18.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_16.setRightComponent(splitPane_18);
		
		if(type)
		{
			button23 = new JButton();
			button23.setText(String.valueOf(m[2][3]));
			setText( button23);
			splitPane_18.setLeftComponent(button23);
		}

		if(type)
		{
			button33 = new JButton();
			button33.setText(String.valueOf(m[3][3]));
			setText( button33);
			splitPane_18.setRightComponent(button33);
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		splitPane_2.setLeftComponent(panel_1);
		
		JSplitPane splitPane_19 = new JSplitPane();
		setSplit(splitPane_19);
		splitPane_19.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setRightComponent(splitPane_19);
		
		JSplitPane splitPane_20 = new JSplitPane();
		splitPane_20.setResizeWeight(0.1);
		setSplit(splitPane_20);
		splitPane_19.setRightComponent(splitPane_20);
		
		JSplitPane splitPane_21 = new JSplitPane();
		splitPane_21.setResizeWeight(0.8999999);
		setSplit(splitPane_21);
		splitPane_21.setBorder(null);
		splitPane_20.setRightComponent(splitPane_21);
		
		JPanel panel_7 = new JPanel();
		splitPane_21.setRightComponent(panel_7);
		
		JSplitPane splitPane_22 = new JSplitPane();
		splitPane_22.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_21.setLeftComponent(splitPane_22);
		
		JPanel panel_5 = new JPanel();
		splitPane_22.setRightComponent(panel_5);
		
		JTextArea textArea = new JTextArea();
		splitPane_22.setLeftComponent(textArea);
		
	    ButtonGroup group = new ButtonGroup();
		
		JPanel panel_6 = new JPanel();
		splitPane_20.setLeftComponent(panel_6);
		
		JPanel panel = new JPanel();
		splitPane_19.setLeftComponent(panel);
		
		JPanel panel_2 = new JPanel();
		splitPane.setLeftComponent(panel_2);
		ButtonGroup group2 = new ButtonGroup();
		frame.setVisible(true);
	}
	
	private void setSplit(JSplitPane a)
	{
		a.setDividerSize(0);
		a.setBorder(null);
	}
	private void setText(JButton a)
	{
		//a.setSize(2, 2);
		a.setBackground(Color.white);
		a.setPreferredSize(new Dimension(50, 50));
		//a.setBorder(null);
	}
}
