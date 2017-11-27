package com.xiao1zhao2.seach.service;

import com.xiao1zhao2.seach.core.DefaultTranslator;
import com.xiao1zhao2.seach.core.SearchRequest;

public class SearchService implements ISearchService {

	@Override
	public SearchResponse<Entity> search(SearchRequest request) throws Exception {

		String query = new DefaultTranslator().translate(request);

		System.out.println("query >> " + query);
		return null;
	}
}
