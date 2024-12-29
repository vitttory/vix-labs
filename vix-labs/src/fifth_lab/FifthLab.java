package fifth_lab;

import config.LabConfig;
import core.Command;
import core.Runner;
import fifth_lab.devices.ElectricDevice;
import fifth_lab.devices.Fan;
import fifth_lab.devices.Lamp;
import fifth_lab.devices.Refrigerator;

import java.util.List;

public class FifthLab implements Command {
    // Config
    private static int VARIANT = LabConfig.VARIANT;
    private static int C13 = VARIANT % 13; // 2 -> [Визначити ієрархію електроприладів. Увімкнути деякі електроприлади
                                           // в розетку. Підрахувати споживану потужність. Провести сортування приладів
                                           // у квартирі на основі потужності. Знайти прилад у квартирі, що відповідає
                                           // заданому діапазону електромагнітного випромінювання.]
    /**
     * Виконує основну логіку лабораторної роботи 5.
     */
    @Override
    public void execute() {
        Runner.runZoned(FifthLab::runApp, "LAB 5");
    }

    private static void runApp() {
        try {
            // Створення електроприладів
            final ElectricDevice lamp = new Lamp("Living Room Lamp", 60, 200, 500);
            final ElectricDevice fan = new Fan("Bedroom Fan", 75, 300, 700);
            final ElectricDevice refrigerator = new Refrigerator("Kitchen Refrigerator", 150, 500, 1500);

            final Apartment apartment = new Apartment();
            apartment.addDevice(lamp);
            apartment.addDevice(fan);
            apartment.addDevice(refrigerator);

            System.out.println("Total Power Consumption when devices are turned off: " + apartment.getTotalPowerConsumption() + "W");
            System.out.println("\nTurning on devices:");
            lamp.turnOn();
            fan.turnOn();
            refrigerator.turnOn();
            System.out.println("Total Power Consumption when devices are turned on: " + apartment.getTotalPowerConsumption() + "W");

            System.out.println("\nDevices sorted by power:");
            apartment.sortDevicesByPower();
            apartment.printDevices();

            double rangeStart = 200;
            double rangeEnd = 700;
            System.out.println("\nDevices in electromagnetic range (" + rangeStart + " - " + rangeEnd + "):");
            List<ElectricDevice> devicesInRange = apartment.findDevicesInElectromagneticRange(rangeStart, rangeEnd);
            for (ElectricDevice device : devicesInRange) {
                System.out.println(device);
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
