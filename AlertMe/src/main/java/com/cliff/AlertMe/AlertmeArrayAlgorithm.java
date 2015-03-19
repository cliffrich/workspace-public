package com.cliff.AlertMe;

/**
 * @author cliffr
 *
 */
public class AlertmeArrayAlgorithm {
	
	/**
	 * Given two arrays, this method will find the starting position of the second array in the first array.
	 * i.e. [2,3,4,5] and [4,5] should return 2
	 * 
	 * @param array1
	 * @param array2
	 * @return -1 if array 2 is not found in array 1
	 */
	private static int findStartPositionForArray2InArray1(int[] array1, int[] array2){
		int array2FirstElement = array2[0], returnIndex = -1;
		for(int i=0;i<array1.length;i++){
			if(returnIndex >0)
				break;
			if(array1[i] == array2FirstElement){
				// Found the starting position of the second array in the first array
				returnIndex = i;
				int array1RunningPosition = i+1;
				for(int j=1;j<array2.length;j++){ // check for the rest of the elements from array2
					if(!(array1[array1RunningPosition] == array2[j])){
						returnIndex = -1;
					}
					if(returnIndex == -1)
						break;
					else
						array1RunningPosition++;
				}
			}
		}
		return returnIndex;
	}
    public static void main( String[] args ){
    	// Testing with some sample data
        System.out.format( "Starting position is %d between arrays [2,3,4,5] and [6,7]%n", findStartPositionForArray2InArray1(new int[] {2,3,4,5}, new int[] {6,7}) ); 	
        System.out.format( "Starting position is %d between arrays [2,3,4,5] and [4,5]%n", findStartPositionForArray2InArray1(new int[] {2,3,4,5}, new int[] {4,5}) );
        System.out.format( "Starting position is %d between arrays [1,2,3,4,3,6] and [3,6]%n", findStartPositionForArray2InArray1(new int[] {1,2,3,4,3,6}, new int[] {3,6}) );
        System.out.format( "Starting position is %d between arrays [1,2,3,4,5,3,6] and [3,6]%n", findStartPositionForArray2InArray1(new int[] {1,2,3,4,5,3,6}, new int[] {3,6}) );
        System.out.format( "Starting position is %d between arrays [1,2,3,4,5,3,4,5,6] and [3,4,5,6]%n", findStartPositionForArray2InArray1(new int[] {1,2,3,4,5,3,4,5,6}, new int[] {3,4,5,6}) );
    }
}
