import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        /*
         * 1. Complete writing the method getNumPoints that has one parameter s that is of type Shape.
         * This method returns an integer that is the number of points in Shape s.
         * Hint: You will need to iterate over all the points in the Shape S and count them.
         */
        int count =0;
        for (Point d : s.getPoints())
        {
            count = count + 1;
        }
        
        return count;
    }

    public double getAverageLength(Shape s) {
       
        /*
         * 3. Complete writing the method getAverageLength that has one parameter
         * s that is of type Shape. This method returns a number of type double that is
         * the calculated average of all the sides’ lengths in the Shape S.
         */
        
        
        int numPoints = getNumPoints(s); //This will get the count of points present in the list 
        System.out.println("count " + numPoints);
        
        double perimeter = getPerimeter(s); //this will get the length : NOt sure 
        System.out.println("Perimeter " + perimeter);
        
        return perimeter/numPoints;
    }

    public double getLargestSide(Shape s) {
        /*
         * 5. Complete writing the method getLargestSide that has one parameter s that is of type Shape.
         * This method returns a number of type double that is the longest side in the Shape S.
         */
        
        double longest = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if(currDist > longest){
                longest = currDist;                
            }
            prevPt = s.getLastPoint();
        }
        System.out.println("Longest " + longest);
        return longest;
    }

    public double getLargestX(Shape s) {
     
        /*
         *7. Complete writing the method getLargestX that has one parameter s that is of type Shape.
         * This method returns a number of type double that is the largest x value over all the points in the Shape s.
         */
        double largest = 0;
      
        for(Point p : s.getPoints())
        {
            if (p.getX() > largest)
            {
                largest = p.getX();
            }
        }
        System.out.println("Largest = " +largest);
        return largest;
    }

    public double getLargestPerimeterMultipleFiles() {
        /*
         * 1. Complete writing the method getLargestPerimeterMultipleFiles that has no parameters.
         * This method creates a DirectoryResource (so you can select multiple files) and
         * then iterates over these files. For each File f, it converts the file into a FileResource with the line
         * 
         * FileResource fr = new FileResource(f);
         * 
         * Then it creates a Shape from the FileResource and
         * calculates the shapes perimeter. What else does it need to do?
         * It needs to return the the largest perimeter over all the
         * shapes in the files you have selected.
         */
        DirectoryResource dr = new DirectoryResource();
        double perim=0.0;
        double perimeterOld = 0;
        for (File f1 : dr.selectedFiles()){
        
        FileResource fr = new FileResource(f1);
       Shape s = new Shape(fr);
     
       if (perimeterOld < getPerimeter(s))
       {
           perimeterOld = getPerimeter(s);
       }
        }
        return perimeterOld;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        
        /*
         * 3. Finish writing the method getFileWithLargestPerimeter that has no parameters.
         * This method should, like the getLargestPerimeterMultipleFiles method, create
         * its own Directory Resource, except that this new method returns
         * the File that has the largest such perimeter, so it has return type File.
         */
        
        DirectoryResource dr = new DirectoryResource();
        double perim=0.0;
        double perimeterOld = 0;
        for (File f1 : dr.selectedFiles()){
        
        FileResource fr = new FileResource(f1);
       Shape s = new Shape(fr);
     
       if (perimeterOld < getPerimeter(s))
       {
           perimeterOld = getPerimeter(s);
           temp = f1;
       }
        }
        System.out.println("The largest perimeter with file name "  + temp);
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        
        /*
         * 2. Add code in the method testPerimeter to call getNumPoints and to print the result.
         */
        int len = getNumPoints(s);
        
        /*
         * 4. Add code in the method testPerimeter to call the method getAverageLength and to print out the result.
         * Note: if you were to select the file example1.txt, then the average side length should be 4.0.
         */
        double avgLength = getAverageLength(s);
        System.out.println("avgLength" + avgLength);
        double length = getPerimeter(s);
        
        /*
         * 6. Add code in the method testPerimeter to call the method getLargestSide and to print out the result.
         * Note if you were to select the file example1.txt, then the longest side should be 5.0.
         */
        double largestSide = getLargestSide(s);
        System.out.println("Largest Side" + largestSide);
        
        /*
         * 8.Add code in the method testPerimeter to call the method
         * getLargestX and to print out the result.
         * Note if you were to select the file example1.txt, then the longest side should be 4.0.
         */
        
        double largestx = getLargestX(s);
        
        System.out.println("perimeter = " + length);
        
        
        System.out.println("*********");
        testPerimeterMultipleFiles();
        testFileWithLargestPerimeter();
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
       System.out.println("THe Largest perimeter is "+ getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        /*
         * 4. Add code to the method testFileWithLargestPerimeter
         * to call getFileWithLargestPerimeter.
         * For the File that is returned, print the name of that file.
         */
        
        System.out.println("The FIle with largest Perimeter is " + getFileWithLargestPerimeter());
       
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    
    
    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
    
}

