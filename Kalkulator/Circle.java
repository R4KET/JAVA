public class Circle extends Figure implements Printable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculatePerimeter() {
        return Math.PI * 2 * radius;
    }

    public double calculateVolume() {
        return radius;
        
    }

    public void print() {
        if (radius <= 0) {
            System.out.println("Promien kola musi byc wiekszy od 0!");
        } else {
            System.out.println("Kolo o promieniu: " + radius);
            System.out.println("Obwod kola wynosi: " + calculatePerimeter());
            System.out.println("Pole kola wynosi: " + calculateArea());
        }
    }
}
