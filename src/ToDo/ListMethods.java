package ToDo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListMethods {

    int taskCounter;
    List<String> stringList;
    int numTasks;

    public ListMethods(List<String> stringList, int numTasks) {
        this.stringList = stringList;
        this.numTasks = numTasks;
    }

    public void add(String task, List<String> list, ListMethods listMethods) {
        taskCounter++;
        if (taskCounter >= listMethods.getNumTasks()) {
            System.out.println("Couldn't add task: Limit reached.");
        } else {
            list.add(task);
        }
    }
    public void remove(int taskNO, List<String> list) {
        taskCounter--;
        try {
            list.remove(taskNO - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Number inserted is not valid.");
        }
    }

    public void check(int taskNO) {
        stringList.set(taskNO - 1, "[X] " + stringList.get(taskNO));
    }

    public void print(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("[X]")) {
                System.out.println(list.get(i));
            } else {
                System.out.println("[] " + list.get(i));
            }
        }
    }

    public void inciar(ListMethods conList, List<String> list) {
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        System.out.println("What do you want to do? [Add, Remove, Check, Print, Close]");
        while (!choice.equalsIgnoreCase("Close")) {
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Add")) {
                System.out.println("What is the name of your task?");
                String taskName = scanner.nextLine();
                conList.add(taskName, list, conList);
                for (String t : list) {
                    if (!t.equalsIgnoreCase(taskName)) {

                    } else {
                        System.out.println("Task added.");
                    }
                }
                System.out.println("What do you want to do? [Add, Remove, Check, Print, Close]");
            } else if (choice.equalsIgnoreCase("Check")) {
                System.out.println("Which task do you wish to check? (Insert the number of the task)");
                int taskNum = scanner.nextInt();
                conList.check(taskNum);
                System.out.println("Task marked as completed.");
                System.out.println("What do you want to do? [Add, Remove, Check, Print, Close]");
            } else if (choice.equalsIgnoreCase("Print")) {
                System.out.println("Your to-do list: ");
                conList.print(list);
                System.out.println("What do you want to do? [Add, Remove, Check, Print, Close]");
            } else if (choice.equalsIgnoreCase("remove")) {
                System.out.println("Which task do you wish to remove? (Insert the number of the task)");
                int taskNO = scanner.nextInt();
                conList.remove(taskNO, list);
                System.out.println("What do you want to do? [Add, Remove, Check, Print, Close]");
            }

        }
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public int getNumTasks() {
        return numTasks;
    }

    public void setNumTasks(int numTasks) {
        this.numTasks = numTasks;
    }

    public int getTaskCounter() {
        return taskCounter;
    }
}
