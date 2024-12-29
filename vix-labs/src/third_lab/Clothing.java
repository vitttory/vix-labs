package third_lab;

import java.util.Objects;

/**
 * Клас {@code Clothing} представляє предмет одягу з такими атрибутами, як бренд, розмір, колір,
 * матеріал і ціна. Він надає методи для порівняння предметів одягу за різними атрибутами та
 * перевизначає стандартні методи, такі як {@code toString}, {@code equals} та {@code hashCode}.
 */
public class Clothing {

    private String brand;
    private String size;
    private String color;
    private String material;
    private double price;

    /**
     * Конструює новий об'єкт {@code Clothing} з вказаними брендом, розміром, кольором, матеріалом та ціною.
     *
     * @param brand бренд одягу
     * @param size розмір одягу
     * @param color колір одягу
     * @param material матеріал одягу
     * @param price ціна одягу
     */
    public Clothing(String brand, String size, String color, String material, double price) {
        this.brand = brand;
        this.size = size;
        this.color = color;
        this.material = material;
        this.price = price;
    }

    /**
     * Отримує бренд одягу.
     *
     * @return бренд одягу
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Встановлює бренд одягу.
     *
     * @param brand новий бренд одягу
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Отримує розмір одягу.
     *
     * @return розмір одягу
     */
    public String getSize() {
        return size;
    }

    /**
     * Встановлює розмір одягу.
     *
     * @param size новий розмір одягу
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Отримує колір одягу.
     *
     * @return колір одягу
     */
    public String getColor() {
        return color;
    }

    /**
     * Встановлює колір одягу.
     *
     * @param color новий колір одягу
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Отримує матеріал одягу.
     *
     * @return матеріал одягу
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Встановлює матеріал одягу.
     *
     * @param material новий матеріал одягу
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Отримує ціну одягу.
     *
     * @return ціна одягу
     */
    public double getPrice() {
        return price;
    }

    /**
     * Встановлює ціну одягу.
     *
     * @param price нова ціна одягу
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Повертає рядкове подання предмета одягу.
     * Рядок містить бренд, розмір, колір, матеріал та ціну.
     *
     * @return рядкове подання одягу
     */
    @Override
    public String toString() {
        return "Clothing{" +
                "brand='" + brand + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", price=" + price +
                '}';
    }

    /**
     * Порівнює ціну цього предмета одягу з ціною іншого предмета одягу.
     *
     * @param other інший предмет одягу для порівняння
     * @return від'ємне ціле число, нуль або додатне ціле число в залежності від того, чи є ціна цього одягу
     *         меншою, рівною або більшою за ціну вказаного предмета одягу
     */
    public int compareByPrice(Clothing other) {
        return Double.compare(this.price, other.price);
    }

    /**
     * Порівнює бренд цього предмета одягу з брендом іншого предмета одягу.
     *
     * @param other інший предмет одягу для порівняння
     * @return від'ємне ціле число, нуль або додатне ціле число в залежності від того, чи є бренд цього одягу
     *         лексикографічно меншим, рівним або більшим за бренд вказаного предмета одягу
     */
    public int compareByBrand(Clothing other) {
        return this.brand.compareTo(other.brand);
    }

    /**
     * Порівнює розмір цього предмета одягу з розміром іншого предмета одягу.
     *
     * @param other інший предмет одягу для порівняння
     * @return від'ємне ціле число, нуль або додатне ціле число в залежності від того, чи є розмір цього одягу
     *         лексикографічно меншим, рівним або більшим за розмір вказаного предмета одягу
     */
    public int compareBySize(Clothing other) {
        return this.size.compareTo(other.size);
    }

    /**
     * Порівнює цей предмет одягу з вказаним об'єктом. Порівняння базується на бренді, розмірі, кольорі,
     * матеріалі та ціні одягу.
     *
     * @param o об'єкт для порівняння
     * @return true, якщо цей предмет одягу рівний вказаному об'єкту; false в іншому випадку
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clothing clothing = (Clothing) o;
        return Double.compare(clothing.price, price) == 0 &&
                Objects.equals(brand, clothing.brand) &&
                Objects.equals(size, clothing.size) &&
                Objects.equals(color, clothing.color) &&
                Objects.equals(material, clothing.material);
    }

    /**
     * Повертає хеш-код для цього предмета одягу. Хеш-код базується на бренді, розмірі, кольорі,
     * матеріалі та ціні одягу.
     *
     * @return хеш-код для цього предмета одягу
     */
    @Override
    public int hashCode() {
        return Objects.hash(brand, size, color, material, price);
    }
}
