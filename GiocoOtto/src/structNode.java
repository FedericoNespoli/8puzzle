public class structNode 
{
	private int m[][];
	private int x,y;
	private String mov;
	
	//depth used for Astar algorithm
	private int level;
	private int cost;
	public structNode()
	{
		this.x=0;
		this.y=0;
		this.mov="";
		this.level=0;
		this.cost=0;
	}
	public void assign(int a[][])
	{
		m=new int[a[0].length][a[1].length];
		for(int i=0;i<a[0].length;i++)
			for(int j=0;j<a[1].length;j++)
				this.m[i][j]=a[i][j];
	}
	//return true if 2 nodes have the same matrix
	public boolean isSame(structNode n)
	{
		boolean k=true;
		for(int i=0;i<n.m[0].length && k!=false;i++)
			for(int j=0;j<n.m[1].length && k!=false;j++)
				if(this.m[i][j]!=n.m[i][j])
					k=false;
		return k;
	}
	
	//find zero position in matrix
	public void findZero()
	{
		boolean k=false;
		for(int i=0;i<m[0].length && k==false;i++)
			for(int j=0;j<m[1].length && k==false;j++)
				if(m[i][j]==0)
				{
					k=true;
					this.x=i;
					this.y=j;
				}
	}
	
	//function that move the empty cell to right
	//the move control is done in the calling void, to avoid to call that function if not possible
	//x and y give the position of the empty cell
	public void zeroRight(boolean k)
	{
		int app;
		app=this.m[x][y+1];
		this.m[x][y+1]=0;
		this.m[x][y]=app;
		this.y+=1;
		if(k)
			mov+="R";
	}
	
	//function that move the empty cell to left
	public void zeroLeft(boolean k)
	{
		int app;
		app=this.m[x][y-1];
		this.m[x][y-1]=0;
		this.m[x][y]=app;
		this.y-=1;
		if(k)
			mov+="L";
	}
	
	//function that move the empty cell up
	public void zeroUp(boolean k)
	{
		int app;
		app=this.m[x-1][y];
		this.m[x-1][y]=0;
		this.m[x][y]=app;
		this.x-=1;
		if(k)
			mov+="U";
	}
	
	//function that move the empty cell down
	public void zeroDown(boolean k)
	{
		int app;
		app=this.m[x+1][y];
		this.m[x+1][y]=0;
		this.m[x][y]=app;
		this.x+=1;
		if(k)
			mov+="D";
	}
	

	
	//function that control if the goal is reached
	public boolean isGoal(int solution[][])
	{
		boolean k=true;
		for(int i=0;i<m[0].length && k!=false;i++)
			for(int j=0;j<m[1].length && k!=false;j++)
				if(solution[i][j]!=this.m[i][j])
					k=false;
		return k;
	}
	
	public structNode clone()
	{
		structNode app=new structNode();
		app.assign(this.m);
		app.x=this.x;
		app.y=this.y;
		app.mov=this.mov;
		return app;
	}
	
	//print matrix and zero coord of structNode
	public String print()
	{
		String s="";
		for(int i=0;i<this.mLength();i++)
			for(int j=0;j<this.mLength();j++)
			{
				if(j==0)
					s = s + "[ ";
				if(m[i][j]<10)
					s = s + m[i][j] + "   ";
				else
					s = s + m[i][j]+ " ";
				if((j+1)%this.mLength()==0)
					s = s +" ]\n";
			}
		s=s+"\n\n";
		return s;
	}
	//return the position of the searched element inside the matrix
	public int[] returnPosition(int element)
	{
		boolean trovato=false;
		int pos[]=new int[2];
		for(int i=0;i<this.mLength()&&!trovato;i++)
			for(int j=0;j<this.mLength()&&!trovato;j++)
				if(element==this.returnElementByCoord(i, j))
				{
					trovato=true;
					pos[0]=i;
					pos[1]=j;
				}
		return pos;
	}
	public int[][] getM()
	{
		return this.m;
	}
	public void setCost(int c)
	{
		this.cost=c;
	}
	public void setLevel(int l)
	{
		this.level=l;
	}
	public int getLevel()
	{
		return this.level;
	}
	public int getCost()
	{
		return this.cost;
	}
	public int returny()
	{
		return y;
	}
	public int returnx()
	{
		return x;
	}
	public int returnElementByCoord(int x, int y)
	{
		return this.m[x][y];
	}
	public String printMov()
	{
		return this.mov;
	}
	
	public void assignMov(char a)
	{
		this.mov+=a;
	}
	
	public void assignMov(String a)
	{
		this.mov+=a;
	}
	
	public int mLength()
	{
		return m.length;
	}
}