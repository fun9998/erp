package com.example.demo.utils;

import org.dmg.pmml.FieldName;
import org.dmg.pmml.PMML;
import org.jpmml.evaluator.*;
import org.jpmml.model.PMMLUtil;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class model_util {
    private Evaluator modelEvaluator;

    /**
     * 通过传入 PMML 文件路径来生成机器学习模型
     *
     * @param pmmlFileName pmml 文件路径
     */
    public model_util(String pmmlFileName) {
        System.out.println("开始加载模型");
        PMML pmml = null;
        try {
            if (pmmlFileName != null) {
                InputStream is = new FileInputStream(pmmlFileName);
                pmml = PMMLUtil.unmarshal(is);

                try {
                    is.close();
                } catch (IOException e) {
                    System.out.println("InputStream close error!");
                }

                ModelEvaluatorFactory modelEvaluatorFactory = ModelEvaluatorFactory.newInstance();

                this.modelEvaluator = (Evaluator) modelEvaluatorFactory.newModelEvaluator(pmml);
                modelEvaluator.verify();
                System.out.println("加载模型成功！");
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    // 获取模型需要的特征名称
    public List<String> getFeatureNames() {
        List<String> featureNames = new ArrayList<String>();

        List<InputField> inputFields = modelEvaluator.getInputFields();

        for (InputField inputField : inputFields) {
            featureNames.add(inputField.getName().toString());
        }
        return featureNames;
    }

    // 获取目标字段名称
    public String getTargetName() {
        return modelEvaluator.getTargetFields().get(0).getName().toString();
    }

    // 使用模型生成概率分布
    private Classification getProbabilityDistribution(Map<FieldName, ?> arguments) {
        Map<FieldName, ?> evaluateResult = modelEvaluator.evaluate(arguments);

        FieldName fieldName = new FieldName(getTargetName());

        return (Classification) evaluateResult.get(fieldName);

    }

    // 预测不同分类的概率
    public ValueMap<String, Number> predictProba(Map<FieldName, Number> arguments) {
        Classification probabilityDistribution = getProbabilityDistribution(arguments);
        return probabilityDistribution.getValues();
    }

    // 预测结果分类
    public Object predict(Map<FieldName, ?> arguments) {
        Classification probabilityDistribution = getProbabilityDistribution(arguments);

        return probabilityDistribution.getPrediction();
    }

    public static void main(String[] args) {

//        model_util knn = new model_util("G:\\model\\KNN.pmml");
        model_util decisionTree = new model_util("G:\\model\\DecisionTree.pmml");
        model_util logistic = new model_util("G:\\model\\Logistic1.pmml");

//        List<String> featureNames = knn.getFeatureNames();
//        System.out.println("feature: " + featureNames);

        // 构建待预测数据
        Map<FieldName, Number> waitPreSample = new HashMap<>();
        waitPreSample.put(new FieldName("age"), 60);
        waitPreSample.put(new FieldName("gender"), 1);
        waitPreSample.put(new FieldName("ap_hi"), 130);
        waitPreSample.put(new FieldName("ap_lo"), 60);

        waitPreSample.put(new FieldName("cholesterol"), 1);
        waitPreSample.put(new FieldName("gluc"), 1);
        waitPreSample.put(new FieldName("smoke"), 1);
        waitPreSample.put(new FieldName("alco"), 1);
        waitPreSample.put(new FieldName("active"), 0);
        waitPreSample.put(new FieldName("BMI"), 20);


//        Map<FieldName, Number> waitPreSample = new HashMap<>();
//        waitPreSample.put(new FieldName("x1"), 50);
//        waitPreSample.put(new FieldName("x2"), 1);
//        waitPreSample.put(new FieldName("x3"), 150);
//        waitPreSample.put(new FieldName("x4"), 120);
//
//        waitPreSample.put(new FieldName("x5"), 3);
//        waitPreSample.put(new FieldName("x6"), 3);
//        waitPreSample.put(new FieldName("x7"), 1);
//        waitPreSample.put(new FieldName("x8"), 1);
//        waitPreSample.put(new FieldName("x9"), 0);
//        waitPreSample.put(new FieldName("x10"), 20);


        System.out.println("waitPreSample predict result: " + decisionTree.predict(waitPreSample).toString());
//        System.out.println("waitPreSample predict result: " + knn.predict(waitPreSample).toString());
    }

}