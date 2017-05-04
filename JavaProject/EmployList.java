
public class EmployList<T>{
	
	
	private EmployeesNode list;
	private int size;
	
	public EmployList(){
		list=null;
	}
	
	
	public T getList(int j){
		T result =null;
		EmployeesNode current =list;
		
		if(list==null){
			return null;
		}
		else{
			current=list;
		
		for(int i=0;i<j;i++){
		if(current!=null){
			result= current.employee;
			current=current.next;
		}
		else 
			return null;
		}
			
		return result;}
			
		}
		
		
	
	
	
	
	public void add (T employee){
		EmployeesNode node =new EmployeesNode(employee);
		EmployeesNode current;
		if(list==null){
			list=node;
		}
		else{
			current=list;
			while(current.next!=null)
				current=current.next;
			current.next=node;
			
		}
		size++;
	}
	public int Size(){
		return size;
	}
	public String toString(){//can i make it return the object instead of string
		String result="";
		EmployeesNode current =list;
		while(current!=null){
			result+= current.employee+"\n";
			current=current.next;
		}
		return result;
	}
	
	private class EmployeesNode{
		public T employee;
		public EmployeesNode next;
		
		public EmployeesNode (T part){
			employee=part;
			next = null;
		}
	}
	
	

}