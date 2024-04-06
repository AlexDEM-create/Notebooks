public class Notebook {

    String brand;    //Бренд (Лучше сделать enum)
    String model; //Модель
    int diagonal; //Диагональ
    int ram; //ОЗУ 16 ГБ
    int hard;//Объем ЖД 512 ГБ
    String operationSystem;//Операционная система
    String color; //Цвет




    @Override
    public String toString() {
        return  brand + " "+ model +" "+diagonal + " " + operationSystem +" "+ ram +"Гб " + hard+ "Гб " + color;


    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { //сравниваются две ссылки на разные участки памяти
            // this - текущий объект
            // super - родительский объект
            return true;
        }

        if (obj instanceof Notebook) {
            Notebook notebook = (Notebook) obj;
            return brand.equals(notebook.brand) && model.equals(notebook.model) && diagonal == notebook.diagonal &&
                    ram == notebook.ram && hard == notebook.hard && operationSystem.equals(notebook.operationSystem) && color.equals(notebook.color);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return  7*brand.hashCode()+11*model.hashCode()+13*diagonal+17*ram+19*hard+23*operationSystem.hashCode()+29*color.hashCode();
    }
}
