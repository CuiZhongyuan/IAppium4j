package com.iappium.page.dao;

import com.iappium.entity.TestData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnJianDao extends JpaRepository<TestData, Long> {
}
