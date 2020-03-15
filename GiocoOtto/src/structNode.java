public class structNode 
{
	int m[][];
	int x,y;
	String prevMov;

	public void assign(int a[][])
	{
		m=new int[a[0].length][a[1].length];
		for(int i=0;i<a[0].length;i++)
			for(int j=0;j<a[1].length;j++)
				this.m[i][j]=a[i][j];
	}

	public boolean isSame(structNode n)
	{
		boolean k=true;
		for(int i=0;i<n.m[0].length && k!=false;i++)
			for(int j=0;j<n.m[1].length && k!=false;j++)
				if(this.m[i][j]!=n.m[i][j])
					k=false;
		return k;
	}
	public void findZero()
	{
		boolean k=false;
		for(int i=0;i<m[0].length && k!=false;i++)
			for(int j=0;j<m[1].length && k!=false;j++)
				if(m[i][j]==0)
				{
					k=true;
					x=i;
					y=j;
				}
	}
	
	//function that move the empty cell to right
	//the move control is done in the calling void, to avoid to call that function if not possible
	//x and y give the position of the empty cell
	public void zeroRight()
	{
		int app;
		app=m[x][y+1];
		m[x][y+1]=0;
		m[x][y]=app;
		y+=1;
	}
	
	//function that move the empty cell to left
	public void zeroLeft()
	{
		int app;
		app=m[x][y-1];
		m[x][y-1]=0;
		m[x][y]=app;
		y-=1;
	}
	
	//function that move the empty cell up
	public void zeroUp()
	{
		int app;
		app=m[x-1][y];
		m[x-1][y]=0;
		m[x][y]=app;
		x-=1;
	}
	
	//function that move the empty cell down
	public void zeroDown()
	{
		int app;
		app=m[x-1][y];
		m[x-1][y]=0;
		m[x][y]=app;
		x+=1;
	}
	

	
	//function that control if the goal is reached
	public boolean isGoal(int solution[][])
	{
		boolean k=true;
		for(int i=0;i<3 && k!=false;i++)
			for(int j=0;j<3 && k!=false;j++)
				if(solution[i][j]!=m[i][j])
			k=false;
		return k;
	}
}