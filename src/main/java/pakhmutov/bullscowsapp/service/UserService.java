package pakhmutov.bullscowsapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import pakhmutov.bullscowsapp.entity.User;
import pakhmutov.bullscowsapp.repositories.UsersRepository;

import java.util.List;

/**
 * взаимодействие с пользователями
 */
@Service
public class UserService {
    private final UsersRepository usersRepository;

    @Autowired
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * @return список всех пользователей
     */
    //@Query (value = "SELECT * FROM Users", nativeQuery = true)
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    /**
     * @param userName имя пользователя
     * @return пользователь с данным именем
     */
    //@Query(value = "SELECT * FROM Users u WHERE u.username = :userName", nativeQuery = true)
    public User getUser(String userName) {
        return usersRepository.findById(userName).orElse(null);
    }

    /**
     * @param user пользователь, которого необходимо добавить в базу данных
     * добавляет пользователя в базу данных
     */
    //@Query (value = "INSERT INTO Users VALUES (#{user.getUsername()}, #{user.getPassword()})", nativeQuery = true)
    public void addUser(User user) {
        usersRepository.save(user);
    }


}
