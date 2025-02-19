package Tests;

// Завершение без опорожнения.
public class Test4 extends Test {

    @Override
    public void run() {
        // Инициализация:
        sys.setLevel(0);
        sys.setTemp(25);
        sys.setPress(0);
        sys.model.in.supply = true;

        System.out.println("plc power supply");
        sys.model.iter();
        print();

        sys.model.in.startBtn = true;
        System.out.println("startBtn");
        sys.model.iter();
        sys.model.in.startBtn = false;
        print();

        sys.setLevel(30);
        System.out.printf("Level = %d  ", sys.getLevel());
        System.out.printf("full[%d]\n", bool2int(sys.model.in.full));
        sys.model.in.swStop = true;
        sys.model.in.withDrain = false;
        System.out.println("swStop[1]  withDrain[0]");
        sys.model.iter();
        print();

        sys.setTemp(80);
        System.out.printf("Temp = %d  ", sys.getTemp());
        System.out.printf("workTemp[%d]\n", bool2int(sys.model.in.workTemp));
        sys.model.iter();
        print();

        sys.setPress(100);
        System.out.printf("Press = %d  ", sys.getPress());
        System.out.printf("workPress[%d]\n", bool2int(sys.model.in.workPress));
        sys.model.iter();
        print();

        sys.setPress(10);
        sys.setLevel(20);
        System.out.printf("Press = %d  Level = %d  ", sys.getPress(), sys.getLevel());
        System.out.printf("minPress[%d]  minLevel[%d]\n", bool2int(sys.model.in.minPress), bool2int(sys.model.in.minLevel));
        sys.model.iter();
        print();
    }
}
