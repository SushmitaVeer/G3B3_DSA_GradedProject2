package com.greatlearning.graded2.question1.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class SkyScrapper {
	public void generateFloorAssemblyOrder(int totalNumberOfFloors, int[] floorSizeArray) {

		Stack<Integer> floorConstructionTrack = new Stack<>();
		int smallestAssembledFloor = totalNumberOfFloors + 1;

		for (int i = 0; i < totalNumberOfFloors; i++) {
			System.out.println("Day: " + (i + 1));

			// Floors to be added on day i
			List<Integer> floorsOnDayI = new ArrayList<Integer>();
			int assemblyIndex = 0;
			if (!floorConstructionTrack.isEmpty() && (floorSizeArray[i] == smallestAssembledFloor - 1)) {
				while (!floorConstructionTrack.isEmpty() && floorSizeArray[i] > floorConstructionTrack.peek()) {

					if (floorsOnDayI.isEmpty()) {
						if (floorSizeArray[i] - floorConstructionTrack.peek() > 1) {
							break;
						}

						floorsOnDayI.add(floorConstructionTrack.pop());
						assemblyIndex++;
					} else {
						if (floorsOnDayI.get(assemblyIndex - 1) - 1 == floorConstructionTrack.peek()) {
							floorsOnDayI.add(floorConstructionTrack.pop());
							assemblyIndex++;
						} else {
							break;
						}
					}
				}

				floorsOnDayI.add(floorSizeArray[i]);
			} else if ((floorSizeArray[i] == smallestAssembledFloor - 1)) {
				floorsOnDayI.add(floorSizeArray[i]);
			} else {
				floorConstructionTrack.push(floorSizeArray[i]);
			}

			sortStack(floorConstructionTrack);

			Collections.sort(floorsOnDayI, Collections.reverseOrder());

			if (!floorsOnDayI.isEmpty()) {
				// smallest floor that has been added till day
				smallestAssembledFloor = floorsOnDayI.get(floorsOnDayI.size() - 1);
			}
			printAnArrayList(floorsOnDayI);
		}

	}

	private static void printAnArrayList(List<Integer> arr) {
		for (int num : arr) {
			if (num != 0) {
				System.out.print(num + " ");
			}
		}
		System.out.println("");
	}

	private static void sortedInsert(Stack<Integer> stack, int key) {
		if (stack.isEmpty() || key > stack.peek()) {
			stack.push(key);
			return;
		}
		int top = stack.pop();

		sortedInsert(stack, key);

		stack.push(top);
	}

	private static void sortStack(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}

		int top = stack.pop();

		sortStack(stack);
		sortedInsert(stack, top);
	}
}
