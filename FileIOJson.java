package com.capgemini.Address;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import com.google.gson.Gson;

public class FileIOJson {
	public static final String FILENAME = "AddressBookRecord.json";

	public boolean writeData(ArrayList<Collection> record) {

		try {
			Writer writer = Files.newBufferedWriter(Paths.get(FILENAME));
			new Gson().toJson(record, writer);
			writer.close();
			return true;
		} catch (IOException exception) {
			exception.printStackTrace();
			return false;
		}
	}

	public ArrayList<Collection> readData() {
		ArrayList<Collection> record = new ArrayList<Collection>();

		try {
			Reader reader = Files.newBufferedReader(Paths.get(FILENAME));
			record.addAll(Arrays.asList(new Gson().fromJson(reader, Collection[].class)));
			reader.close();
			return record;
		} catch (IOException exception) {
			exception.printStackTrace();
			return null;
		}
	}
}
