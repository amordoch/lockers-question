import java.util.Scanner;

public class Lockers {

  private static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.print("Input number of lockers: ");
    int lockersDesired = input.nextInt();
    // Create an array that contains all lockers and store the number of student that we are on.
    int[] lockers = new int[lockersDesired];
    int[] students = new int[lockersDesired];
    int student = 1;
    // Now we want to open/close lockers for each student, so we loop 400 times.
    for (int i = 0; i < lockers.length; i++) {
    	// If the student we're on is the first one, open every locker.
    	if(student == 1) {
    		for(int x = 0; x < lockers.length; x++) {
    			lockers[x] = 1;
                students[x] = 1;
    		}
    	} else {
            // Since we are changing lockers by multiples, we'll store the locker number we're changing
            // as the student we're on.
            int lockerNum = student;
            // Now go through each locker the student must change.
            while (lockerNum < lockers.length) {
              // System.out.println("Student: " + student + " Changing Locker: " + lockerNum);
              // If the locker is open, close it, and vice versea.
              if (lockers[lockerNum - 1] == 0) {
                // System.out.println("Locker opened");
                lockers[lockerNum - 1] = 1;
                students[lockerNum - 1] = student;
              } else if (lockers[lockerNum - 1] == 1) {
                // System.out.println("Locker closed");
                lockers[lockerNum - 1] = 0;
              }
              /*
               * For the next iteration, we want to change the locker that is the next multiple of the
               * student that we're on. For example, if we are on the second student and have just
               * changed the second locker, the next locker we must change is the fourth one, or 2
               * (student) + 2 (locker number).
               */
              lockerNum = lockerNum + student;
            }
      	}
      // When it's all over, make sure we advance the student and iterate.
      student++;
    }
    // Loop through lockers[] and count how many lockers are open, then print the result to console.
    int lockersOpen = 0;
    for (int x = 0; x < lockers.length; x++) {
      if (lockers[x] == 1) {
        System.out.println("Locker " + (x+1) + " is open, opened by student " + students[x]);
        lockersOpen++;
      }
    }
    System.out.println(lockersOpen);

  }

}
