package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {
	
	private RateDomainModel RDM;
	
	
	public RateException(RateDomainModel R){
		this.RDM = R;
	}

	public RateDomainModel getRDM(){
		return this.RDM;
	}

}
