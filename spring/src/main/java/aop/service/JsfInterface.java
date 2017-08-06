package aop.service;

import java.util.List;
import java.util.Map;

/**
 * Created by wangxichun on 2017/8/6 0006.
 */
public interface JsfInterface {

    Map<String,List<Result<Long>>> doService(Map params) throws Exception;


    class Result<T> {
        boolean isProcessSuccess;
        int errorCode;
        String msg;
        T data;


        public Result(boolean isProcessSuccess, int errorCode, String msg, T data) {
            this.isProcessSuccess = isProcessSuccess;
            this.errorCode = errorCode;
            this.msg = msg;
            this.data = data;
        }

        public boolean isProcessSuccess() {
            return isProcessSuccess;
        }

        public void setProcessSuccess(boolean processSuccess) {
            isProcessSuccess = processSuccess;
        }

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}
