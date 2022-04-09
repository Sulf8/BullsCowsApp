package pakhmutov.bullscowsapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pakhmutov.bullscowsapp.entity.Game;
import pakhmutov.bullscowsapp.entity.User;
import pakhmutov.bullscowsapp.service.GameService;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/bc/game")
public class GameController {
    private final GameService gameService;
    private static int COUNT;
    final static List<Integer> userNumber = new ArrayList<>();
    /**
     * число, устанавливающее "сложность задачи" - именно такая разрядность будет у загаданного числа и, следовательно,
     * столтько чисел предстоит угадывать
     */
    final static int magicInt = 4;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @ModelAttribute("magicInt")
    public int getMagicInt(){
        return magicInt;
    }

    /**
     * {@Link pakhmutov.bullscowsapp.gameLogic.NumberGenerator#generateNumber(int) generateNumber}
     */
    @ModelAttribute("sample")
    public List<Integer> generate() {
        return gameService.generate(magicInt);
    }

    /**
     * @return список значений кнопок выбора при угадывании числа
     */
    @ModelAttribute("listForChoice")
    public List<Integer> listForChoice() {
        return new LinkedList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    /**
     * @return главная страница игры
     */
    @GetMapping
    public String getGame(@ModelAttribute("username") final String username, Model model) {
        //model.addAttribute("authorizationUsername", username);
        return "game";
    }

    @PostMapping
    public String getTry(@RequestParam(value = "oneOfNumber") @NotEmpty int oneOfNumber, Model model) {
        if (userNumber.size() != magicInt) {
            userNumber.add(oneOfNumber);
            return null;//что вернуть?????????????????????????????????????????
        } else return "redirect:/bc/game/check";

        //@SuppressWarnings("unchecked")//некрасиво
        List<Integer> sampleList = (List<Integer>) model.getAttribute("sample");

        String animalCode = gameService.check(userNumber, sampleList);
        gameService.addTry((String) model.getAttribute("username"), userNumber, animalCode);
        if (animalCode.equals("4Б0К")) return "redirect:/bc/game/endGame";
        return null;
    }


    @PostMapping("/check")
    public String check(@ModelAttribute("name") String name, @RequestBody List<Integer> userNumber,
                        @ModelAttribute("number") List<Integer> sample, Model model) {
        COUNT++;
        gameService.addTry(name, userNumber, gameService.check(userNumber, sample));
        if (gameService.check(userNumber, sample).equals("4Б0К")) return "redirect:/bc/game/endGame";
            //TODO вот тут явно неправильно, поскольку нужно как-то обновлять UserNumber
        else return "redirect:/bc/game/check";

    }

    /**
     * @return страница окончания игры с сылкой на рейтинговую таблицу
     */
    @GetMapping("/endGame")
    public String end(Model model) {
        StringBuilder sb = new StringBuilder();
        sb.append("Поздравляем, ")
                .append(model.addAttribute("username"))
                .append("! Вы угадали число ")
                .append(model.getAttribute("number"))
                .append(" c ")
                .append(COUNT)
                .append(" попытки!");
        model.addAttribute("victoryMassage", sb.toString());
        return "endGame";
    }


}
