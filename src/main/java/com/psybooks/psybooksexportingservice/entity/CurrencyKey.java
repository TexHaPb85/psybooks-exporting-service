package com.psybooks.psybooksexportingservice.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CurrencyKey {
    UAH("UAH", "Hrivna"),
    EUR("EUR", "Euro"),
    USD("USD", "US Dollar");
    private String currencyCode;
    private String currencyName;
}
