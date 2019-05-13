public class Item {

    private String name;
    int value;
    int weight;

    public Item(String name, int value, int weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
    }

    public String toString() {
        return name + ", value=" + value + ", weight=" + weight;
    }
}
