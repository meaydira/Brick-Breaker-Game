public class ModelDuck extends Duck{

    public ModelDuck() {
        quackBehaviour = new MuteQuack();
        flyBehaviour = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("I am a model duck");
    }


}
