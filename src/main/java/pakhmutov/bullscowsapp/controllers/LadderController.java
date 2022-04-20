package pakhmutov.bullscowsapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pakhmutov.bullscowsapp.entity.LadderAVG;
import pakhmutov.bullscowsapp.service.LadderService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        //model.addAttribute("ladder", ladderService.showLadderWithAVG());
        //TODO убрать!
        model.addAttribute("ladder2", ladderService.showLadder());
        return "ladder";
    }
}
