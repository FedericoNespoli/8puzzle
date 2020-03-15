import java.util.List;

public class otto 
{
	//scacchiere delle due dimensioni
	private int scacchiera8 [][]= new int [][]{{1,2,3},
								  {5,4,6},
								  {7,8,0}};
	private int [][] solution;
	structNode node=new structNode();
	 private List<structNode> closedList;
	 private List<structNode> openList;
	//private int scacchiera15 [][]=new int [4][4];
	
	//list of seen states
	
	
	otto()
	{
		//gestione creazione matrice e selezione tabella
		//eliminerò poi scacchiera 8 e la sostituirò con il vettore in input

		node.assign(scacchiera8);
		node.findZero();
		if(node.m.length==3)
			solution= new int[][] {{1,2,3},{4,5,6},{7,8,0}};
		if(node.m.length==4)
			solution= new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
		//System.out.println(solution);
	}
	
	//solve the 8 puzzle with depth search
	public void profondità()
	{

		
	}
	
	//solve the 8 puzzle with breadth search
	public void ampiezza()
	{
		int x=0,y=0;

		
		//loop
		if(y!=2)
		{
			//zeroDown();
		}
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
	

}
/*		for(int i=0;i<scacchiera8[0].length;i++)
			for(int j=0;j<scacchiera8[1].length;j++)
				System.out.println(node.m[i][j]);*/
//System.out.println(solve[0][0]);
//System.out.println(goal());