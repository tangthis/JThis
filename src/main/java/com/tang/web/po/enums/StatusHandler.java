package com.tang.web.po.enums;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;


@SuppressWarnings("rawtypes")
public class StatusHandler extends BaseTypeHandler implements TypeHandler {

	@Override
	public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		Integer s = rs.getInt(columnIndex);
		return s == null ? null : Status.getStatusByType(s);
	}

	@Override
	public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
		Integer s = rs.getInt(columnName);  
	    return s == null ? null : Status.getStatusByType(s);
	}

	@Override
	public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		Integer s = cs.getInt(columnIndex);  
	    return s == null ? null : Status.getStatusByType(s);
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
		ps.setInt(i, ((Status)parameter).ordinal());  
	}
}
