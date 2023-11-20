package com.greatlearning.graded2.question1.driver;

import java.util.Scanner;
import com.greatlearning.graded2.question1.service.*;

public class FloorsMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SkyScrapper floor = new SkyScrapper();
		System.out.println("Enter the total number of floors in building -");
		int totalNumberOfFloors = scanner.nextInt();

		int[] floorSizeArray = new int[totalNumberOfFloors];

		for (int i = 1; i <= totalNumberOfFloors; i++) {
			System.out.println("Enter the floor size given on day " + i + ":");
			floorSizeArray[i - 1] = scanner.nextInt();
		}

		scanner.close();

		System.out.println("\n\nThe order of construction is as follows -");

		floor.generateFloorAssemblyOrder(totalNumberOfFloors, floorSizeArray);

	}

}
