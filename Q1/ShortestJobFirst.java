import java.util.Scanner;  

public class ShortestJobFirst {
  public static void main(String[] args) {

    Scanner myScanner = new Scanner(System.in); 

    int noP;
    System.out.print("Enter Number of Process : ");
    noP = myScanner.nextInt();

    String [] PIT = new String[noP];
    int [] BT = new int[noP];
    int [] CT = new int[noP];
    int [] TAT = new int[noP];
    int [] WT = new int[noP];

    for(int i=0;i<noP;i++){
        System.out.print("Enter Process " + (i+1) + " Process ID : ");
        PIT[i] = myScanner.next();
        System.out.print("Enter " + PIT[i] + " BT : ");
        BT[i] = myScanner.nextInt();
    }

    myScanner.close();

    String pit_temp = " ";
    int bt_temp = 0;  

    for(int i=0; i < noP; i++){  
            for(int j=1; j < (noP-i); j++){  
                     if(BT[j-1] > BT[j]){  
                            pit_temp = PIT[j-1];
                            bt_temp = BT[j-1];  
                            PIT[j-1] = PIT[j];
                            BT[j-1] = BT[j]; 
                            PIT[j] = pit_temp;
                            BT[j] = bt_temp;  
                    }    
            }  
    }  

    int sum = 0;
    float avgSum = 0;

    System.out.println("\nPID\tBT\tCt\tTAT\tWT");

    for(int i=0;i<noP;i++){
        CT[i] = BT[i] + sum;
        TAT[i] = CT[i];
        WT[i] = TAT[i] - BT[i];
        avgSum += WT[i];
        System.out.println(PIT[i] + "\t" + BT[i] + "\t" + CT[i] + "\t" + TAT[i] + "\t" + WT[i]);
        sum += BT[i];
    }

    System.out.println("\nAvarage waiting time : " + avgSum/noP);

  }
}
