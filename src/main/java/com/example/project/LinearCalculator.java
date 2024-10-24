package com.example.project;

public class LinearCalculator {
    // INSTANCE VARIABLES 
    // 4 INTEGER variables (name them: x1,x2,y1,y2) 
    private Integer x1;
    private Integer x2;
    private Integer y1;
    private Integer y2;

    // CONSTRUCTOR
    // 1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    // For example, "(1,2)" and "(3,4)" would be two parameter values 
    // You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String coord1, String coord2) { // <--add 2 string parameters to this constructor
        int idx = coord1.indexOf(",");
        x1 = Integer.parseInt(coord1.substring(1, idx));
        y1 = Integer.parseInt(coord1.substring(idx + 1, coord1.length() - 1));

        idx = coord2.indexOf(",");
        x2 = Integer.parseInt(coord2.substring(1, idx));
        y2 = Integer.parseInt(coord2.substring(idx + 1, coord2.length() - 1));
    }

    // METHODS
    // getters and setters for the 4 instance variables (8 methods total) 
    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public void setX1(int newX) {
        x1 = newX;
    }

    public void setY1(int newY) {
        y1 = newY;
    }

    public void setX2(int newX) {
        x2 = newX;
    }

    public void setY2(int newY) {
        y2 = newY;
    }

    // distance() -> returns a double. 
    // calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance() {
        // Calculate the distance using the distance formula
        Double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        // Return the distance rounded to the nearest hundredth
        return Math.round(d * 100) / (double) 100; // return rounded distance
    }

    // yInt() -> returns a double.
    // calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    public double yInt() {
        // Check for undefined y-intercept (vertical line)
        if (x2 - x1 == 0) {
            return -999.99;
        }
        // Calculate the y-intercept
        double intercept = y1 - (slope() * x1);
        // Return the y-intercept rounded to the nearest hundredth
        return Math.round(intercept * 100) / (double) 100;
    }

    // slope() -> returns a double. 
    // calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    public double slope() {
        // Check for undefined slope (vertical line)
        if (x2 - x1 == 0) {
            return -999.99;
        }
        // Calculate the slope
        double s = (y2 - y1) / (double) (x2 - x1);
        // Return the slope rounded to the nearest hundredth
        return Math.round(s * 100) / (double) 100;
    }

    // equation() -> returns a String.
    // calculates the final equation in y=mx+b form and returns the string
    public String equation() {
        // Check for undefined slope
        if (slope() == -999.99) {
            return "undefined";
        }
        // Handle the case where the slope is 0 (horizontal line)
        if (slope() == 0) {
            return "y=" + yInt();
        }
        // Handle case where y-intercept is 0
        if (yInt() == 0) {
            return "y=" + slope() + "x"; // No need to show y-intercept
        }
        // Handle cases where y-intercept is negative or positive
        if (yInt() < 0) {
            return "y=" + slope() + "x" + yInt();
        }
        return "y=" + slope() + "x" + "+" + yInt();
    }

    // roundedToHundredth(double x) -> returns double
    // calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x) {
        return Math.round(x * 100) / (double) 100;
    }

    // findSymmetry() -> returns a String.
    public String findSymmetry() {
        // Check for symmetry about the origin
        if (x2 == -x1 && y2 == -y1) {
            return "Symmetric about the origin";
        }
        // Check for symmetry about the x-axis
        else if (x1 == x2 && y2 == -y1) {
            return "Symmetric about the x-axis";
        } 
        // If neither condition is met
        else {
            return "No symmetry";
        }
    }

    // Midpoint() -> returns a String.
    public String Midpoint() {
        double midX = (x1 + x2) / 2.0; // Calculate midpoint for X
        double midY = (y1 + y2) / 2.0; // Calculate midpoint for Y
        return "The midpoint of this line is: (" + midX + "," + midY + ")"; // Return formatted midpoint
    }


    // printInfo()  returns a string of information
    // this method is tested but you can also call it in your main method if gradle tests are 
    // not working. 
    public String printInfo() {
        // Create a string to hold info
        String str = "The two points are: ";
        str += "(" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n"; // Include point coordinates
        str += "The equation of the line between these points is: " + equation(); // Include line equation
        str += "\nThe slope of this line is: " + slope(); // Include slope
        str += "\nThe y-intercept of the line is: " + yInt(); // Include y-intercept
        str += "\nThe distance between the two points is: " + distance(); // Include distance
        str += "\n"+ findSymmetry();
        str += "\n"+ Midpoint();

        return str; // Return the complete information string
    }
}