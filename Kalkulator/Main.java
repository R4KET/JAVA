import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice, choicePrism;
        double height;
        do {
            System.out.println("Co chcesz obliczyc?");
            System.out.println("1. Prostokat");
            System.out.println("2. Kolo");
            System.out.println("3. Trojkat");
            System.out.println("0. Wyjscie");
            System.out.print("Wybor: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    double length, width;
                    System.out.println("Podaj dlugosc prostokata: ");
                    length = scanner.nextDouble();
                    System.out.println("Podaj szerokosc prostokata: ");
                    width = scanner.nextDouble();
                    Rectangle rectangle = new Rectangle(length, width);
                    rectangle.print();

                    if (length == width) {
                        System.out.println(
                                "Czy chcesz dodatkowo obliczyc objetosc graniastoslupa prawidlowego opartego o kwadrat?");
                        System.out.println("Wcisnij 1 aby obliczyc: ");
                        System.out.println("Wcisnij dowolny inny klawisz, aby zakonczyc dzialanie programu: ");
                        choicePrism = scanner.nextInt();
                        if (choicePrism == 1) {
                            System.out.println("Podaj wysokosc graniastoslupa: ");
                            height = scanner.nextDouble();
                            Prism prism = new Prism(height, rectangle);
                            prism.print();
                        }
                    }
                    break;
                case 2:
                    double radius;
                    System.out.println("Podaj promien kola: ");
                    radius = scanner.nextDouble();
                    Circle circle = new Circle(radius);
                    circle.print();
                    System.out.println(
                            "Czy chcesz dodatkowo obliczyc objetosc cylindra opartego o kolo?");
                    System.out.println("Wcisnij 1 aby obliczyc: ");
                    System.out.println("Wcisnij dowolny inny klawisz, aby zakonczyc dzialanie programu: ");
                    choicePrism = scanner.nextInt();

                    if (choicePrism == 1) {
                        System.out.println("Podaj wysokosc graniastoslupa: ");
                        height = scanner.nextDouble();
                        Prism prism = new Prism(height, circle);
                        prism.print();
                    }
                    break;
                case 3:
                    double sideA, sideB, sideC;
                    System.out.println("Podaj bok A trojkata: ");
                    sideA = scanner.nextDouble();
                    System.out.println("Podaj bok B trojkata: ");
                    sideB = scanner.nextDouble();
                    System.out.println("Podaj bok C trojkata: ");
                    sideC = scanner.nextDouble();
                    if (sideA + sideB <= sideC) {
                        System.err.println("Nie mozna zbudowac trojkata o takich parametrach!");
                    } else {
                        Triangle triangle = new Triangle(sideA, sideB, sideC);
                        triangle.print();

                        if (sideA == sideB && sideB == sideC) {
                            System.out.println(
                                    "Czy chcesz dodatkowo obliczyc objetosc graniastoslupa prawidlowego opartego o trojkat?");
                            System.out.println("Wcisnij 1 aby obliczyc: ");
                            System.out.println("Wcisnij dowolny inny klawisz, aby zakonczyc dzialanie programu: ");
                            choicePrism = scanner.nextInt();
                            if (choicePrism == 1) {
                                System.out.println("Podaj wysokosc graniastoslupa: ");
                                height = scanner.nextDouble();
                                Prism prism = new Prism(height, triangle);
                                prism.print();
                            }
                        }
                    }
                    break;
                case 0:
                    System.out.println("Koniec programu.");
                    break;
                default:
                    System.out.println("Nieprawidlowy wybor.");
            }
        } while (choice != 0);

        scanner.close();
    }

}
