import edu.duke.*;

//1. Create a new Java project named StringsSecondAssignments.
//You can put all the classes for this programming exercise in this project.
public class StringSecondExample
{
   

    public static void main()
    {
     part1d p1 = new part1d();
     String dna = "TKAKJAKJSKASJKAJSKJTAA";
     int startIndex=0;
    String stopCodon="TAA";
    p1.findStopCodon(dna, startIndex, stopCodon);
    }
}
//2. Create a new Java Class named Part1. The following methods go in this class.
 class part1d{

    /*
     * 3. Write the method findStopCodon that has three parameters,
     * a String parameter named dna, an integer parameter named startIndex that
     * represents where the first occurrence of ATG occurs in dna, and a String
     * parameter named stopCodon. This method returns the index of the first occurrence
     * of stopCodon that appears past startIndex and is a multiple of 3 away from startIndex.
     * If there is no such stopCodon, this method returns the length of the dna strand.
     */
    
    public int findStopCodon(String dna,int startIndex,String stopCodon)
    {
        System.out.println("The DNA is "+ dna);
        System.out.println("The startIndex"+ startIndex);
        System.out.println("The STopCOdon is "+ stopCodon);
        
        
        for(int i=0; i< dna.length();i++)
        {
            System.out.println(dna.length());
        }
        return 0;
    }   
    
    
    
}


