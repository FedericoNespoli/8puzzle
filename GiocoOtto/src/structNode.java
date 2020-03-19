public class structNode 
{
	int m[][];
	int x,y;
	structNode parent;

	public structNode()
	{
		
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
	public void zeroRight()
	{
		int app;
		app=this.m[x][y+1];
		this.m[x][y+1]=0;
		this.m[x][y]=app;
		this.y+=1;
		
	}
	
	//function that move the empty cell to left
	public void zeroLeft()
	{
		int app;
		app=this.m[x][y-1];
		this.m[x][y-1]=0;
		this.m[x][y]=app;
		this.y-=1;
	}
	
	//function that move the empty cell up
	public void zeroUp()
	{
		int app;
		app=this.m[x-1][y];
		this.m[x-1][y]=0;
		this.m[x][y]=app;
		this.x-=1;
	}
	
	//function that move the empty cell down
	public void zeroDown()
	{
		int app;
		app=this.m[x+1][y];
		this.m[x+1][y]=0;
		this.m[x][y]=app;
		this.x+=1;
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
		app.parent=this.parent;
		return app;
	}
	
	//print matrix and zero coord of structNode
	public void print()
	{
		System.out.print("[");
		for(int i=0;i<m[0].length;i++)
			for(int j=0;j<m[1].length;j++)
				if((j+1)%3==0)
					System.out.print("el i["+i+"] e j["+j+"] valore"+m[i][j]+"\n");
				else
					System.out.print("el i["+i+"] e j["+j+"] valore"+m[i][j]+"     ");
		System.out.print("x:"+this.x+"   Y:"+this.y+"]");
	}
}