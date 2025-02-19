package Control;

public class ControlSystem {

    // Сигналы аналоговых датчиков:
    private int level = 0;  // Уровень жидкости в сепараторе.
    private int temp = 25;  // Температура нагревателя.
    private int press = 10; // Давление в сепараторе.

    // Настройки:
    private final int lev1 = 10;
    private final int lev2 = 20;
    private final int lev3 = 30;

    private final int tempMax = 100;
    private final int tempWork = 80;

    private final int pressWork = 100;
    private final int pressMin = 10;

    public AutomatonModel model = new AutomatonModel();

    public void setLevel(int level) {
        this.level = level;
        model.in.empty = (level <= lev1);
        model.in.banBoost = (level <= lev2);
        model.in.minLevel = (level <= lev2);
        model.in.full = (level >= lev3);
    }

    public void setTemp(int temp) {
        this.temp = temp;
        model.in.maxTemp = (temp >= tempMax);
        model.in.workTemp = (temp >= tempWork);
    }

    public void setPress(int press) {
        this.press = press;
        model.in.workPress = (press >= pressWork);
        model.in.minPress = (press <= pressMin);
    }

    public int getLevel() {
        return level;
    }

    public int getTemp() {
        return temp;
    }

    public int getPress() {
        return press;
    }
}
