package com.psybooks.psybooksexportingservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psybooks.psybooksexportingservice.entity.Item;

public interface ItemRepository extends JpaRepository<Item, String> {
}
