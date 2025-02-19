package Control;

import General.Automaton;
import General.Environment;

public class A31 extends Automaton {

    public A31(Environment env) {
        super(env);
    }

    @Override
    protected boolean condOn() {
        return env.a3.curState() == 1;
    }

    @Override
    protected boolean condOff() {
        return !(env.a3.curState() == 1);
    }

    @Override
    protected void actionOn() {
        if (!in.banBoost)             { curState = 1; }
        if (in.banBoost && !in.empty) { curState = 2; }
        if (in.empty)                 { curState = 3; }
        lam(curState);
    }

    @Override
    protected void actionOff() {
        curState = 0;
        out.tmrRun = false;
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
                if (in.banBoost) { resultState = 2; }
            }
            case 2 -> {
                if (in.empty) { resultState = 3; }
            }
            case 3 -> {
                if (in.timeout) { resultState = 4; }
            }
        }
        return resultState;
    }

    @Override
    protected void lam(int state) {
        switch (state) {
            case 0, 4 -> {
                out.V2 = false;
                out.V3 = false;
                out.V4 = false;
                out.V5 = false;
            }
            case 1 -> {
                out.V2 = false;
                out.V3 = true;
                out.V4 = false;
                out.V5 = true;
            }
            case 2 -> {
                out.V2 = false;
                out.V3 = false;
                out.V4 = false;
                out.V5 = true;
            }
            case 3 -> {
                out.V2 = true;
                out.V3 = false;
                out.V4 = true;
                out.V5 = false;
            }
        }
        out.tmrRun = (state == 3);
    }
}
