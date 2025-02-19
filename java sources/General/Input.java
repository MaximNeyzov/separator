package General;

public class Input {
    public boolean empty;       // Сепаратор опорожнён.
    public boolean banBoost;    // Запрет ускоренного сброса (низкий уровень).
    public boolean minLevel;    // Низкий уровень жидкости (испарение завершено).
    public boolean full;        // Сепаратор наполнен.
    public boolean maxTemp;     // Аварийный перегрев нагревателя.
    public boolean workTemp;    // Рабочая температура нагревателя достигнута.
    public boolean workPress;   // Рабочее давление в сепараторе достигнуто.
    public boolean minPress;    // Давление в сепараторе снизилось.
    public boolean swStop;      // Переключатель "Останов работы".
    public boolean withDrain;   // Переключатель "С опорожнением"
    public boolean startBtn;    // Кнопка запуска работы сепаратора.
    public boolean ackBtn;      // Кнопка подтверждения завершения аварийного останова.
    public boolean supply;      // Есть питание цепей управления клапанами.
    public boolean timeout;     // Время продувки сепаратора истекло.
}
