package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> loginDto() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"goodwin49@mail.ru", "Car12345"});
        list.add(new Object[]{"goodwin49@mail.ru", "Car12345"});
        list.add(new Object[]{"goodwin49@mail.ru", "Car12345"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginModelDto() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("goodwin49@mail.ru").withPassword("Car12345")});
        list.add(new Object[]{new User().withEmail("goodwin49@mail.ru").withPassword("Car12345")});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationDto() {
        List<Object[]> list = new ArrayList<>();

        for (int j = 0; j < 2; j++) {
            int i = (int) (Math.random() * 1000);
            list.add(new Object[]{new User().withEmail("asdh" + i + "@gmail.com").withPassword("Qwery1234").withName("Ilia")
                    .withLastname("Petrov")});

        }

        return list.iterator();

    }

}
