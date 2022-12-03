package com.archql.labs.wtlab4pst.controller.command;

import com.archql.labs.wtlab4pst.controller.context.RequestContextHelper;

import javax.servlet.http.HttpServletResponse;

public interface Command {
    CommandResult execute(RequestContextHelper helper, HttpServletResponse response);
}
