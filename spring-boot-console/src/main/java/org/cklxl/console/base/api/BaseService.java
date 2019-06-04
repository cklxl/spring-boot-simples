package org.cklxl.console.base.api;

public interface BaseService<T, ID> {

    T selectById(ID id);
}
