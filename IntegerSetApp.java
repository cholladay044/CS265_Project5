import java.util.Scanner;
public class IntegerSetApp {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of integersets: ");
        int size = input.nextInt();
        IntegerSet[] tempArray = new IntegerSet[2];
        for (int i=0; i<tempArray.length; i++){
            tempArray[i] = new IntegerSet();
          for (int j=0; j<size; j++){
              System.out.println("Enter number: ");
              int num = input.nextInt();
              tempArray[i].add(num);
          }
          System.out.println((i+1) +" Integer Set filled.");
        }
        System.out.println("-------------Starting Sets------------------");
        tempArray[0].display();
        tempArray[1].display();
        System.out.println("--------------------------------------------");
      int action = 0;
      int no =0;
      
       do {
           //
           System.out.println("(Choose 1) Test: isEmpty()");
           System.out.println("(Choose 2) Test: isMember()");
           System.out.println("(Choose 3) Test: add");
           System.out.println("(Choose 4) Test: remove");
           System.out.println("(Choose 5) Test: isSubset");
           System.out.println("(Choose 6) Test: intersection");
           System.out.println("(Choose 7) Test: union");
           System.out.println("(Choose 8) Test: difference");
           System.out.println("(Choose 9) To Display");
           System.out.println("(Choose 0) QUIT");
           action = input.nextInt(); 
      
           if (action == 1){//isEmpty check
                Scanner intset = new Scanner(System.in);
                System.out.println("Which integer set do you want to check? ");
                int intSet1 = intset.nextInt()-1;
                System.out.println(tempArray[intSet1].isEmpty());
            }
       
            if (action == 2){
                Scanner intSet = new Scanner(System.in);
                System.out.println("Which integer set do you want to check? ");
                int intSet1 = intSet.nextInt();
                System.out.println("Number to check: ");
                int num = intSet.nextInt();
                System.out.println("Results: " + tempArray[intSet1].isMember(num));
   
            }
       
            if (action == 3){//add
                Scanner intSetInput = new Scanner(System.in);
                System.out.println("Which Integerset do you want to add? ");
                int intSet = intSetInput.nextInt() -1;
                System.out.println("Number to add: ");
                int num = intSetInput.nextInt();
                System.out.println(tempArray[intSet].add(num));
            } 
            if(action == 4){//remove
                Scanner intSetRemove = new Scanner(System.in);
                System.out.println("Which Integer Set do you want to remove from? ");
                int intSet = intSetRemove.nextInt() -1;
                System.out.println("Value to remove: ");
                int num = intSetRemove.nextInt();
                System.out.println(tempArray[intSet].remove(num));
            }
            if (action == 5){//check subnet
                Scanner intSet = new Scanner(System.in);
                System.out.println("What is the first integerset?");
                int intSet1 = intSet.nextInt() -1;
                System.out.println("What is the second integerset?");
                int intSet2 = intSet.nextInt() -1;
                System.out.println("Results: " + tempArray[intSet1].isSubnet(tempArray[intSet2]));
            }
                   
            if (action == 6){//check intersection
                Scanner intSet = new Scanner(System.in);
                System.out.println("What is the first integerset?");
                int intSet1 = intSet.nextInt() -1;
                System.out.println("What is the second integerset?");
                int intSet2 = intSet.nextInt() -1;
                IntegerSet temp = tempArray[intSet1].intersection(tempArray[intSet2]);
                System.out.print("Intesection Set:");
                temp.display();
            }
        
            if (action == 7){ //check union
                Scanner intSet = new Scanner(System.in);
                System.out.println("What is the first integetset?");
                int intSet1 = intSet.nextInt() -1;
                System.out.println("What is the second integerset?");
                int intSet2 = intSet.nextInt() -1;
                IntegerSet temp = tempArray[intSet1].union(tempArray[intSet2]);
                System.out.print("Union Set: ");
                temp.display();
            }
            if (action == 8){ //check difference
                Scanner intSet = new Scanner(System.in);
                System.out.println("What is the first integetset?");
                int intSet1 = intSet.nextInt() -1;
                System.out.println("What is the second integerset?");
                int intSet2 = intSet.nextInt() -1;
                IntegerSet temp = tempArray[intSet1].difference(tempArray[intSet2]);
                System.out.print("Union Set: ");
                temp.display();
            }
            if(action == 9){ //display integerSet
                Scanner intSet = new Scanner(System.in);
                System.out.println("Which integer set do you want to display?");
                int intSet1 = intSet.nextInt() -1;
                tempArray[intSet1].display();
            }          
            if (action == 0){
                System.out.println("Exiting");
                break;
            }
       }
       while(action != 0);
    }  
}
