package General;

public class Environment {
    public Input input = new Input();
    public Output output = new Output();

    public Automaton a;
    public Automaton a2;
    public Automaton a22;
    public Automaton a3;
    public Automaton a31;

    public void setA(Automaton a) {
        this.a = a;
    }

    public void setA2(Automaton a2) {
        this.a2 = a2;
    }

    public void setA22(Automaton a22) {
        this.a22 = a22;
    }

    public void setA3(Automaton a3) {
        this.a3 = a3;
    }

    public void setA31(Automaton a31) {
        this.a31 = a31;
    }
}
