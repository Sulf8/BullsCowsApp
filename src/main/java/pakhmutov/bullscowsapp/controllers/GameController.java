package pakhmutov.bullscowsapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pakhmutov.bullscowsapp.service.GameService;

import java.util.List;

@Controller
@RequestMapping("/bc/game")
public class GameController {
    private final GameService gameService;
    private static int COUNT;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }


    @ModelAttribute
    public void generate(Model model) {
        model.addAttribute("number", gameService.generate(4));

    }

    @PostMapping("/check")
    public String check(@ModelAttribute("name") String name, @RequestBody List<Integer> userNumber,
                        @ModelAttribute("number") List<Integer> sample, Model model) {
        COUNT++;
        gameService.add(name, userNumber, gameService.check(userNumber, sample));
        if (gameService.check(userNumber, sample).equals("4Б0К")) return "redirect:/bc/game/endGame";
            //TODO вот тут явно неправильно, поскольку нужно как-то обновлять UserNumber
        else return "redirect:/bc/game/check";

    }

    //TODO переписать! брать из модели, а не из запроса
    @GetMapping("/endGame")
    public String end(@RequestParam("name") String name,
                      @RequestParam("number") String number,//нужно забрать c generate
                      @RequestParam("amount") int amount,
                      Model model) {
        StringBuilder sb = new StringBuilder();
        sb.append("Поздравляем, ")
                .append(name)
                .append("! Вы угадали число ")
                .append(number)
                .append(" c ")
                .append(amount)
                .append(" попытки!");
        model.addAttribute("victoryMassage", sb.toString());
        model.addAttribute("name", name);

        return "endGame";
    }


}
