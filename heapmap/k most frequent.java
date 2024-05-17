import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
    
	    for (int outerloop = 0; outerloop < tc; outerloop++) {
    
	        int n = sc.nextInt();
    
	        int k = sc.nextInt();
    
	        int[] B = new int[n];
            for (int i = 0; i < B.length; i++) {
    
	            B[i] = sc.nextInt();
    
	        }

			funtoppee(B,n,k);
		}

	}

	static int find(int[] arr, int ele)

    {
        for (int i = 0; i < arr.length; i++)

            if (arr[i] == ele)

                return i;
        return -1;

    }

	static void funtoppee(int[] a, int n, int k)

    {


        int[] toppee = new int[k + 1];



        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < k + 1; i++)
 
            frequency.put(i, 0);
 
        for (int m = 0; m < n; m++) {
 
            if (frequency.containsKey(a[m]))
 
                frequency.put(a[m], frequency.get(a[m]) + 1);
 
            else
 
                frequency.put(a[m], 1);
            toppee[k] = a[m];
 

 
            int i = find(toppee, a[m]);
 
            i -= 1;
            while (i >= 0) {


 
                if (frequency.get(toppee[i]) < frequency.get(toppee[i + 1])) {
 
                    int tempeory = toppee[i];
                    toppee[i] = toppee[i + 1];
 
                    toppee[i + 1] = tempeory;
 
                }
 



                else if ((frequency.get(toppee[i]) == frequency.get(toppee[i + 1])) && (toppee[i] > toppee[i + 1])) {
 
                    int tempeory = toppee[i];
 
                    toppee[i] = toppee[i + 1];
 
                    toppee[i + 1] = tempeory;
 
                }
 
 
                else
 
                    break;
                i -= 1;
 
            }
 
            for (int j = 0; j < k && toppee[j] != 0; ++j)
 
                System.out.print(toppee[j] + " ");
        }
 
        System.out.println();
 
    }
}
