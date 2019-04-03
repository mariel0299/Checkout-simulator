package model;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import view.*;

import java.util.LinkedList; 
import java.util.Queue; 

public class ClientGenerator implements Runnable{
	private DigitalWatch gui = new DigitalWatch();
	private int numberOfQueues=5;
	Queue<Client> coada1 = new LinkedList<>();
	Queue<Client> coada2 = new LinkedList<>();
	Queue<Client> coada3 = new LinkedList<>();
	Queue<Client> coada4 = new LinkedList<>();
	Queue<Client> coada5 = new LinkedList<>();
	private int time;
	private int serviceTime=(int)(Math.random()*20 +1);
	private int newClientWaitTime=0;
	private String id;
	private float avg = 0.0f;
	private int waitTime = 0;
	private int currentTime;
	private int passedTime1=0;
	private int passedTime2=0;
	private int passedTime3=0;
	private int passedTime4=0;
	private int passedTime5=0;
	private int idnum=0;
	private int coada1waitTime=0;
	private int coada2waitTime=0;
	private int coada3waitTime=0;
	private int coada4waitTime=0;
	private int coada5waitTime=0;
	private int coada1startTime;
	private int coada2startTime;
	private int coada3startTime;
	private int coada4startTime;
	private int coada5startTime;
	private Thread th1 = new Thread();
	public void run() {
		for(currentTime = 0;currentTime<600;currentTime++){
		System.out.println("-----"+currentTime+"-----");
		removeClient();
		addNewClient();
		gui.refresh(idnum,currentTime,coada1,coada2,coada3,coada4,coada5);
		try {
			th1.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
		System.out.println("The Store is closed");
		System.out.println("The avarage service time was: "+ avg/idnum);
	
	}
	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public void addNewClient(){
		if(currentTime -waitTime == 0){
			id= "Client "+idnum++;
			avg+=serviceTime;
			switch (getMinimumServiceTime()){
			case 1:
				coada1.add(new Client(serviceTime, id));
				setCoada1waitTime(getCoada1waitTime() + serviceTime);
				System.out.println(" "+(idnum-1)+ " in coada 1");
				newClientWaitTime=(int)( Math.random()*2+1);
				if(coada1.size()==1)
					coada1startTime=newClientWaitTime;
				break;
			case 2:
				coada2.add(new Client(serviceTime, id));
				setCoada2waitTime(getCoada2waitTime() + serviceTime);
				System.out.println(" "+(idnum-1)+ " in coada 2");
				newClientWaitTime=(int)( Math.random()*2+1);
				if(coada2.size()==1)
					coada2startTime=newClientWaitTime;
				break;
			case 3:
				coada3.add(new Client(serviceTime, id));
				setCoada3waitTime(getCoada3waitTime() + serviceTime);
				System.out.println(" "+(idnum-1)+ " in coada 3");
				newClientWaitTime=(int)( Math.random()*2+1);
				if(coada3.size()==1)
					coada3startTime=newClientWaitTime;
				break;
			case 4:
				coada4.add(new Client(serviceTime, id));
				setCoada4waitTime(getCoada4waitTime() + serviceTime);
				System.out.println(" "+(idnum-1)+ " in coada 4");
				newClientWaitTime=(int)( Math.random()*2+1);
				if(coada4.size()==1)
					coada4startTime=newClientWaitTime;
				break;
			case 5:
				coada5.add(new Client(serviceTime, id));
				setCoada5waitTime(getCoada5waitTime() + serviceTime);
				System.out.println(" "+(idnum-1)+ " in coada 5");
				newClientWaitTime=(int)( Math.random()*2+1);
				if(coada5.size()==1)
					coada5startTime=newClientWaitTime;
				break;
			}
			serviceTime= (int)(Math.random()*20 +1);
			System.out.println("new wait time: "+newClientWaitTime+" ");
			waitTime+= newClientWaitTime;
			}
	}
	public void removeClient(){
		if(!coada1.isEmpty())
			if(currentTime -passedTime1- coada1.peek().getServiceTime() >= 0){
				passedTime1 = currentTime;
				setCoada1waitTime(getCoada1waitTime() - coada1.peek().getServiceTime());
				System.out.println("I've removed "+coada1.remove().getId()+" from coada 1 ");
			}
		if(!coada2.isEmpty())
			if(currentTime -passedTime2-coada2startTime- coada2.peek().getServiceTime() >= 0){
				passedTime2 = currentTime;
				setCoada2waitTime(getCoada2waitTime() - coada2.peek().getServiceTime());
				System.out.println("I've removed "+coada2.remove().getId()+" from coada 2 ");
			}
		if(!coada3.isEmpty())
			if(currentTime -passedTime3-coada3startTime- coada3.peek().getServiceTime() >= 0){
				passedTime3 = currentTime;
				setCoada3waitTime(getCoada3waitTime() - coada3.peek().getServiceTime());
				System.out.println("I've removed "+coada3.remove().getId()+" from coada 3 ");
			}
		if(!coada4.isEmpty())
			if(currentTime -passedTime4-coada4startTime- coada4.peek().getServiceTime() >= 0){
				passedTime4 = currentTime;
				setCoada4waitTime(getCoada4waitTime() - coada4.peek().getServiceTime());
				System.out.println("I've removed "+coada4.remove().getId()+" from coada 4 ");
			}
		if(!coada5.isEmpty())
			if(currentTime -passedTime5-coada5startTime- coada5.peek().getServiceTime() >= 0){
				passedTime5 = currentTime;
				setCoada5waitTime(getCoada5waitTime() - coada5.peek().getServiceTime());
				System.out.println("I've removed "+coada5.remove().getId()+" from coada 5 ");
			}
	}
	public int getCoada1waitTime() {
		return coada1waitTime;
	}

	public void setCoada1waitTime(int coada1waitTime) {
		this.coada1waitTime = coada1waitTime;
	}
	
	public int getCoada2waitTime() {
		return coada2waitTime;
	}

	public void setCoada2waitTime(int coada2waitTime) {
		this.coada2waitTime = coada2waitTime;
	}
	public int getCoada3waitTime() {
		return coada3waitTime;
	}

	public void setCoada3waitTime(int coada3waitTime) {
		this.coada3waitTime = coada3waitTime;
	}
	public int getCoada4waitTime() {
		return coada4waitTime;
	}

	public void setCoada4waitTime(int coada4waitTime) {
		this.coada4waitTime = coada4waitTime;
	}
	public int getCoada5waitTime() {
		return coada5waitTime;
	}

	public void setCoada5waitTime(int coada5waitTime) {
		this.coada5waitTime = coada5waitTime;
	}
	
	public int getMinimumServiceTime(){
		if(numberOfQueues == 5){
		if(coada1waitTime<=coada2waitTime&&coada1waitTime<=coada3waitTime&&coada1waitTime<=coada4waitTime&&coada1waitTime<=coada5waitTime)
			return 1;
		if(coada2waitTime<=coada2waitTime&&coada2waitTime<=coada3waitTime&&coada2waitTime<=coada4waitTime&&coada2waitTime<=coada5waitTime)
			return 2;
		if(coada3waitTime<=coada1waitTime&&coada3waitTime<=coada2waitTime&&coada3waitTime<=coada4waitTime&&coada3waitTime<=coada5waitTime)
			return 3;
		if(coada4waitTime<=coada1waitTime&&coada4waitTime<=coada2waitTime&&coada4waitTime<=coada3waitTime&&coada4waitTime<=coada5waitTime)
			return 4;
		if(coada5waitTime<=coada1waitTime&&coada5waitTime<=coada2waitTime&&coada5waitTime<=coada4waitTime&&coada5waitTime<=coada4waitTime)
			return 5;
		}
		if(numberOfQueues == 4){
			if(coada1waitTime<=coada2waitTime&&coada1waitTime<=coada3waitTime&&coada1waitTime<=coada4waitTime)
				return 1;
			if(coada2waitTime<=coada2waitTime&&coada2waitTime<=coada3waitTime&&coada2waitTime<=coada4waitTime)
				return 2;
			if(coada3waitTime<=coada1waitTime&&coada3waitTime<=coada2waitTime&&coada3waitTime<=coada4waitTime)
				return 3;
			if(coada4waitTime<=coada1waitTime&&coada4waitTime<=coada2waitTime&&coada4waitTime<=coada3waitTime)
				return 4;
			}
		if(numberOfQueues == 3){
			if(coada1waitTime<=coada2waitTime&&coada1waitTime<=coada3waitTime)
				return 1;
			if(coada2waitTime<=coada2waitTime&&coada2waitTime<=coada3waitTime)
				return 2;
			if(coada3waitTime<=coada1waitTime&&coada3waitTime<=coada2waitTime)
				return 3;
			}
		if(numberOfQueues == 2){
			if(coada1waitTime<=coada2waitTime)
				return 1;
			if(coada2waitTime<=coada2waitTime)
				return 2;
			}
		if(numberOfQueues == 1){
				return 1;
			}
		return 0;
	}
}
