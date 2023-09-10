package com.isheikh03.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseRepository {
	
	@Autowired
	private EntityManager entityManager;
	
	public <T> T baseSave(T obj) {
		try {
			this.entityManager.persist(obj);
			return obj;
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return null;
	}
	public <T> T baseUpdate(T obj) {
		try {
			T objSaved = this.entityManager.merge(obj);
			return objSaved;
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return null;
	}
	
	public <T> T baseFindOne(String sql,  Class<T> clazz) {
		try {
			return this.entityManager.createQuery(sql, clazz).getSingleResult();
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return null;
	}
	
	public <T> List<T> baseFindList(String sql,  Class<T> clazz) {
		try {
			return entityManager.createQuery(sql, clazz).getResultList();
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return null;
    }
	
	public <T> List<T> baseFindListByLimit(int limit, String sql,  Class<T> clazz) {
		try {
			return entityManager.createQuery(sql, clazz).setMaxResults(limit).getResultList();
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return null;
	}

}
