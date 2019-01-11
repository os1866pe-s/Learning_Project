package school.EDDA10.Inl3;

public class Complex {

    private double re, im;

    /**Creates a complex number with the virtual part re and
     * the imaginary part im.*/
    public Complex(double re, double im){
        this.re = re;
        this.im = im;
    }

    /**Returns the virtual part re.*/
    public double getRe(){
        return re;
    }

    /**Returns the imaginary part im.*/
    public double getIm(){
        return im;
    }

    /**returns the absolute value of the complex number in squared.*/
    public double getAbs2(){
        return (re * re) + (im * im);
    }

    /**Adds the complex number c to the current complex number.*/
    public void add(Complex c){
        re += c.getRe();
        im += c.getIm();
    }

    /**Multiplies the complex number c to the current complex number.*/
    public void mul(Complex c){
        double reTemp = re * c.getRe() - (im * c.getIm());
        double imTemp = (im * c.getRe()) + (re * c.getIm());
        re = reTemp;
        im = imTemp;
    }

}
