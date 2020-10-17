package com.capgemini.Address;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class FileIOOpenCSV {

	public static final String FILENAME = "AddressBookRecord.csv";

	public boolean writeData(ArrayList<Collection> record){
		try {
			FileWriter writer = new FileWriter(new File(FILENAME));
			CSVWriter csvwriter = new CSVWriter(writer);
			for(Collection c:record){
				String[] dataStr=c.pushDataCSV();
				csvwriter.writeNext(dataStr);
			}
			csvwriter.close();
			return true;
		}catch(Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	public int countLines() {
		int lines = 0;

		try {
			lines = (int) Files.lines(new File(FILENAME).toPath()).count();
		}catch(IOException exception) {
			exception.printStackTrace();
		}
		return lines;
	}

	public ArrayList<Collection> readData(){
		ArrayList<Collection> record=new ArrayList<Collection>();
		
		try {
			FileReader reader=new FileReader(FILENAME);
			CSVReader csvreader=new CSVReader(reader);
			String[] dataRecord;
			while(csvreader.readNext()!=null) {
				dataRecord=csvreader.readNext();
				Collection c=new Collection(dataRecord[0], dataRecord[1],
						dataRecord[2], dataRecord[3], dataRecord[4],
						Long.valueOf(dataRecord[5]), dataRecord[6], dataRecord[7]);
				record.add(c);
			}
			csvreader.close();
			return record;
		}catch(Exception exception) {
			System.out.println("Exception occured");
			exception.printStackTrace();
		}
		return null;
	}
}
