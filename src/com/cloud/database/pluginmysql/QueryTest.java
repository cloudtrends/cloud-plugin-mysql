package com.cloud.database.pluginmysql;

import com.cloud.host.HostVO;
import com.cloud.utils.db.QueryBuilder;
import com.cloud.utils.db.SearchCriteria.Op;

public class QueryTest {

	
	public void test(){
		int agentId = 1;
		QueryBuilder<HostVO> sc = QueryBuilder.create(HostVO.class);
        sc.and(sc.entity().getId(), Op.EQ, agentId);
        HostVO h = sc.find();
        
	}
}
