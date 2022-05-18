/**
 * 
 */
package com.ams.repository;

import com.ams.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * @createdBy: Anwar.Badr
 *
 */
public interface BaseRepository<T extends BaseEntity<ID>, ID extends Serializable> extends JpaRepository<T, ID> {
}
