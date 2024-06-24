package com.example.demo.util;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExceptionSourceName {
    public static final String ADDRESS = "address";
    public static final String CATEGORY = "category";
    public static final String INGREDIENT = "ingredient";
    public static final String ORDER_ITEM = "order item";
    public static final String ORDER = "order";
    public static final String PRODUCT = "product";
    public static final String USER = "user";
}
