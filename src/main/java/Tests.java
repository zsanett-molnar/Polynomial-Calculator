import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class Tests {

    Operation operation = new Operation();

    @Test
    public void testAdunare() {
        Polinom polinom1 = new Polinom();//2X^2+3X^1+1
        Polinom polinom2 = new Polinom(); //3X^2+6

        polinom1.splitPolynom("2X^2+3X^1+1X^0");
        polinom2.splitPolynom("3X^2+6X^0");

        String rezultatCorect = "5.0X^2+3.0X^1+7.0X^0";
        Polinom rezultatActual = new Polinom();
        rezultatActual = operation.adunarePolinoame(polinom1,polinom2);
        String rezultat = rezultatActual.convertToString();
        assertEquals(rezultatCorect, rezultat);
    }
    @Test
    public void testScadere() {
        Polinom polinom1 = new Polinom();//2X^2+3X^1+1
        Polinom polinom2 = new Polinom(); //3X^2+6

        polinom1.splitPolynom("2X^2+3X^1+1X^0");
        polinom2.splitPolynom("3X^2+6X^0");

        String rezultatCorect = "-1.0X^2+3.0X^1+-5.0X^0";
        Polinom rezultatActual = new Polinom();
        rezultatActual = operation.scaderePolinoame(polinom1,polinom2);
        String rezultat = rezultatActual.convertToString();
        assertEquals(rezultatCorect, rezultat);
    }

    @Test
    public void testDerivare() {
        Polinom polinom1 = new Polinom();//2X^2+3X^1+1

        polinom1.splitPolynom("2X^2+3X^1+1X^0");
        String rezultatCorect = "4.0X^1+3.0X^0";
        Polinom rezultatActual = new Polinom();
        rezultatActual = operation.derivare(polinom1);
        String rezultat = rezultatActual.convertToString();
        assertEquals(rezultatCorect, rezultat);
    }
@Test
    public void testIntegrare() {
        Polinom polinom1 = new Polinom();//3X^2+2X^1

        polinom1.splitPolynom("3X^2+2X^1");
        String rezultatCorect = "1.0X^3+1.0X^2";
        Polinom rezultatActual = new Polinom();
        rezultatActual = operation.integrare(polinom1);
        String rezultat = rezultatActual.convertToString();
        assertEquals(rezultatCorect, rezultat);
    }

    @Test
    public void testInmultire() {
        Polinom polinom1 = new Polinom();//2X^1+1
        Polinom polinom2 = new Polinom(); //3X^1+4

        polinom1.splitPolynom("2X^1+1X^0");
        polinom2.splitPolynom("3X^1+4X^0");

        String rezultatCorect = "6.0X^2+11.0X^1+4.0X^0";
        Polinom rezultatActual = new Polinom();
        rezultatActual = operation.inmultire(polinom1,polinom2);
        String rezultat = rezultatActual.convertToString();
        assertEquals(rezultatCorect, rezultat);
    }

    @Test
    public void testImpartire() {
        Polinom polinom1 = new Polinom();//2X^3-4X^1+5
        Polinom polinom2 = new Polinom(); //1X^2+1X^0

        polinom1.splitPolynom("2X^3-4X^1+5X^0");
        polinom2.splitPolynom("1X^2+1X^0");

        List<Polinom> rezultatCorect = new ArrayList<>();
        List<Polinom> rezultatObtinut = new ArrayList<>();

        Polinom cat = new Polinom();
        Polinom rest = new Polinom();
        //rezultatul corect este:
        cat.splitPolynom("2X^1"); //catul
        rest.splitPolynom("5X^0-6X^1"); //restul
        rest.sortareDupaGrad();
        rezultatCorect.add(cat);
        rezultatCorect.add(rest);


        rezultatObtinut = operation.impartire(polinom1,polinom2);
        for(int i=0; i<rezultatCorect.size(); i++) {
            assertEquals(rezultatCorect.get(i).convertToString(), rezultatObtinut.get(i). convertToString());
        }

    }

}
