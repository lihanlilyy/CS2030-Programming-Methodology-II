class Loader{
	protected final int serId;
	protected final Cruise cruise;
	private final boolean isRecycled;
	protected final int serviceCompletionTime;

	Loader(int serId){
		this.serId = serId;
		this.cruise = null;
		this.isRecycled = false;
		this.serviceCompletionTime = 0;
	}
	
	Loader(int serId, Cruise cruise){
		this.serId = serId;
		this.cruise = cruise;
		this.isRecycled = false;
		this.serviceCompletionTime = cruise.getServiceCompletionTime();
	}

	Loader(int serId, Cruise cruise, boolean isRecycled){
		this.serId = serId;
		this.cruise = cruise;
		this.isRecycled = isRecycled;
		this.serviceCompletionTime = cruise.getServiceCompletionTime() + 60;
	}

	Loader serve(Cruise cruise){
		if(this.cruise == null && cruise == null){
			return new Loader(this.serId);
		} else if(isRecycled){
			if(canServe(cruise)){
				return new Loader(this.serId, cruise, true);
			} else {
				return null;
			}
		} else if(canServe(cruise) && cruise != null) {
			return new Loader(this.serId, cruise);
		} else{
			return null;
		}
	}

	public boolean canServe(Cruise cruise){
		if(this.cruise == null || cruise == null || this.serviceCompletionTime <= cruise.getArrivalTime()){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public String toString(){
		
		if (cruise == null){
			return "Loader " + this.serId;
		} else if(isRecycled){
			return ("Loader " + this.serId + " (recycled) serving " + cruise.getIdentifier() + "@" + String.format("%04d", cruise.getTimeOfArr()));
		} else {
			return  ("Loader " + this.serId + " serving " + cruise.getIdentifier() + "@" + String.format("%04d", cruise.getTimeOfArr()));
		}
	}
}


/*
public class Loader{
	protected final int serId;
	protected final Cruise cruise;
	//protected boolean isRecycled = false;
	protected final int serviceCompletionTime;

	Loader(int serId) {
		this.serId = serId;
		this.cruise = null;
		this.serviceCompletionTime = cruise.getServiceCompletionTime();
	}

	Loader(int serId, Cruise cruise) {
		this.serId = serId;
		this.cruise = cruise;
		this.serviceCompletionTime = cruise.getServiceCompletionTime();
	}

	public Loader(int serId, Cruise cruise, boolean isRecycled) {
		this.serId = serId;
		this.cruise = cruise;
		this.isRecycled = isRecycled;
		this.serviceCompletionTime = cruise.getServiceCompletionTime() + 60;
	}

	Loader serve(Cruise cruise) {

		if (this.cruise == null) {
			return new Loader(this.serId);
		}
		/*
		if (isRecycled) {
			if (canServe(cruise)) {
				return new Loader(this.serId, cruise, true);
			}
		}
		 else if (canServe(cruise)) {
			return new Loader(this.serId, cruise);
		} else {
			return null;
		}

	}

	boolean canServe(Cruise cruise) {
		if(this.cruise == null || this.serviceCompletionTime <= cruise.getArrivalTime()){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString(){
		if (this.cruise == null){
			return "Loader " + this.serId;
		}
		
		else if(isRecycled){
			return ("Loader " + this.serId + " (recycled) serving " + cruise.getIdentifier() + "@" + String.format("%04d", cruise.getTimeOfArr()));
		}
		else {
			return  ("Loader " + this.serId + " serving " + cruise.getIdentifier() + "@" + String.format("%04d", cruise.getTimeOfArr()));
			}
		}
}
*/
