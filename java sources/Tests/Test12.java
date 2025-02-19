package Tests;

// Аварийная температура при q2=2 и q22=2.
public class Test12 extends Test {

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

        sys.setTemp(80);
        System.out.printf("Temp = %d  ", sys.getTemp());
        System.out.printf("workTemp[%d]\n", bool2int(sys.model.in.workTemp));
        sys.model.iter();
        print();

        sys.model.in.maxTemp = true;
        System.out.println("maxTemp[1]");
        sys.model.iter();
        print();
    }
}
