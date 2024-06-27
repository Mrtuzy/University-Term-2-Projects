public class Product implements Comparable<Product>{
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (" + category + "): " + price + "₺";
    }

    @Override
    public int compareTo(Product other) {
        if(category == null){
            return name.compareTo(other.getName());
        }
       else if(category.compareTo(other.getCategory()) == 0){
            return name.compareTo(other.getName());
        }else{
            return category.compareTo(other.getCategory());
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product product = (Product) obj;
        return name.equals(product.name);
    }
}

