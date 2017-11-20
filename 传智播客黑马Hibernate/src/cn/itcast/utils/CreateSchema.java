package cn.itcast.utils;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class CreateSchema {
	@Test
	/**
	 * 生成表结   方式二：
	 * @throws Exception
	 */
	public void testName() throws Exception {
		Configuration cfg=new Configuration().configure();
		SchemaExport schemaExport=new SchemaExport(cfg);
		//第一个参数script是： print the DDL to the console
		//第二个参数export是： export the script to the database
		schemaExport.create(true, true);
	}
}
