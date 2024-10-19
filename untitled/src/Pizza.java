public class Pizza {
    private String name;
    private String size;
    private String toppings;
    private Double price;



    public Pizza(String name, String size, String toppings, double price){
        this.name = name;
        this.size = size;
        this.toppings = toppings;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public String getSize() {
        return size;
    }
    public String getToppings() {
        return toppings;
    }
    public Double getPrice() {
        return price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public void setToppings(String toppings) {
        this.toppings = toppings;
    }
    public void setPrice(Double price) {
        this.price = price;
    }








}

