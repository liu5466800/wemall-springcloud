package cn.segema.cloud.common.vo;

import java.io.Serializable;

public class ApiResult implements Serializable{
	
	private static final long serialVersionUID = -5817878425419706227L;
	/**
	 * @fields status 状态信息，正确返回OK，
	 * 否则返回 ERROR，如果返回ERROR则需要填写Message信息
	 */
	private Status status;
	/**
	 * @fields record 消息对象
	 */
	private Object message;
	/**
	 * @fields record 数据对象
	 */
	private Object data;

	public ApiResult() {
		super();
	}
	/**
	 * @description
	 * @param status 状态
	 * @param message 消息
	 */
	public ApiResult(Status status, Object message) {
		this.status = status;
		this.message = message;
	}
	/**
	 * @description
	 * @param status 状态
	 * @param message 消息
	 * @param data 数据
	 */
	public ApiResult(Status status, Object message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	/**
	 * @ClassName: Status
	 * @description: 结果类型信息
	 * @author: wangyong
	 * @date: 2016年2月27日 下午9:51:10
	 */
	public enum Status {
		OK, ERROR
	}

	/**
	 * @title: addOK
	 * @description: 添加成功结果信息
	 * @return: void
	 */
	public void addOK(Object message) {
		this.message = message;
		this.status = Status.OK;
	}
	/**
	 * @title: addError
	 * @description: 添加错误消息
	 * @return: void
	 */
	public void addError(Object message) {
		this.message = message;
		this.status = Status.ERROR;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Object getMessage() {
		return message;
	}
	public void setMessage(Object message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
