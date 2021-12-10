package geeks_for_geeks.java;

public class SelectionSort1 {

    int  select(int arr[], int i)
	{
        int smallest = Integer.MAX_VALUE;
        int smallestIndex = -1;
        for(int index = i; index < arr.length ; index++){
            int currentElem = arr[index];
            if(smallest > currentElem){
                smallest = currentElem;
                smallestIndex = index;
            }
        }
        return smallestIndex;
	}
	
	void selectionSort(int arr[], int n)
	{
        int sortedArrayEndingIndex = 0;
        while(sortedArrayEndingIndex < n){
            int smallestIndex = select(arr, sortedArrayEndingIndex);
            int temp = arr[sortedArrayEndingIndex];
            arr[sortedArrayEndingIndex] = arr[smallestIndex];
            arr[smallestIndex] = temp;

            sortedArrayEndingIndex++;
        }
	}

    public static  void printArray(int[] arr){
        for(int elem : arr){
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SelectionSort1 selectionSort1 = new SelectionSort1();
        selectionSort1.selectionSort(arr,arr.length);

        SelectionSort1.printArray(arr);


        
    }
    
}
