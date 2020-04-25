import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.FileResource;
import edu.duke.URLResource;

/*Part 1: Finding a Gene - Using the Simplified Algorithm
This assignment is to write the code from the lesson from scratch by 
following the steps below.
 This will help you see if you really 
understood how to put the code together, and might identify a part
that you did not fully understand. If you get stuck, then you can go
back and watch the coding videos that go with this lesson again. We 
recommend you try this with many of the future Java 
coding examples before starting programming exercises.*/


/*
Specifically, you should do the following:

1. Create a new Java project named StringsFirstAssignments. You can put all the classes for this programming 
exercise in this project.

2. Create a new Java Class named Part1. The following methods go in this class.

3. . Write the method findSimpleGene that has one String parameter dna, representing a string of DNA.
 This method does the following:

Finds the index position of the start codon “ATG”. If there is no “ATG”, return the empty string.
Finds the index position of the first stop codon “TAA” appearing after the “ATG” that was found.
 If there is no such “TAA”, return the empty string.
If the length of the substring between the “ATG” and “TAA” is a multiple of 3, 
then return the substring that starts with that “ATG” and ends with that “TAA”.


4. Write the void method testSimpleGene that has no parameters. You should create five DNA strings. 
The strings should have specific test cases, such as: DNA with no “ATG”, DNA with no “TAA”, 
DNA with no “ATG” or “TAA”, DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene), 
and DNA with ATG, TAA and the substring between them is not a multiple of 3. For each DNA string you should:

Print the DNA string.
See if there is a gene by calling findSimpleGene with this string as the parameter.
 If a gene exists following our algorithm above, then print the gene, otherwise print the empty string.
*/


public class StringsFirstAssignments
{
    
    public StringsFirstAssignments()
    {
    }
    
    public static void main(String[] args)
    {
        /*
         * part1 p1 = new part1();
         * String sampleDNA="AAATGCCCTAACTAGATTAAGAAACC";//"TCSGSGGSHSGSYHUSJSHSATGHDUKSKSJDDNCNDUUDJSNSJSLDJDLSDKLKTAA";
         * System.out.println("The given string is     :" + sampleDNA);
         * System.out.println("The Gene from string is :" + p1.findSimpleGene(sampleDNA));
         * 
         * 
         * System.out.println("PART 2 of the Java File ");
         * part2 p2 = new part2();
         * String startCodon ="ATG";
         * String endCodon = "TAA";
         * System.out.println("The Gene from string is :" + p2.findSimpleGene(sampleDNA, startCodon, endCodon));
         * 
         * 
         * System.out.println("Part 3 of the java file");
         * part3 p3 = new part3();
         * String stra = "senba";
         * String strb = " All abide  by the rules of the company";
         * System.out.println(p3.twoOccurrences(stra, strb));
         * 
         * 
         * 
         * System.out.println("Part 4 of the Java File");
         * part4 p4 = new part4();
         * p4.urlResourceReader();
         * 
         * 
         * 
         * 
         * part4d pd1 = new part4d();
         * String dna = "TKAKJAKJSKASJKAJSKJTAA";
         * int startIndex=0;
         * String stopCodon="TAA";
         * pd1.findStopCodon(dna, startIndex, stopCodon);
         * 
         */
       week3 ex3 = new week3();    
       ex3.tester();
       
    }    
}

class week3 {
    
    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
       // countryInfo(parser, "Nauru");
    //   listExportersTwoProducts(parser,"Gold","Diamonds");
      //  numberOfExporters(parser,"gold");
        
        bigExporters(parser,"$999,999,999,999");
        
      //  numberOfExporters(parser,"sugar");
        
    }
    
    /*
     * . Write a method named countryInfo that has two parameters, parser is a CSVParser and country is a String.
     * This method returns a string of information about the country or returns “NOT FOUND” if there
     * is no information about the country. The format of the string returned
     * is the country, followed by “: “, followed by a list of the countries’ exports,
     * followed by “: “, followed by the countries export value.
     * For example, using the file exports_small.csv
     * and the country Germany, the program returns the string:
     * Germany: motor vehicles, machinery, chemicals: $1,547,000,000,000
     */
    public void countryInfo(CSVParser parser, String country) {
        
        for(CSVRecord record:parser) {
                        
            String encounteredCountry = record.get("Country");  
            
              if(encounteredCountry.equalsIgnoreCase(country))
              {
              System.out.println(country +":"+ record.get("Exports") + ":" + record.get("Value (dollars)"));
              }                      
        }        
    }
    
    
    /*
     * Write a void method named listExportersTwoProducts that has three parameters, parser is a
     * CSVParser, exportItem1 is a String and exportItem2 is a String. This method prints
     * the names of all the countries that have both exportItem1 and exportItem2 as export
     * items. For example, using the file exports_small.csv, this method called with the
     * items “gold” and “diamonds” would print the countriesWrite a void method named
     * listExportersTwoProducts that has three parameters, parser is a CSVParser,
     * exportItem1 is a String and exportItem2 is a String. This method prints the
     * names of all the countries that have both exportItem1 and exportItem2 as
     * export items. For example, using the file exports_small.csv,
     * this method called with the items “gold” and “diamonds” would print the countries
     */
    
    
    public void listExportersTwoProducts(CSVParser parser,String exportItem1,String exportItem2)
    {
        for(CSVRecord record:parser) {
            String export = record.get("Exports");
            
            
           if(export.indexOf(exportItem1.toLowerCase()) != -1 && export.indexOf(exportItem2.toLowerCase()) != -1) {
               String country = record.get("Country");
               System.out.println(country);
           }
        }
    }
    
    
    /*
     * Write a method named numberOfExporters, which has two parameters, parser is a CSVParser,
     * and exportItem is a String. This method returns the number of countries that export exportItem.
     * For example, using the file exports_small.csv, this method called with the item “gold” would return 3.
     */
    
    
    public void numberOfExporters(CSVParser parser, String exportItem) {
        int count = 0;
        for(CSVRecord record:parser) {
            
            String exportedGoods = record.get("Exports");
            
            if(exportedGoods.indexOf(exportItem) !=-1)
            {
                count ++;
            }
            
        }
        
        System.out.println(count);
    }
    
    
    
    
    /*
     * Write a void method named bigExporters that has two parameters, parser is a CSVParser,
     * and amount is a String in the format of a dollar sign, followed by an integer number
     * with a comma separator every three digits from the right. An example of such a string
     * might be “$400,000,000”. This method prints the names of countries and their Value amount
     * for all countries whose Value (dollars) string is longer than the amount string. You do
     * not need to parse either string value as an integer, just compare the lengths of the
     * strings. For example, if bigExporters is called with the file exports_small.csv and
     * amount with the string $999,999,999, then this method would print eight countries and
     * their export values shown here:
     */
    
    
    public void bigExporters(CSVParser parser, String amount) {
        for(CSVRecord record:parser) {
            String calculatedAmount = record.get("Value (dollars)");
            
            if(calculatedAmount.length() > amount.length()) {
                String countryName = record.get("Country");
                System.out.println(countryName + " " + calculatedAmount);
            }
            
        }
    }
    
}



class part1 {
 
    
    public String  findSimpleGene(String sampleDNA) {
        
        String simpleGene = "";
  
        String startCodon = "ATG";
        String endCodon = "TAA";
        
        
        int startCodonIndex = sampleDNA.indexOf(startCodon);
        if(startCodonIndex == -1) return ""; //step: 3a
        int endCodonIndex = sampleDNA.indexOf(endCodon,startCodonIndex+3);
        if(endCodonIndex == -1) return ""; //step 3b
        
        if((endCodonIndex-startCodonIndex)%3 == 0) //step: 3C
        {
            simpleGene = sampleDNA.substring(startCodonIndex,endCodonIndex+3);
            System.out.println("Simple Gene is" + simpleGene);
        }
        
        return simpleGene;
        
    }
}


/*
 * Part 2: Finding a Gene - Using the Simplified Algorithm Reorganized
 * This assignment will determine if a DNA strand has a gene in it by using the
 * simplified algorithm from the lesson, but organizing the code in a slightly different way.
 * You will modify the method findSimpleGene to have three parameters, one for the DNA string,
 * one for the start codon and one for the stop codon.
 * 
 * Specifically, you should do the following:
 * 
 * 1. Create a new Java Class named Part2 in the StringsFirstAssignments project.
 * 
 * 2. Copy and paste the two methods findSimpleGene and testSimpleGene from the Part1 class
 * into the Part2 class.
 * 
 * 3. The method findSimpleGene has one parameter for the DNA string named dna.
 * Modify findSimpleGene to add two additional parameters, one named startCodon for
 * the start codon and one named stopCodon for the stop codon. What additional changes do
 * you need to make for the program to compile? After making all changes, run your program to
 * check that you get the same output as before.
 * 
 * 4. Modify the findSimpleGene method to work with DNA strings that are either all uppercase
 * letters such as “ATGGGTTAAGTC” or all lowercase letters such as “gatgctataat”. Calling
 * findSimpleGene with “ATGGGTTAAGTC” should return the answer with uppercase letters,
 * the gene “ATGGGTTAA”, and calling findSimpleGene with “gatgctataat” should return
 * the answer with lowercase letters, the gene “atgctataa”.
 * HINT: there are
 * two string methods toUpperCase() and toLowerCase().
 * If dna is the string “ATGTAA” then dna.toLowerCase() results in the string “atgtaa”.
 * 
 */

class part2 {
public String  findSimpleGene(String sampleDNA,String startCodon,String endCodon) {
        
        String simpleGene = "";
  
       // String startCodon = "ATG";
     //   String endCodon = "TAA";
        
        
        int startCodonIndex = sampleDNA.indexOf(startCodon);
        if(startCodonIndex == -1) return ""; //step: 3a
        int endCodonIndex = sampleDNA.indexOf(endCodon,startCodonIndex+3);
        if(endCodonIndex == -1) return ""; //step 3b
        
        if((endCodonIndex-startCodonIndex)%3 == 0) //step: 3C
        {
            simpleGene = sampleDNA.substring(startCodonIndex,endCodonIndex+3);
            System.out.println("Simple Gene is" + simpleGene);
        }
        
        if(sampleDNA.equals(sampleDNA.toUpperCase()))
        {
            return simpleGene.toUpperCase();
        }
        else
        {
            return simpleGene.toLowerCase();
        }
        
    }
}





/*
 * Part 3: Problem Solving with Strings
 * This assignment will give you additional practice using String methods.
 *  You will write two methods to solve some problems using strings and a third method to test
 * these two methods.
 * 
 * Specifically, you should do the following:
 * 
 * 1. Create a new Java Class named Part3 in the StringsFirstAssignments project. Put the following
 *  methods in this class.
 * 
 * 2. Write the method named twoOccurrences that has two String parameters named stringa and stringb.
 *  This method returns true if stringa appears at least twice in
 * stringb, otherwise it returns false. For example, the call twoOccurrences(“by”, “A story by Abby Long”)
 *  returns true as there are two occurrences of “by”, the call
 * twoOccurrences(“a”, “banana”) returns true as there are three occurrences of “a” so “a” occurs at
 *  least twice, and the call twoOccurrences(“atg”, “ctgtatgta”) returns
 * false as there is only one occurence of “atg”.
 * 
 * 3. Write the void method named testing that has no parameters. This method should call 
 * twoOccurrences on several pairs of strings and print the strings and the result
 * of calling twoOccurrences (true or false) for each pair. Be sure to test examples that 
 * should result in true and examples that should result in false.
 * 
 * 4. Write the method named lastPart that has two String parameters named stringa and stringb.
 *  This method finds the first occurrence of stringa in stringb, and returns
 * the part of stringb that follows stringa. If stringa does not occur in stringb, then return 
 * stringb. For example, the call lastPart(“an”, “banana”) returns the string
 * “ana”, the part of the string after the first “an”. The call lastPart(“zoo”, “forest”) returns
 *  the string “forest” since “zoo” does not appear in that word.
 * 
 * 5. Add code to the method testing to call the method lastPart with several pairs of strings.
 *  For each call print the strings passed in and the result. For example, the
 * output for the two calls above might be:
 * 
 * The part of the string after an in banana is ana.
 * The part of the string after zoo in forest is forest.
 */


class part3 {
    
    

    public boolean twoOccurrences(String stra, String strb) {
        
        System.out.println("The check string is  :"+ stra);
        System.out.println("The tosearch string is :"+strb);
int startpoint = -1;
int count = 0;
boolean test = true;
while(test)
{
    System.out.println("****");

    System.out.println(count);
    System.out.println(startpoint);
    int startindex = strb.indexOf(stra,startpoint+1);
    System.out.println(startindex);
    if(startindex != -1)
    {
        startpoint = startindex;
        count = count+1;
    }
    else
    {
        test = false;
    }
   
}

if(count >=2) 
    return true;
else
    return false;
 }
    
}



/*
 * Write a program that reads the lines from the file at this URL location, http://www.dukelearntoprogram.com/course2/data/manylinks.html, and prints each URL on the page
 * that is a link to youtube.com. Assume that a link to youtube.com has no spaces in it and would be in the format (where [stuff] represents characters that are not
 * verbatim): “http:[stuff]youtube.com[stuff]”
 * 
 * Here are suggestions to get started.
 * 
 * 1. Create a new Java Class named Part4 in the
 * StringsFirstAssignments project and put your code in that class.
 * 
 * 2. Use URLResource to read the file at http://www.dukelearntoprogram.com/course2/data/manylinks.html word by word.
 * 
 * 3. For each word, check to see if “youtube.com” is in it.
 * If it is, find the double quote to the left and right of the occurrence
 * of “youtube.com” to identify the beginning and end of the URL.
 * Note, the double quotation mark is a special character in Java.
 * To look for a double quote, look for (\”), since the backslash (\)
 * character indicates we want the literal quotation marks (“) and not the Java character.
 * The string you search for would be written “\”” for one double quotation mark.
 * 
 * 4. In addition to the String method indexOf(x, num), you might want to
 * consider using the String method lastIndexOf(s, num) that can be used
 * with two parameters s and num. The parameter s is the string or character to look for,
 * and num is the last position in the string to look for it. This method returns the last
 * match from the start of the string up to the num position, so it is a good option for
 * finding the opening quotation mark of a string searching backward from “youtube.com.”
 * More information on String methods can be found
 * in the Java documentation for Strings: http://docs.oracle.com/javase/7/docs/api/java/lang/String.html.
 * 
 * Caution: The word Youtube could appear in different cases such as YouTube, youtube,
 * or YOUTUBE. You can find the URLs more easily by converting the string to lowercase.
 * However, you will need the original string (with uppercase and lowercase letters) to view
 * the YouTube URL to answer a quiz question because YouTube links are case sensitive.
 * The link https://www.youtube.com/watch?v=ji5_MqicxSo is different than the link https://www.youtube.com/watch?v=ji5_mqicxso, where all the letters are lowercase.
 */


class part4 {
    
    public void urlResourceReader() {
        
        String urlData = "http://www.dukelearntoprogram.com/course2/data/manylinks.html";
        URLResource url = new URLResource(urlData);
        
       System.out.println(url);
       
       for (String line : url.words()) {
           // process each line in turn
          // System.out.println(line);
           
           
           
           if(line.contains("\"") && line.contains("youtube.com") )
           {
               System.out.println("******");
               System.out.println(line);
           }
       }
    }
}




class part4d {    

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
            
            //String subString = dna.substring(beginIndex, endIndex)
        }
        boolean test = true;
        
        while(test)
        {
            int lastIndex = dna.indexOf(stopCodon, startIndex+1);
            if((lastIndex-startIndex)%3==0)
            {
                test=false;//to break the loop
                return lastIndex;
            }else
            {
                startIndex = lastIndex;
            }
        }
        return 0;
    }     
    
}



