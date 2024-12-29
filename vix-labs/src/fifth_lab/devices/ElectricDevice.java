package fifth_lab.devices;

/**
 * Абстрактний клас, що описує електроприлад.
 */
public abstract class ElectricDevice {
    protected String name;
    protected double power;
    protected double electromagneticRangeStart;
    protected double electromagneticRangeEnd;

    /**
     * Конструктор для ініціалізації електроприладу.
     * @param name Назва приладу
     * @param power Споживана потужність в ватах
     * @param electromagneticRangeStart Початок діапазону електромагнітного випромінювання
     * @param electromagneticRangeEnd Кінець діапазону електромагнітного випромінювання
     */
    public ElectricDevice(String name, double power, double electromagneticRangeStart, double electromagneticRangeEnd) {
        this.name = name;
        this.power = power;
        this.electromagneticRangeStart = electromagneticRangeStart;
        this.electromagneticRangeEnd = electromagneticRangeEnd;
    }

    boolean turnedOn = false;

    /**
     * Абстрактний метод для увімкнення приладу.
     */
    public void turnOn() {
        turnedOn = true;
        System.out.println(name + " is now ON.");
    }

    /**
     * Абстрактний метод для вимкнення приладу.
     */
    public void turnOff() {
        turnedOn = false;
        System.out.println(name + "is now OFF.");
    }

    /**
     * Отримання споживаної потужності приладу.
     * @return Потужність в ватах
     */
    public double getPower() {
        return turnedOn ?  power : 0;
    }

    /**
     * Перевірка, чи потрапляє прилад в заданий діапазон електромагнітного випромінювання.
     * @param start Початок діапазону
     * @param end Кінець діапазону
     * @return true, якщо прилад потрапляє в діапазон, false - якщо ні
     */
    public boolean isWithinElectromagneticRange(double start, double end) {
        return (electromagneticRangeStart >= start && electromagneticRangeEnd <= end);
    }

    /**
     * Переозначення методу toString для виведення інформації про прилад.
     * @return Інформація про прилад
     */
    @Override
    public String toString() {
        return "Device: " + name + ", Power: " + power + "W";
    }
}