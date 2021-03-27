package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
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

        userService.add(new User("Василий", "Васильев", "vasya@mail.ru"));
        userService.add(new User("Петр", "Петров", "petya@mail.ru"));
        userService.add(new User("Иван", "Иванов", "ivan@mail.ru"));
        userService.add(new User("Николай", "Сидоров", "kolya@mail.ru"));

        User user1 = new User("Иван", "Иванов", "ivan@mail.ru");
        Car car1 = new Car("Mercedes", 500);
        user1.setCar(car1);
        userService.add(user1);

        User user2 = new User("Петр", "Петров", "petya@mail.ru");
        Car car2 = new Car("Mercedes", 320);
        user2.setCar(car2);
        userService.add(user2);

        userService.getUser("Mercedes", 500);

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
