package webTable;

public class ListOfTable {

	String name;
	String progress;
	public ListOfTable(String name, String progress) {
		super();
		this.name = name;
		this.progress = progress;
	}
	@Override
	public String toString() {
		return "ListOfTable [name=" + name + ", progress=" + progress + "]";
	}

}
