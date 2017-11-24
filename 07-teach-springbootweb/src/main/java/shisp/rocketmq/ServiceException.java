package shisp.rocketmq;

/**
 * 服务抛出异常给前台。
 *
 */
public class ServiceException extends ErrorCodeException{

    private static final long serialVersionUID = 1L;

    public ServiceException(int errorCode, String errorMsg, Exception e) {
		super(errorCode, errorMsg, e);
	}

	public ServiceException(int errorCode, String errorMsg) {
		super(errorCode, errorMsg);
	}
	
}
