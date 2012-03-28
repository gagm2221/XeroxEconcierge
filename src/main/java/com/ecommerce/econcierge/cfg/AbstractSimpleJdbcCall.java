package com.ecommerce.econcierge.cfg;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 * An instance of SpJdbcCall that use Spring SimpleJdbcCall as an implementation
 * 
 * @author EDavid
 * 
 * @param <RETURN>
 */
public abstract class AbstractSimpleJdbcCall<RETURN> implements SpJdbcCall<RETURN>
{
	// The spring SimpleJdbcCall
	private SimpleJdbcCall sp;

	/**
	 * Create an anonymous instance of SimpleJdbcCall feed with dataSource Use
	 * the implementation withoutProcedureColumnMetaDataAccess
	 * 
	 * @param dataSource
	 */
	public AbstractSimpleJdbcCall(DataSource dataSource)
	{
		sp = new SimpleJdbcCall(dataSource)
		{
		};
		sp.withoutProcedureColumnMetaDataAccess();
	}

	/**
	 * Set the stored procedure to be use
	 * 
	 * @param sp
	 */
	protected void setSp(String sp)
	{
		this.sp.withProcedureName(sp);
	}

	/**
	 * Add a paramater declaration to the stored procedure
	 * 
	 * @param name
	 * @param type
	 */
	protected void addDeclaredParameter(String name, int type)
	{
		sp.addDeclaredParameter(new SqlParameter(name, type));
	}

	/**
	 * Define the returning result and the row mapper to be use
	 * 
	 * @param name
	 * @param rowMapper
	 */
	protected void returningResultSet(String name, RowMapper<?> rowMapper)
	{
		sp.returningResultSet(name, rowMapper);
	}

	/**
	 * Compile the SP
	 */
	protected void compile()
	{
		sp.compile();
	}

	/**
	 * Execute the SP
	 * 
	 * @param args
	 * @return
	 */
	protected Map<String, Object> run(Map<String, Object> args)
	{
		return sp.execute(args);
	}
}
