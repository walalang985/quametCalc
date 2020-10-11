package quametCalculator;
public class dataRanks{
    public double percentile(double perc, double[] data) throws IllegalArgumentException{
		int numdata = data.length + 1;
		if(perc >= 100 || perc <=1) {
			throw new IllegalArgumentException("");
		}
		double c = perc * numdata/100;
		int d = (int) c;
		double e = c - (double) d;
		double f = data[d-1];
		return f + (e * (data[d] - f));
	}
	public double decile(double dec, double[] data) throws IllegalArgumentException{
		int numdata = data.length + 1;
		if(dec >= 10|| dec <= 1) {
			throw new IllegalArgumentException("");
		}
		double c = dec * numdata/10;
		int d = (int) c;
		double e = c - (double) d;
		double f = data[d-1];
		return f + (e * (data[d] - f));
	}
	public double quartile(double quart, double[] data) throws IllegalArgumentException{
		int numdata = data.length + 1;
		if(quart >= 10|| quart < 1) {
			throw new IllegalArgumentException("");
		}
		double c = quart * numdata/4;
		int d = (int) c;
		double e = c - (double) d;
		double f = data[d-1];
		return f + (e * (data[d] - f));
	}
}
