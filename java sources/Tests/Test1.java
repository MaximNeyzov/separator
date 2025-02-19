package Tests;

// Автомат А22 делает цикл.
public class Test1 extends Test {

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

        sys.setPress(100);
        System.out.printf("Press = %d  ", sys.getPress());
        System.out.printf("workPress[%d]\n", bool2int(sys.model.in.workPress));
        sys.model.iter();
        print();

        sys.setPress(10);
        System.out.printf("Press = %d  ", sys.getPress());
        System.out.printf("minPress[%d]\n", bool2int(sys.model.in.minPress));
        sys.model.iter();
        print();
    }
}
