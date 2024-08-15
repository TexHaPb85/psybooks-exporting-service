package com.psybooks.psybooksexportingservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.psybooks.psybooksexportingservice.entity.dto.ItemDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "items")
public class Item {
    @Id
    private String id;
    private String nameLocalizationKey;
    private String descriptionLocalizationKey;
    private String category;
    private Long price;
    @Enumerated(EnumType.STRING)
    private CurrencyKey currency;
    private Boolean instancesLeft;
    private String photoUri;
    private String metaKeyWordsLocalizationKey;
    private String metaDescriptionLocalizationKey;
    private String headerLocalizationKey;

    public Item(ItemDto itemDto){
        this.id = itemDto.getId();
        this.price=itemDto.getPrice();
        this.nameLocalizationKey=itemDto.getNameLocalizationKey();
        //TODO other fields
    }
}
