import java.util.ArrayList;
public class OrderedArrayList<T extends Comparable<T>> extends NoNullArrayList<T>{

	public OrderedArrayList(){
		super();
	}

	public OrderedArrayList(int startingCapacity){
		super(startingCapacity);
	}

	private int findIndex(T element){
		if(element == null)
			throw new IllegalArgumentException("No nulls allowed.");
		for(int i = 0; i < size(); i++){
			if(get(i).compareTo(element) > 0)
				return i;
		}
		return size();
	}

	public boolean add(T element){
		int index = findIndex(element);
		super.add(index, element);
		return true;
	}

	public void add(int index, T element){
		int realindex = findIndex(element);
		super.add(realindex, element);
	}

	public T set(int index, T element){
		T oldvalue = get(index);
		if(element == null)
			throw new IllegalArgumentException("No nulls allowed.");
		remove(index);
		int realindex = findIndex(element);
		add(element);
		return oldvalue;
	}
		
}