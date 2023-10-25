package KI306.Chaus.Lab6;
interface Tool extends Comparable<Tool> {
	
  int getSize();
  
  void print();
}

interface Tool1<T>{
	public void print_data(T data);
}