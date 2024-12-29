package fifth_lab.devices;

/**
 * Клас, що описує лампу.
 */
public class Lamp extends ElectricDevice {

    /**
     * Конструктор для ініціалізації лампи.
     * @param name Назва лампи
     * @param power Потужність лампи
     * @param electromagneticRangeStart Початок діапазону випромінювання
     * @param electromagneticRangeEnd Кінець діапазону випромінювання
     */
    public Lamp(String name, double power, double electromagneticRangeStart, double electromagneticRangeEnd) {
        super(name, power, electromagneticRangeStart, electromagneticRangeEnd);
    }

    /**
     * Увімкнення лампи.
     */
    @Override
    public void turnOn() {
       super.turnOn();
    }

    /**
     * Вимкнення лампи.
     */
    @Override
    public void turnOff() {
       super.turnOff();
    }
}