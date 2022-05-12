import java.util.*;

public class Monom implements Comparable<Monom> {
    private int grad;
    private double coef;

    public Monom(int grad, double coef) {
        this.grad = grad;
        this.coef = coef;
    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }


    public void setNegativ(){
        this.setCoef(-this.getCoef());
    }

    public Monom divide(Monom m) {
        double coef = this.getCoef()/m.getCoef();
        int grad = this.getGrad() - m.getGrad();
        Monom result = new Monom(grad, coef);
        return result;
    }

    @Override
    public int compareTo(Monom m) {
        return m.getGrad() - this.getGrad();
    }
}
