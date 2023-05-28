import java.util.Scanner;
interface Food{
    String getType();
}

class Pizza implements Food{
    public String getType(){
        return "Someone ordered a Fast Food!";
    }
}

class FoodFactory{

    public Food getFood(String order) {
        try {
            String classname = order.substring(0, 1).toUpperCase() + order.substring(1).toLowerCase();
            System.out.println("The factory returned class "+classname);
            return (Food) Class.forName(classname).newInstance();
        } catch (Exception e) {
            return null;
        }
    }
}

class Cake implements Food{
    public String getType(){
        return "Someone ordered a Dessert!";
    }
}

public class Fabrica {

    public static void main(String[] args) {
        FoodFactory foodFactory = new FoodFactory();
        Scanner sc = new Scanner(System.in);
        Food food = foodFactory.getFood(sc.next());
        System.out.println(food.getType());
    }
}
