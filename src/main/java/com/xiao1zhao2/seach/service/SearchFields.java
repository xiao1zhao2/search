package com.xiao1zhao2.seach.service;

import com.xiao1zhao2.seach.actor.Field;

public class SearchFields {

	public static final Field<String> CITY = new Field<String>("city");
	public static final Field<Integer> CATE = new Field<Integer>("cate");
	public static final Field<Integer> AGE = new Field<Integer>("age");
	public static final Field<Boolean> HAS_PHOTO = new Field<Boolean>("hasPhoto");
}
