package Control;

import General.Automaton;
import General.Environment;

public class A2 extends Automaton {

    public A2(Environment env) {
        super(env);
    }

    private int histState = 1; // Историческое состояние - состояние автомата перед его отключением.

    public int getHistState() {
        return histState;
    }

    @Override
    protected boolean condOn() {
        return env.a.curState() == 2;
    }

    @Override
    protected boolean condOff() {
        return !(env.a.curState() == 2);
    }

    @Override
    protected void actionOn() {
        curState = histState;
        lam(curState);
    }

    @Override
    protected void actionOff() {
        hist();
        curState = 0;
    }

    private void hist() {
        if (tr1()) {
            curState = del(oldState, env);
            histState = curState;
        } else if (tr2()) {
            histState = curState;
        } else if (tr3()) {
            histState = 1;
        }
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
                if (in.full) { resultState = 2; }
            }
            case 2 -> {
                if (in.minLevel && gasOut()) { resultState = 3; }
            }
            case 3 -> {
                if (in.empty) { resultState = 1; }
            }
        }
        return resultState;
    }

    // Газ выведен.
    private boolean gasOut() {
        return (env.a22.oldState() == 3) && (env.a22.newState() != 3);
    }

    @Override
    protected void lam(int state) {
        switch (state) {
            case 0 -> {
                out.V1 = false;
                out.V2 = false;
                out.V5 = false;
                out.V6 = false;
            }
            case 1 -> {
                out.V1 = true;
                out.V2 = true;
                out.V5 = false;
                out.V6 = false;
            }
            case 2 -> {
                out.V1 = false;
                // V2 delegate to A22.
                out.V5 = false;
                // V6 delegate to A22.
            }
            case 3 -> {
                out.V1 = false;
                out.V2 = false;
                out.V5 = true;
                out.V6 = false;
            }
        }
    }
}
