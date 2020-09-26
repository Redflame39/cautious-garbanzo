package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        LinkedList<Integer> list = new LinkedList<>();
        SingleList listSpec = new SingleList();

        do {
            System.out.println("1.Добавить \n2.Удалить \n3.Вывести общий список \n4.Вывести список без спецслужб" +
                    " \n5.Создать список без спецслужб \n6.Выход ");
            int num = in.nextInt();
            switch (num) {
                case 1:
                    System.out.println("Тип номера \n1.Служебный \n2.Обычный");
                    num = in.nextInt();
                    PhoneType type = null;
                    switch (num) {
                        case 1:
                            type = PhoneType.OFFICIAL;
                            break;
                        case 2:
                            type = PhoneType.SUBSCRIBER;
                            break;
                    }
                    System.out.println("Номер");
                    int number = in.nextInt();
                    list.addLast(number, type);
                    break;

                case 2:
                    System.out.println("Порядковый номер удаляемого ");
                    number = in.nextInt();
                    list.deleteIndex(number);
                    break;

                case 3:
                    Iterator<Integer> iter = new Iterator<>(list);
                    while (iter.getCurrent() != null) {
                        System.out.println(iter.getCurrent().item + " " + iter.getCurrent().type);
                        iter.nextNode();
                    }
                    System.out.println("\n");
                    break;

                case 4:
                    for (int i = 0; i < listSpec.size(); i++) {
                        System.out.println(listSpec.get(i));
                    }
                    break;

                case 5:
                    Iterator<Integer> iterSpec = new Iterator<>(list);
                    while (iterSpec.getCurrent() != null) {
                        if (iterSpec.getCurrent().type.equals(PhoneType.OFFICIAL))
                            listSpec.add(iterSpec.getCurrent().item, iterSpec.getCurrent().type);
                        iterSpec.nextNode();
                    }
                    System.out.println("\n");
                    break;

                case 6:
                    flag = false;
                    break;

            }
        } while (flag);
    }
}
