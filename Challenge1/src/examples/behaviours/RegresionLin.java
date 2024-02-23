package examples.behaviours;

public class RegresionLin {
    private double beta0;
    private double beta1;

    public RegresionLin(DataSet dataSet) {
        double[] xData = dataSet.getXData();
        double[] yData = dataSet.getYData();
        calcularParametros(xData, yData);
    }

    private void calcularParametros(double[] xData, double[] yData) {
        int n = xData.length;
        double sumX = 0;
        double sumY = 0;
        double sumXY = 0;
        double sumX2 = 0;

        for (int i = 0; i < n; i++) {
            sumX += xData[i];
            sumY += yData[i];
            sumXY += xData[i] * yData[i];
            sumX2 += xData[i] * xData[i];
        }

        beta1 = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        beta0 = (sumY - beta1 * sumX) / n;
    }

    public double predecir(double x) {
        return beta0 + beta1 * x;
    }

    public void imprimirEcuacion() {
        System.out.printf("Ecuación de Regresión: Y = %.2f + %.2fX\n", beta0, beta1); //precision de decimales
    }
}