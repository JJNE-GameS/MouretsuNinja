package com.jjnegames.mouretsu.game.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MapFileReader {


	public static int[][] Loadmap() {
		
		String csvFile = "C:/Pelituotannon_projekti/map.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
		int c = 0;
		int i = 0;
	 
		try {
	 
			br = new BufferedReader(new FileReader(csvFile));
			
			while ((line = br.readLine()) != null) {
	 
			        // use comma as separator
				String[] numbers = line.split(cvsSplitBy);
				i = numbers.length;
				System.out.println("Numbers=" +Arrays.toString(numbers));
				c++;
			}
			
			System.out.println("Rows: "+c+ " Colums: "+i+ " Tiles: "+ c*i);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		int[][] map = new int[i][c];
		int cc = 0;
		try {
			 
			br = new BufferedReader(new FileReader(csvFile));
			
			while ((line = br.readLine()) != null) {
	 
			        // use comma as separator
				String[] numbers = line.split(cvsSplitBy);
				i = numbers.length;
				for(int m = 0;m<i;m++){
					map[m][c-cc-1] = Integer.parseInt(numbers[m]);
				}
				cc++;
			}
			
			System.out.println("Rows: "+c+ " Colums: "+i+ " Tiles: "+ c*i);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		return map;
	}
}
