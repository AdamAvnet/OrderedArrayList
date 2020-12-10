import java.util.ArrayList;
public class OrderedArrayList<T extends Comparable<T>> extends NoNullArrayList<T>{

	public OrderedArrayList(){
		super();
	}

	public OrderedArrayList(int startingCapacity){
		super(startingCapacity);
	}

	private int findIndex(T element){
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
		int realindex = findIndex(element);
		T oldvalue = get(index);
		remove(index);
		super.add(element);
		return oldvalue;
	}
		
}