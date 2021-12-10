package com.tyss.esslite.idgenerator;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;


public class ProfilePrefIxedSequenceGenerator extends SequenceStyleGenerator{
	
	public static final String VALUE_PREFIX_PARAMETER ="valuePrefix";
	public static final String VALUE_PREFIX_DEFAULT ="PRO";
	
	private String valuePrefix ;
	public static final String DATE_FORMAT_PARAMETER_YEAR = "dateYearFormat";
    public static final String DATE_FORMAT_DEFAULT_YEAR = "%tY";
    
    public static final String DATE_FORMAT_PARAMETER_MONTH = "dateMonthFormat";
    public static final String DATE_FORMAT_DEFAULT_MONTH = "%tm";
	
	public static final String NUMBER_FORMAT_PARAMETER ="numberFormat";
	
	public static final String NUMBER_FORMAT_DEFAULT ="%d";
	
	private String dateYearFormat;
	
	private String format;

	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
	
		super.configure(LongType.INSTANCE, params, serviceRegistry);
		 valuePrefix =ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER, params,VALUE_PREFIX_DEFAULT);
		String numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER,params, NUMBER_FORMAT_DEFAULT);
		dateYearFormat = ConfigurationHelper.getString(DATE_FORMAT_PARAMETER_YEAR, params, DATE_FORMAT_DEFAULT_YEAR); 
		String dateMonthFormat = ConfigurationHelper.getString(DATE_FORMAT_PARAMETER_MONTH, params, DATE_FORMAT_DEFAULT_MONTH); 
		this.format=dateMonthFormat+numberFormat;
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
	
		return valuePrefix+String.format(dateYearFormat,LocalDate.now(),super.generate(session, object))+String.format(format,LocalDate.now(),super.generate(session, object));
	}

}
