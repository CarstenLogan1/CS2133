import java.util.Arrays;
import java.util.Random;


/*Run time differences between O(n^2) and O(nlogn) can start off
small but as input sizes increase the time difference
becomes quite great. n^2 means that for every double
in input size your operations increase fourfold.
 This is seen in the relatively quick timeout of our
 bubble sort

 n log n has much fewer operations for the same increase
 in size when compared to n^2. The increase is
 logarithmically rather than x4; if doubled operations
 really only increase by about double. We saw the
 difference in efficiency by how quickly bubble
 times out in comparison to merge. */

public class Sorting {
    static boolean timeout = false;
    public static void main(String[] args){
        int n = 10;
        double[] arr1, arr2;
        long start, stop, bubble, merge;

        while(true){
           try{
               arr1 = generateRandomArray(n);
               arr2 = Arrays.copyOf(arr1, arr1.length);

               start = System.currentTimeMillis();
               bubbleSort(arr1);
               stop = System.currentTimeMillis();
               bubble = stop - start;

               start = System.currentTimeMillis();
               mergeSort(arr2);
               stop = System.currentTimeMillis();
               merge = stop - start;

               System.out.println("Bubble Sort took : " + bubble+ "ms");
               System.out.println("Merge Sort took : " + merge + "ms");

               if(timeout){
                   System.out.println("Bubble sort timed out");
                   while(true){
                       arr2 = generateRandomArray(n);
                       start = System.currentTimeMillis();
                       mergeSort(arr2);
                       stop = System.currentTimeMillis();
                       merge = stop - start;

                       System.out.println("Merge Sort took : " + merge + "ms");
                       n*=10;

                   }
               }
               n*=10;

           } catch(OutOfMemoryError e){

            }

        }
    }

    private static double[] generateRandomArray(int n) {
        double[] arr = new double[n];
        Random r = new Random();

        for(int i = 0; i<n; i++){
            arr[i] = r.nextDouble();
        }
        return arr;
    }

    private static double[] bubbleSort(double[] arr){
        int n = arr.length;
        long start = System.currentTimeMillis();
        long elapsed = 0;

        for(int i = 0; i< n-1; i++){
            for(int j = n-1; j>= i+1; j--){
                if(arr[j]>arr[j-1]){
                    double temp = arr[j];
                    arr[j]= arr[j-1];
                    arr[j-1] = temp;
                }
                elapsed = System.currentTimeMillis()-start;
                if(elapsed > 20000){
                    timeout = true;
                    break;
                }
            }

        }
        return arr;

    }

    private static void mergeSort(double[] arr){
        long start = System.currentTimeMillis();
        int n = arr.length;

        if(n < 2){
            return;
        }
        int middle = n/2;
        double[] leftArr = new double[middle];
        double[] rightArr = new double[n-middle];

        for(int i = 0; i<middle;i++){
            leftArr[i]=arr[i];
        }

        for(int i = middle; i<n; i++){
            rightArr[i-middle] = arr[i];
        }

        mergeSort(leftArr);
        mergeSort(rightArr);

        merge(arr, leftArr, rightArr);

        long elapse = System.currentTimeMillis() - start;
        if(elapse > 20000){
            System.out.println("Merge sort timed out");
            System.exit(0);
        }


    }

    private static void merge(double[] arr, double[] leftArr, double[] rightArr){
        int leftSize = leftArr.length;
        int rightSize = rightArr.length;

        int i = 0, j = 0, k = 0;

        while(i < leftSize && j < rightSize){
            if(leftArr[i]<= rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            }
            else{
              arr[k] = rightArr[j];
              j++;
            }
            k++;
        }
        while(i < leftSize){
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while(j < rightSize){
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }


}
