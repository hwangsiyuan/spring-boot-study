package com.hussein.exception;

/**
 * <p>Title: LoginException</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/9 11:59 AM
 */
public class LoginException extends OaException {

    private int status;

    private String tip;

    public LoginException(int status, String tip) {
        super(tip);
        this.status = status;
        this.tip = tip;
    }

    public int getStatus() {
        return status;
    }

    public String getTip() {
        return tip;
    }
}
