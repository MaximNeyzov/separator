package Control;

import General.Automaton;
import General.Environment;

public class A22 extends Automaton {

    public A22(Environment env) {
        super(env);
    }

    @Override
    protected boolean condOn() {
        return (env.a2.oldState() == 1) && (env.a2.curState() == 2);
    }

    @Override
    protected boolean condOff() {
        return degasCompletion() || alrMode();
    }

    private boolean alrMode() {
        return env.a.curState() == 3;
    }

    @Override
    protected void actionOn() {
        curState = 1;
        lam(curState);
    }

    @Override
    protected void actionOff() {
        curState = 0;
    }

    @Override
    protected void work() {
        curState = del(oldState, env);
        if (env.a2.curState() == 2) {
            lam(curState);
        } else {
            lam(0);
        }
    }

    @Override
    protected int del(int state, Environment env) {
        int resultState = state;
        switch (state) {
            case 1 -> {
                if (in.workTemp) { resultState = 2; }
            }
            case 2 -> {
                if (in.workPress) { resultState = 3; }
            }
            case 3 -> {
                if (in.minPress) { resultState = 1; }
            }
        }
        return resultState;
    }

    @Override
    protected void lam(int state) {
        switch (state) {
            case 0, 2 -> {
                out.V2 = false;
                out.V6 = false;
            }
            case 1 -> {
                out.V2 = false;
                out.V6 = true;
            }
            case 3 -> {
                out.V2 = true;
                out.V6 = false;
            }
        }
    }
}
