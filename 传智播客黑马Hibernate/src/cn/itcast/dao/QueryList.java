package cn.itcast.dao;

import java.util.List;

public class QueryList {
	private int count; // 总记录数
	private List list; // 一页的数据

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public QueryList(int count, List list) {
		this.count = count;
		this.list = list;
	}
}
