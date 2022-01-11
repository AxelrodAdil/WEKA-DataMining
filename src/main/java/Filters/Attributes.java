package Filters;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import java.io.File;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class Attributes {
    public static void method(){
        try {
            DataSource source = new DataSource("Path... \\src\\main\\resources\\weather.nominal_copy.arff");
            Instances dataset = source.getDataSet();
            String[] options = new String[]{"-R", "1"};
            Remove remove = new Remove();
            remove.setOptions(options);
            remove.setInputFormat(dataset);
            Instances newData = Filter.useFilter(dataset, remove);

            ArffSaver saver = new ArffSaver();
            saver.setInstances(newData);
            saver.setFile(new File("Path... \\src\\main\\resources\\new_arff_filter_attributes.arff"));
            saver.writeBatch();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}