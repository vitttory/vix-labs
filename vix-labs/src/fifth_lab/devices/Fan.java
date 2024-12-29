package fifth_lab.devices;

/**
 * Клас, що описує вентилятор.
 */
public class Fan extends ElectricDevice {

    /**
     * Конструктор для ініціалізації вентилятора.
     * @param name Назва вентилятора
     * @param power Потужність вентилятора
     * @param electromagneticRangeStart Початок діапазону випромінювання
     * @param electromagneticRangeEnd Кінець діапазону випромінювання
     */
    public Fan(String name, double power, double electromagneticRangeStart, double electromagneticRangeEnd) {
        super(name, power, electromagneticRangeStart, electromagneticRangeEnd);
    }

    /**
     * Увімкнення вентилятора.
     */
    @Override
    public void turnOn() {
        super.turnOn();
    }

    /**
     * Вимкнення вентилятора.
     */
    @Override
    public void turnOff() {
       super.turnOff();
    }
}
