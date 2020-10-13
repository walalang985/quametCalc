package quametCalculator;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    static Scanner scan = new Scanner(System.in);
    static measureOfVariance a = new measureOfVariance();
    static dataRanks b = new dataRanks();
    static centralTendency c = new centralTendency();
    public static void main(String[] args) throws Exception {
        System.out.println("How big is the data set?");
        int count = scan.nextInt(), ctr = 1;
        System.out.println("Please enter " +count + " data/s");
        double data[] = new double[count];
        for(int i = 0; i < count;i++) {
            System.out.println("Enter data number: " + ctr);
            data[i] = scan.nextDouble();
            ctr++;
        }
        Arrays.sort(data);
        System.out.println("The sorted data is: ");
        for(int i = 0;i < data.length;i++) {
        	if(data[i] > (int) data[i]) {
			System.out.print(data[i] + " ");
        	}
        	else {
        		System.out.print((int)data[i]+ " ");
        	}
        }
        System.out.print("\n");
        getCentralTendency(data);
        System.out.println("What kind of ranking do you want to get");
        String rType = scan.next();
        System.out.println("At what position");
        double nth = scan.nextDouble();
        getSegmentedData(rType, nth, data);
        getMeasureOfVariance(data);
    	contSegmentedData(data);
    }
    private static void getSegmentedData(String choice, double nth, double[] data){
        switch(choice.toLowerCase()) {
		case "decile":
			System.out.println("The value at position " + nth + " is " + b.decile(nth, data));
			break;
		case "quartile":
			System.out.println("The value at position " + nth + " is " + b.quartile(nth, data));
			break;
		case "percentile":
			System.out.println("The value at position " + nth + " is " + b.percentile(nth, data));
			break;
		default:
			throw new IllegalArgumentException("wrong choice");
		}
    }
    private static void getCentralTendency(double[] data){
        double[] mode = c.mode(data);
        System.out.println("The mean is " + c.mean(data) + " \nThe median is " + c.median(data) + "\nThe mode is " + mode[1] + " which occured " + mode[0] +" times" );
        System.out.println("The geometric mean is " + c.geometricMean(data));
        System.out.println("The harmonic mean is " + c.harmonicMean(data));
    }
    private static void getMeasureOfVariance(double[] data){
        System.out.println("The range is " + a.range(data));
		System.out.println("The IQR is " + a.IQR(data));
		System.out.println("The variance is " + a.variance(data));
		System.out.println("The standard deviation is " + a.stdDev(data));
		System.out.println("The Coefficient of Variation is " + a.coeVariation(data) + "%");
    }
    private static void contSegmentedData(double[] data) throws IOException {
    	System.out.println("Do you want to get other values for segmented data?");
    	String a = scan.next();
    	switch(a.toLowerCase()) {
    	case "yes":
    		System.out.println("What kind of ranking do you want to get");
            String rType = scan.next();
            System.out.println("At what position");
            double nth = scan.nextDouble();
            if(Double.isNaN(nth)) {
            	throw new IOException("Sorry not a number");
            }
            getSegmentedData(rType, nth, data);
    	case "no":
    		System.exit(0);
    	}	
    }
}
