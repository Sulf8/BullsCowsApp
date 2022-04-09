package pakhmutov.bullscowsapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
     * @return страница авторизации/регистрации пользователя
     */
    @GetMapping()
    public String start(@ModelAttribute("user") User user) {
        return "authorization";
    }

    /**
     * @param user пользователь с введёнными в форме именем и паролем, причём  проверяется
     *             есть ли пользователь с таким именем в базе, если нет - регистрирует,
     *             если да - проверяется правильность пароля.
     * @return поле с игрой при регистрации нового пользователя
     * или вводе правильного пароля зарегистрированного ранее пользователя
     */
    //если выдепять метод validatePass(User user),то не вполне очевидно где он вообще должен находиться:
    //в контроллере или сервисе. Предпочёл написать всю логику в одном методе
    @PostMapping
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model,
                         @ModelAttribute("username") final String username, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) return "authorization";

        if (userService.getUser(user.getUsername()) == null) {
            userService.addUser(user);
            //делаем атрибут доступным для других контроллеров
            redirectAttributes.addFlashAttribute("username", user.getUsername());//??
            return "redirect:/bc/game";
        } else if (!userService.getUser(user.getUsername()).getPassword().equals(user.getPassword())) {
            return "redirect:/bc";
        } else {
            //делаем атрибут доступным для других контроллеров
            redirectAttributes.addFlashAttribute("username", user.getUsername());
            return "redirect:/bc/game";
        }
    }
}
