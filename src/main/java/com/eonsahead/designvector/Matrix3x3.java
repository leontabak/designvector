package com.eonsahead.designvector;

public class Matrix3x3 {

    private double[][] m = new double[3][3];

    public Matrix3x3() {
        this.makeIdentity();
    } // Matrix3x3()

    public final double get( int row, int column ) {
        return this.m[row][column];
    } // get( int, int )
    
    public final void set( int row, int column, double value ) {
        this.m[row][column] = value;
    } // set( int, int, double )
    
    public final void makeIdentity() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    m[i][j] = 1.0;
                } // if
                else {
                    m[i][j] = 0.0;
                } // else
            } // for
        } // for
    } // makeIdentity()

    public final void makeRotation(double angle) {
        double cosine = Math.cos(angle);
        double sine = Math.sin(angle);

        this.makeIdentity();

        m[0][0] = cosine;
        m[0][1] = -sine;
        m[1][0] = sine;
        m[1][1] = cosine;
    } // makeRotation( double )

    public final void makeScaling(double xFactor, double yFactor) {
        this.makeIdentity();

        m[0][0] = xFactor;
        m[1][1] = yFactor;
    } // makeScaling( double, double )

    public final void makeTranslation(double deltaX, double deltaY) {
        this.makeIdentity();

        m[0][2] = deltaX;
        m[1][2] = deltaY;
    } // makeTranslation( deltaX, deltaY )

    public final Vector2D multiply(Vector2D v) {
        Vector2D product = new Vector2D();

        for (int i = 0; i < 3; i++) {
            double sum = 0.0;
            for( int j = 0; j < 3; j++ ) {
                sum += m[i][j] * v.get(j);
            } // for 
            product.set(i, sum);
        } // for

        return product;
    } // multiply( Vector2D )

    public final Matrix3x3 multiply( Matrix3x3 other ) {
        Matrix3x3 product = new Matrix3x3();
        
        for( int i = 0; i < 3; i++ ) {
            for( int j = 0; j < 3; j++ ) {
                double sum = 0.0;
                for( int k = 0; k < 3; k++ ) {
                    sum += this.get(i, k) * other.get(k, j);
                } // for
                product.set(i, j, sum );
            } // for
        } // for
        
        return product;
    } // multiply( Matrix3x3 )
    
} // Matrix3x3
