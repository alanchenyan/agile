package part_1.operation.tests;

public interface IHandler {
	
	public void onSuccess();
	
	public void onFailure(Error error);
	
	public void onResultResponse(IResponse response);
	
	public void onErrorResponse();
}
