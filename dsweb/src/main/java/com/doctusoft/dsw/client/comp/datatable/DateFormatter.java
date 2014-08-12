package com.doctusoft.dsw.client.comp.datatable;

/*
 * #%L
 * dsweb
 * %%
 * Copyright (C) 2014 Doctusoft Ltd.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


import java.io.Serializable;
import java.util.Date;

import com.doctusoft.bean.binding.Converter;
import com.doctusoft.dsw.client.util.DateTimeFormat;

public class DateFormatter implements Converter<Date, String>, Serializable{
	
	private DateTimeFormat simpleDateFormat;

	public DateFormatter(String pattern) {
		simpleDateFormat = DateTimeFormat.getFormat(pattern);
	}
	
	@Override
	public String convertSource(Date source) {
		if (source == null) {
			return "";
		}
		return simpleDateFormat.format(source);
	}
	
	public Date convertTarget(String target) {
		throw new UnsupportedOperationException();
	}

}
