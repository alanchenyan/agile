package part_1.operation.tests;

import part_1.operation.exercises.temp.WebSocket;

public interface INet {
	
	public abstract void send(WebSocket webSocket);
	
	public abstract void responseReceived(IResponse response);
}
