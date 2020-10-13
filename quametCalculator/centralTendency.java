package quametCalculator;
public class centralTendency {
    public double mean(double[] data){
        double ans = 0.0;
        for(int i = 0; i < data.length;i++) {
            ans += data[i];
        }
        return ans/(double)data.length;
    }
    public double median(double[] data){
        int temp = data.length;
        if((data.length % 2) == 1){
            return data[(temp+1)/2];
        }
        else{
           return ((data[(temp+1)/2]) + (data[((temp + 1)/2) - (1)])) / 2;
        }
    }
    public double geometricMean(double[] data){
        double temp = 1;
        for(int i = 0; i < data.length;i++){
            temp *= data[i];
        }
        return Math.pow(temp, 1.0/ (double)data.length);
    }
    public double harmonicMean(double[] data){
        double denominator = 0;
        for(int i = 0;i<data.length;i++){
            denominator += (1.0 / data[i]);
        }
        return (double) data.length/denominator;
    }
    public double[] mode(double[] data){
        double[] ans = new double[2];
        double maxValue = 0, maxCount = 0;
        for (int i = 0; i < data.length; ++i) 
        {
            int count = 0;
            for (int j = 0; j < data.length; ++j) 
            {
                if (data[j] == data[i])
                    count++;
            }
            if (count > maxCount) 
            {
                maxCount = count;
                maxValue = data[i];
            }
        }
        ans[0] = maxCount;
        ans[1] = maxValue;
        return ans;
    }
}
