package com.psybooks.psybooksexportingservice.entity.dto;

import com.psybooks.psybooksexportingservice.entity.CurrencyKey;
import com.psybooks.psybooksexportingservice.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDto {
    private String id;
    private String nameLocalizationKey;
    private String descriptionLocalizationKey;
    private String category;
    private Long price;
    private CurrencyKey currency;
    private Boolean instancesLeft;
    private String photoUri;
    private String metaKeyWordsLocalizationKey;
    private String metaDescriptionLocalizationKey;
    private String headerLocalizationKey;

    public ItemDto(Item item) {
        this(
            item.getId(),
            item.getNameLocalizationKey(),
            item.getDescriptionLocalizationKey(),
            item.getCategory(),
            item.getPrice(),
            item.getCurrency(),
            item.getInstancesLeft(),
            item.getPhotoUri(),
            item.getMetaKeyWordsLocalizationKey(),
            item.getMetaDescriptionLocalizationKey(),
            item.getHeaderLocalizationKey()
        );
    }
}
