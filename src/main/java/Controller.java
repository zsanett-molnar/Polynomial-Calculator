import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Controller implements ActionListener {
    private View view;
    private Operation operation = new Operation();
    //private Polinom polinom = new Polinom();

    public Controller(View view) {
        this.view = view;
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object source = e.getSource();
        if(source == view.adunare){
            String s1 = view.getFirstPolynom();
            String s2 = view.getSecondPolynom();
            Polinom p1 = new Polinom();
            p1.splitPolynom(s1);
            Polinom p2 = new Polinom();
            p2.splitPolynom(s2);
            Polinom result = operation.adunarePolinoame(p1,p2);
            if(result.convertToString() != "") {
                view.setResult(result.convertToString());
            }
            else {
                view.setResult("0");
            }


        }

        if(source == view.scadere){
            String s1 = view.getFirstPolynom();
            String s2 = view.getSecondPolynom();
            Polinom p1 = new Polinom();
            p1.splitPolynom(s1);
            Polinom p2 = new Polinom();
            p2.splitPolynom(s2);
            Polinom result = operation.scaderePolinoame(p1,p2);

            if(result.convertToString() != "") {
                view.setResult(result.convertToString());
            }
            else {
                view.setResult("0");
            }

        }

        if(source==view.inmultire) {
            String s1 = view.getFirstPolynom();
            String s2 = view.getSecondPolynom();
            Polinom p1 = new Polinom();
            p1.splitPolynom(s1);
            Polinom p2 = new Polinom();
            p2.splitPolynom(s2);
            Polinom result = operation.inmultire(p1,p2);
            view.setResult(result.convertToString());

        }

        if(source==view.derivare) {
            String s1 = view.getFirstPolynom();
            Polinom p1 = new Polinom();
            p1.splitPolynom(s1);
            Polinom result = operation.derivare(p1);
            view.setResult(result.convertToString());

        }

        if(source==view.integrare) {
            String s1 = view.getFirstPolynom();
            Polinom p1 = new Polinom();
            p1.splitPolynom(s1);
            Polinom result = operation.integrare(p1);
            view.setResult(result.convertToString());


        }

        if(source==view.impartire) {
            List<Polinom> result = new ArrayList<>();
            String s1 = view.getFirstPolynom();
            String s2 = view.getSecondPolynom();
            Polinom p1 = new Polinom();
            p1.splitPolynom(s1);
            Polinom p2 = new Polinom();
            p2.splitPolynom(s2);
            result=operation.impartire(p1,p2);
            view.setResult(result.get(0).convertToString());
            view.setRest(result.get(1).convertToString());

        }

        if(source==view.clear) {
            view.clearTextField();

        }

    }
}
