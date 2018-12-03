package wonderList;

public class Mobiles implements Comparable<Mobiles>{
	
	public String name;
	public int price;
	public Mobiles(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	// To compare String
	/*@Override
	public int compareTo(Mobiles o) {
		if (this.name  == o.name) {
			return 1;
		}else return -1;
	}*/
	
	// To compare integer
	@Override
	public int compareTo(Mobiles o) {
		if (this.price  < o.price) {
			return -1;
		}else return 1;
	}
	@Override
	public String toString() {
		return "Mobiles [name=" + name + ", price=" + price + "]";
	}
	
	
	

}
