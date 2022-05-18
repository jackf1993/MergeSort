/* author: Jack Farah
 * description: Implementation of merge sort merging 10 random numbers between -9 and 9; This algorithm run time is
 *              O(nlogn)
 */

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();   // Random object created
        int [] numbers = new int [10];  // initializing array of size 10 to build array with rand ints.

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = rand.nextInt() % 10;  // storing the rand ints generated into the array names numbers
        }

        System.out.println("Before:");   //printing unsorted array
        printArray(numbers);

        mergeSort(numbers);              // calling mergeSort with numbers array as the parameter

        System.out.println("After:");   // printing sorted array
        printArray(numbers);
    }

    public static void mergeSort(int [] array){  //merge method accepting the above array as its parameters.
        int inputLength = array.length;

        if(inputLength <2){         //recursion break statement
            return;
        }

        int midIndex = inputLength/2;                        //initializing the midpoint variable to split array into 2
        int [] leftHalf = new int[midIndex];                 // int array that stores the leftHalf elements of the split
        int [] rightHalf = new int[inputLength - midIndex];  // int array that stores the rightHalf elements of the split


        for(int i =0; i < midIndex; i++){                   // storing the leftHalf elements into the leftHalf array
            leftHalf[i] = array[i];
        }

        for(int i =midIndex; i < inputLength; i++){         // storing the rightHalf elements into the rightHalf array
            rightHalf[i - midIndex] = array[i];
        }

        mergeSort(leftHalf);       // recursive call of the leftHalf array to continue breaking down the leftHalf into 2
        mergeSort(rightHalf);      // recursive call of the leftHalf array to continue breaking down the rightHalf into 2

        merge(array, leftHalf, rightHalf); //calling the merge method with parameters of the original array, leftHalf, and rightHalf

    }

    private static void merge (int [] inputArray, int [] leftHalf, int [] rightHalf){  //mergeSort method and implementation
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        int i =0 , j =0, k =0; // i -> leftHalf index tracker
                               // j -> rightHalf index tracker
                               //k -> final array index tracker

        while(i < leftSize && j < rightSize){  //break condition to compare elements in leftHalf
                                               // and rightHalf elements until one is empty

            inputArray[k++] = leftHalf[i] <= rightHalf[j] ? leftHalf[i++] : rightHalf[j++];
            //inputArray k = if leftHalf at i is greater or equal to rightHalf at j -> if true: inputArray at k =
            // leftHalf at i and i++. If false: intputArray at k = rightHalf at j and j++
            // k is also incremented by 1 everytime this algorithm is used.
        }

        while(i < leftSize){              //clean up: if any element(s) are remaining in leftHalf, then add that element
            inputArray[k] = leftHalf[i];  // to the end of inputeArray. incrementing i and k by 1.
            i++;
            k++;
        }

        while(j < rightSize){             //clean up: if any element(s) are remaining in rightHalf, then add that element
            inputArray[k] = rightHalf[j]; // to the end of inputeArray. incrementing j and k by 1.
            j++;
            k++;
        }
    }

    private static void printArray(int[] numbers) { //print method to print the arrays
        for(int i =0; i < numbers.length ; i++){
            System.out.print(numbers[i] +", ");
        }
        System.out.print("\b");
        System.out.println("");
    }
}
