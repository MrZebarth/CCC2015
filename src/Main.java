import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int x=in.nextInt();
		int y=in.nextInt();
		//Call the initial method. Use the number of pies as the max so that all possibilities are considered.
		System.out.println(Solve(x, y, x));
	}

	public static int Solve(int pies, int people, int biggest) {
		//If you have the same number of pies and people, return 1
		if (pies == people && pies / people <= biggest) {
			return 1;
		}
		//If you're down to one person and the number of pies is less than or equal to the biggest option, then return 1
		if (people==1 && pies<=biggest) {
			return 1;
		}
		//If you're down to one person and the condition is not met, return 0 to end the recursion
		else if (people==1) {
			return 0;
		}
		
		/*
		 * RECURSIVE PATTERN
		 * Assume one pie per person and the last person gets all of them for a starting point.
		 * Looping through from the starting point to 1, calculate how many combinations there are for people-1
		 * This will repeat until you hit a base case of 1 person or pies==people.
		 */
		int counter = 0;
		
		int ctr = pies - people + 1;
		while (ctr > 1) {
			int nextCtr = pies - ctr;
			int nextPeople = people - 1;
			//If the next round is possible, do a recursive call
			if ((nextCtr) / (nextPeople) <= biggest && (ctr <= biggest)) {
				counter += Solve(nextCtr, nextPeople, ctr);
			}
			ctr--;
		}
		//Bump up a level in the recursion.
		return counter;
	}

}
