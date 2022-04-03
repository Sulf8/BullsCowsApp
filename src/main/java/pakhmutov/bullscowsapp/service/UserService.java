package pakhmutov.bullscowsapp.service;

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

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * @return список имён всех пользователей
     */
    //TODO проверить nativeQuery
    //@Query (value = "SELECT username FROM Users ", nativeQuery = true)
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    //@Query(value = "SELECT username FROM Users u WHERE u.username = :userName", nativeQuery = true)
    public User getUser(String userName) {
        return usersRepository.findById(userName).orElse(null);
    }

    //@Query (value = "INSERT INTO Users VALUES (#{user.getUsername()}, #{user.getPassword()})", nativeQuery = true)
    public void addUser(User user) {
        usersRepository.save(user);
    }


}
