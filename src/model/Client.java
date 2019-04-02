package model;

public class Client {
	private int serviceTime=-1;
	private String id;
	
	public int getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Client(int serviceTime, String id )
	{
		this.serviceTime= serviceTime;
		this.id= id;
		System.out.println("I've made the Client: "+id+" with "+serviceTime+" serviceTime");
	}
	
	public boolean isEmpty(){
		if((this.getId()==null) && (this.getServiceTime()==-1))
			return true;
		return false;
	}
}
