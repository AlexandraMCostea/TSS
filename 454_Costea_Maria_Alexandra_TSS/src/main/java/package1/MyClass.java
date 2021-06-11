package package1;

import java.util.Objects;

import java.util.HashMap;
import java.util.Map;

class Pair {

    private int X;
    private int Y;

    public Pair() {
        this.X = 0;
        this.Y = 0;
    }

    public Pair(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public int getX() {
        return this.X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return this.Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pair other = (Pair) obj;
        return Objects.equals(X, other.X) &&
                Objects.equals(Y, other.Y);
    }

}


public class MyClass {

    public static void main(String[] args) {

        int T = 0;
        int N = 0;
        int[] x = new  int[100];
        int[] y = new int [100];
        int i = 0;
        int j = 0;
        int t = 0;
        int a = 0;
        boolean ok = false;
        String plagiat;
        Map<Pair, Integer> map = new HashMap<>();

        T = Integer.parseInt(args[a]);
        a++;
        // System.out.println("T = " + T);

        if(T < 1) {
            System.out.println("T < 1");
            return;
        } else if (T > 5) {
            System.out.println("T > 5");
            return;
        }


        for(t = 0; t < T; t++) {

            N = Integer.parseInt(args[a]);
            a++;
            // System.out.println("N = " + N);

            if(N < 1) {
                System.out.println("N < 1");
                return;
            } else if (N > 10) {
                System.out.println("N > 10");
                return;
            }

            for(i = 0; i < N; i ++) {

                x[i] = Integer.parseInt(args[a]);
                a++;
                // System.out.print("x = " + x[i] + " ");

                if(x[i] < 0) {
                    System.out.println("x < 0");
                    return;
                } else if (x[i] > 109) {
                    System.out.println("x > 109");
                    return;
                }

                y[i] = Integer.parseInt(args[a]);
                a++;
                // System.out.println("y = " + y[i]);

                if(y[i] < 0) {
                    System.out.println("y < 0");
                    return;
                } else if (y[i] > 109) {
                    System.out.println("y > 109");
                    return;
                }

            }

            for(i = 0; i < N-1; i ++) {
                for(j = i+1; j < N; j++) {
                    if ((x[i] == x[j]) && (y[i] == y[j])) {
                        System.out.println("2 stele cu aceleasi coordonate");
                        return;
                    }
                }
            }

            plagiat = args[a];
            a++;
             System.out.println("plagiat = " + plagiat);

            map.clear();

            for(i = 0; i < N-1; i ++) {
                for(j = i+1; j < N; j++) {

                    int X = Math.abs(x[j] - x[i]);
                    // System.out.print("X = " + X + " ");
                    int Y = Math.abs(y[j] - y[i]);
                    // System.out.println("Y = " + Y);

                    Pair pair = new Pair(X, Y);
                    // System.out.print("pair.X = " + pair.getX() + " ");
                    // System.out.println("pair.Y = " + pair.getY());

                    Integer value = map.get(pair);
                    if (value == null) {
                        value = 0;
                    }
                    value++;
                    // System.out.println("value = " + value);
                    map.put(pair, value);
                    // System.out.println("map <<" + pair.getX() + ", " + pair.getY() + ">, " + map.get(pair) + ">");
                    if(map.get(pair) >= 3) {
                        ok = true;
                        break;
                    }

                }

                if(ok == true) {
                    break;
                }

            }

            if(ok == true){
                plagiat = "DA";
                System.out.println(plagiat);
            } else {
                plagiat = "NU";
                System.out.println(plagiat);
            }

        }

    }

}
