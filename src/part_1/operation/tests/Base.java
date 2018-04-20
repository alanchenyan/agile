package part_1.operation.tests;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

import part_1.operation.exercises.temp.WebSocket;

public class Base {

	protected static final long TIMEOUT = 2 * 60 * 1000;

	private static ConcurrentHashMap<String, Base> actives = new ConcurrentHashMap<String, Base>();
	protected String id;
	
	protected IHandler handler;
	private Timer timer;
	private TimerTask timeoutTask;

	public Base(IHandler handler,String id) {
		this.id = id;
		this.timeoutTask = createTimerTask();
		this.timer = new Timer();
		this.handler = handler;
	}


	private TimerTask createTimerTask() {
		return new TimerTask() {
			@Override
			public void run() {
				handler.onFailure(Error.TIMEOUT);
				cleanup();
			}
		};
	}

	protected void send(WebSocket webSocket, String sendMsg,long timeout) {
		if (webSocket == null) {
			handler.onFailure(Error.NULL);
			return;
		}
		webSocket.sendTextMessage(sendMsg);
		actives.put(id, this);
		timer.schedule(timeoutTask, timeout);
	}

	protected void cleanup() {
		if (timer != null) {
			timer.cancel();
		}
		actives.remove(id);
	}
}
