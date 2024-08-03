package ToDo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the list size.");
        int num = scanner.nextInt();
        ListMethods conList = new ListMethods(list, num);
        conList.inciar(conList, list);
    }
}
