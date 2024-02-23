package examples.behaviours;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

import java.util.Scanner;

public class OneShotAgent extends Agent {

    protected void setup() {
        System.out.println("Agent "+getLocalName()+" started.");
        addBehaviour(new MyOneShotBehaviour());
    }

    private class MyOneShotBehaviour extends OneShotBehaviour {

        public void action() {

            double[] xData = {23,26,30,34,43,48,52,57,58};
            double[] yData = {651,762,856,1063,1190,1298,1421,1440,1518};

            DataSet dataSet = new DataSet(xData, yData);
            RegresionLin modelo = new RegresionLin(dataSet);
            modelo.imprimirEcuacion();

            Scanner scanner = new Scanner(System.in);
            double[] valoresX = new double[10];
            double[] valoresY = new double[10];

            for (int i = 0; i < 10; i++) {
                System.out.printf("Ingrese el valor %d de X a calcular: ", i + 1); //de caracter Double
                valoresX[i] = scanner.nextDouble();
                valoresY[i] = modelo.predecir(valoresX[i]);
                System.out.printf("Para X=%.2f, se predice Y=%.2f\n", valoresX[i], valoresY[i]);
            }


        }

        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }
    }    // END of inner class ...Behaviour
}