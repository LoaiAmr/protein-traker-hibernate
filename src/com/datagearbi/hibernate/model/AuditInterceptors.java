package com.datagearbi.hibernate.model;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class AuditInterceptors extends EmptyInterceptor{

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		System.out.println("Savin an Entity...");
		return false;
	}

	@Override
	public void postFlush(Iterator entities) {
		System.out.println("After Entity has been Flushed...");
	}

	
}
