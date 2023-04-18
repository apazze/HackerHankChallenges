public class Heranca {
    public static void main(String[] args) {
        String s = "WestBengal";
        Region region = null;

        switch (s) {
            case "WestBengal":
                region = new WestBengal();
                break;
            case "AndhraPradesh":
                region = new AndhraPradesh();
                break;
        }
        Flower flower = region.yourNationalFlower();
        System.out.println(flower.whatsYourName());
    }
}
class Flower {
    String whatsYourName() {
        return null;
    }
}

class Jasmine extends Flower {
    @Override
    String whatsYourName(){
        return "Jasmine";
    }
}

class Lily extends Flower{
    @Override
    String whatsYourName(){
        return "Lily";
    }
}

class Region {
    Flower yourNationalFlower(){
        return new Flower();
    }
}

class WestBengal extends Region {
    @Override
    Flower yourNationalFlower(){
        return new Jasmine();
    }
}

class AndhraPradesh extends Region{
    @Override
    Flower yourNationalFlower(){
        return new Lily();
    }
}