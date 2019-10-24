package com.dbis.asset.exception;

/**
 * 
* @Title: BizException
* @Description: 业务异常类
 * @Author tom
 * @Date 2019/10/23 14:26
 * @Version 1.0
 */
public class BizException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 错误码
	 */
	protected String errorCode;
	/**
	 * 错误信息
	 */
	protected String errorMsg;

	public BizException() {
		super();
	}

	public BizException(BaseErrorInfoInterface errorInfoInterface) {
		super(errorInfoInterface.getResultCode());
		this.errorCode = errorInfoInterface.getResultCode();
		this.errorMsg = errorInfoInterface.getResultMsg();
	}
	
	public BizException(BaseErrorInfoInterface errorInfoInterface, Throwable cause) {
		super(errorInfoInterface.getResultCode(), cause);
		this.errorCode = errorInfoInterface.getResultCode();
		this.errorMsg = errorInfoInterface.getResultMsg();
	}
	
	public BizException(String errorMsg) {
		super(errorMsg);
		this.errorMsg = errorMsg;
	}
	
	public BizException(String errorCode, String errorMsg) {
		super(errorCode);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public BizException(String errorCode, String errorMsg, Throwable cause) {
		super(errorCode, cause);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getMessage() {
		return errorMsg;
	}

	/**
	 */
	@Override
	public Throwable fillInStackTrace() {
		return this;
	}

}
