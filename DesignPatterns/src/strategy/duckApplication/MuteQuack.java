package strategy.duckApplication;



public class MuteQuack implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }

}
