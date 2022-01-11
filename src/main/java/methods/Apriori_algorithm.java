package methods;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.associations.Apriori;

public class Apriori_algorithm {
    public static void method(){
        try {
            // weka.associations.Apriori: Cannot handle numeric attributes!
            String dataset = "Path... \\Weka-3-8-5\\data\\weather.nominal.arff";
            DataSource source = new DataSource(dataset);
            Instances data = source.getDataSet();
            System.out.println(data.toSummaryString());
            System.out.println("----------------------------");
            Apriori model = new Apriori();
            model.buildAssociations(data);
            System.out.println(model);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}