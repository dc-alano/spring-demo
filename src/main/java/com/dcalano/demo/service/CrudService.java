package com.dcalano.demo.service;

import com.dcalano.demo.service.action.Create;
import com.dcalano.demo.service.action.Delete;
import com.dcalano.demo.service.action.Get;
import com.dcalano.demo.service.action.List;
import com.dcalano.demo.service.action.Update;

public interface CrudService<E, T> extends Create<E>, Delete<T>, Get<E, T>, List<E>, Update<E, T> {

}
