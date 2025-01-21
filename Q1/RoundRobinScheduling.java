import java.util.Scanner;

public class RoundRobinScheduling {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        
        System.out.print("Enter Number of Process : ");
        int noP = myScanner.nextInt();
        
        String [] PIT = new String[noP];
        int [] BT = new int[noP];
        int [] CT = new int[noP];
        int [] TAT = new int[noP];
        int [] WT = new int[noP];
        int [] RT = new int[noP]; //remaining Time
        
        for (int i = 0; i < noP; i++) {
            System.out.print("Enter Process " + (i+1) + " Process ID : ");
            PIT[i] = myScanner.next();
            System.out.print("Enter " + PIT[i] + " BT : ");
            BT[i] = myScanner.nextInt();
            RT[i] = BT[i];
        }
        
        System.out.print("Enter the Time Quantum: ");
        int timeQuantum = myScanner.nextInt();
        
        myScanner.close();

        int time = 0;
        float avgSum = 0;

        while (true) {
            boolean done = true;
            for (int i = 0; i < noP; i++) {
                if (RT[i] > 0) {
                    done = false;
                    if (RT[i] > timeQuantum) {
                        time += timeQuantum;
                        RT[i] -= timeQuantum;
                    } else {
                        time += RT[i];
                        WT[i] = time - BT[i];
                        RT[i] = 0;
                        avgSum += WT[i];
                    }
                }
            }
            if (done == true) break;
        }
        
        for (int i = 0; i < noP; i++) {
            CT[i] = BT[i] + WT[i];
            TAT[i] = CT[i];
        }
        
        System.out.println("\nPID\tBT\tCt\tTAT\tWT");

        for (int i = 0; i < noP; i++) {
            System.out.println(PIT[i] + "\t" + BT[i] + "\t" + CT[i] + "\t" + TAT[i] + "\t" + WT[i]);
        }

        System.out.println("\nAvarage waiting time : " + avgSum/noP);
        
    }
}
