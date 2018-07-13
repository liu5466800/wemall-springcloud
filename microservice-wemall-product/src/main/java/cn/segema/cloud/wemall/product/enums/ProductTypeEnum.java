package cn.segema.cloud.wemall.product.enums;

public enum ProductTypeEnum {
	
	REGISTED("注册用户"),
	NO_REGISTED("非注册用户");

	private String typeName;

	ProductTypeEnum(String typeName) {
		this.typeName = typeName;
	}

	public String getValue() {
		return typeName;
	}

    public static ProductTypeEnum valueOf(Integer type) {
        if (type == null) {
            return null;
        }

        for (ProductTypeEnum item : values()) {
            if (item.ordinal() == type) {
                return item;
            }
        }
        return null;
    }
}
