package Tests;

// Проверка процесса аварийного завершения (аварийная температура при q2=2 и q22=1).
public class Test15 extends Test {

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

        sys.model.in.maxTemp = false;
        sys.model.in.ackBtn = true;
        System.out.println("maxTemp[0]  ackBtn");
        sys.model.iter();
        sys.model.in.ackBtn = false;
        print();
    }
}
