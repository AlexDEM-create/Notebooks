import java.util.*;

public class Main {
    public static void main(String[] args) {
        Notebook notebook1 = new Notebook();
        notebook1.brand = "Apple";
        notebook1.model = "MacBook Pro";
        notebook1.diagonal = 13;
        notebook1.operationSystem = "MacOS";
        notebook1.color = "Gray";
        notebook1.ram = 16;
        notebook1.hard = 512;

        Notebook notebook2 = new Notebook();
        notebook2.brand = "Xiaomi";
        notebook2.model = "RedmiBook Pro";
        notebook2.diagonal = 17;
        notebook2.operationSystem = "Windows";
        notebook2.color = "Black";
        notebook2.ram = 16;
        notebook2.hard = 1024;

        Notebook notebook3 = new Notebook();
        notebook3.brand = "Huawei";
        notebook3.model = "MateBook";
        notebook3.diagonal = 21;
        notebook3.operationSystem = "Windows";
        notebook3.color = "Silver";
        notebook3.ram = 32;
        notebook3.hard = 512;

        Notebook notebook4 = new Notebook();
        notebook4.brand = "Apple";
        notebook4.model = "MacBook Air";
        notebook4.diagonal = 15;
        notebook4.operationSystem = "MacOS";
        notebook4.color = "Silver";
        notebook4.ram = 8;
        notebook4.hard = 1024;

        Notebook notebook5 = new Notebook();
        notebook5.brand = "Apple";
        notebook5.model = "MacBook Pro";
        notebook5.diagonal = 17;
        notebook5.operationSystem = "MacOS";
        notebook5.color = "Grey";
        notebook5.ram = 16;
        notebook5.hard = 1024;

        Notebook notebook6 = new Notebook();
        notebook6.brand = "Huawei";
        notebook6.model = "MateBook";
        notebook6.diagonal = 13;
        notebook6.operationSystem = "Windows";
        notebook6.color = "Grey";
        notebook6.ram = 16;
        notebook6.hard = 1024;

        Notebook notebook7 = new Notebook();
        notebook7.brand = "Xiaomi";
        notebook7.model = "RedmiBook";
        notebook7.diagonal = 15;
        notebook7.operationSystem = "Windows";
        notebook7.color = "White";
        notebook7.ram = 8;
        notebook7.hard = 512;

        Notebook notebook8 = new Notebook();
        notebook8.brand = "Apple";
        notebook8.model = "MacBook Pro";
        notebook8.diagonal = 13;
        notebook8.operationSystem = "MacOS";
        notebook8.color = "Grey";
        notebook8.ram = 16;
        notebook8.hard = 512;

        Notebook notebook9 = new Notebook();
        notebook9.brand = "Apple";
        notebook9.model = "MacBook Pro";
        notebook9.diagonal = 22;
        notebook9.operationSystem = "MacOS";
        notebook9.color = "Silver";
        notebook9.ram = 16;
        notebook9.hard = 1024;

        Notebook notebook10 = new Notebook();
        notebook10.brand = "Xiaomi";
        notebook10.model = "RedmiBook";
        notebook10.diagonal = 22;
        notebook10.operationSystem = "Windows";
        notebook10.color = "Black";
        notebook10.ram = 8;
        notebook10.hard = 2048;




        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(notebook1);
        notebooks.add(notebook2);
        notebooks.add(notebook3);
        notebooks.add(notebook4);
        notebooks.add(notebook5);
        notebooks.add(notebook6);
        notebooks.add(notebook7);
        notebooks.add(notebook8);
        notebooks.add(notebook9);
        notebooks.add(notebook10);
        //System.out.println(notebook1+notebook1.getClass().getSimpleName());
        //System.out.println(notebook1.equals(notebook8));
        printSet(notebooks);

        printSet(findByDiagonal(15, notebooks));
        //System.out.println(filterCriteriaBuilder());

        Map<String,String> CriteriaMap = filterCriteriaBuilder();
        System.out.println("Вы искали :"+ CriteriaMap);
        System.out.println("Результат:" + findByMapOfCriteria(CriteriaMap,notebooks));
    }
    static void printSet(Set<Notebook>notebooks){
        for (Notebook notebook: notebooks){
            System.out.println(notebook);
        }
    }
     static Map<String,String> filterCriteriaBuilder(){
        Map<String,String> filterCriteria = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Выберите параметр для фильтрации (или нажмите 5 для поиска):");
            System.out.println("1. Минимальный объем ОЗУ");
            System.out.println("2. Минимальный объем жесткого диска");
            System.out.println("3. Операционная система");
            System.out.println("4. Цвет");
            System.out.println("5. Поиск");
            String choice = scanner.nextLine();


            if (choice.equals("5")){
                break;
            }
            System.out.println("Введите значение параметра:");
            String value = scanner.nextLine();
            filterCriteria.put(choice, value);

        }
        return filterCriteria;

    }

    static Set<Notebook> findByMapOfCriteria(Map<String, String> mapOfCriteria, Set<Notebook> notebooks) {
        Set<Notebook> filteredSet = new HashSet<>();
        for (Notebook notebook : notebooks) {
            boolean match = true;
            for (Map.Entry<String, String> entry : mapOfCriteria.entrySet()) {    //Пробегаемся по карте множества критериев фильтра
                String key = entry.getKey();
                String value = entry.getValue();

                switch (key) {
                    case "1":
                        if (notebook.ram <= Integer.parseInt(value)) {
                            match = false;
                        }
                        break;
                    case "2":
                        if (notebook.hard <= Integer.parseInt(value)) {
                            match = false;
                        }
                        break;
                    case "3":
                        if (!Objects.equals(notebook.operationSystem, value)) {
                            match = false;
                        }
                        break;
                    case "4":
                        if (!Objects.equals(notebook.color, value)) {
                            match = false;
                        }
                        break;
                    default:
                        break;
                }
                if (!match) {
                    break;
                }
            }
            if (match) {
                filteredSet.add(notebook);
            }
        }
        return filteredSet;
    }



    static Set<Notebook> findByDiagonal (int wishingDiagonal, Set<Notebook> notebooks){
        Set<Notebook> filteredSet = new HashSet<>();
        for (Notebook notebook: notebooks) {
            if (notebook.diagonal == wishingDiagonal){
                filteredSet.add(notebook);
            }
        }
        return filteredSet;
    }
//    static Set<Notebook> findByBrand (int wishingDiagonal, Set<Notebook> notebooks){
//        Set<Notebook> filteredSet = new HashSet<>();
//        for (Notebook notebook: notebooks) {
//            if (notebook.diagonal.equals(wishingDiagonal)){
//                filteredSet.add(notebook);
//            }
//
//
//        }
//        return filteredSet;
//    }
}