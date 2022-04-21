package pakhmutov.bullscowsapp.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pakhmutov.bullscowsapp.entity.UserTry;
import pakhmutov.bullscowsapp.gameLogic.NumberGenerator;
import pakhmutov.bullscowsapp.service.GameService;
import pakhmutov.bullscowsapp.service.LadderService;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bc/game")
public class GameController {
    private final GameService gameService;
    private final LadderService ladderService;

    private static int COUNT;
    private static final int MAGICINT = 4;
    private static final List<Integer> SAMPLE = NumberGenerator.generateNumber(MAGICINT);
    private final List<UserTry> userTrys = new ArrayList<>();
    private String username;

    /**
     * Метод, добавляющий в модель число - разрядность для загаданного числа
     * @return число, устанавливающее "сложность задачи" - именно такая разрядность будет у загаданного числа и,
     * следовательно, столько чисел предстоит угадывать
     */
    @ModelAttribute("magicInt")
    public int getMagicInt() {
        return MAGICINT;
    }

    /**
     * Метод, добавляющий в модель загаданное число
     * @return образец для сравнения
     */
    @ModelAttribute("sample")
    public List<Integer> generate() {
        return SAMPLE;
    }

    /**
     * Метод, добавляющий в модель имя текущего пользователя
     * @return имя пользователя, переданное из UsersController
     */
    @ModelAttribute("username")
    public String getUsername(Model model) {
        if (username == null) username = (String) model.getAttribute("usernameFromUsersController");
        return username;
    }

    /**
     * Метод, возвращающий главную страницу игры
     * @return главная страница игры
     */
    @GetMapping
    public String getGame(Model model) {
        model.addAttribute("userTrys", userTrys);
        return "game";
    }

    /**
     * Метод для проверки соответствия загаданного числа и числа, введённого пользователем
     * @param sample образец для сравнения
     * @param userNumberStr комбинация цифр, введённая пользователем в виде строки
     * @return страница окончания игры, если пользователь отгадал заданное число
     */
    @PostMapping("/check")
    public String goCheck(@RequestParam(value = "userNumberStr") String userNumberStr,
                          @ModelAttribute("sample") List<Integer> sample) {
        COUNT++;
        String animalCode = gameService.check(userNumberStr, sample);

        UserTry userTry = new UserTry(userNumberStr, animalCode);
        userTrys.add(userTry);

        if (animalCode.equals("4Б0К"))
            return "redirect:/bc/game/endGame";
        else return "redirect:/bc/game";
    }

    /**
     * Метод возвращающий страницу поздравления с угадыванием загаданного числа
     * @param username имя пользователя
     * @param sample образец для сравнения
     * @return страница окончания игры с сылкой на рейтинговую таблицу
     */
    @GetMapping("/endGame")
    public String end(@ModelAttribute("username") String username,
                      @ModelAttribute("sample") final List<Integer> sample, Model model) {
        StringBuilder sb = new StringBuilder();
        sb.append("Поздравляем, ")
                .append(username)
                .append("! Вы угадали число ");
        sample.forEach(sb::append);
                sb.append(" c ")
                .append(COUNT)
                .append(" попытки!");
        model.addAttribute("victoryMassage", sb.toString());
        ladderService.addInLadder(username, COUNT);
        return "endGame";
    }
}
