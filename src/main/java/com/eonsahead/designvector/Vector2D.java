package com.eonsahead.designvector;

/*
 * Vocabulary that you should know by
 * the end of our course:
 *   encapsulation
 *   information hiding
 *   inheritance
 *   polymorphism
 *
 * Step 0. Define a class that has main() method, a 
 * call to System.out.println() in that main() method,
 * and nothing else. Compile and run.
 * Step 1. Add instance variables to the class. Compile.
 * Step 2. Add a constructor. Compile.
 * Step 3. Add a toString() method. Add code that creates
 * an instance of the class in the main() method. Add code
 * in the main method that prints the vector.
 * Step 4. Add getters (also called accessor methods). Use NetBeans'
 * refactor / encapsulate fields command. Add code in main() method
 * that exercises the new methods.
 * Step 5. Add a method to compute a dot product of 2 vectors,
 * plus code to test that new method.
 * Step 6. Add a method to compute the magnitude of a
 * vector, plus code to test that new method.
 *
 */
public class Vector2D {

    // We might think of more than one
    // way to organize the data in our class.
    // "Information hiding" and "encapsulation"
    // mean that the programmers who use our
    // class do not need to know which of the
    // alternatives we chose.
    // We could define 3 separate instance variables.
//    private double x;
//    private double y;
//    private double h;
    // Or we could define a single instance variable
    // that is an array.
    // (Because we have chosen not to define any
    // setters, we could make this instance variable
    // final.)
    private final double[] components = new double[3];

    public Vector2D() {
        this( 0.0, 0.0 );
    } // Vector2D()
    
    public Vector2D(double x, double y) {
        this.components[0] = x;
        this.components[1] = y;
        this.components[2] = 1.0;
    } // Vector2D( double, double )

    public double get(int index) {
        return this.components[index];
    } // get( int )

    public double getX() {
        return this.components[0];
    } // getX()

    public double getY() {
        return this.components[1];
    } // getY()

    public double getH() {
        return this.components[2];
    } // getH()

    public void set(int index, double value) {
        this.components[index] = value;
    } // set( int, double )

    public void setX(double value) {
        this.components[0] = value;
    } // setX( double )

    public void setY(double value) {
        this.components[1] = value;
    } // setY( double )

    public void setH(double value) {
        this.components[2] = value;
    } // setH( double )

    // stub method
    public double dot(Vector2D other) {
        return this.getX() * other.getX() + this.getY() * other.getY();
    } // dot( Vector2D )

    public double magnitude() {
        return Math.sqrt(this.dot(this));
    } // magnitude()

    // Override annotation is helpful but optional.
    // It is a reminder to us and to the compiler that
    // we are redefining a method that this class 
    // inherited from the Object class.
    // (All classes inherit from the Object class.)
    @Override
    public String toString() {
        // Java's String class provides a method for
        // formatting strings.
        // %8.4f is a formatting code.
        // It means a floating point value
        // represented with 8 digits in total,
        // including 4 digits to the right of
        // the decimal point.
        return String.format("(%8.4f,%8.4f)", this.getX(), this.getY());
    } // toString()

    public static void main(String[] args) {
        Vector2D u = new Vector2D(3, 4);
        System.out.println("u = " + u);
        System.out.println("x component of u = " + u.getX());
        System.out.println("y component of u = " + u.getY());
        System.out.println("h component of u = " + u.getH());

        Vector2D v = new Vector2D(5, 12);

        System.out.println("dot product = " + u.dot(v));

        System.out.println("magnitude of u = " + u.magnitude());
        System.out.println("magnitude of v = " + v.magnitude());

    } // main( String [] )

} // Vector2D

