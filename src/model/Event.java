package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Event {
	private ArrayList<Evaluation> evals;
	public final static String FILE_SER = "data/info.dat";
	public final static String FILE_EXPORT = "data/report.csv";
	
	public Event() {
		this.evals = new ArrayList<Evaluation>();
	}
	public ArrayList<Evaluation> getEvals() {
		return evals;
	}
	
	public void load() throws IOException, ClassNotFoundException {
		
		File f = new File(FILE_SER);
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
		ArrayList<Evaluation> evs = (ArrayList<Evaluation>)ois.readObject();
		if(evs !=null) {
			evals = evs;
			ois.close();
		}
	}
	public void save() throws FileNotFoundException, IOException {
		File f = new File(FILE_SER);
		ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(evals);
		oos.close();
		
	}
	
	public void exportCSV() throws FileNotFoundException, IOException {
		File f = new File(FILE_EXPORT);
		FileWriter fw = new FileWriter(f);
		PrintWriter pw = new PrintWriter(f);
		//BufferedWriter bw = new BufferedWriter(fw);
		String n = "";
		for (int i = 0; i < evals.size(); i++) {
			n += evals.get(i).getGrade() + "\t" +evals.get(i).getComments()+"\t\n";
		}
		pw.print(n);
		fw.close();
		pw.close();
	}
}
