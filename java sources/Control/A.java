package Control;

import General.Automaton;
import General.Environment;

public class A extends Automaton {

    public A(Environment env) {
        super(env);
    }

    @Override
    protected boolean condOn() {
        return true;
    }

    @Override
    protected boolean condOff() {
        return false;
    }

    @Override
    protected void actionOn() {
        curState = 1;
        lam(curState);
    }

    @Override
    protected void actionOff() {
        // nop.
    }

    @Override
    protected void work() {
        curState = del(oldState, env);
        lam(curState);
    }

    @Override
    protected int del(int state, Environment env) {
        int resultState = state;
        switch (state) {
            case 1 -> {
                if (in.startBtn && in.supply && !in.maxTemp) { resultState = 2; }
            }
            case 2 -> {
                if (tr1() || tr2()) { resultState = 1; }
                if (tr3()) { resultState = 3; }
            }
            case 3 -> {
                if (in.ackBtn && safety()) { resultState = 1; }
            }
        }
        return resultState;
    }

    // Сепаратор в безопасном состоянии.
    private boolean safety() {
        return (env.a31.oldState() == 4) && (!in.maxTemp);
    }

    @Override
    protected void lam(int state) {
        switch (state) {
            case 0, 1 -> {
                out.V1 = false;
                out.V2 = false;
                out.V3 = false;
                out.V4 = false;
                out.V5 = false;
                out.V6 = false;
            }
            case 2 -> {
                // V1 delegate to A2.
                // V2 delegate to A2.
                out.V3 = false;
                out.V4 = false;
                // V5 delegate to A2.
                // V6 delegate to A2.
            }
            case 3 -> {
                out.V1 = false;
                // V2 delegate to A3.
                // V3 delegate to A3.
                // V4 delegate to A3.
                // V5 delegate to A3.
                out.V6 = false;
            }
        }
    }
}
