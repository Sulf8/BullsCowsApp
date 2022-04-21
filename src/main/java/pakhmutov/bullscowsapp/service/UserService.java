package pakhmutov.bullscowsapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pakhmutov.bullscowsapp.entity.User;
import pakhmutov.bullscowsapp.repositories.UsersRepository;
import java.util.List;

/**
 * взаимодействие с пользователями
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UsersRepository usersRepository;

    /**
     * Метод, показывающий таблицу со всеми пользователями
     * @return список всех пользователей
     */
    //@Query (value = "SELECT * FROM Users", nativeQuery = true)
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    /**
     * Метод, показывающий запись таблицы с конкретным пользователем
     * @param userName имя пользователя
     * @return пользователь с данным именем
     */
    //@Query(value = "SELECT * FROM Users u WHERE u.username = :userName", nativeQuery = true)
    public User getUser(String userName) {
        return usersRepository.findById(userName).orElse(null);
    }

    /**
     * Метод, добавляющий пользователю в таблицу пользователей
     * @param user пользователь, которого необходимо добавить в базу данных
     */
    //@Query (value = "INSERT INTO Users VALUES (#{user.getUsername()}, #{user.getPassword()})", nativeQuery = true)
    public void addUser(User user) {
        usersRepository.save(user);
    }


}
