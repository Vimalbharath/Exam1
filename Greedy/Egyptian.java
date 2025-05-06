package Greedy;

public class Egyptian {

    public static void printegyptian(int nm, int dm) {
        if (nm == 0 || dm == 0) {
            return;
        }

        if (dm % nm == 0) {
            System.out.println("1/" + dm / nm);
            return;
        }

        if (nm % dm == 0) {
            System.out.println(nm / dm);
            return;
        }

        if (nm > dm) {
            System.out.println(nm / dm + " + ");
            printegyptian(nm % dm, dm);
            return;
        }

        int n = dm / nm + 1;
        System.out.print("1/" + n + " + ");

        // Recur for remaining part
        printegyptian(nm * n - dm, dm * n);
    }

    public static void main(String[] args) {
        int nm = 6;
        int dm = 14;

        printegyptian(nm, dm);

    }
}
