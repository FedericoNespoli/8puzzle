import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
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
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

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
    JRadioButton rdbOtto;
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
		//rdbOtto.setSelected(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 525, 306);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		textField00 = new JTextField();
		setText( textField00);
		//textField00.setColumns(10);
		splitPane_8.setLeftComponent(textField00);
		
		textField10 = new JTextField();
		//textField10.setColumns(10);
		setText( textField10);
		splitPane_8.setRightComponent(textField10);
		
		JSplitPane splitPane_9 = new JSplitPane();
		setSplit(splitPane_9);
		splitPane_9.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_7.setRightComponent(splitPane_9);
		
		textField20 = new JTextField();
		setText( textField20);
		//textField20.setColumns(10);
		splitPane_9.setLeftComponent(textField20);
		
		textField30 = new JTextField();
		setText( textField30);
		//textField30.setColumns(10);
		splitPane_9.setRightComponent(textField30);
		
		JSplitPane splitPane_10 = new JSplitPane();
		setSplit(splitPane_10);
		splitPane_10.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_5.setRightComponent(splitPane_10);
		
		JSplitPane splitPane_12 = new JSplitPane();
		setSplit(splitPane_12);
		splitPane_12.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_10.setLeftComponent(splitPane_12);
		
		textField01 = new JTextField();
		setText( textField01);
		textField01.setText("");
		//textField01.setColumns(10);
		splitPane_12.setLeftComponent(textField01);
		
		textField11 = new JTextField();
		setText( textField11);
		//textField11.setColumns(10);
		splitPane_12.setRightComponent(textField11);
		
		JSplitPane splitPane_11 = new JSplitPane();
		setSplit(splitPane_11);
		splitPane_11.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_10.setRightComponent(splitPane_11);
		
		textField21 = new JTextField();
		//setText( textField21);
		//textField21.setText("");
		//textField21.setColumns(10);
		splitPane_11.setLeftComponent(textField21);
		
		textField31 = new JTextField();
		setText( textField31);
		//textField31.setColumns(10);
		splitPane_11.setRightComponent(textField31);
		
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
		
		textField02 = new JTextField();
		setText( textField02);
		//textField02.setColumns(10);
		splitPane_15.setLeftComponent(textField02);
		
		textField12 = new JTextField();
		setText( textField12);
		//textField12.setColumns(10);
		splitPane_15.setRightComponent(textField12);
		
		JSplitPane splitPane_14 = new JSplitPane();
		setSplit(splitPane_14);
		splitPane_14.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_13.setRightComponent(splitPane_14);
		
		textField22 = new JTextField();
		setText( textField22);
		//textField22.setColumns(10);
		splitPane_14.setLeftComponent(textField22);
		
		textField32 = new JTextField();
		setText( textField32);
		//textField32.setColumns(10);
		splitPane_14.setRightComponent(textField32);
		
		JSplitPane splitPane_16 = new JSplitPane();
		setSplit(splitPane_16);
		splitPane_16.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_6.setRightComponent(splitPane_16);
		
		JSplitPane splitPane_17 = new JSplitPane();
		setSplit(splitPane_17);
		splitPane_17.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_16.setLeftComponent(splitPane_17);
		
		textField03 = new JTextField();
		setText( textField03);
		//textField03.setColumns(10);
		splitPane_17.setLeftComponent(textField03);
		
		textField13 = new JTextField();
		setText( textField13);
		//textField13.setColumns(10);
		splitPane_17.setRightComponent(textField13);
		
		JSplitPane splitPane_18 = new JSplitPane();
		setSplit(splitPane_18);
		splitPane_18.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_16.setRightComponent(splitPane_18);
		
		textField23 = new JTextField();
		setText( textField23);
		//textField23.setColumns(10);
		splitPane_18.setLeftComponent(textField23);
		
		textField33 = new JTextField();
		setText( textField33);
		//textField33.setColumns(10);
		splitPane_18.setRightComponent(textField33);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		splitPane_2.setLeftComponent(panel_1);
		
		JSplitPane splitPane_19 = new JSplitPane();
		setSplit(splitPane_19);
		splitPane_19.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setRightComponent(splitPane_19);
		
		JSplitPane splitPane_20 = new JSplitPane();
		setSplit(splitPane_20);
		splitPane_19.setRightComponent(splitPane_20);
		
		JSplitPane splitPane_21 = new JSplitPane();
		splitPane_21.setResizeWeight(0.8);
		setSplit(splitPane_21);
		splitPane_21.setBorder(null);
		splitPane_20.setRightComponent(splitPane_21);
		
		JSplitPane splitPane_22 = new JSplitPane();
		splitPane_22.setResizeWeight(0.1);
		setSplit(splitPane_22);
		splitPane_22.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_21.setLeftComponent(splitPane_22);
		
		JPanel panel_5 = new JPanel();
		splitPane_22.setLeftComponent(panel_5);
		
		JRadioButton rdb1 = new JRadioButton("Ricerca in ampiezza");
		rdb1.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_5.add(rdb1);
		
		JRadioButton rdb2 = new JRadioButton("Ricerca in profondità");
		rdb2.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_5.add(rdb2);
		
		JRadioButton rdb6 = new JRadioButton("AStar Hamming");
		rdb6.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_5.add(rdb6);
		
		JPanel panel_8 = new JPanel();
		splitPane_22.setRightComponent(panel_8);
		
		JRadioButton rdb3 = new JRadioButton("AStar Manhattan");
		panel_8.add(rdb3);
		
		JRadioButton rdb4 = new JRadioButton("Ricerca bidirezionale");
		panel_8.add(rdb4);
		
	    JRadioButton rdb5 = new JRadioButton("Gioca");
	    panel_8.add(rdb5);
		
	    ButtonGroup group = new ButtonGroup();
	    group.add(rdb1);
	    group.add(rdb2);
	    group.add(rdb3);
	    group.add(rdb4);
	    group.add(rdb5);
	    group.add(rdb6);
	    

	    
		JSplitPane splitPane_23 = new JSplitPane();
		setSplit(splitPane_23);
		splitPane_23.setResizeWeight(0.3);
		splitPane_23.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_21.setRightComponent(splitPane_23);
		
		JPanel panel_7 = new JPanel();
		splitPane_23.setLeftComponent(panel_7);
		
		JPanel panel_9 = new JPanel();
		splitPane_23.setRightComponent(panel_9);
		
		JButton insertButton = new JButton("Submit");

		panel_9.add(insertButton);
		
		JPanel panel_6 = new JPanel();
		splitPane_20.setLeftComponent(panel_6);
		
		JPanel panel = new JPanel();
		splitPane_19.setLeftComponent(panel);
		
		JLabel istrLabel = new JLabel("Inserisci la composizione iniziale e seleziona il metodo risolutivo o gioca");
		istrLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel.add(istrLabel);
		
		JPanel panel_2 = new JPanel();
		splitPane.setLeftComponent(panel_2);
		
		//radio button 8 game
		rdbOtto = new JRadioButton("Gioco dell'8");
		panel_2.add(rdbOtto);
		rdbOtto.addActionListener(new ActionListener() 
		{
	        @Override
	        public void actionPerformed(ActionEvent e) 
	        {
	        	//System.out.println("premo8");
	        	textField03.setVisible(false);
	        	textField13.setVisible(false);
	        	textField23.setVisible(false);
	        	textField33.setVisible(false);
	        	textField30.setVisible(false);
	        	textField31.setVisible(false);
	        	textField32.setVisible(false);
	        	textField33.setVisible(false);

	        }
	    });
		//radio button 15 game
		JRadioButton rdbQuindici = new JRadioButton("Gioco del 15");
		rdbQuindici.setSelected(true);
		panel_2.add(rdbQuindici);
		rdbQuindici.addActionListener(new ActionListener() 
		{
	        @Override
	        public void actionPerformed(ActionEvent e) 
	        {
	        	//System.out.println("premo15");
	        	textField03.setVisible(true);
	        	textField13.setVisible(true);
	        	textField23.setVisible(true);
	        	textField33.setVisible(true);
	        	textField30.setVisible(true);
	        	textField31.setVisible(true);
	        	textField32.setVisible(true);
	        	textField33.setVisible(true);
	        }
	    });
		ButtonGroup group2 = new ButtonGroup();
	    group2.add(rdbOtto);
	    group2.add(rdbQuindici);
		insertButton.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		    	//passa valori a funzione selezionata
		        //System.out.println("premo");
		    	int m[][];
		    	boolean k=true;
		    	if(rdbQuindici.isSelected())
		    	{
		    		//System.out.println("15");
		    		m=new int[4][4];
		    		k=controlAll(true);
		    		if(k)
		    		{
		    			m[0][0]=Integer.parseInt(textField00.getText());
		    			m[0][1]=Integer.parseInt(textField01.getText());
			    		m[0][2]=Integer.parseInt(textField02.getText());
			    		m[0][3]=Integer.parseInt(textField03.getText());
			    		m[1][0]=Integer.parseInt(textField10.getText());
			    		m[1][1]=Integer.parseInt(textField11.getText());
			    		m[1][2]=Integer.parseInt(textField12.getText());
			    		m[1][3]=Integer.parseInt(textField13.getText());
			    		m[2][0]=Integer.parseInt(textField20.getText());
			    		m[2][1]=Integer.parseInt(textField21.getText());
			    		m[2][2]=Integer.parseInt(textField22.getText());
			    		m[2][3]=Integer.parseInt(textField23.getText());
			    		m[3][0]=Integer.parseInt(textField30.getText());
			    		m[3][1]=Integer.parseInt(textField31.getText());
			    		m[3][2]=Integer.parseInt(textField32.getText());
			    		m[3][3]=Integer.parseInt(textField33.getText());
		    		}
		    	}
		    	else
		    	{
		    		//System.out.println("8");
		    		m=new int[3][3];
		    		k=controlAll(false);
		    		if(k)
		    		{
		    			m[0][0]=Integer.parseInt(textField00.getText());
		    			m[0][1]=Integer.parseInt(textField01.getText());
			    		m[0][2]=Integer.parseInt(textField02.getText());
			    		m[1][0]=Integer.parseInt(textField10.getText());
			    		m[1][1]=Integer.parseInt(textField11.getText());
			    		m[1][2]=Integer.parseInt(textField12.getText());
			    		m[2][0]=Integer.parseInt(textField20.getText());
			    		m[2][1]=Integer.parseInt(textField21.getText());
			    		m[2][2]=Integer.parseInt(textField22.getText());
		    		}
		    	}
		    	if(k&&controlMatrix(m))
	    		{
		    		boolean type=true;
		    		otto esegui=new otto(m);
		    		String r[]= {"",""};
		    		executeInterface show;
		    		if(rdbOtto.isSelected())
		    			type=false;
		    		
	    			//passa valori a funzioni e scegli cosa fare in base ai focus
		    		if(rdb1.isSelected())//ampiezza
		    		{
		    			r=esegui.ampiezza();
		    			show= new executeInterface(m,type,1);
		    			System.out.println("prima di entrare"+ r[0] +"-" +r[1]);
		    			show.visualizza(r[0],r[1]);
		    		}
		    		else if(rdb2.isSelected())//profondità
		    		{
		    			r=esegui.profondità();
		    			show= new executeInterface(m,type,2);
		    			System.out.println("prima di entrare"+ r[0] +"-" +r[1]);
		    			show.visualizza(r[0],r[1]);
		    		}
		    		else if(rdb3.isSelected())//manhattan
		    		{
		    			r=esegui.Astar(1);
		    			show= new executeInterface(m,type,3);
		    			System.out.println("prima di entrare"+ r[0] +"-" +r[1]);
		    			show.visualizza(r[0],r[1]);
		    		}
		    		else if(rdb4.isSelected())//Bidirezionale
		    		{
		    			esegui.bidirezionale();
		    			show= new executeInterface(m,type,4);
		    		}
		    		else if(rdb5.isSelected())//gioca
		    		{
		    			show= new executeInterface(m,type,5);
		    		}
		    		else if(rdb6.isSelected())//Hamming
		    		{
		    			esegui.Astar(0);
		    			show= new executeInterface(m,type,6);
		    			System.out.println("prima di entrare"+ r[0] +"-" +r[1]);
		    			show.visualizza(r[0],r[1]);
		    		}
	    		}
	    		else
	    		{
	    			if(k&&!controlMatrix(m))
	    				JOptionPane.showMessageDialog(null, "Hai inserito valori più di una volta",null, JOptionPane.ERROR_MESSAGE);
	    		}
		    }
		});
	}
	
	private void setSplit(JSplitPane a)
	{
		a.setDividerSize(0);
		a.setBorder(null);
	}
	private void setText(JTextField a)
	{
		//a.setSize(2, 2);
		a.setColumns(4);
		//a.setBorder(null);
	}
	private boolean controlAll(boolean cond)
	{
		boolean k=true;
		if(cond)
		{
			k=controlText(textField00, true);
			if(k)
				k=controlText(textField01, true);
			if(k)
				k=controlText(textField02, true);
			if(k)
				k=controlText(textField10, true);
			if(k)
				k=controlText(textField11, true);
			if(k)
				k=controlText(textField12, true);
			if(k)
				k=controlText(textField20, true);
			if(k)
				k=controlText(textField21, true);
			if(k)
				k=controlText(textField22, true);
    		if(k)
    			k=controlText(textField03, true);
    		if(k)
    			k=controlText(textField13, true);
    		if(k)
    			k=controlText(textField23, true);
    		if(k)
    			k=controlText(textField30, true);
    		if(k)
    			k=controlText(textField31, true);
    		if(k)
    			k=controlText(textField32, true);
    		if(k)
    			k=controlText(textField33, true);
		}
		else
		{
			k=controlText(textField00, false);
			if(k)
				k=controlText(textField01, false);
			if(k)
				k=controlText(textField02, false);
			if(k)
				k=controlText(textField10, false);
			if(k)
				k=controlText(textField11, false);
			if(k)
				k=controlText(textField12, false);
			if(k)
				k=controlText(textField20, false);
			if(k)
				k=controlText(textField21, false);
			if(k)
				k=controlText(textField22, false);
		}

		return k;
	}
	//controlla valori inseriti
	private boolean controlText(JTextField a, boolean k)
	{
		int value=0;
		boolean res=true;
		try
		{
				value=Integer.parseInt(a.getText());

		}
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, "Devi inserire solo valori numerici",null, JOptionPane.ERROR_MESSAGE);
			res=false;
		}
		if(k==true && value>15 || value<0)
		{
			JOptionPane.showMessageDialog(null, "Devi inserire valori compresi tra 0 e 15 (0 o nulla per la cella vuota)",null, JOptionPane.ERROR_MESSAGE);
			res=false;
		}
		else
			if(k==false && value>8 || value<0)
			{
				JOptionPane.showMessageDialog(null, "Devi inserire valori compresi tra 0 e 8 (0 o nulla per la cella vuota)",null, JOptionPane.ERROR_MESSAGE);
				res=false;
			}
		return res;
	}
	private boolean controlMatrix(int m[][])
	{
		boolean k=true;
		//System.out.println(m.length);
		boolean num[]=new boolean [m.length*m.length];
		for(int i=0;i<m.length&&k==true;i++)
			for(int j=0;j<m.length&&k==true;j++)
			{
				if(num[m[i][j]]==false)
					num[m[i][j]]=true;
				else	
					k=false;
				//System.out.println(m[i][j]);
			}
		return k;
	}
}
