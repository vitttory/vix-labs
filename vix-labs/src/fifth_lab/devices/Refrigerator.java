package fifth_lab.devices;

/**
 * Клас, що описує холодильник.
 */
public class Refrigerator extends ElectricDevice {

    /**
     * Конструктор для ініціалізації холодильника.
     * @param name Назва холодильника
     * @param power Потужність холодильника
     * @param electromagneticRangeStart Початок діапазону випромінювання
     * @param electromagneticRangeEnd Кінець діапазону випромінювання
     */
    public Refrigerator(String name, double power, double electromagneticRangeStart, double electromagneticRangeEnd) {
        super(name, power, electromagneticRangeStart, electromagneticRangeEnd);
    }

    /**
     * Увімкнення холодильника.
     */
    @Override
    public void turnOn() {
       super.turnOn();
    }

    /**
     * Вимкнення холодильника.
     */
    @Override
    public void turnOff() {
        super.turnOff();
    }
}