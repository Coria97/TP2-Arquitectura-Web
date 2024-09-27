import Factory.FactoryRepository;
import Factory.MySQLFactory;

public class Main {
    public static void main(String[] args) {
        FactoryRepository dbManager = new MySQLFactory();
    }
}
