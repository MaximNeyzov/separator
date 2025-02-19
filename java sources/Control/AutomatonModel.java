package Control;

import General.Automaton;
import General.Environment;
import General.Input;
import General.Output;

import java.util.ArrayList;
import java.util.List;

public class AutomatonModel {

    public Input in;
    public Output out;

    private final List<Automaton> automatons;
    public Automaton a;
    public Automaton a2;
    public Automaton a22;
    public Automaton a3;
    public Automaton a31;

    public AutomatonModel() {
        Environment atmEnv = new Environment();
        in = atmEnv.input;
        out = atmEnv.output;

        // Create automatons.
        a = new A(atmEnv);
        a2 = new A2(atmEnv);
        a22 = new A22(atmEnv);
        a3 = new A3(atmEnv);
        a31 = new A31(atmEnv);

        atmEnv.setA(a);
        atmEnv.setA2(a2);
        atmEnv.setA22(a22);
        atmEnv.setA3(a3);
        atmEnv.setA31(a31);

        automatons = new ArrayList<>();
        automatons.add(a);
        automatons.add(a2);
        automatons.add(a3);
        automatons.add(a22);
        automatons.add(a31);
    }

    public void iter() {
        updateOldStates();
        for (Automaton atm : automatons) {
            atm.iter();
        }
    }

    private void updateOldStates() {
        for (Automaton atm : automatons) {
            atm.updateOldState();
        }
    }
}
