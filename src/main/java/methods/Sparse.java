package methods;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.instance.NonSparseToSparse;

import java.io.File;

public class Sparse {
    public static void method(){
        try{
            DataSource source = new DataSource("Path... \\Weka-3-8-5\\data\\cpu.arff");
            Instances dataset = source.getDataSet();
            NonSparseToSparse sp = new NonSparseToSparse();
            sp.setInputFormat(dataset);

            Instances newData = Filter.useFilter(dataset, sp);
            ArffSaver saver = new ArffSaver();
            saver.setInstances(newData);
            saver.setFile(new File("Path... \\src\\main\\resources\\sparse_arff.arff"));
            saver.writeBatch();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}