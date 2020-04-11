package user;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Jdbi jdbi = Jdbi.create("jdbc:h2:mem:test"); // (H2 in-memory database)
        jdbi.installPlugin(new SqlObjectPlugin());
        try (Handle handle = jdbi.open()) {
            UserDao dao = handle.attach(UserDao.class);

            User user = User.builder()
                    .id(Long.valueOf(1))       //???????????
                    .username("Pinky")
                    .password("PinkyMouse")
                    .name("Miss Pink")
                    .email("pinky@vmi.hu")
                    .gender(User.Gender.FEMALE)
                    .dob(LocalDate.parse("2020-04-10"))
                    .enabled(true)
                    .build();

            dao.createTable();
            dao.insert(user);
            dao.findById(user.getId());  //?????????
            dao.findByUsername(user.getUsername());     //????????????

            System.out.println(user); ///???
            dao.list();
            dao.list().stream().forEach(System.out::println);
            dao.delete(user);

        }
    }
}