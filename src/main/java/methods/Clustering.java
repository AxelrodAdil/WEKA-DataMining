package methods;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;

public class Clustering {
    public static void method() {
        try {
            String dataset = "Path... \\Weka-3-8-5\\data\\diabetes.arff";
            DataSource source = new DataSource(dataset);
            Instances data = source.getDataSet();

            SimpleKMeans model = new SimpleKMeans();
            model.setNumClusters(2);

            //set distance
            //model.setDistanceFunction(new weka.core.ManhattanDistance());

            model.buildClusterer(data);
            System.out.println(model);


            ClusterEvaluation clusterEvaluation = new ClusterEvaluation();
            clusterEvaluation.setClusterer(model);
            clusterEvaluation.evaluateClusterer(data);
            System.out.println("Cluster: " + clusterEvaluation.getNumClusters());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}