
public class Main {

    public static void main(String[] args) {
        //timer start
        long startTime = System.currentTimeMillis();

        String weights="5 3 4 4 5 9 8 4 4 9 1 10 1 10 8 1 10 9 2 1 9 8 9 6 10 9";
        String values="15 2 15 18 20 14 12 5 2 7 8 20 15 12 18 12 4 9 1 19 13 1 8 13 2 19";
        int l=26;
        int capacity=40;

        Solver solver =new Solver(values,weights,l,capacity);
        solver.play();

        //timer stop
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
    }
}
