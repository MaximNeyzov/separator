package Tests;

// Прерывание аварийного завершения при q31=4.
public class Test16 extends Test {

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

        sys.model.in.maxTemp = true;
        System.out.println("maxTemp[1]");
        sys.model.iter();
        print();

        sys.setLevel(20);
        System.out.printf("Level = %d  ", sys.getLevel());
        System.out.printf("banBoost[%d]\n", bool2int(sys.model.in.banBoost));
        sys.model.iter();
        print();

        sys.setLevel(10);
        System.out.printf("Level = %d  ", sys.getLevel());
        System.out.printf("empty[%d]\n", bool2int(sys.model.in.empty));
        sys.model.iter();
        print();

        sys.model.in.timeout = true;
        System.out.println("timeout");
        sys.model.iter();
        sys.model.in.timeout = false;
        print();

        sys.model.in.supply = false;
        System.out.println("supply[0]");
        sys.model.iter();
        print();
    }
}
