import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class Polinom {

    List <Monom> polinom;

    public Polinom() {
        this.polinom = new ArrayList<>();
    }

    public void adaugaMonom(Monom m){
        polinom.add(m);
    }

    public void stergeMonom(Monom m){
        polinom.remove(m);
    }

    public List<Monom> getPolinom() {
        return polinom;
    }

    public void afisarePolinom() {
        for (Monom m : polinom) {
            if (polinom.indexOf(m) == polinom.size() - 1) {
                System.out.print(m.getCoef() + "X^" + m.getGrad());
            } else {
                System.out.print(m.getCoef() + "X^" + m.getGrad() + "+");
            }
        }
    }

    public String convertToString() {
        String s="";
        for(Monom m : polinom) {
            if (polinom.indexOf(m) == polinom.size() - 1) {
                s = s + m.getCoef() + "X^" + m.getGrad();
            } else {
                s = s + m.getCoef() + "X^" + m.getGrad() + "+";
            }
        }
        return s;
    }

    public void calcule() {
        for(int i = 0; i < polinom.size(); i++) {
            for(int j = 1; j < polinom.size(); j++) {
                if(polinom.get(i).getGrad() ==polinom.get(j).getGrad() && i != j) {
                    polinom.add(i,new Monom( polinom.get(i).getGrad(), polinom.get(i).getCoef() + polinom.get(j).getCoef()));
                    polinom.remove(i+1);
                    polinom.remove(j);
                }
            }
        }
    }


    public void splitPolynom (String polinom) {
        polinom=polinom.replace("-", "+-");
        String[] parts = polinom.split("\\+");
        String[] vector = new String[2];

        for(String s : parts) {
            vector = s.split("X\\^");

            double coef = Double.parseDouble(vector[0]);
            //System.out.println(coef);
            int grad = Integer.parseInt(vector[1]);
            //System.out.println(grad);
            Monom m = new Monom(grad, coef);
            this.polinom.add(m);
        }

    }

    public Monom getMonomMax() {
        int maxGrad = polinom.get(0).getGrad();
        Monom maxMonom = polinom.get(0);
        for(Monom m : polinom) {
            if(m.getGrad() > maxGrad) {
                maxGrad = m.getGrad();
                maxMonom = m;
            }

        }
        return maxMonom;
    }

    public int getGradMax() {
        int maxGrad=0;
        for(Monom m : polinom) {
            if(m.getGrad() != 0) {
                maxGrad = m.getGrad();
                break;
            }
        }
        for(Monom m2 : polinom) {
            if(m2.getGrad() >= maxGrad) {
                maxGrad = m2.getGrad();
            }
        }
        return maxGrad;
    }

    public void sortareDupaGrad() {
        Collections.sort(polinom);
    }


}
