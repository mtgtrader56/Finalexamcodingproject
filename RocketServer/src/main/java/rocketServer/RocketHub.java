package rocketServer;

import java.io.IOException;

import exceptions.RateException;
import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;


public class RocketHub extends Hub {

	private RateBLL _RateBLL = new RateBLL();
	
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Override
	protected void messageReceived(int ClientID, Object message) {
		System.out.println("Message Received by Hub");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			
			LoanRequest lrqst = (LoanRequest) message;
			try
			{	
				lrqst.setdRate(RateBLL.getRate(lrqst.getiCreditScore())); 
				lrqst.setdPayment(-(RateBLL.getPayment((lrqst.getdRate()/100)/12, lrqst.getiTerm(), lrqst.getdAmount(), 0, false)));
			}
			
			catch(RateException e)
			{
				sendToAll(e);
				return;
			}
			sendToAll(lrqst);
		}
	}
}
