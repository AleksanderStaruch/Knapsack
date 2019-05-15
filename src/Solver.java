import java.util.ArrayList;
import java.util.List;

public class Solver {

    private int l;
    private int capacity;
    private Item[] items;

    public Solver(String values, String weights, int l, int capacity) {
        this.l = l;
        this.capacity = capacity;

        items=new Item[l];
        for(int i=0;i<l;i++){
            items[i]=new Item("P"+(i+1),
                    Integer.parseInt(values.split(" ")[i]),
                    Integer.parseInt(weights.split(" ")[i])
            );
        }
    }

    public void play(){
        String[] tab=new String[l];
        for(int i=0;i<l;i++){
            StringBuilder tmp=new StringBuilder();
            for(int j=0;j<i;j++){
                tmp.append("0");
            }
            tab[i]=tmp.toString();
        }

        String bin;
        int maxValue=0;
        int size;
        int value;
        int pow=(int)Math.pow(2,l);

        loop:
        for(int i=0;i<pow;i++){
            bin= Integer.toBinaryString(i);
            size=0;
            value=0;
            bin=tab[l-bin.length()]+bin;

            for(int j=0;j<bin.length();j++){
                if(bin.charAt(j)=='1'){
                    size+=items[j].weight;
                    value+=items[j].value;
                }
                if(size>capacity){
                    continue loop;
                }
            }
            if(maxValue<value){
                maxValue=value;
                System.out.println("B= "+bin+" S= "+size+" V= "+value);
            }
        }
    }

    public void solve() {
        int NB_ITEMS = items.length;
        // we use a matrix to store the max value at each n-th item
        int[][] matrix = new int[NB_ITEMS + 1][capacity + 1];

        // first line is initialized to 0
        for (int i = 0; i <= capacity; i++)
            matrix[0][i] = 0;

        // we iterate on items
        for (int i = 1; i <= NB_ITEMS; i++) {
            // we iterate on each capacity
            for (int j = 0; j <= capacity; j++) {
                if (items[i - 1].weight > j)
                    matrix[i][j] = matrix[i-1][j];
                else
                    // we maximize value at this rank in the matrix
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i-1][j - items[i-1].weight]
                            + items[i-1].value);
            }
        }

        int res = matrix[NB_ITEMS][capacity];
        int w = capacity;
        List<Item> itemsSolution = new ArrayList<>();

        for (int i = NB_ITEMS; i > 0  &&  res > 0; i--) {
            if (res != matrix[i-1][w]) {
                itemsSolution.add(items[i-1]);
                // we remove items value and weight
                res -= items[i-1].value;
                w -= items[i-1].weight;
            }
        }

        System.out.println(matrix[NB_ITEMS][capacity]);
        itemsSolution.forEach(System.out::println);

        String s="";
        for(int i=0;i<l;i++){
            if(itemsSolution.contains(items[i])){
                s+="1";
            }else{
                s+="0";
            }
        }
        System.out.println(s);

    }

}
