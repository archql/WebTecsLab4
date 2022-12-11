package com.archql.labs.wtlab4pst.service.validator.impl;

import com.archql.labs.wtlab4pst.service.validator.AbstractValidator;

public class NaturalNumberValidator extends AbstractValidator {
    private static final String NATURAL_NUMBER_REGEX = "^(([1-9][0-9]*)|([1-9]))$";

    @Override
    protected String getRegex() {
        return NATURAL_NUMBER_REGEX;
    }
}