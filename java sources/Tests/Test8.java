package Tests;

// Исчезновение питание при q2=2 и q22=1.
public class Test8 extends Test {

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
        sys.model.iter();
        print();

        sys.model.in.supply = false;
        System.out.println("supply[0]");
        sys.model.iter();
        print();

        sys.model.in.supply = true;
        sys.model.in.startBtn = true;
        System.out.println("supply[1]  startBtn");
        sys.model.iter();
        sys.model.in.startBtn = false;
        print();
    }
}
