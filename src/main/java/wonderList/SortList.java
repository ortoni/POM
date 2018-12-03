package wonderList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList{

	public static void main(String[] args) {
		
		List<Mobiles> ls = new ArrayList<>();
		ls.add(new Mobiles("z", 40));
		ls.add(new Mobiles("c", 32));
		ls.add(new Mobiles("d", 40));
		ls.add(new Mobiles("d", 40));
		ls.add(new Mobiles("a", 22));
		Collections.sort(ls);
		for (Mobiles mobiles : ls) {
			System.out.println(mobiles);
		}
	}
	
	/*static Comparator<Mobiles> com = new Comparator<Mobiles>() {
		
		@Override
		public int compare(Mobiles o1, Mobiles o2) {
			if(o1.price < o2.price) {
				return -1;
			}else {
				return 1;
			}
		}

	}*/;

	
}
