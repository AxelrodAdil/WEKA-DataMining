package methods;

import weka.core.Instances;
import weka.core.converters.ArffSaver;

import java.io.*;

public class Loading_saving_Data {
    public static void method(){
        try{
            StringBuilder sb = new StringBuilder();
            sb.append("weather.nominal");
            String arff_file = ".arff";
            Instances dataset = new Instances(new BufferedReader(new FileReader("Path... \\Weka-3-8-5\\data\\" + sb + arff_file)));
            System.out.println(dataset.toSummaryString());

            ArffSaver saver = new ArffSaver();
            saver.setInstances(dataset);
            sb.append("_test");
            saver.setFile(new File("Path... \\src\\main\\resources\\" + sb + arff_file));
            saver.writeBatch();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}