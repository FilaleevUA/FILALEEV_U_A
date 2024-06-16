import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        model model = new model("");

        view view = new view();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string (separated by a space)");

        view.input(scanner.nextLine());

        controller controller = new controller(model, view);
        controller.calculate();

        double result = view.returnResult();
        System.out.println(result);
    }
}
