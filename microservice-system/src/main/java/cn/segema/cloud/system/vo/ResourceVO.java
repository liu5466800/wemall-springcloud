package cn.segema.cloud.system.vo;

import java.io.Serializable;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 资源
 * 
 * @author wangyong
 *
 */
@JsonInclude(value = Include.NON_EMPTY)
public class ResourceVO implements Serializable {
	private static final long serialVersionUID = 775279373134000868L;

	private BigInteger resourceId;

	private String resourceName;

	public BigInteger getResourceId() {
		return resourceId;
	}

	public void setResourceId(BigInteger resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

}
