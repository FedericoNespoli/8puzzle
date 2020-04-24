import java.util.ArrayList;
import java.util.List;

public class otto 
{
	private double inizio, fine;
	//scacchiere delle due dimensioni
	/*private int scacchiera8 [][]= new int [][] {{8,0,3},
												{4,1,2},
												{7,6,5}};*/
	private int [][] solution;
	
	private structNode node=new structNode();
	//analyzed items
	private List<structNode> openlist = new ArrayList<structNode>();

	private List<structNode> closedlist = new ArrayList<structNode>();
	
	//list of seen states
	
	
	otto(int m[][])
	{
		//manage the insertion of 4x4 or 3x3
		
		inizio = System.currentTimeMillis();
		node.assign(m);
		node.findZero();
		node.assignMov('S');
		openlist.add(node);
		System.out.println("inizializzo");
		if(node.mLength()==3)
			solution= new int[][] {{1,2,3},{4,5,6},{7,8,0}};
		if(node.mLength()==4)
			solution= new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
	}
	
	//------------------------------------------------------------------------------------------------------------
	//solve the 8 puzzle with breadth search
	public String[] ampiezza()
	{
		System.out.println("ampiezza");
		boolean goal=false;
		String r[]= {"",""};
		structNode structGoal=new structNode();
		structNode copy;
		structNode app=node.clone();
		int k=0;
			while(!openlist.isEmpty()&&!goal)
			{
				//DOWN
				if(app.returnx()!=app.mLength()-1 && app.printMov().charAt(app.printMov().length()-1)!='U')
				{
					copy=app.clone();
					copy.zeroDown(true);					
					openlist.add(copy);
					if(copy.isGoal(solution))
					{
						goal=true;
						structGoal=copy;
					}
				}
				//UP
				if(app.returnx()!=0 && app.printMov().charAt(app.printMov().length()-1)!='D')
				{
					copy=app.clone();
					copy.zeroUp(true);
					openlist.add(copy);
					if(copy.isGoal(solution))
					{
						goal=true;
						structGoal=copy;
					}
				}
				//RIGHT
				if(app.returny()!=app.mLength()-1 && app.printMov().charAt(app.printMov().length()-1)!='L')
				{
					copy=app.clone();
					copy.zeroRight(true);
					openlist.add(copy);
					if(copy.isGoal(solution))
					{
						goal=true;
						structGoal=copy;
					}
				}
				//LEFT
				if(app.returny()!=0 && app.printMov().charAt(app.printMov().length()-1)!='R')
				{
					copy=app.clone();
					copy.zeroLeft(true);
					openlist.add(copy);
					if(copy.isGoal(solution))
					{
						goal=true;
						structGoal=copy;
					}
				}
				if(!openlist.isEmpty())
				{
					openlist.remove(0);
					app=openlist.get(0).clone();
				}
				k++;
			}
			r[0]=structGoal.printMov();
			r[1] = getPath(structGoal,k) + node.print();
			System.out.println("fine ampiezza"+ r[0] +"-" +r[1]);
			return r;

	}
	
	//------------------------------------------------------------------------------------------------------------
	//solve the 8 puzzle with depth search
	public void profondità()
	{

		
	}
	
	//-------------------------------------------------------------------------------------------------------------
	//solve the 8 puzzle with bidirectional search
	public void bidirezionale()
	{
		
		
	}
	
	
	//--------------------------------------------------------------------------------------------------------------
	//solve the 8 puzzle with the Astar algoritm
	//the used euristic is: count the wrong cells doing a movement
	//if type is 0 Astar use hammingDistance and if type is 1, Astar use Manhattan distance
	public void Astar(int type)
	{
		boolean goal=false;
		int min=100,i,lvl=0,remove=0;
		structNode structGoal=new structNode();
		structNode copy;
		structNode app=node.clone();
		int size=openlist.size();
		//openlist.add(app);
		int k=0;
		if(app.isGoal(solution))
		{
			System.out.println("Soluzione trovata in 0 passi: \n");
		    app.print();
		}
		else
			{
				while(!goal)
				//while(k<5)
				{
					i=0;
					//app.print();
					min=99999;
					while(i<openlist.size())
					{
						
						if(openlist.get(i).getCost()<=min)
						{
							app=openlist.get(i).clone();
							if(!closedlist.contains(app))
							{
								min=app.getCost();
								lvl=app.getLevel();
								remove=i;
							}
						}
						i++;
					}
					//app.print();
					//System.out.println("\n\n\n\n\n\n");
					openlist.remove(remove);
					if(app.returnx()!=0 && app.printMov().charAt(app.printMov().length()-1)!='D')
					{
						copy=app.clone();
						copy.zeroUp(true);
						copy.setLevel(lvl+1);
						if(type==0)
							copy.setCost(hammingDistance(copy)+copy.getLevel());
						else
							copy.setCost(manhattanDistance(copy)+copy.getLevel());
						//copy.print();
						if(!contain(copy,openlist) && !contain(copy,closedlist))
						{
							openlist.add(copy);
							if(copy.isGoal(solution))
							{
								goal=true;
								structGoal=copy;
							}
						}
					}
					if(app.returnx()!=app.mLength()-1 && app.printMov().charAt(app.printMov().length()-1)!='U')
					{
						copy=app.clone();
						copy.zeroDown(true);
						copy.setLevel(lvl+1);
						if(type==0)
							copy.setCost(hammingDistance(copy)+copy.getLevel());
						else
							copy.setCost(manhattanDistance(copy)+copy.getLevel());
						//copy.print();
						if(!contain(copy,openlist) && !contain(copy,closedlist))
						{
							openlist.add(copy);
							if(copy.isGoal(solution))
							{
								goal=true;
								structGoal=copy;
							}
						}
					}
					
					if(app.returny()!=app.mLength()-1 && app.printMov().charAt(app.printMov().length()-1)!='L')
					{
						copy=app.clone();
						copy.zeroRight(true);
						copy.setLevel(lvl+1);
						if(type==0)
							copy.setCost(hammingDistance(copy)+copy.getLevel());
						else
							copy.setCost(manhattanDistance(copy)+copy.getLevel());
						//copy.print();
						if(!contain(copy,openlist) && !contain(copy,closedlist))
						{
							openlist.add(copy);
							if(copy.isGoal(solution))
							{
								goal=true;
								structGoal=copy;
							}
						}
					}
					
					if(app.returny()!=0 && app.printMov().charAt(app.printMov().length()-1)!='R')
					{
						copy=app.clone();
						copy.zeroLeft(true);
						copy.setLevel(lvl+1);
						if(type==0)
							copy.setCost(hammingDistance(copy)+copy.getLevel());
						else
							copy.setCost(manhattanDistance(copy)+copy.getLevel());
						//copy.print();
						if(!contain(copy,openlist) && !contain(copy,closedlist))
						{
							openlist.add(copy);
							if(copy.isGoal(solution))
							{
								goal=true;
								structGoal=copy;
							}
						}
					}
					closedlist.add(app);
					//System.out.println(k++);
					k++;
				}
				
				getPath(structGoal,k);
			}
	}
	
	//-------------------------------------------------------------------------
	//
	//void that print the final output
	private String getPath(structNode app, int i) 
	{
		int k=1;
		String path="";
	    fine = System.currentTimeMillis()-inizio;
		fine=fine/1000;

		path=path + "Execution time: " + fine + "\n";
		path=path + "Number of expanded nodes: " + i +"\n";
		path=path + "Risultato finale:\n\n";
		path=path + app.print();
		while(app.printMov().length()-k>=0 && app!=null)
		{
			switch (app.printMov().charAt(app.printMov().length()-k))
			{
			case 'U':
				app.zeroDown(false);
				path=path + app.print();
				break;
			case 'D':
				app.zeroUp(false);
				path=path + app.print();
				break;
			case 'R':
				app.zeroLeft(false);
				path=path + app.print();
				break;
			case 'L':
				app.zeroRight(false);
				path=path + app.print();
				break;
			case 'S':
				path=path +"Start Node:\n";
				break;
			}
			k++;
		}
		return path;
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
	
	//calculate Hamming distance from node to solution
	public int hammingDistance(structNode n)
	{
		int cost=0;
		for(int i=0;i<n.mLength();i++)
			for(int j=0;j<n.mLength();j++)
				if(solution[i][j]!=n.returnElementByCoord(i, j))
					cost++;
		return cost;
	}
	
	//calculate Manhattan distance from node to solution
	public int manhattanDistance(structNode n)
	{
		int cost=0;
		int pos[]=new int[2];
		for(int i=0;i<n.mLength();i++)
			for(int j=0;j<n.mLength();j++)
				if(solution[i][j]!=n.returnElementByCoord(i, j))
				{
					pos=n.returnPosition(solution[i][j]);
					cost+=Math.abs(i-pos[0])+Math.abs(j-pos[1]);
				}
		return cost;
	}
	
/*	// A utility function to count 
	// inversions in given array 'arr[]' 
	static int getInvCount(int[][] arr) 
	{ 
	    int inv_count = 0; 
	    for (int i = 0; i < arr.length - 1; i++) 
	        for (int j = i + 1; j < arr.length; j++) 
	          
	            // Value 0 is used for empty space 
	            if (arr[j][i] > 0 && 
	                            arr[j][i] > arr[i][j]) 
	                inv_count++; 
	    return inv_count; 
	} 
	  
	// This function returns true 
	// if given 8 puzzle is solvable. 
	static boolean isSolvable(int[][] puzzle) 
	{ 
	    // Count inversions in given 8 puzzle 
	    int invCount = getInvCount(puzzle); 
	  
	    // return true if inversion count is even. 
	    return (invCount % 2 == 0); 
	} */

}
/*		for(int i=0;i<scacchiera8[0].length;i++)
			for(int j=0;j<scacchiera8[1].length;j++)
				System.out.println(node.m[i][j]);*/
//System.out.println(solve[0][0]);
//System.out.println(goal());