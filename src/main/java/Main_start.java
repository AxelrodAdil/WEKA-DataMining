import methods.*;

public class Main_start {
    /**
     * https://weka.sourceforge.io/doc.dev/
     */

    public static void main(String[] args) {
        try{
            System.out.println("... methods.Loading_saving_Data.method() ...");
            Loading_saving_Data.method();
            sleep();

            System.out.println("... methods.arff_csv.method() ...");
            arff_csv.method();
            sleep();

            System.out.println("... methods.csv_arff.method() ...");
            csv_arff.method();
            sleep();

            // *** Filters ***
            System.out.println("... Filters.Attributes.method() ...");
            Filters.Attributes.method();
            sleep();

            System.out.println("... Filters.J48_main.method() ...");
            Filters.J48_main.method();
            sleep();

            System.out.println("... Filters.CrossValidation.method() ...");
            Filters.CrossValidation.method();
            sleep();

	    System.out.println("... Filters.IBK_KNN.method() ...");
            Filters.IBK_KNN.method();
            sleep();
            // *** ***

            System.out.println("... methods.Sparse.method() ...");
            Sparse.method();
            sleep();

            System.out.println("... methods.SelectionAttr.method() ...");
            SelectionAttr.method();
            sleep();

            System.out.println("... methods.Apriori_algorithm.method() ...");
            Apriori_algorithm.method();
            sleep();

            System.out.println("... methods.Clustering.method() ...");
            Clustering.method();
            sleep();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    static void sleep(){
        try{
            Thread.sleep(1000);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}