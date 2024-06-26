package com.dcalano.demo.controller;

import com.dcalano.demo.controller.action.ControllerActionCreate;
import com.dcalano.demo.controller.action.ControllerActionDelete;
import com.dcalano.demo.controller.action.ControllerActionGet;
import com.dcalano.demo.controller.action.ControllerActionList;
import com.dcalano.demo.controller.action.ControllerActionUpdate;
import com.dcalano.demo.dto.BaseDto;

public interface CrudController<D extends BaseDto<T>, T> extends ControllerActionCreate<D>, ControllerActionDelete<T>,
		ControllerActionGet<D, T>, ControllerActionList<D>, ControllerActionUpdate<D, T> {

}
