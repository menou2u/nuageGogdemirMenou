/**
 * 
 */
package pidr.model.historic;

import java.io.File;
import java.io.IOException;

/**
 * @author Arnault Le Prévost-Corvellec
 *
 */
public class testHistoricata {
	public static void main(String[] args) throws IOException {
		File folder = new File("output");
		folder.mkdir();
		File file = new File(folder, "test.h");
		HistoricData data = new HistoricData();
		for (int i = 0; i < 32; i++)
			data.put(new File("historicdata" + i + ".test"));
		HistoricHandler.store(data, file);
		
		
		HistoricData loadedData = HistoricHandler.load(new File("output/test.h"));
		for(String path : loadedData.paths){
			System.out.println(path);
		}
		
	}
}
