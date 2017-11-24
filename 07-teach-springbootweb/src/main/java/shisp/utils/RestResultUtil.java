package shisp.utils;

/**
 * 返回信息包装
 */
public class RestResultUtil {

    private static ResponseResult<Object> result;

    public static ResponseResult<> success(Object object) {
        result = new ResponseResult<>();
        result.setErrorCode(0);
        result.setErrorMsg("成功");
        result.setData(object);
        return result;
    }

    public static ResponseResult<?> success() {
        return success(null);
    }

    public static ResponseResult<Object> error(int code, String msg) {
        result = new ResponseResult<>();
        result.setErrorCode(code);
        result.setErrorMsg(msg);
        return result;
    }
}
