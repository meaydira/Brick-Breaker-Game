public abstract class Duck {
    /**
     * For different quacking behaviour we have the interface quackbehaviour
     */
    QuackBehaviour quackBehaviour;

    /**
     * For different flying behaviour we have the interface flybehaviour
     */
    FlyBehaviour flyBehaviour;

    public Duck() {
    }

    public abstract void display();

    public void performFly(){
        flyBehaviour.fly();
    }
    public void performQuack(){
        quackBehaviour.quack();
    }
    public void swim(){
        System.out.println("All ducks can swim..");
    }

    public void setQuackBehaviour(QuackBehaviour qb){
        this.quackBehaviour = qb;
    }

    public void setFlykBehaviour(FlyBehaviour fb){
        this.flyBehaviour = fb;
    }


}
