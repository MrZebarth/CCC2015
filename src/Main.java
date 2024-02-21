import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int x=in.nextInt();
		int y=in.nextInt();
		System.out.println(Solve(x, y, x));
	}

	public static int Solve(int pies, int people, int biggest) {
		if (pies == people && pies / people <= biggest) {
			return 1;
		}
		if (people==1 && pies/people<=biggest) {
			return 1;
		}else if (people==1) {
			return 0;
		}
		int counter = 0;
		int ctr = pies - people + 1;
		while (ctr > 1) {
			int nextCtr = pies - ctr;
			int nextPeople = people - 1;
			if ((nextCtr) / (nextPeople) <= biggest && (ctr <= biggest)) {
				counter += Solve(nextCtr, nextPeople, ctr);
			}
			ctr--;
		}
		return counter;
	}

}
