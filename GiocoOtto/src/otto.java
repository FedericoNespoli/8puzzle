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
	//frontier
	private List<structNode> openlist = new ArrayList<structNode>();

	//openlist bidirezionale
	private List<structNode> openlist1 = new ArrayList<structNode>();
	
	//analized items
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
					openlist.add(copy);//add the element at the end of the list
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
	public String[] profondità()
	{
		System.out.println("profondità");
		boolean goal=false,op=false;
		String r[]= {"",""};
		structNode structGoal=new structNode();
		structNode copy;
		structNode app=node.clone();
		int k=0;
			while(!openlist.isEmpty()&&!goal)
			{
				op=false;
				//DOWN
				if(app.returnx()!=app.mLength()-1 && app.printMov().charAt(app.printMov().length()-1)!='U')
				{
					copy=app.clone();
					copy.zeroDown(true);
					if(!contain(copy,closedlist) && !contain(copy,openlist))
					{
						op=true;
						openlist.add(copy);
						if(copy.isGoal(solution))
						{
							goal=true;
							structGoal=copy;
						}
					}
				}//UP
				 if(app.returnx()!=0 && app.printMov().charAt(app.printMov().length()-1)!='D' )
					{
						copy=app.clone();
						copy.zeroUp(true);
						if(!contain(copy,closedlist) && !contain(copy,openlist))
						{
							if(!op)
							{
								openlist.add(copy);
								op=true;
							}
							if(copy.isGoal(solution))
							{
								goal=true;
								structGoal=copy;
							}
						}
					}//RIGHT
				 if(app.returny()!=app.mLength()-1 && app.printMov().charAt(app.printMov().length()-1)!='L')
				{
					copy=app.clone();
					copy.zeroRight(true);
					if(!contain(copy,closedlist) && !contain(copy,openlist))
					{
						if(!op)
						{
							openlist.add(copy);
							op=true;
						}
						if(copy.isGoal(solution))
						{
							goal=true;
							structGoal=copy;
						}
					}
				}//LEFT
				 if(!op && app.returny()!=0 && app.printMov().charAt(app.printMov().length()-1)!='R')
				{
					copy=app.clone();
					copy.zeroLeft(true);
					if(!contain(copy,closedlist) && !contain(copy,openlist))
					{
						if(!op)
						{
							op=true;
							openlist.add(copy);
						}
						if(copy.isGoal(solution))
						{
							goal=true;
							structGoal=copy;
						}
					}
				}
				if(!openlist.isEmpty())
				{
					//openlist.remove(0);
					if(!op)
					{
						closedlist.add(app);
						app=openlist.remove(openlist.size()-1);//non rimuove
					}
					else
						app=openlist.get(openlist.size()-1).clone();
				}
				k++;
				System.out.println(app.print());
			}
			r[0]=structGoal.printMov();
			r[1] = getPath(structGoal,k) + node.print();
			System.out.println("fine ampiezza"+ r[0] +"-" +r[1]);
			return r;
		
	}
	
	//-------------------------------------------------------------------------------------------------------------
	//solve the 8 puzzle with bidirectional search
	public String[] bidirezionale()
	{
		System.out.println("Bidirezionale");
		boolean goal=false;
		String r[]= {"",""};
		String appoggio;
		structNode structGoal=new structNode();
		structNode copy;
		structNode app=node.clone();
		
		structNode app1= new structNode();
		app1.assign(solution);
		app1.findZero();
		app1.assignMov('S');
		openlist1.add(app1);
		int k=0;
		//devo partire dalla situazione iniziale e dalla soluzione
		//controlli devo cambiarli. non controllare più se trovano la soluzione ma se si congiungono con la frontiera 2
			while(!openlist.isEmpty()&&!goal)
			{
				//1 - DOWN-------------------------------------------------------------------------------
				if(app.returnx()!=app.mLength()-1 && app.printMov().charAt(app.printMov().length()-1)!='U')
				{
					copy=app.clone();
					copy.zeroDown(true);					
					openlist.add(copy);//add the element at the end of the list
					if(contain(copy,openlist1))
					{
						
						goal=true;
						int j=retIndex(copy,openlist1);
						structGoal=copy;
						appoggio=openlist1.get(j).printMov();
						appoggio=inverti(appoggio);
						structGoal.assignMov(appoggio);
						
					}
				}
				//1 - UP
				if(!goal && app.returnx()!=0 && app.printMov().charAt(app.printMov().length()-1)!='D')
				{
					copy=app.clone();
					copy.zeroUp(true);
					openlist.add(copy);
					if(contain(copy,openlist1))
					{
						goal=true;
						int j=retIndex(copy,openlist1);
						structGoal=copy;
						appoggio=openlist1.get(j).printMov();
						appoggio=inverti(appoggio);
						structGoal.assignMov(appoggio);
					}
				}
				//1 - RIGHT
				if(!goal && app.returny()!=app.mLength()-1 && app.printMov().charAt(app.printMov().length()-1)!='L')
				{
					copy=app.clone();
					copy.zeroRight(true);
					openlist.add(copy);
					if(contain(copy,openlist1))
					{
						goal=true;
						int j=retIndex(copy,openlist1);
						structGoal=copy;
						appoggio=openlist1.get(j).printMov();
						appoggio=inverti(appoggio);
						structGoal.assignMov(appoggio);
					}
				}
				//1 - LEFT
				if(!goal && app.returny()!=0 && app.printMov().charAt(app.printMov().length()-1)!='R')
				{
					copy=app.clone();
					copy.zeroLeft(true);
					openlist.add(copy);
					if(contain(copy,openlist1))
					{
						goal=true;
						int j=retIndex(copy,openlist1);
						structGoal=copy;
						appoggio=openlist1.get(j).printMov();
						appoggio=inverti(appoggio);
						structGoal.assignMov(appoggio);
					}
				}
				//2 - DOWN-------------------------------------------------------------------------------
				if(!goal && app1.returnx()!=app1.mLength()-1 && app1.printMov().charAt(app1.printMov().length()-1)!='U')
				{
					copy=app1.clone();
					copy.zeroDown(true);					
					openlist1.add(copy);//add the element at the end of the list
					if(contain(copy,openlist))
					{
						goal=true;
						int j=retIndex(copy,openlist1);
						structGoal=openlist1.get(j);
						appoggio=copy.printMov();
						appoggio=inverti(appoggio);
						structGoal.assignMov(appoggio);
					}
				}
				//2 - UP
				if(!goal && app1.returnx()!=0 && app1.printMov().charAt(app1.printMov().length()-1)!='D')
				{
					copy=app1.clone();
					copy.zeroUp(true);
					openlist1.add(copy);
					if(contain(copy,openlist))
					{
						goal=true;
						int j=retIndex(copy,openlist1);
						structGoal=openlist1.get(j);
						appoggio=copy.printMov();
						appoggio=inverti(appoggio);
						structGoal.assignMov(appoggio);
					}
				}
				//2 - RIGHT
				if(!goal && app1.returny()!=app1.mLength()-1 && app1.printMov().charAt(app1.printMov().length()-1)!='L')
				{
					copy=app1.clone();
					copy.zeroRight(true);
					openlist1.add(copy);
					if(contain(copy,openlist))
					{
						goal=true;
						int j=retIndex(copy,openlist1);
						structGoal=openlist1.get(j);
						appoggio=copy.printMov();
						appoggio=inverti(appoggio);
						structGoal.assignMov(appoggio);
					}
				}
				//2 - LEFT
				if(!goal && app1.returny()!=0 && app1.printMov().charAt(app1.printMov().length()-1)!='R')
				{
					copy=app1.clone();
					copy.zeroLeft(true);
					openlist1.add(copy);
					if(contain(copy,openlist))
					{
						goal=true;
						int j=retIndex(copy,openlist1);
						structGoal=openlist1.get(j);
						appoggio=copy.printMov();
						appoggio=inverti(appoggio);
						structGoal.assignMov(appoggio);
					}
					System.out.println("mosse"+structGoal.printMov());
				}
				if(!goal && !openlist.isEmpty())
				{
					openlist.remove(0);
					app=openlist.get(0).clone();
					openlist1.remove(0);
					app1=openlist1.get(0).clone();
				}
				k++;
			}
			r[0]=structGoal.printMov();
			System.out.println("r0"+ r[0]);
			r[1] = getPath1(structGoal,k) + node.print();
			System.out.println("fine bidirezionale"+ r[0] +"-" +r[1]);
			return r;
		
	}
	
	
	private String inverti(String appoggio) 
	{
		int k=1;
		String path="";
		while(appoggio.length()-k>0 && appoggio!=null)
		{
			switch (appoggio.charAt(appoggio.length()-k))
			{
			case 'U':
				path=path + 'D';
				break;
			case 'D':
				path=path + 'R';
				break;
			case 'R':
				path=path + 'L';
				break;
			case 'L':
				path=path + 'R';
				break;
			}
			k++;
		}
		return path;
	}

	//--------------------------------------------------------------------------------------------------------------
	//solve the 8 puzzle with the Astar algoritm
	//the used euristic is: count the wrong cells doing a movement
	//if type is 0 Astar use hammingDistance and if type is 1, Astar use Manhattan distance
	public String[] Astar(int type)
	{
		String r[]= {"",""};
		boolean goal=false;
		int min=100,i,lvl=0,remove=0;
		structNode structGoal=new structNode();
		structNode copy;
		structNode app=node.clone();
		//int size=openlist.size();
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
				
				
			}
		r[0]=structGoal.printMov();
		r[1] = getPath(structGoal,k) + node.print();
		System.out.println("fine ampiezza"+ r[0] +"-" +r[1]);
		return r;
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
	
	private String getPath1(structNode app, int i) 
	{
		int k=0;
		String path="";
	    fine = System.currentTimeMillis()-inizio;
		fine=fine/1000;

		path=path + "Execution time: " + fine + "\n";
		path=path + "Number of expanded nodes: " + i +"\n";
		path=path + "Partenza:\n\n";
		path=path + node.print();
		while(k<app.printMov().length() && app!=null)
		{
			switch (app.printMov().charAt(k))
			{
			case 'U':
				node.zeroUp(false);
				path=path + node.print();
				break;
			case 'D':
				node.zeroDown(false);
				path=path + node.print();
				break;
			case 'R':
				node.zeroRight(false);
				path=path + node.print();
				break;
			case 'L':
				node.zeroLeft(false);
				path=path + node.print();
				break;
			case 'S':
				path=path +"Soluzione:\n";
				path=path + node.print();
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
	public int retIndex(structNode n, List<structNode> list)
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
		i--;
		return i;
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