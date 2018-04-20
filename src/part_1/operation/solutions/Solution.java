package part_1.operation.solutions;


/*

interface Request {
    public String getId();
}

interface Handler<RP, F extends Enum<F>> {
	public void onResultResponse(RP response);
	public void onErrorResponse();
	public void onFailure(F reason);
}


abstract class RequestTimeoutTracker<R extends Request, RP, F extends Enum<F>> {
	
	public static ConcurrentHashMap<String, R> activeExchanges = new ConcurrentHashMap<String, R>();
	private R request;
	private Handler<RP> handler;
	private Timer timeout;
	private TimerTask timeoutTask;
	private String id;
	private static final long TIMEOUT = 2*60*1000;
	
	protected abstract void sendRequest(WebSocket webSocket, R request);
	protected abstract Class<F> getFailureEnumClass();
	
	public ExchangeTracker(R request, final Handler<RP> handler) {
		
		this.request = request;
		id = request.getId();
		this.handler = handler;
		timeout = new Timer();
		timeoutTask = new TimerTask() {
			
			@Override
			public void run() {
				notifyFailure("TIMEOUT");
                cleanup();
			}
		};
		
	}
    private void notifyFailure(String code) {
        handler.onFailure(getFailureEnumClass().valueOf(code));
    }
	public void send(WebSocket webSocket) {
		
		if (webSocket == null) {
    		notifyFailure("NULL");
			return;
		}
		sendRequest(webSocket, request);
		activeExchanges.put(id, this);
		timeout.schedule(timeoutTask, TIMEOUT);
	}

	protected void cleanup() {
		
		if (timeout != null) {
			timeout.cancel();
		}
		activeExchanges.remove(id);
	}

}


interface PingHandler extends Handler<PingRequest, Ping.Failure> {
}


PingRequest implements Request {
    private String id;

    public PingRequest() {
        this.id=new String(randomByte());
    }

	private byte[] randomByte() {
		byte[] b = new byte[2];
		new Random().nextBytes(b);
		return b;
	}
}

public class Ping extends RequestTimeoutTracker<PingRequest, PingResponse, Ping.Failure> {
	
	public enum Failure {
		NULL, TIMEOUT, BUSYPING
	}
    public static Ping container = null;
	
	public Ping(final PingHandler handler) {
        super(new PingRequest(), handler);
	}
	public void send(WebSocket webSocket) {
		if (container != null) {
			handler.onFailure(Ping.Failure.BUSYPING);
			return;
		}
        container=this;
        super.send(webSocket);
    }
	protected void sendRequest(WebSocket webSocket, PingRequest request) {
		webSocket.sendPingMessage(request.getId().getBytes());
    }
	protected Class<Ping.Failure> getFailureEnumClass() {
        return Ping.Failure.class;
    }
	public void pingReceived(PingResponse response) {
		handler.onResultResponse(response);
		cleanup();
	}
	protected void cleanup() {
        super.cleanup();
        containier=null;
    }
}

interface IQHandler extends Handler<IQ, IQOperation.Failure> {
}


class IQOperation extends RequestTimeoutTracker<IQ, IQ, IQOperation.Failure> {
	
	private IQ iqResponse;
	
	public enum Failure {
		TIMEOUT, NULL
	}
	
	public IQOperation(IQ iqRequest, final IQHandler handler) {
        super(iqReuest, handler);
	}
	protected void sendRequest(WebSocket webSocket, IQ request) {
		String jIqRequest = iqRequest.toJSON();
		webSocket.sendTextMessage(jIqRequest);
    }
	protected Class<IQOperation.Failure> getFailureEnumClass() {
        return IQOperation.Failure.class;
    }
	
	public void send() {
		WebSocket webSocket = RumpyService.webSocket;
        send(webSocket);
    }

	public void iqResponseReceived(IQ iqResponse) {
		
		this.iqResponse = iqResponse;
		String type = iqResponse.getType();
		
		if (type.equals("result")) {
			handler.onResultResponse(iqResponse);
			
		} else if (type.equals("error")) {
			handler.onErrorResponse();
		}
		
		cleanup();
	}
}

*/
