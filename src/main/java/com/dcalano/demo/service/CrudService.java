package com.dcalano.demo.service;

import com.dcalano.demo.entity.BaseEntity;
import com.dcalano.demo.service.action.ServiceActionCreate;
import com.dcalano.demo.service.action.ServiceActionDelete;
import com.dcalano.demo.service.action.ServiceActionGet;
import com.dcalano.demo.service.action.ServiceActionList;
import com.dcalano.demo.service.action.ServiceActionUpdate;

public interface CrudService<E extends BaseEntity<T>, T> extends ServiceActionCreate<E>, ServiceActionDelete<T>,
		ServiceActionGet<E, T>, ServiceActionList<E>, ServiceActionUpdate<E, T> {

}
