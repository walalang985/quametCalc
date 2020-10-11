package quametCalculator;
public class measureOfVariance {
    dataRanks d = new dataRanks();
    centralTendency c = new centralTendency();
    public double range(double[] data) {
		return data[data.length - 1] - data[0];
	}
	public double IQR(double[] data) {
		double a = d.quartile(3,data), b = d.quartile(1,data);
		System.out.println(b + " " + a);
		return (a - b);
	}
	public double variance(double[] data) {
		double mean = c.mean(data);
		double[] temp = new double[data.length];
		double var = 0.0;
		for(int i = 0; i < data.length;i++) {
			temp[i] = (data[i] - mean);
		}
		for(int i = 0;i < data.length;i++) {
			var += Math.pow(temp[i], 2);
		}
		var = var / data.length - 1;
		return var;
	}
	public double stdDev(double[] data) {
		return Math.sqrt(variance(data));
	}
	public double coeVariation( double[] data ) {
		return (stdDev(data) / c.mean(data) ) * 100;
	}
}
