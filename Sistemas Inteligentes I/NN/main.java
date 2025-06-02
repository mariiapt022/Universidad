package benchmark;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.encog.Encog;
import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.engine.network.activation.ActivationTANH;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;

public class main {
	public static void main (String[] args) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter("output.txt");
		
		
		double[][] t = Generate.generaMatrix();
		double[][] val = Generate.generaMatrix();
		double[][] tRes = new double[1000][1];
		double[][] valRes = new double[1000][1];
		
		for (int i=0; i<1000; i++) {
			tRes[i][0] = Generate.generaF(t[i][0], t[i][1]);
			valRes[i][0] = Generate.generaF(val[i][0], val[i][1]);
		}
		
		BasicNetwork net = new BasicNetwork();
		
		net.addLayer(new BasicLayer(new ActivationTANH(), true, 2));
		net.addLayer(new BasicLayer(new ActivationTANH(), true, 14));
		net.addLayer(new BasicLayer(new ActivationTANH(), true, 1));
		net.getStructure().finalizeStructure();
		net.reset();
		
		MLDataSet trainSet = new BasicMLDataSet(t, tRes);
		MLDataSet validationSet = new BasicMLDataSet(val, valRes);
		
		final ResilientPropagation train = new ResilientPropagation(net, trainSet);
		
		int epoch = 1;
		
		do {
			train.iteration();
			pw.append("Epoch #" + epoch + " TrainingError:" + train.getError() + "\n");
			System.out.println("Epoch #" + epoch + " TrainingError:" + train.getError());
			
			pw.append("Epoch #" + epoch + " ValidationError:" +  MSE(net, validationSet) + "\n");
			System.out.println("Epoch #" + epoch + " ValidationError:" +  MSE(net, validationSet));
			
			epoch++;
		} while (train.getError() > 0.01);
		
		train.finishTraining();
		
		double [][] tsamp = Generate.generagrid();
		double [][] tsampRes = new double[10000][1];
		for (int i=0; i<10000; i++) {
			tsampRes[i][0] = Generate.generaF(tsamp[i][0], tsamp[i][1]);
		}
		MLDataSet tsampSet = new BasicMLDataSet(tsamp, tsampRes);
		System.out.println("The mean squared error for the test samples is: " + MSE(net, tsampSet)/10);
		pw.append("The mean squared error for the test samples is: " + MSE(net, tsampSet)/10);
		pw.close();
		
		Encog.getInstance().shutdown();
	}
	
	public static double MSE(BasicNetwork net, MLDataSet Set) {
		double error = 0;
		for (MLDataPair pair: Set) {
			final MLData output = net.compute(pair.getInput());
			error += Math.pow(output.getData(0) - pair.getIdeal().getData(0), 2);
		}
		
		return error/1000;
	}
}
