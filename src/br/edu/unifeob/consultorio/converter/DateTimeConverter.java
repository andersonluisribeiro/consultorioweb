package br.edu.unifeob.consultorio.converter;

import static com.google.common.base.Strings.isNullOrEmpty;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.ConversionException;
import br.com.caelum.vraptor.converter.ConversionMessage;
import br.com.caelum.vraptor.converter.Converter;

@Alternative
@Priority(Interceptor.Priority.APPLICATION)
@Convert(Date.class)
public class DateTimeConverter implements Converter<Date>{

	public static final String INVALID_MESSAGE_KEY = "is_not_a_valid_date";

	private final Locale locale;
	
	protected DateTimeConverter() {
		this(null);
	}

	@Inject
	public DateTimeConverter(Locale locale) {
		this.locale = locale;
	}
	
	@Override
	public Date convert(String value, Class<? extends Date> type) {
		if (isNullOrEmpty(value)) {
			return null;
		}

		try {
			return getDateFormat().parse(value);

		} catch (ParseException pe) {
			throw new ConversionException(new ConversionMessage(INVALID_MESSAGE_KEY, value));
		}
	}

	protected DateFormat getDateFormat() {
		return DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, locale);
	}
	
}
