import java.util.ArrayList;
import java.util.List;

public class Exe {

    private int l;
    private int capacity;
    private Item[] items;

    public Exe(String values, String weights, int l, int capacity) {
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
        /**
         * 0
         * 00
         * 000
         * 0000
         * 00000
         * 000000
         */
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
        int size,value;
        int pow=(int)Math.pow(2,l);

        loop:
        for(int i=0;i<pow;i++){
            bin= Integer.toBinaryString(i);
            size=0;
            value=0;

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
                bin+=tab[l-bin.length()];
                System.out.println("B= "+bin+" S= "+size+" V= "+value);
            }
        }
    }

}
