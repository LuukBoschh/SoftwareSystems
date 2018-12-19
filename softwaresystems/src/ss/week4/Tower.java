package ss.week4;
import java.util.Arrays;
public class Tower {
	Counter c;
	int[][] game;
	int dim;
	
	public static void main(String[] args) {
		Tower t = new Tower(10);
		t.moveTower(10,1,3);
		System.out.println("\n Total Number of moves is:" + t.getCounter().returnCount());
		t.getCounter().resetCount();
	}

	public Tower(int dim) {
		game = new int[dim][3];
		c = new Counter();
		this.dim = dim;
		for(int i = 0; i < dim; i++) {
			game[i][0]=i+1;
			
		}		
		
	}
	
	public void moveTower(int dim, int from, int to) {
		if (dim==1) {
			moveDisk(from, to);
			
			c.count();
		}
		else {
			int other = 6-from-to;
			moveTower(dim-1, from, other);
			moveDisk(from,to);
			c.count();
			moveTower(dim-1,other,to);	
		}
	}

		
	public void moveDisk(int from, int to) {
		setDisk(to, getFirstDisk(from));
		print2(game);
	}
	
	
	public int getFirstDisk(int row) {
		for(int i = 0; i<dim; i++) {
			if(game[i][row-1] != 0) {
				int x = game[i][row-1];
				game[i][row-1] = 0;
				return x;
			}
		}
		return 0;
	}
	
	public void setDisk(int to, int disk) {
		for(int i = dim-1; i<dim; i = i-1) {
			if(game[i][to-1] == 0 ) {
				game[i][to-1] = disk;
				
				break;
			}
			else {
			}
			}
		
		
	}
	
	public Counter getCounter() {
		return c;
	}
	
	public int[][] getGame(){
		return game;
	}
	
	
	public void print2(int[][] elements) {
		String s = ""; 
		for (int i = 0; i < elements.length; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(getMark(game[i][j],dim)+ "  |  ");
							}
			System.out.println("");
		}
		for (int i = 0; i < elements.length; i++) {
			
		}
		System.out.println("\n");
	}
		

		
	public String getMark(int x, int dim) {
		String s = "";
		long max = dim*2-1;
		int cur = x*2-1;
		long spac = (max-cur)/2;
		if(x == 0) {
			for(int i = 0; i < max; i++) {
				if(i == max/2) {
					s = s + "▌";
				}
				else {
				s = s + " ";
			}
			}

			return s;
		}
		else {
		for(int i = 0; i < max; i++) {
			if( i < spac) {
				s = s + " ";
			}
			else if( spac <= i && i < (cur+spac)) {
				s = s + "▄";
			}
			else {
				s = s + " ";
			}
		}

		return s;
		

	}
	}
}
