package factory;

public class VehicleFactory<T> {

    private static VehicleFactory factory_instance = null;

    public static VehicleFactory getInstance(){
        if(factory_instance == null){
            factory_instance = new VehicleFactory();
            return factory_instance;
        }
        return factory_instance;
    }


    public T getVehicle(String className){
        Package pack = this.getClass().getPackage();
        String packageName = pack.getName();
        try {
            T object = (T) Class.forName(packageName+"."+className).newInstance();
            return object;
        } catch (InstantiationException e) {
            System.out.println("I can't find any class");
        } catch (IllegalAccessException e) {
            System.out.println("Illegal access to the class");
        } catch (ClassNotFoundException e) {
            System.out.println("I can't find any class");
        }
    return null;
    }
}
