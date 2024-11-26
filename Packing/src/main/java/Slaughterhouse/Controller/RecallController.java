package Slaughterhouse.Controller;

import Slaughterhouse.Entities.Recall;
import Slaughterhouse.Service.RecallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recalls")
public class RecallController {

    @Autowired
    private RecallService recallService;

    @PostMapping("/{animalId}")
    public ResponseEntity<Recall> initiateRecall(@PathVariable Integer animalId) {
        Recall recall = recallService.initiateRecall(animalId);
        return ResponseEntity.ok(recall);
    }
}
