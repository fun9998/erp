package com.example.demo.controller;

import com.example.demo.model.Ap;
import com.example.demo.model.Cardio;
import com.example.demo.model.Cardio_plus;
import com.example.demo.service.ApService;
import com.example.demo.service.PredictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PerdictController {
    @Autowired
    private PredictService predictService;

    @RequestMapping("/predict")
    @ResponseBody
    public String all(Cardio cardio){
        System.out.println(cardio);
        double bml = cardio.getWeight()/( cardio.getHeight() * cardio.getHeight() / 10000 );
        System.out.println(bml);
        Cardio_plus cardio_plus = new Cardio_plus(cardio.getId(), cardio.getAge(), cardio.getGender(), cardio.getHeight(), cardio.getWeight(),
                cardio.getAp_hi(), cardio.getAp_lo(), cardio.getCholesterol(), cardio.getGluc(), cardio.getSmoke(), cardio.getGluc(), cardio.getActive(), cardio.getCardio(), bml);
        return predictService.predict(cardio_plus);
    }

}
