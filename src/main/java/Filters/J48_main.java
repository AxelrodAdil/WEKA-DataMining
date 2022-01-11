package Filters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;

public class J48_main {
    public static void method(){
        try{
            //create J48_main classifier by creating object of J48_main class
            J48 j48Classifier = new J48();
            String breastCancerDataset_path = "Path... \\Weka-3-8-5\\data\\diabetes.arff";
            Instances datasetInstances = new Instances(new BufferedReader(new FileReader(breastCancerDataset_path)));

            //Target Class
            datasetInstances.setClassIndex(datasetInstances.numAttributes() - 1);

            // Evaluating by creating object of Evaluation class
            Evaluation evaluation = new Evaluation(datasetInstances);

            // Cross Validate Model with 10 folds
            evaluation.crossValidateModel(j48Classifier, datasetInstances, 10, new Random(1));
            System.out.println(evaluation.toSummaryString("\nResults", false));
        } catch (Exception e){
            System.err.println("Error Occurred!!!! \n" + e.getMessage());
        }
    }
}