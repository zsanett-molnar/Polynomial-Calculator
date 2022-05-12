import java.util.ArrayList;
import java.util.List;

public class Operation {

    public Polinom adunarePolinoame(Polinom p1, Polinom p2) {
        Polinom result1 = new Polinom();
        Polinom result2 = new Polinom();

        for(Monom m1 : p1.getPolinom()) {
            result1.adaugaMonom(m1);
        }

        for(Monom m2 : p2.getPolinom()) {
            result1.adaugaMonom(m2);
        }

        result1.calcule();

        for(Monom m : result1.getPolinom()) {
            if(m.getCoef() != 0) {
                result2.adaugaMonom(m);
            }
        }
        result2.sortareDupaGrad();
        return result2;

    }
    public Polinom scaderePolinoame(Polinom p1, Polinom p2) {
        Polinom result1 = new Polinom();
        Polinom result2 = new Polinom();

        for(Monom m1 : p1.getPolinom()) {
            result1.adaugaMonom(m1);
        }

        for(Monom m2: p2.getPolinom()) {
            m2.setNegativ();
            result1.adaugaMonom(m2);
        }

        result1.calcule();

        for(Monom m : result1.getPolinom()) {
            if(m.getCoef() != 0) {
                result2.adaugaMonom(m);
            }
        }
        result2.sortareDupaGrad();
        return result2;
    }



    public Polinom inmultire(Polinom p1, Polinom p2)
    {
        Polinom result = new Polinom();
        for (Monom m1 : p1.getPolinom()) {
            for (Monom m2 : p2.getPolinom()) {

                Monom m = new Monom(m1.getGrad() + m2.getGrad(), m1.getCoef() * m2.getCoef());
                //result.calcule();
                result.adaugaMonom(m);

                }
        }
        result.calcule();
        result.sortareDupaGrad();
        return result;
    }

    public Polinom derivare(Polinom p){
        Polinom result = new Polinom();

        for (Monom m : p.getPolinom()){
            if (m.getGrad()!=0) {
                Monom monom = new Monom(m.getGrad() - 1, m.getCoef() * m.getGrad());
                result.adaugaMonom(monom);
            }
        }
        result.calcule();
        result.sortareDupaGrad();
        return result;
    }

    public Polinom integrare(Polinom p) {
        Polinom result = new Polinom();
        for (Monom m : p.getPolinom()) {
            if (m.getGrad() >= 0) {
                double coef = (double)(m.getCoef() / (m.getGrad() + 1));
                m.setCoef(coef);
                result.adaugaMonom(new Monom( m.getGrad() + 1, m.getCoef()));
            }
        }
        result.calcule();
        result.sortareDupaGrad();
        return result;
    }

    public Polinom inmultireCuMonom(Polinom p, Monom monom) {
        Polinom result = new Polinom();
        for(Monom m : p.getPolinom())  {
            double coef = m.getCoef() * monom.getCoef();
            int grad = m.getGrad() + monom.getGrad();
            Monom nou = new Monom(grad, coef);
            result.adaugaMonom(nou);
        }
        result.calcule();
        result.sortareDupaGrad();
        return result;
    }

    public List<Polinom> impartire (Polinom p1, Polinom p2) {
        List<Polinom> result = new ArrayList<Polinom>();
        Polinom cat = new Polinom();

        while(p1.getGradMax() >= p2.getGradMax()) {
            Monom mp1 = p1.getMonomMax();
            Monom mp2 = p2.getMonomMax();
            Monom mcat = mp1.divide(mp2);
            cat.adaugaMonom(mcat);
            Polinom aux = inmultireCuMonom(p2,mcat);
            p1 = scaderePolinoame(p1,aux);


        }
        result.add(cat);
        result.add(p1);
        return result;

    }


}

