package com.matias.app.infrastructure.adapter.out.persistance.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matias.app.infrastructure.adapter.out.persistance.entity.PriceEntity;
import com.matias.app.infrastructure.adapter.out.persistance.entity.pk.PriceEntityPk;

public interface PriceJpaRepository extends JpaRepository<PriceEntity, PriceEntityPk> {

}
