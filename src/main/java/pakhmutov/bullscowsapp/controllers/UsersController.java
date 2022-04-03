package pakhmutov.bullscowsapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pakhmutov.bullscowsapp.entity.User;
import pakhmutov.bullscowsapp.service.UserService;

import javax.validation.Valid;

/**
 * контроллер операций с пользователями
 */
@Controller
@RequestMapping("/bc")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    /**
     * вызывается после нажатия на кнопке "submit".
     * @param user пользователь с введёнными в форме именем и паролем, причём  проверяется
     *             есть ли пользователь с таким именем в базе, если нет - регистрирует,
     *             если да - проверяется правильность пароля.
     * @return поле с игрой при регистрации нового пользователя
     * или правильном пароле зарегистрированного ранее пользователя
     */
    //если выдепять метод validatePass(User user),то не вполне очевидно где он вообще должен находиться:
    //в контроллере или сервисе. Предпочёл написать всю логику в одном методе
    @PostMapping
    public String create(@RequestBody @Valid User user, Model model) {
        if (userService.getUser(user.getUsername()) == null) {
            userService.addUser(user);
            model.addAttribute("name", user.getUsername());
        } else if (!userService.getUser(user.getUsername()).getPassword().equals(user.getPassword())) {
            model.addAttribute("errorPass", "Неверный пароль!");
            return "redirect:/bc";
        } else model.addAttribute("name", user.getUsername());
        return "redirect:/bc/game";
    }
}
