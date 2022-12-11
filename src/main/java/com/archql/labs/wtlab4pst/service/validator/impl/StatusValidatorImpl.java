package com.archql.labs.wtlab4pst.service.validator.impl;

import com.archql.labs.wtlab4pst.service.validator.AbstractValidator;

public class StatusValidatorImpl extends AbstractValidator {
    private static final String STATUS_REGEX = "^(.{1,15})$";

    @Override
    protected String getRegex() {
        return STATUS_REGEX;
    }
}
