import org.apache.commons.csv.CSVRecord;

import edu.duke.FileResource;

public class babyNames
{
    
    public babyNames()
    {
        // TODO Auto-generated constructor stub
    }
    
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        System.out.println("Hell0");
        babynamesProgram bnp = new babynamesProgram();
        bnp.testing();
    }
    
}


class babynamesProgram {
    

    public void testing(){
printNames();
totalBirths();
    }

    public void printNames() {
        FileResource fr = new FileResource();
        for(CSVRecord rec: fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if(numBorn <=100) {
                System.out.println("Name" + rec.get(0) + "Gender" + rec.get(1) + "Num Born" + rec.get(2));
            }
        }
    }


    public void totalBirths() {
        
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        FileResource fr = new FileResource();
        for(CSVRecord rec: fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
          //  System.out.println(numBorn);
          //  System.out.println(rec.get(1));
            if(rec.get(1).equals("M"))
            {
                System.out.println(numBorn);
                totalBoys += numBorn;
            }
            else
            {
                totalGirls += numBorn;
            }
        }

        System.out.println(totalBirths);
         System.out.println(totalBoys);
          System.out.println(totalGirls);
    }
}