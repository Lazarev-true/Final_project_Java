import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Task {
    public static void main(String[] args) {
        Laptop notebook1 = new Laptop("HP", "8", "500", "Windows", "grey");
        Laptop notebook2 = new Laptop("Asus", "8", "1000", "Lunex", "white");
        Laptop notebook3 = new Laptop("HP", "8", "1000", "Windows", "black");
        Laptop notebook4 = new Laptop("HP", "16", "1500", "Windows", "grey");
        Laptop notebook5 = new Laptop("Acer", "16", "2000", "Windows", "black");

        Set<Laptop> notebooks = new HashSet<>(List.of(notebook1, notebook2,
            notebook3, notebook4, notebook5));

        Map<String, String> sel = selectCriteria();
        sort(sel, notebooks);
   }

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        return scan;
        // scanner.close();
    }

    public static Map<String, String> selectCriteria() {
        Map<String, String> resultCriterias = new HashMap<>();
        while (true) {
            System.out.println("Выбрать параметры для ноутбука? Если НЕТ введите 'n', если ДА - введите любой символ");
            String question = scanner();
            if (question.equals("n")) break;
            
            else {

                System.out.println("Введите цифру, соответствующую необходимому критерию: " + 
                "\n1 - Фирма \n2 - ОЗУ \n3 - Объем ЖД \n4 - Операционная система \n5 - Цвет");
                String key = scanner();
                System.out.println("Введите значения для выбранного критерия: ");
                String value = scanner();

                resultCriterias.put(key, value);
            }
        }
        return resultCriterias;
    }

    public static void sort(Map<String, String> criterias, Set<Laptop> notebooks) {

        Set<Laptop> temp = new HashSet<>(notebooks);
        for (Laptop notebook : notebooks) {

            for (Object pair : criterias.keySet()) {

                if (pair.equals("1") && !notebook.getName().equals(criterias.get(pair))) {
                temp.remove(notebook);
                }
                for (Object pair1 : criterias.keySet()) {

                    if (pair1.equals("2") && !notebook.getRam().equals(criterias.get(pair1))) {
                        temp.remove(notebook);
                    }

                    for (Object pair2 : criterias.keySet()) {
                        if (pair2.equals("3") && !notebook.getHardDisk().equals(criterias.get(pair2))) {
                            temp.remove(notebook);
                        }

                        for (Object pair3 : criterias.keySet()) {
                            if (pair3.equals("4") && !notebook.getOperatingSystem().equals(criterias.get(pair3))) {
                                temp.remove(notebook);
                            }

                            for (Object pair4 : criterias.keySet()) {
                                if (pair4.equals("5") && !notebook.getColour().equals(criterias.get(pair4))) {
                                temp.remove(notebook);
                                }
                            }
                        }
                    }
                }
            }

        }

        if (temp.isEmpty()) {
            System.out.println("По введенным критериям ничего не найдено!");
        } else {
            System.out.println("Вот что мы можем предложить: \n" + temp.toString());
        }
    } 
}