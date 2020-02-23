package com.vanpanda.crmsystem.wrappers;

public interface Result<T> {
    public String getMessage();
    public void setMessage(String message);
    public boolean isSuccess();
    public void setSuccess(boolean isSuccess);
    public T getItem();
    public void setItem(T item);
}
