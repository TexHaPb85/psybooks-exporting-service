package com.psybooks.psybooksexportingservice.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocalizationEntity {
    private String key;
    private String uaLocalization;
    private String ruLocalization;
    private String enLocalization;
}
