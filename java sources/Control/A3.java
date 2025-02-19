package Control;

import General.Automaton;
import General.Environment;

public class A3 extends Automaton {

    public A3(Environment env) {
        super(env);
    }

    @Override
    protected boolean condOn() {
        return env.a.curState() == 3;
    }

    @Override
    protected boolean condOff() {
        return !(env.a.curState() == 3);
    }

    @Override
    protected void actionOn() {
        if (in.supply) { curState = 1; } else { curState = 2; }
        lam(curState);
    }

    @Override
    protected void actionOff() {
        curState = 0;
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
                if (!in.supply && env.a31.curState() != 4) { resultState = 2; }
            }
            case 2 -> {
                if (in.supply) { resultState = 1; }
            }
        }
        return resultState;
    }

    @Override
    protected void lam(int state) {
        switch (state) {
            case 0, 2 -> {
                out.V2 = false;
                out.V3 = false;
                out.V4 = false;
                out.V5 = false;
            }
            case 1 -> {
                // V2 delegate to A31.
                // V3 delegate to A31.
                // V4 delegate to A31.
                // V5 delegate to A31.
            }
        }
    }
}
