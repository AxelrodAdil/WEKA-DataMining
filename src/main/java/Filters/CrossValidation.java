package Filters;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;

import java.util.Random;

public class CrossValidation {
    public static void method(){
        try {
            DataSource source = new DataSource("Path... \\Weka-3-8-5\\data\\iris.arff");
            Instances dataset = source.getDataSet();
            System.out.println("--------------------------------------");
            System.out.println(dataset.toSummaryString());
            dataset.setClassIndex(dataset.numAttributes() - 1);

            NaiveBayes nb = new NaiveBayes();
            int seed = 1;
            int folds = 10;
            Random random = new Random(seed);

            // random dataset
            Instances randomData = new Instances(dataset);
            randomData.randomize(random);

            // stratify
            if (randomData.classAttribute().isNominal()){
                randomData.stratify(folds);
            }

            for (int i = 0; i < folds; i++) {
                Evaluation evaluation = new Evaluation(randomData);
                Instances train = randomData.trainCV(folds, i);
                Instances test = randomData.testCV(folds, i);
                nb.buildClassifier(train);
                evaluation.evaluateModel(nb, test);

                System.out.println();
                System.out.println(evaluation.toSummaryString("\nResults", false));
                /*System.out.println(evaluation.toMatrixString("Confusion matrix for fold - " + (i+1) + "/" + folds));
                System.out.println("Correct % " + evaluation.pctCorrect());
                System.out.println("Incorrect % " + evaluation.pctIncorrect());
                System.out.println("Kappa " + evaluation.kappa());
                System.out.println("MAE " + evaluation.meanAbsoluteError());
                System.out.println("RMSE " + evaluation.rootMeanSquaredError());*/
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}