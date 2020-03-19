import java.util.ArrayList;
import java.util.List;

public class otto 
{
	double inizio, fine;
	//scacchiere delle due dimensioni
	private int scacchiera8 [][]= new int [][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{0,13,14,15}};
	private int [][] solution;
	
	structNode node=new structNode();
	//analyzed items
	private List<structNode> openList = new ArrayList<structNode>();

	//private int scacchiera15 [][]=new int [4][4];
	
	//list of seen states
	
	
	otto()
	{
		//manage the insertion of 4x4 or 3x3
		
		inizio = System.currentTimeMillis();
		node.assign(scacchiera8);
		node.findZero();
		node.assignMov('S');
		openList.add(node);
		if(node.m.length==3)
			solution= new int[][] {{1,2,3},{4,5,6},{7,8,0}};
		if(node.m.length==4)
			solution= new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
	}
	
	//----------------------------------------------------------------------------------------------
	//solve the 8 puzzle with breadth search
	public structNode ampiezza()
	{
		boolean goal=false;
		structNode structGoal=new structNode();
		structNode copy;
		structNode app=node.clone();
		int k=0;
		
		while(!openList.isEmpty()&&!goal)
		{
			if(app.x!=app.mLenght()-1 && app.mov.charAt(app.printMov().length()-1)!='U')
			{
				copy=app.clone();
				copy.zeroDown(true);					
				openList.add(copy);
				if(copy.isGoal(solution))
				{
					goal=true;
					structGoal=copy;
				}
			}
			
			if(app.x!=0 && app.mov.charAt(app.printMov().length()-1)!='D')
			{
				copy=app.clone();
				copy.zeroUp(true);
				openList.add(copy);
				if(copy.isGoal(solution))
				{
					goal=true;
					structGoal=copy;
				}
			}
			
			if(app.y!=app.mLenght()-1 && app.mov.charAt(app.printMov().length()-1)!='L')
			{
				copy=app.clone();
				copy.zeroRight(true);
				openList.add(copy);
				if(copy.isGoal(solution))
				{
					goal=true;
					structGoal=copy;
				}
			}
			
			if(app.y!=0 && app.mov.charAt(app.printMov().length()-1)!='R')
			{
				copy=app.clone();
				copy.zeroLeft(true);
				openList.add(copy);
				if(copy.isGoal(solution))
				{
					goal=true;
					structGoal=copy;
				}
			}
			if(!openList.isEmpty())
			{
				openList.remove(0);
				app=openList.get(0).clone();
			}
			k++;
		}
		
		getPath(structGoal,k);
		return structGoal;
	}
	
	//-------------------------------------------------------------------------
	//solve the 8 puzzle with depth search
	public void profondità()
	{

		
	}
	
	//-------------------------------------------------------------------------
	//solve the 8 puzzle with bidirectional search
	public void bidirezionale()
	{
		
		
	}
	
	
	//-------------------------------------------------------------------------
	//solve the 8 puzzle with the Astar algoritm
	//the used euristic is: count the wrong cells doing a movement
	public void Astar()
	{
		
	}
	
	//-------------------------------------------------------------------------
	//void that print the final output
	private void getPath(structNode app, int i) 
	{
		int k=1;
	    fine = System.currentTimeMillis()-inizio;
		fine=fine/1000;
		System.out.println("Execution time: " + fine);
		System.out.println("Number of expanded nodes: " + i);
		
		System.out.println("Risultato finale:\n");
		
		app.print();
		while(app.printMov().length()-k!=-1 && app!=null)
		{
			switch (app.printMov().charAt(app.printMov().length()-k))
			{
			case 'U':
				app.zeroDown(false);
				app.print();
				break;
			case 'D':
				app.zeroUp(false);
				app.print();
				break;
			case 'R':
				app.zeroLeft(false);
				app.print();
				break;
			case 'L':
				app.zeroRight(false);
				app.print();
				break;
			case 'S':
				System.out.println("Start Node:\n");
				break;
			}
			k++;
		}
	}
	
	//function that return true if find a node in a list
	public boolean contain(structNode n, List<structNode> list)
	{
		int i=0;
		boolean found=false;
		while(i<list.size() && !found)
		{
			if(list.get(i).isSame(n))
			{
				found=true;
			}
			i++;
		}

		return found;
	}
	public void generateChildren(structNode n)
	{

	}

}
/*		for(int i=0;i<scacchiera8[0].length;i++)
			for(int j=0;j<scacchiera8[1].length;j++)
				System.out.println(node.m[i][j]);*/
//System.out.println(solve[0][0]);
//System.out.println(goal());