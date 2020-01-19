package rc.bootsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import rc.bootsecurity.entity.User;
import rc.bootsecurity.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User nazmul = new User("nazmul", "nazmul123", "USER","");
        User admin = new User("admin", "admin123", "ADMIN", "ACCESS_TEST1, ACCESS_TEST2");
        User manager = new User("manager", "manager123", "MANAGER", "ACCESS_TEST1");

        List<User> users = Arrays.asList(nazmul, admin, manager);

        // save to db
        this.userRepository.saveAll(users);
    }
}
