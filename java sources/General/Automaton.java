package General;

public abstract class Automaton {

    private enum ControllerState {
        OFF,
        ON
    }
    private ControllerState ctrlState = ControllerState.OFF;

    protected Environment env;
    protected Input in;
    protected Output out;

    protected int oldState = 0; // Состояние автомата на момент начала итерации работы автоматов.
    protected int curState = 0; // Текущее состояние автомата.

    public Automaton(Environment env) {
        this.env = env;
        this.in = env.input;
        this.out = env.output;
    }

    protected abstract boolean condOn();

    protected abstract boolean condOff();

    protected abstract void actionOn();

    protected abstract void actionOff();

    protected abstract void work();

    public void iter() {
        switch (ctrlState) {
            case OFF -> {
                if (condOn()) {
                    actionOn();
                    ctrlState = ControllerState.ON;
                }
            }
            case ON -> {
                if (condOff()) {
                    actionOff();
                    ctrlState = ControllerState.OFF;
                } else {
                    work();
                }
            }
        }
    }

    protected abstract int del(int state, Environment env);

    protected abstract void lam(int state);

    //** newState - новое состояние автомата,
    // в которое он перейдёт при текущих условиях (если в данный момент выполнит ход) */
    public int newState() {
        return del(oldState, env);
    }

    public int oldState() {
        return oldState;
    }

    public int curState() {
        return curState;
    }

    public void updateOldState() {
        oldState = curState;
    }

    /** Общие условия, используемые автоматами */
    // Завершение опорожнения.
    protected boolean drainCompletion() {
        return (env.a2.oldState() == 3) && (env.a2.newState() != 3);
    }

    // Завершение дегазации.
    protected boolean degasCompletion() {
        return (env.a2.oldState() == 2) && (env.a2.newState() != 2);
    }

    protected boolean tr1() {
        return (in.swStop &&  in.withDrain && drainCompletion()) ||
               (in.swStop && !in.withDrain && degasCompletion());
    }

    protected boolean tr2() {
        return !in.supply && !in.maxTemp;
    }

    protected boolean tr3() {
        return in.maxTemp;
    }
}
