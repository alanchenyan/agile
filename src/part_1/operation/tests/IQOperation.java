package part_1.operation.tests;

import part_1.operation.exercises.temp.RumpyService;
import part_1.operation.exercises.temp.WebSocket;

public class IQOperation extends Base implements INet {

	private IQ iqRequest;

	public IQOperation(IQ iqRequest, final IHandler handler) {
		super(handler,iqRequest.getId());
		this.iqRequest = iqRequest;
	}

	@Override
	public void send(WebSocket webSocket) {
		if(webSocket == null){
			webSocket = RumpyService.webSocket;
		}
		String jIqRequest = iqRequest.toJSON();
		super.send(webSocket, jIqRequest,TIMEOUT);
	}

	@Override
	public void responseReceived(IResponse response) {
		String type = response.getType();
		if (type.equals("result")) {
			handler.onResultResponse(response);

		} else if (type.equals("error")) {
			handler.onErrorResponse();
		}
		cleanup();
	}
}