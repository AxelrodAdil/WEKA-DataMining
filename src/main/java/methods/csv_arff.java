package methods;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import java.io.File;

public class csv_arff {
    public static void method(){
        try{
            StringBuilder sb = new StringBuilder();
            CSVLoader loader = new CSVLoader();
            loader.setSource(new File("Path... \\src\\main\\resources\\weather.nominal_csv.csv"));
            Instances data = loader.getDataSet();

            ArffSaver saver = new ArffSaver();
            saver.setInstances(data);
            saver.setFile(new File("Path... \\src\\main\\resources\\weather.nominal_arff.arff"));
            saver.writeBatch();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}