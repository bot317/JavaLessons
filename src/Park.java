public class Park {

    //Создать класс Park с внутренним классом,
    // с помощью объектов которого можно хранить информацию об аттракционах, времени их работы и стоимости.
    public class Attraction{
        public String name;
        public  String workingHours;
        public int price;

        public Attraction (String name, String workingHours, int price){
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }
        public Attraction (){
            this.name = "Empty";
            this.workingHours = "Empty";
            this.price = 0;
        }
    }

    public static void main(String[] args) {
        Park park = new Park();
        Park.Attraction[] attractionArray = new Attraction[5];
        attractionArray[0] = park.new Attraction("Колесо", "10.00-23.00", 200);
        attractionArray[1] = park.new Attraction("Поезд", "10.00-23.00", 100);
        attractionArray[2] = park.new Attraction("Лодочки", "10.00-20.00", 150);
        attractionArray[3] = park.new Attraction("Зайчики", "10.00-23.00", 300);
        attractionArray[4] = park.new Attraction("Машинки", "10.00-23.00", 250);

        for (Park.Attraction attraction : attractionArray) {
            System.out.println("Атракцион: " + attraction.name + ". Время работы: " + attraction.workingHours + ". Стоимость: " + attraction.price + ".");
        }

    }
}
