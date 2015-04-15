package com.jjnegames.mouretsu.game.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class MapFileReader {


	public static int[][] Loadmap() {
		
		FileHandle csvFile = Gdx.files.internal("map.csv");
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
		int c = 0;
		int i = 0;
	 
		try {
	 
			br = new BufferedReader(new InputStreamReader(csvFile.read()));
			
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
			 
			br = new BufferedReader(new InputStreamReader(csvFile.read()));
			
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
	
public static int[][] LoadBackGroundmap() {	
	
		
		FileHandle csvFile = Gdx.files.internal("backgroundmap.csv");
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
		int d = 0;
		int a = 0;
	 
		try {
	 
			br = new BufferedReader(new InputStreamReader(csvFile.read()));
			
			while ((line = br.readLine()) != null) {
	 
			        // use comma as separator
				String[] numbers = line.split(cvsSplitBy);
				a = numbers.length;
				System.out.println("Numbers=" +Arrays.toString(numbers));
				d++;
			}
			
			
			
			
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
		
		int[][] backgroundmap = new int[a][d];
		int dd = 0;
		try {
			 
			br = new BufferedReader(new InputStreamReader(csvFile.read()));
			
			while ((line = br.readLine()) != null) {
	 
			        // use comma as separator
				String[] numbers = line.split(cvsSplitBy);
				a = numbers.length;
				for(int e = 0;e<a;e++){
					backgroundmap[e][d-dd-1] = Integer.parseInt(numbers[e]);
				}
				dd++;
			}
			
			System.out.println("Rows: "+d+ " Colums: "+a+ " Tiles: "+ d*a+"Mappi");
			
			
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
		
		
		
		return backgroundmap;
	}
}
