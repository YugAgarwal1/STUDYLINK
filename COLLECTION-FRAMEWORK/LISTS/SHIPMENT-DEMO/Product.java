import java.util.Comparator;

public class Product implements Comparable<Product>{           
	private String name;
	private double weight;
	public Product(String name , double weight){
		this.name = name ;
		this.weight = weight;
	}
	public String getName(){return this.name;}
	public double getWeight(){return this.weight;}
	@Override
	public String toString(){
		return "Product: ["+this.name + ", " + this.weight + "]";
	}
  
  @Override
  public int compareTo(Product  other){
  	return this.name.compareTo(other.name);
  }

  public static final Comparator<Product> BY_WEIGHT = new Comparator<Product>(){
  	public int compare(Product p1 , Product p2){
  		return (int)p1.getWeight() - (int)p2.getWeight();
  	}
  }
 

}

public class Shipment{
	private ArrayList<Product> proc;
    
}