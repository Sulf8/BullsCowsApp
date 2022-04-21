package pakhmutov.bullscowsapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pakhmutov.bullscowsapp.entity.User;
import pakhmutov.bullscowsapp.service.UserService;

import javax.validation.Valid;

/**
 * контроллер операций с пользователями
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/bc")
public class UsersController {
    private final UserService userService;

    /**
     * Метод, возвращающий страницу авторизации пользователей
     * @return страница авторизации/регистрации пользователя
     */
    @GetMapping()
    public String start(@ModelAttribute("user") User user) {
        return "authorization";
    }

    /**
     * Метод, авторизирующий уже зарегестрированных пользователей, регистрирующий новых пользователей
     * и возвращающий основную страницу игры в случае успеха авторизщации/регистрации
     * @param user пользователь с введёнными в форме именем и паролем, причём  проверяется
     *             есть ли пользователь с таким именем в базе, если нет - регистрирует,
     *             если да - проверяется правильность пароля.
     * @return поле с игрой при регистрации нового пользователя
     * или вводе правильного пароля зарегистрированного ранее пользователя
     */
    //если выдепять метод validatePass(User user),то не вполне очевидно где он вообще должен находиться:
    //в контроллере или сервисе. Предпочёл написать всю логику в одном методе
    @PostMapping
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                         @ModelAttribute("username") final String username, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) return "authorization";

        if (userService.getUser(user.getUsername()) == null) {
            userService.addUser(user);
            //делаем атрибут доступным для других контроллеров
            redirectAttributes.addFlashAttribute("usernameFromUsersController", user.getUsername());//??
            return "redirect:/bc/game";
        } else if (!userService.getUser(user.getUsername()).getPassword().equals(user.getPassword())) {
            return "redirect:/bc";
        } else {
            //делаем атрибут доступным для других контроллеров
            redirectAttributes.addFlashAttribute("usernameFromUsersController", user.getUsername());
            return "redirect:/bc/game";
        }
    }
}
