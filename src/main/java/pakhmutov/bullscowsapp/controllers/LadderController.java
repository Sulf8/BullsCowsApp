package pakhmutov.bullscowsapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pakhmutov.bullscowsapp.service.LadderService;

/**
 * контроллер для рейтинговой таблицы
 */
@Controller
@RequestMapping("/bc/ladder")
public class LadderController {
    private final LadderService ladderService;

    public LadderController(LadderService ladderService) {
        this.ladderService = ladderService;
    }

    /**
     * @param name текущий пользователь
     * @return рейтинговая таблица
     */
    @GetMapping()
    public String showLadder(@ModelAttribute("name")String name, Model model) {
        //TODO делать акцент на игроке
        model.addAttribute("ladder", ladderService.showLadder());
        return "ladder";
    }
}
