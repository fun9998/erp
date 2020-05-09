package com.example.demo.service.Impl;

import com.example.demo.model.Cardio_plus;
import com.example.demo.service.PredictService;
import com.example.demo.utils.model_util;
import org.dmg.pmml.FieldName;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PredictServiceImpl implements PredictService {
//    model_util knn = new model_util("G:\\model\\KNN.pmml");
    model_util logistic = new model_util("G:\\model\\Logistic1.pmml");
    model_util decisionTree = new model_util("G:\\model\\DecisionTree.pmml");


    @Override
    public String predict(Cardio_plus cardio_plus) {

        // 构建待预测数据
/*        Map<FieldName, Number> waitPreSample = new HashMap<>();
        waitPreSample.put(new FieldName("age"), ( cardio_plus.getAge() - 53.33682 ) / 6.76359 );
        waitPreSample.put(new FieldName("gender"), (cardio_plus.getGender() - 1.34979 ) / 0.47690);
        waitPreSample.put(new FieldName("ap_hi"), ( cardio_plus.getAp_hi() / 128.636307 ) / 150.03478 );
        waitPreSample.put(new FieldName("ap_lo"), ( cardio_plus.getAp_lo() - 96.93116 ) / 192.86259);
        waitPreSample.put(new FieldName("cholesterol"), ( cardio_plus.getCholesterol() - 1.36652 ) / 0.67995);
        waitPreSample.put(new FieldName("gluc"), ( cardio_plus.getGluc() - 1.22759 ) /  0.57356);
        waitPreSample.put(new FieldName("smoke"), ( cardio_plus.getSmoke() - 0.088125 ) / 0.28347);
        waitPreSample.put(new FieldName("alco"), ( cardio_plus.getAlco() - 0.054565 ) / 0.22713);
        waitPreSample.put(new FieldName("active"), ( cardio_plus.getActive() - 0.80412 ) / 0.39687);
        waitPreSample.put(new FieldName("BMI"), ( cardio_plus.getBmi() - 0.274795 ) / 5.20665);*/


        Map<FieldName, Number> waitPreSample = new HashMap<>();
        waitPreSample.put(new FieldName("x1"), ( cardio_plus.getAge() - 53.33682 ) / 6.76359 );
        waitPreSample.put(new FieldName("x2"), (cardio_plus.getGender() - 1.34979 ) / 0.47690);
        waitPreSample.put(new FieldName("x3"), ( cardio_plus.getAp_hi() / 128.636307 ) / 150.03478 );
        waitPreSample.put(new FieldName("x4"), ( cardio_plus.getAp_lo() - 96.93116 ) / 192.86259);
        waitPreSample.put(new FieldName("x5"), ( cardio_plus.getCholesterol() - 1.36652 ) / 0.67995);
        waitPreSample.put(new FieldName("x6"), ( cardio_plus.getGluc() - 1.22759 ) /  0.57356);
        waitPreSample.put(new FieldName("x7"), ( cardio_plus.getSmoke() - 0.088125 ) / 0.28347);
        waitPreSample.put(new FieldName("x8"), ( cardio_plus.getAlco() - 0.054565 ) / 0.22713);
        waitPreSample.put(new FieldName("x9"), ( cardio_plus.getActive() - 0.80412 ) / 0.39687);
        waitPreSample.put(new FieldName("x10"), ( cardio_plus.getBmi() - 0.274795 ) / 5.20665);

        Map<FieldName, Number> waitPreSample1 = new HashMap<>();
        waitPreSample1.put(new FieldName("age"), cardio_plus.getAge() );
        waitPreSample1.put(new FieldName("gender"), cardio_plus.getGender()  );
        waitPreSample1.put(new FieldName("ap_hi"),  cardio_plus.getAp_hi() );
        waitPreSample1.put(new FieldName("ap_lo"), cardio_plus.getAp_lo());
        waitPreSample1.put(new FieldName("cholesterol"),  cardio_plus.getCholesterol() );
        waitPreSample1.put(new FieldName("gluc"),  cardio_plus.getGluc());
        waitPreSample1.put(new FieldName("smoke"),  cardio_plus.getSmoke());
        waitPreSample1.put(new FieldName("alco"),  cardio_plus.getAlco());
        waitPreSample1.put(new FieldName("active"),  cardio_plus.getActive());
        waitPreSample1.put(new FieldName("BMI"),  cardio_plus.getBmi());



//        int knn_result = Integer.parseInt( knn.predict(waitPreSample).toString() );
        int logistic_result = Integer.parseInt(logistic.predict(waitPreSample1).toString());
        int decisionTree_result = Integer.parseInt( decisionTree.predict(waitPreSample).toString());

//        System.out.println("KNN predict result: " + knn_result);
        System.out.println("logistic predict result: " + logistic_result);
        System.out.println("decisionTree predict result: " + decisionTree_result);
//        if ( (logistic_result + decisionTree_result + knn_result) > 1.5 ){
        if ( (logistic_result + decisionTree_result ) > 1 ){
            return "经过我们的模型评测，您患有心血管疾病的风险 较高，建议及时医治。";
        }else {
            return "经过我们的模型评测，您患有心血管疾病的风险 较低。";
        }

    }
}
