package Filters;

import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public class IBK_KNN {
    public static void method(){
        try{
            IBk Ibk_Knn_classifier = new IBk();
            String _path = "Path... \\Weka-3-8-5\\data\\contact-lenses.arff";
            Instances datasetInstances = new Instances(new BufferedReader(new FileReader(_path)));

            //Target Class
            datasetInstances.setClassIndex(datasetInstances.numAttributes() - 1);

            // Evaluating by creating object of Evaluation class
            Evaluation evaluation = new Evaluation(datasetInstances);

            // Cross Validate Model with 10 folds
            evaluation.crossValidateModel(Ibk_Knn_classifier, datasetInstances, 10, new Random(1));
            System.out.println(evaluation.toSummaryString("\nResults", false));
        } catch (Exception e){
            System.err.println("Error Occurred!!!! \n" + e.getMessage());
        }
    }
}