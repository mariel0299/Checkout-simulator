package view;
import javax.swing.*;

import model.Client;

import java.awt.*;  
import java.text.*;  
import java.util.*;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
public class DigitalWatch {  
JFrame f;  
JButton idnum;
JButton currtime;
JButton firstCustomer1,firstCustomer2,firstCustomer3,firstCustomer4,firstCustomer5;
JButton coada1clienti,coada2clienti,coada3clienti,coada4clienti,coada5clienti;
public DigitalWatch() {  
    f=new JFrame();  
    f.setSize(1200,1200);  
    f.setLayout(new GridLayout(3,3));
    
      
    idnum=new JButton("");  
    currtime = new JButton("");
    firstCustomer1= new JButton("");
    firstCustomer2= new JButton("");
    firstCustomer3= new JButton("");
    firstCustomer4= new JButton("");
    firstCustomer5= new JButton("");
    coada1clienti =new JButton("");
    coada2clienti =new JButton("");
    coada3clienti =new JButton("");
    coada4clienti =new JButton("");
    coada5clienti =new JButton("");
    f.add(currtime);  
    f.add(idnum);
    f.add(firstCustomer1);
    f.add(coada1clienti);
    f.add(firstCustomer2);
    f.add(coada2clienti);
    f.add(firstCustomer3);
    f.add(coada3clienti);
    f.add(firstCustomer4);
    f.add(coada4clienti);
    f.add(firstCustomer5);
    f.add(coada5clienti);
      
    f.setVisible(true);   
         }  

public void refresh(int id,int currTime, Queue<Client> first, Queue<Client> second,Queue<Client> third,Queue<Client> fourth,Queue<Client> fifth){
	idnum.setText("Newest customer: "+id);
	currtime.setText("Current Time: "+currTime);
	if(first.isEmpty()){
		firstCustomer1.setText("NO CUSTOMERS");
		coada1clienti.setText(" ");
	}
	else{
	firstCustomer1.setText("Customer at cashier 1: "+ first.peek().getId()+" with service time "+ first.peek().getServiceTime());
	coada1clienti.setText("Number of waiting clients at cashier 1: "+ first.size());
	}
	if(second.isEmpty()){
		firstCustomer2.setText("NO CUSTOMERS");
		coada2clienti.setText(" ");
	}
	else{
	firstCustomer2.setText("Customer at cashier 2: "+ second.peek().getId()+" with service time "+ second.peek().getServiceTime());
	coada2clienti.setText("Number of waiting clients at cashier 2: "+ second.size());
	}
	if(third.isEmpty()){
		firstCustomer3.setText("NO CUSTOMERS");
		coada3clienti.setText(" ");
	}
	else{
	firstCustomer3.setText("Customer at cashier 3: "+ third.peek().getId()+" with service time "+ third.peek().getServiceTime());
	coada3clienti.setText("Number of waiting clients at cashier 3: "+ third.size());
	}
	if(fourth.isEmpty()){
		firstCustomer4.setText("NO CUSTOMERS");
		coada4clienti.setText(" ");
	}
	else{
	firstCustomer4.setText("Customer at cashier 4: "+ fourth.peek().getId()+" with service time "+ fourth.peek().getServiceTime());
	coada4clienti.setText("Number of waiting clients at cashier 4: "+ fourth.size());
	}
	if(fifth.isEmpty()){
		firstCustomer5.setText("NO CUSTOMERS");
		coada5clienti.setText(" ");
	}
	else{
	firstCustomer5.setText("Customer at cashier 5: "+ fifth.peek().getId()+" with service time "+ fifth.peek().getServiceTime());
	coada5clienti.setText("Number of waiting clients at cashier 5: "+ fifth.size());
	}
}
   }