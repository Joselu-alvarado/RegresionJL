package examples.behaviours;

public class DataSet {
    private double[] xData;
    private double[] yData;

    public DataSet(double[] xData, double[] yData) {
        this.xData = xData;
        this.yData = yData;
    }

    public double[] getXData() {
        return xData;
    }

    public double[] getYData() {
        return yData;
    }
}