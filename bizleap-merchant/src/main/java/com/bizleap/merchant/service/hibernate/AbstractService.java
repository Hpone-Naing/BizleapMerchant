package com.bizleap.merchant.service.hibernate;

import com.bizleap.merchant.enums.EntityType;

public interface AbstractService {

	public long getCount();
	public String getNextBoId(EntityType entityType);
	public String makeBoId(String prefix, int currentObjCount);
	public String makeBoId(EntityType entityType, int currentObjectCount);
}
