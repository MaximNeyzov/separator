package Tests;

import Control.ControlSystem;

public abstract class Test {

    protected ControlSystem sys = new ControlSystem();

    public abstract void run();

    protected void printCurState() {
        System.out.printf("q[%d]  q2[%d]  q22[%d]  q3[%d]  q31[%d]\n",
                sys.model.a.curState(), sys.model.a2.curState(), sys.model.a22.curState(),
                sys.model.a3.curState(), sys.model.a31.curState());
    }

    protected void printOldState() {
        System.out.printf("q[%d]  q2[%d]  q22[%d]  q3[%d]  q31[%d]\n",
                sys.model.a.oldState(), sys.model.a2.oldState(), sys.model.a22.oldState(),
                sys.model.a3.oldState(), sys.model.a31.oldState());
    }

    protected void printNewState() {
        System.out.printf("q[%d]  q2[%d]  q22[%d]  q3[%d]  q31[%d]\n",
                sys.model.a.newState(), sys.model.a2.newState(), sys.model.a22.newState(),
                sys.model.a3.newState(), sys.model.a31.newState());
    }

    protected void printOutputs() {
        System.out.printf("V1[%d]  V2[%d]  V3[%d]  V4[%d]  V5[%d]  V6[%d]  tmrRun[%d]\n",
                bool2int(sys.model.out.V1), bool2int(sys.model.out.V2), bool2int(sys.model.out.V3),
                bool2int(sys.model.out.V4), bool2int(sys.model.out.V5), bool2int(sys.model.out.V6),
                bool2int(sys.model.out.tmrRun));
    }

    protected int bool2int(boolean b) {
        return b? 1 : 0;
    }

    protected void print() {
        printOldState();
        printCurState();
        printOutputs();
        System.out.println();
    }
}
