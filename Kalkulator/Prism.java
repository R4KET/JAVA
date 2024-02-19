public class Prism implements Printable {
    private double height;
    private Figure base;
    
    public Prism(double height, Figure base) {
       this.height = height;
       this.base = base;
    }
    
    public double getHeight() {
       return height;
    }
    
    public void setHeight(double height) {
       this.height = height;
    }
    
    public Figure getBase() {
       return base;
    }
    
    public void setBase(Figure base) {
       this.base = base;
    }
    
    public double calculateVolume() {
       return base.calculateArea() * height;
    }
    
    public double calculateSurfaceArea() {
       return 2 * base.calculateArea() + base.calculatePerimeter() * height;
    }

    public void print() {
        if (height <= 0) {
            System.out.println("Wysokosc graniastoslupa nie moze byc mniejsza od 0!");
        } else {
            System.out.println("Graniastoslup prawidlowy o wysokosci: " + getHeight() + " posiada objetosc rowna: " + calculateVolume());
        }
    }
 }