
public class Main {

    public static void main(String[] args) {
        //timer start
        long startTime = System.currentTimeMillis();

        String weights="3 1 6 10 1 4 9 1 7 2 6 1 6 2 2 4 8 1 7 3 6 2 9 5 3 3";
        String values="7 4 9 18 9 15 4 2 6 13 18 12 12 16 19 19 10 16 14 3 14 4 15 7 5 10";
        int l=26;
        int capacity=40;

        Exe exe=new Exe(values,weights,l,capacity);
        exe.play();

        //timer stop
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
    }
}
