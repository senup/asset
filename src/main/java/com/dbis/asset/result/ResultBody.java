package com.dbis.asset.result;

import com.alibaba.fastjson.JSONObject;
import com.dbis.asset.enums.CommonEnum;
import com.dbis.asset.exception.BaseErrorInfoInterface;

/**
 *
 * @Title: ResultBody
 * @Description: 返回格式
 * @Version:1.0.0
 * @author tom
 * @date 2019年10月22日
 */
public class ResultBody {
	/**
	 * 响应代码
	 */
	private String status;

	/**
	 * 响应消息
	 */
	private String message;

	/**
	 * 响应结果
	 */
	private Object data;

	public ResultBody() {
	}

	public ResultBody(BaseErrorInfoInterface errorInfo) {
		this.status = errorInfo.getResultCode();
		this.message = errorInfo.getResultMsg();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 成功
	 *
	 * @return
	 */
	public static ResultBody success() {
		return success(null);
	}

	/**
	 * 成功
	 * @param data
	 * @return
	 */
	public static ResultBody success(Object data) {
		ResultBody rb = new ResultBody();
		rb.setStatus(CommonEnum.SUCCESS.getResultCode());
		rb.setMessage(CommonEnum.SUCCESS.getResultMsg());
		rb.setData(data);
		return rb;
	}

	/**
	 * 失败
	 */
	public static ResultBody error(BaseErrorInfoInterface errorInfo) {
		ResultBody rb = new ResultBody();
		rb.setStatus(errorInfo.getResultCode());
		rb.setMessage(errorInfo.getResultMsg());
		rb.setData(null);
		return rb;
	}

	/**
	 * 失败
	 */
	public static ResultBody error(String code, String message) {
		ResultBody rb = new ResultBody();
		rb.setStatus(code);
		rb.setMessage(message);
		rb.setData(null);
		return rb;
	}

	/**
	 * 失败
	 */
	public static ResultBody error( String message) {
		ResultBody rb = new ResultBody();
		rb.setStatus("-1");
		rb.setMessage(message);
		rb.setData(null);
		return rb;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}

}