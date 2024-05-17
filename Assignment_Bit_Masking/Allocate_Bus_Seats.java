package Assignment_Bit_Masking;

import java.util.*;

public class Allocate_Bus_Seats {
    public static void main(String[] args) {
        Scanner rubix = new Scanner(System.in);
        int row = rubix.nextInt();
        int seatsReserved = rubix.nextInt();
        int[][] SeatsReserved = new int[seatsReserved][2];
        for (int i = 0; i < seatsReserved; i++) {
            SeatsReserved[i][0] = rubix.nextInt();
            SeatsReserved[i][1] = rubix.nextInt();
        }
        System.out.println(Families_Max(row, SeatsReserved));
    }

    public static int Families_Max(int n, int[][] SeatsReserved) {
        Map<Integer, Integer> pam = new HashMap<>();
        for (int[] rra : SeatsReserved) {
            int row = rra[0] - 1, col = rra[1];
            pam.put(row, SettingBit(pam.getOrDefault(row, 0), 10 - col));
        }
        int families = 0;
        int left = 480;
        int right = 30;
        int middle = 120;
        for (int row : pam.values()) {
            row = ~(row) & ((1 << 10) - 1);
            if (((row & (left | right)) ^ (left | right)) == 0) {
                families += 2;
            } else if (((row & left) ^ left) == 0 || ((row & right) ^ right) == 0 || ((row & middle) ^ middle) == 0) {
                families++;
            }
        }
        return families + 2 * (n - pam.keySet().size());
    }

    private static int SettingBit(int cinemaSeat, int i) {
        return cinemaSeat | (1 << i);
    }
}
