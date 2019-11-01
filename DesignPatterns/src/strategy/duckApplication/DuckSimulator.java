package strategy.duckApplication;

public class DuckSimulator {
    public static void main(String[] args){
      Duck mallard = new MallardDuck();
      mallard.performFly();
      mallard.performQuack();
      mallard.setFlykBehaviour(new FlyNoWay());
      mallard.performFly();
    }
}
