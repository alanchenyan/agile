package part_1.operation.tests;

class IQ implements IResponse {
	/**
	 * temp
	 */
	String id;
	String type;
	public String toJSON(){
		return "json";
	}
	public String getId() {
		return id;
	}
	
	
	@Override
	public String getType() {
		return type;
	}
}
