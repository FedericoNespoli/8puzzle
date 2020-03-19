import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class otto 
{
	//scacchiere delle due dimensioni
	private int scacchiera8 [][]= new int [][]{{1,3,2},
											   {4,0,5},
											   {6,7,8}};
	private int [][] solution;
	
	structNode node=new structNode();
	
	//path to the solution
	private Stack <structNode> path;
	
	//list that contains analyzed nodes
	private List<structNode> closedList = new ArrayList<structNode>();
	
	//list that contains node that have to be analyzed
	private List<structNode> openList = new ArrayList<structNode>();
	
	//private int scacchiera15 [][]=new int [4][4];
	
	//list of seen states
	
	
	otto()
	{
		//gestione creazione matrice e selezione tabella
		//eliminerò poi scacchiera 8 e la sostituirò con il vettore in input
		node.assign(scacchiera8);
		node.findZero();
		node.parent=null;
		openList.add(node);
		if(node.m.length==3)
			solution= new int[][] {{1,2,3},{4,5,6},{7,8,0}};
		if(node.m.length==4)
			solution= new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
	}
	
	
	//solve the 8 puzzle with breadth search
	public structNode ampiezza()
	{
		boolean goal=false,first=true;
		structNode structGoal=new structNode();
		structNode copy;
		structNode app=node.clone();
		//loop
		int k=0;
		
		while(!openList.isEmpty()&&!goal)
		{
			if(app.x!=2 && (first||app.parent.x!=app.x+1))
			{
				copy=app.clone();
				copy.parent=app;
				copy.zeroDown();					
				if(!contain(copy,closedList)&&!contain(copy,openList))
					openList.add(copy);
				if(copy.isGoal(solution))
				{
					goal=true;
					return copy;
				}
			}
			
			if(app.x!=0 && (first||app.parent.x!=app.x-1))
			{
				copy=app.clone();
				copy.parent=app;
				copy.zeroUp();
				if(!contain(copy,closedList)&&!contain(copy,openList))
					openList.add(copy);
				if(copy.isGoal(solution))
				{
					goal=true;
					return copy;
				}
			}
			
			if(app.y!=2 && (first||app.parent.y!=app.y+1))
			{
				copy=app.clone();
				copy.parent=app;
				copy.zeroRight();
				if(!contain(copy,closedList)&&!contain(copy,openList))
					openList.add(copy);
				if(copy.isGoal(solution))
				{
					goal=true;
					return copy;
				}
			}
			
			if(app.y!=0 && (first||app.parent.y!=app.y-1))
			{
				copy=app.clone();
				copy.parent=app;
				copy.zeroLeft();
				if(!contain(copy,closedList)&&!contain(copy,openList))
					openList.add(copy);
				if(copy.isGoal(solution))
				{
					goal=true;
					return copy;
				}
			}
			//first=false;
			closedList.add(app.clone());
			if(!openList.isEmpty())
			{
				openList.remove(0);
				app=openList.get(0).clone();
				while(contain(app,closedList))
				{
					openList.remove(0);
					app=openList.get(0).clone();
				}
			}
			System.out.println(k++);
		}		
		return structGoal;
	}
	
	//solve the 8 puzzle with depth search
	public void profondità()
	{

		
	}
	

	//solve the 8 puzzle with bidirectional search
	public void bidirezionale()
	{
		
		
	}
	
	//solve the 8 puzzle with the Astar algoritm
	//the used euristic is: count the wrong cells doing a movement
	public void Astar()
	{
		
	}
	
	//---------------------------------------------------
	private void getPath(structNode app) 
	{
		int k=0;
		while(app.parent!=null&&app!=null)
		{
			app=app.parent;
			System.out.print(k++);
		}
		System.out.println("ciao");
		for(int i=0;i<scacchiera8[0].length;i++)
		for(int j=0;j<scacchiera8[1].length;j++)
			System.out.println(app.m[i][j]);
	}
	public boolean contain(structNode n, List<structNode> list)
	{
		//devo riuscire a controllare le MATRICI(non elementi, poichè potrebbero avere un diverso padre
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