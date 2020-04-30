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
import java.util.Date;

import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class executeInterface {

	//type is false when 8 game
	private boolean type;
	private int soluzione[][];
	private int m[][];
	private int method;
	private int mosse=0;
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
	private JTextArea textArea;
	JScrollPane scroll;
	/**
	 * Launch the application.
	 */

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int[][] k=new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};//{{8,0,3},{4,1,2},{7,6,5}};
					executeInterface window = new executeInterface(k,true,1);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}*/
	
	public executeInterface(int m[][], boolean i, int method) 
	{
		this.m=m;
		type=i;
		this.method=method;
		if(type)
			soluzione= new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
		else
			soluzione= new int[][] {{1,2,3},{4,5,6},{7,8,0}};	
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 798, 536);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		switch(method)
		{
		case 1:
			frame.setTitle("Ricerca in ampiezza");
			break;
		case 2:
			frame.setTitle("Ricerca in profondità");
			break;
		case 3:
			frame.setTitle("AStar con distanza di Manhattan");
			break;
		case 4:
			frame.setTitle("Ricerca bidirezionale");
			break;
		case 5:
			frame.setTitle("Gioca");
			break;
		case 6:
			frame.setTitle("AStar con distanza di Hamming");
			break;
		}

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
		setButton( button00);
		button00.setText(String.valueOf(m[0][0]));
		splitPane_8.setLeftComponent(button00);
		
		
		button10 = new JButton();
		setButton( button10);
		button10.setText(String.valueOf(m[1][0]));
		splitPane_8.setRightComponent(button10);
		
		JSplitPane splitPane_9 = new JSplitPane();
		setSplit(splitPane_9);
		splitPane_9.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_7.setRightComponent(splitPane_9);
		
		button20 = new JButton();
		setButton( button20);
		button20.setText(String.valueOf(m[2][0]));
		splitPane_9.setLeftComponent(button20);

		button30 = new JButton();
		splitPane_9.setRightComponent(button30);
		if(!type)
		{
			button30.setBorder(null);
			button30.setText("");
			button30.setEnabled(false);
		}
		else
		{
			setButton( button30);
			button30.setText(String.valueOf(m[3][0]));
		}
		
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
		setButton( button01);
		splitPane_12.setLeftComponent(button01);
		
		button11 = new JButton();
		button11.setText(String.valueOf(m[1][1]));
		setButton( button11);
		splitPane_12.setRightComponent(button11);
		
		JSplitPane splitPane_11 = new JSplitPane();
		setSplit(splitPane_11);
		splitPane_11.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_10.setRightComponent(splitPane_11);
		
		button21 = new JButton();
		button21.setText(String.valueOf(m[2][1]));
		setButton( button21);
		splitPane_11.setLeftComponent(button21);
		
		button31 = new JButton();
		splitPane_11.setRightComponent(button31);
		if(!type)
		{
			button31.setBorder(null);
			button31.setText("");
			button31.setEnabled(false);
		}
		else
		{
			setButton( button31);
			button31.setText(String.valueOf(m[3][1]));
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
		setButton( button02);
		splitPane_15.setLeftComponent(button02);
		
		button12 = new JButton();
		button12.setText(String.valueOf(m[1][2]));
		setButton( button12);
		splitPane_15.setRightComponent(button12);
		
		JSplitPane splitPane_14 = new JSplitPane();
		setSplit(splitPane_14);
		splitPane_14.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_13.setRightComponent(splitPane_14);
		
		button22 = new JButton();
		button22.setText(String.valueOf(m[2][2]));
		setButton( button22);
		splitPane_14.setLeftComponent(button22);

		button32 = new JButton();
		splitPane_14.setRightComponent(button32);
		if(!type)
		{
			button32.setBorder(null);
			button32.setText("");
			button32.setEnabled(false);
		}
		else
		{
			setButton( button32);
			button32.setText(String.valueOf(m[3][2]));
		}

		
		JSplitPane splitPane_16 = new JSplitPane();
		setSplit(splitPane_16);
		splitPane_16.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_6.setRightComponent(splitPane_16);
		
		JSplitPane splitPane_17 = new JSplitPane();
		setSplit(splitPane_17);
		splitPane_17.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_16.setLeftComponent(splitPane_17);
		
		
		button03 = new JButton();
		splitPane_17.setLeftComponent(button03);
		if(!type)
		{
			button03.setBorder(null);
			button03.setText("");
			button03.setEnabled(false);
		}
		else
		{
			setButton( button03);
			button03.setText(String.valueOf(m[0][3]));
		}

		button13 = new JButton();
		splitPane_17.setRightComponent(button13);
		if(!type)
		{
			button13.setBorder(null);
			button13.setText("");
			button13.setEnabled(false);
		}
		else
		{
			setButton( button13);
			button13.setText(String.valueOf(m[1][3]));
		}
		
		JSplitPane splitPane_18 = new JSplitPane();
		setSplit(splitPane_18);
		splitPane_18.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_16.setRightComponent(splitPane_18);
		

		button23 = new JButton();
		splitPane_18.setLeftComponent(button23);
		if(!type)
		{
			button23.setBorder(null);
			button23.setText("");
			button23.setEnabled(false);
		}
		else
		{
			setButton( button23);
			button23.setText(String.valueOf(m[2][3]));
		}

			button33 = new JButton();
			splitPane_18.setRightComponent(button33);		
		if(!type)
		{
			button33.setBorder(null);
			button33.setText("");
			button33.setEnabled(false);
		}
		else
		{
			setButton( button33);
			button33.setText(String.valueOf(m[3][3]));
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
		setSplit(splitPane_22);
		splitPane_22.setResizeWeight(0.9);
		splitPane_22.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_21.setLeftComponent(splitPane_22);
		
		JPanel panel_5 = new JPanel();
		splitPane_22.setRightComponent(panel_5);
		
		


		textArea = new JTextArea();
		 scroll = new JScrollPane (textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		splitPane_22.setLeftComponent(scroll);
		if(method!=5)
		{
			splitPane_1.setResizeWeight(0.001);
			splitPane_19.setResizeWeight(0.001);
		}
		else
		{
			splitPane_1.setResizeWeight(0.9);
			splitPane_19.setResizeWeight(0.9);
		}
		
		JPanel panel_6 = new JPanel();
		splitPane_20.setLeftComponent(panel_6);
		
		JPanel panel = new JPanel();
		splitPane_19.setLeftComponent(panel);
		
		JPanel panel_2 = new JPanel();
		splitPane.setLeftComponent(panel_2);
		if(method!=5)
			setVis(false);
		else 
		{
			textArea.setVisible(false);
			scroll.setVisible(false);
		}
		frame.setVisible(true);
		
		
		button00.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		    	gioca(0,0);
		    }
		});
		button01.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		    	gioca(0,1);
		    }
		});
		button02.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		    	gioca(0,2);
		    }
		});
		button03.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		    	gioca(0,3);
		    }
		});
		button10.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		    	gioca(1,0);
		    }
		});
		button11.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		    	gioca(1,1);
		    }
		});
		button12.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		    	gioca(1,2);
		    }
		});
		button13.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		    	gioca(1,3);
		    }
		});
		button20.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		    	gioca(2,0);
		    }
		});
		button21.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		    	gioca(2,1);
		    }
		});
		button22.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		    	gioca(2,2);
		    }
		});
		button23.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		    	gioca(2,3);
		    }
		});
		button30.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		    	gioca(3,0);
		    }
		});
		button31.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		    	gioca(3,1);
		    }
		});
		button32.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		    	gioca(3,2);
		    }
		});
		button33.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		    	gioca(3,3);
		    }
		});
	}
	
	private void setVis(boolean b) 
	{
		button00.setVisible(b);
		button10.setVisible(b);
		button20.setVisible(b);
		button30.setVisible(b);
		button01.setVisible(b);
		button11.setVisible(b);
		button21.setVisible(b);
		button31.setVisible(b);
		button02.setVisible(b);
		button12.setVisible(b);
		button22.setVisible(b);
		button32.setVisible(b);
		button03.setVisible(b);
		button13.setVisible(b);
		button23.setVisible(b);
		button33.setVisible(b);	
		button00.setText("");
		button10.setText("");
		button20.setText("");
		button30.setText("");
		button01.setText("");
		button11.setText("");
		button21.setText("");
		button31.setText("");
		button02.setText("");
		button12.setText("");
		button22.setText("");
		button32.setText("");
		button03.setText("");
		button13.setText("");
		button23.setText("");
		button33.setText("");	
	}

	//send text and moves to visualize the solution of algorithms
	public void visualizza(String mov, String stamp)
	{
		//System.out.println("prima di entrare"+ mov +"-" +stamp);
		textArea.setText(stamp);
		cmdSend(mov);
		textArea.setCaretPosition(0);
	}
	
	//send all the commands contained in the command string once every loop, to visualize them
	private void cmdSend(String s)
	{
		int i=0;
		char cmd;
		cmd=s.charAt(i);
		traduci(cmd);
	}
	
	//set split properties
	private void setSplit(JSplitPane a)
	{
		a.setDividerSize(0);
		a.setBorder(null);
	}
	//set the color and the dimension of game's button
	private void setButton(JButton a)
	{
		int b;
		if(method!=5)
			b=0;
		else
			b=100;
		a.setBackground(Color.white);
		a.setPreferredSize(new Dimension(b, b));
	}
	
	//make the user play the game
	private void gioca(int x, int y)
	{
		int pos_zero[]=findZero();
		boolean k=isGoal();
		//System.out.println("posizione zero["+pos_zero[0]+pos_zero[1]+"]");
		//System.out.println("posizione tasto["+x+","+y+"]");
		if(method==5 && (x!=pos_zero[0] || y!=pos_zero[1]))
		{
			if(x+1<m.length &&(x+1==pos_zero[0] && y==pos_zero[1]))
				traduci('U');
			else if(x-1>=0 &&(x-1==pos_zero[0] && y==pos_zero[1]))
				traduci('D');
			else if(y+1<m.length &&(x==pos_zero[0] && y+1==pos_zero[1]))
				traduci('L');
			else if(y-1>=0 &&(x==pos_zero[0] && y-1==pos_zero[1]))
				traduci('R');
			mosse++;
			if(!k && isGoal())
				JOptionPane.showMessageDialog(null, "Complimenti, hai vinto!!!!\n Il numero di mosse eseguite è di: "+mosse,null, JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//translate command into a move on the matrix
	private void traduci(char comando)
	{
		int pos_zero[]=findZero(),x,y;
		x=pos_zero[0];
		y=pos_zero[1];
		switch(comando)
		{
		case 'R':
			m[x][y]=m[x][y+1];
			m[x][y+1]=0;
		break;
		case 'L':
			m[x][y]=m[x][y-1];
			m[x][y-1]=0;
		break;
		case 'U':
			m[x][y]=m[x-1][y];
			m[x-1][y]=0;
		break;
		case 'D':
			m[x][y]=m[x+1][y];
			m[x+1][y]=0;
		break;
		default:;
		}
		riscrivi();
	}
	
	//find the zero element into the matrix
	private int[] findZero()
	{
		boolean k=false;
		int x[]=new int[2];
		for(int i=0;i<m[0].length && k==false;i++)
			for(int j=0;j<m[1].length && k==false;j++)
				if(m[i][j]==0)
				{
					k=true;
					x[0]=i;
					x[1]=j;
				}
		return x;
	}
	
	//update the UI with the content of the matrix m
	private void riscrivi()
	{
		button00.setText(String.valueOf(m[0][0]));
		button01.setText(String.valueOf(m[0][1]));
		button02.setText(String.valueOf(m[0][2]));
		button10.setText(String.valueOf(m[1][0]));
		button11.setText(String.valueOf(m[1][1]));
		button12.setText(String.valueOf(m[1][2]));
		button20.setText(String.valueOf(m[2][0]));
		button21.setText(String.valueOf(m[2][1]));
		button22.setText(String.valueOf(m[2][2]));
		if(type)
		{
			button03.setText(String.valueOf(m[0][3]));
			button13.setText(String.valueOf(m[1][3]));
			button23.setText(String.valueOf(m[2][3]));
			button30.setText(String.valueOf(m[3][0]));
			button31.setText(String.valueOf(m[3][1]));
			button32.setText(String.valueOf(m[3][2]));
			button33.setText(String.valueOf(m[3][3]));
		}
	}
	
	//tell if the goal is reached or not when play
	private boolean isGoal()
	{
		boolean k=true;
		for(int i=0;i<m.length && k!=false;i++)
			for(int j=0;j<m.length && k!=false;j++)
				if(soluzione[i][j]!=m[i][j])
					k=false;
		return k;
	}
	
}
