package me.vital1ks.lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class FileHandler {
	private static String pathStr = "C:\\Users\\Vitalya\\eclipse-workspace\\lab3\\src\\main\\webapp\\myData.dat";
	private static Path path = Paths.get(pathStr);
	public static void writeFlowerToFile(Flower flower) throws IOException {
		String flowerString = "";
		flowerString+=flower.getName()+",";
		flowerString+=flower.getMain_color()+",";
		flowerString+=flower.getFamily()+",";
		flowerString+=flower.getHeight()+",";
		flowerString+=flower.getPrice()+"\n";
		if(!Files.exists(path)) {
			Files.createFile(path);
		}
		Files.write(path, flowerString.getBytes(), StandardOpenOption.APPEND);
	}
	public static ArrayList<Flower> readFlowersFromFile() throws IOException {
		if(Files.exists(path)) {
		BufferedReader reader = new BufferedReader(new FileReader(pathStr));
		String data = reader.readLine();
		ArrayList<Flower> flowers = new ArrayList<>();
		while(data != null) {
			String[] parameters = data.split(",");
			Flower tempFlower = new Flower(parameters[0],parameters[1],parameters[2],Float.parseFloat(parameters[3]),Float.parseFloat(parameters[4]));
			flowers.add(tempFlower);
			data = reader.readLine();
		}
		reader.close();
		return flowers;
		}
		return null;
	}
}
