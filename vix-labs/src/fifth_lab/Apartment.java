package fifth_lab;

import fifth_lab.devices.ElectricDevice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Клас, що представляє квартиру з набором електроприладів.
 */
class Apartment {
    private List<ElectricDevice> devices;

    /**
     * Конструктор для ініціалізації квартири.
     */
    public Apartment() {
        devices = new ArrayList<>();
    }

    /**
     * Додавання електроприладу до квартири.
     * @param device Електроприлад, який потрібно додати
     * @throws IllegalArgumentException Якщо прилад є null
     */
    public void addDevice(ElectricDevice device) throws IllegalArgumentException {
        if (device == null) {
            throw new IllegalArgumentException("Device cannot be null.");
        }
        devices.add(device);
    }

    /**
     * Підрахунок загальної споживаної потужності всіх приладів.
     * @return Загальна споживана потужність в ватах
     */
    public double getTotalPowerConsumption() {
        double totalPower = 0;
        for (ElectricDevice device : devices) {
            totalPower += device.getPower();
        }
        return totalPower;
    }

    /**
     * Сортування приладів за їх споживаною потужністю.
     */
    public void sortDevicesByPower() {
        devices.sort(Comparator.comparingDouble(ElectricDevice::getPower));
    }

    /**
     * Пошук приладів в заданому діапазоні електромагнітного випромінювання.
     * @param start Початок діапазону
     * @param end Кінець діапазону
     * @return Список приладів, що потрапляють в заданий діапазон
     */
    public List<ElectricDevice> findDevicesInElectromagneticRange(double start, double end) {
        List<ElectricDevice> result = new ArrayList<>();
        for (ElectricDevice device : devices) {
            if (device.isWithinElectromagneticRange(start, end)) {
                result.add(device);
            }
        }
        return result;
    }

    /**
     * Виведення всіх приладів в квартирі.
     */
    public void printDevices() {
        if (devices.isEmpty()) {
            System.out.println("No devices in the apartment.");
        } else {
            for (ElectricDevice device : devices) {
                System.out.println(device);
            }
        }
    }
}

