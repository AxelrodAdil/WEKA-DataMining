package methods;

import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;

import java.io.File;

public class SelectionAttr {
    public static void method(){
        try{
            DataSource source = new DataSource("Path... \\Weka-3-8-5\\data\\labor.arff");
            Instances dataset = source.getDataSet();

            AttributeSelection filter = new AttributeSelection();
            CfsSubsetEval evaluator = new CfsSubsetEval();
            GreedyStepwise search = new GreedyStepwise();

            search.setSearchBackwards(true);
            filter.setEvaluator(evaluator);
            filter.setSearch(search);
            filter.setInputFormat(dataset);
            Instances newData = Filter.useFilter(dataset, filter);

            ArffSaver saver = new ArffSaver();
            saver.setInstances(newData);
            saver.setFile(new File("Path... \\src\\main\\resources\\Selection.arff"));
            saver.writeBatch();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}