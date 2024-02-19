public class Triangle extends Figure implements Printable {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle (double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double calculateArea() {
        double heronHalfPerimeter = (sideA + sideB + sideC) / 2;
        return Math.sqrt(heronHalfPerimeter * (heronHalfPerimeter - sideA) * (heronHalfPerimeter - sideB) * (heronHalfPerimeter - sideC));
    }

    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    public void print() {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0 ) {
            System.out.println("Boki trojkata musza byc wieksze od 0!");
        } else {
        System.out.println("Trojkat o bokach: " + sideA + " " + sideB + " " + sideC);
        System.out.println("Obwod trojkata wynosi: " + calculatePerimeter());
        System.out.println("Pole trojkata wynosi: " + calculateArea());
        }
    }
}