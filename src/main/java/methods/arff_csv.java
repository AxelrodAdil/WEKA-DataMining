package methods;

import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.CSVSaver;

import java.io.File;

public class arff_csv {
    public static void method(){
        try{
            ArffLoader loader = new ArffLoader();
            loader.setSource(new File("Path... \\src\\main\\resources\\weather.nominal_copy.arff"));
            Instances data = loader.getDataSet();

            CSVSaver saver = new CSVSaver();
            saver.setInstances(data);
            saver.setFile(new File("Path... \\src\\main\\resources\\weather.nominal_csv.csv"));
            saver.writeBatch();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}