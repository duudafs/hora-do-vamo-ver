package com.mfs.milagre.repositories;

import com.mfs.milagre.models.MilagreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MilagreRepository extends JpaRepository<MilagreModel, Long> {

}
