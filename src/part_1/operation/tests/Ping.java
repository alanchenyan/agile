package part_1.operation.tests;

import java.util.Random;

import part_1.operation.exercises.temp.WebSocket;

public class Ping extends Base implements INet {

	private static Ping container = null;

	public Ping(IHandler handler) {
		super(handler,randomByte());
	}

	@Override
	public void send(WebSocket webSocket) {
		if (container != null) {
			handler.onFailure(Error.BUSYPING);
			return;
		}
		container = this;
		super.send(webSocket,id,TIMEOUT);
	}

	@Override
	public void responseReceived(IResponse response) {
		handler.onSuccess();
		cleanup();
	}

	@Override
	public void cleanup() {
		super.cleanup();
		container = null;
	}

	private static String randomByte() {
		byte[] b = new byte[2];
		new Random().nextBytes(b);
		String id = new String(b);
		return id;
	}
}
