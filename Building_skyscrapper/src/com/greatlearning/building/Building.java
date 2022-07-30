package com.greatlearning.building;
import java.util.Arrays;
import java.util.Stack;

public class Building{
	static boolean large;
	boolean flag;
	
	public static void FloorsCalculate(int[] floorSize) {
		int size = floorSize.length;
		Stack<Integer> st = new Stack<>();
		for(int i =0; i<size; i++) {
			large = true;
			int i_Floor = floorSize[i];
			for(int j =1; j <size; j++) {
				if(j ==i) {
					continue;
				}else {
					int j_Floor = floorSize[j];
					if(i_Floor >= j_Floor) {
						large = true;
						continue;
						
					}else {
						large = false;
						st.push(i_Floor);
						break;
					}
				}
			}
			
			if (large == true) {
				Stack temp = viewFloor(st, i_Floor, i, floorSize);
				st.clear();
				st = (Stack<Integer>) temp.clone();
				temp.clear();
				System.out.println();
				
				
			}else {
				System.out.println("Day"+ (i+1)+":");
			}
			
		}
	}
	
	public static Stack viewFloor(Stack st, int c_Floor, int k, int[]Floor) {
		int [] popped = new int[Floor.length];
		int count = 0;
		
		System.out.print("Day" + (k +1)+ ":"+ c_Floor);
		Stack<Integer> temp = new Stack<Integer>();
		boolean biggest;
		if(k == Floor.length - 1) {
			while(!st.empty()) {
				int popFloor = (int) st.pop();
				popped[count++] = popFloor;
			}
			if(popped !=null) {
				Arrays.sort(popped);
				for(int i = popped.length-1; i>0;i++) {
					if(popped[i] !=0) {
						System.out.println(" " + popped[i]);
					}
				}
			}
			return temp;
		}else {
			if(!st.empty()) {
				biggest = true;
				int popFloor = (int) st.pop();
				for(int i = k; i< Floor.length;i++) {
					if(i == k) {
						continue;
					}
					if(popFloor < Floor[i]) {
						temp.push(popFloor);
						biggest = false;
						break;
					}else {
						biggest = true;
					}
				}
				if(biggest = true) {
					popped[count++] = popFloor;
				}
			}
		}
		if (popped != null) {
			Arrays.sort(popped);
			for(int i = popped.length-1; i>0; i--) {
				if(popped[i]!=0) {
					System.out.println(" "+ popped[i]);
				}
			}
		}
		return temp;
	}

}