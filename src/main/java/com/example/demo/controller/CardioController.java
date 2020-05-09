package com.example.demo.controller;

import com.example.demo.model.Cardio;
import com.example.demo.model.Cardio_plus;
import com.example.demo.service.CardioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cardio")
public class CardioController {
    @Autowired
    private CardioService cardioService;

    @RequestMapping("/all")
    @ResponseBody
    public List<Cardio_plus> all(){
        List<Cardio> cardios = cardioService.all();
        ArrayList<Cardio_plus> cardio_pluses = new ArrayList<>();
        for (Cardio ca:cardios
             ) {
            double bml = ca.getWeight()/( ca.getHeight() * ca.getHeight() / 10000 );
            Cardio_plus cardio_plus = new Cardio_plus(ca.getId(), ca.getAge(), ca.getGender(), ca.getHeight(), ca.getWeight(),
                    ca.getAp_hi(), ca.getAp_lo(), ca.getCholesterol(), ca.getGluc(), ca.getSmoke(), ca.getGluc(), ca.getActive(), ca.getCardio(), bml);
            cardio_pluses.add(cardio_plus);
        }
        return cardio_pluses;
    }

}
