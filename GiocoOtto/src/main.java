public class main {

	public static void main(String[] args) {
		structNode a=new structNode();
		structNode b=new structNode();
		int[][] m= new int[][] {{0,1,2},{4,5,3},{7,8,6}};
		otto c=new otto(m);
		System.out.println(c.profondità().toString());
		// c.ampiezza();
		//c.Astar(1);
		 //a.print();
		/*while(!k.empty())
		{
			k.pop();
			i++;
		}
		System.out.println(i);*/
		/*
		int[][] solution= new int[][] {{1,2,3},{4,5,6},{7,8,0}};
		a.assign(solution);
		//a.print();
		a.findZero();
		a.print();
		System.out.println("\n\n\n\n");
		a.print();
		System.out.println("\n\n\n\n");
		b=a.clone();
		b.zeroUp();
		b.findZero();
		b.parent=a;
		a.print();
		System.out.println("\n\n\n\n");
		b.print();
		System.out.println("\n\n\n\n");
		b.parent.print();*/
		
		
	}

}