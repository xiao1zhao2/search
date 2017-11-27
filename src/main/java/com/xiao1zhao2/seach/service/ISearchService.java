package com.xiao1zhao2.seach.service;

import com.xiao1zhao2.seach.core.SearchRequest;

public interface ISearchService {

	SearchResponse<Entity> search(SearchRequest request) throws Exception;
}
