package hiber;

import hiber.config.AppConfig;
import hiber.dao.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car car1 = new Car("Mersedes", 500);
        Car car2 = new Car("Mersedes", 320);
        Car car3 = new Car("Mersedes", 600);
        Car car4 = new Car("Mersedes", 180);

        User user1 = new User("Василий", "Васильев", "vasya@mail.ru");
        user1.setCar(car1);
        userService.add(user1);

        User user2 = new User("Петр", "Петров", "petya@mail.ru");
        user2.setCar(car2);
        userService.add(user2);

        User user3 = new User("Иван", "Иванов", "ivan@mail.ru");
        user3.setCar(car3);
        userService.add(user3);

        User user4 = new User("Коля", "Сидоров", "kolya@mail.ru");
        user4.setCar(car4);
        userService.add(user4);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car_Id = " + user.getCar());
            System.out.println();
        }
        context.close();
    }
}
