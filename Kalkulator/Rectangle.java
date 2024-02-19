public class Rectangle extends Figure implements Printable {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    public void print() {
        if (length <= 0 || width <= 0) {
            System.out.println("Dlugosc lub szerokosc prostokata musi byc wieksza od 0!");
        } else {
        System.out.println("Prostokat o dlugosci: " + length + " i szerokosci: " + width);
        System.out.println("Obwod prostokata wynosi: " + calculatePerimeter());
        System.out.println("Pole prostokata wynosi: " + calculateArea());
        }
    }

}
