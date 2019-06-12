package register.enums;

/**
 * @author gege
 * @Description 注册式单例之枚举单例
 * @date 2019/3/18 14:41
 */
public enum EnumSingleton {
    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
