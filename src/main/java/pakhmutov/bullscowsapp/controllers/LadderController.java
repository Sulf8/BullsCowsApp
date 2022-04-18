package pakhmutov.bullscowsapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pakhmutov.bullscowsapp.service.LadderService;

/**
 * контроллер для рейтинговой таблицы
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/bc/ladder")
public class LadderController {
    private final LadderService ladderService;

    /**
     * @return рейтинговая таблица
     */
    @GetMapping()
    public String showLadder(Model model) {
        model.addAttribute("ladder", ladderService.showLadder());
        return "ladder";
    }
}
