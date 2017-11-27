package com.xiao1zhao2.seach.main;

import com.xiao1zhao2.seach.core.SearchRequest;
import com.xiao1zhao2.seach.core.SearchRequestBuilder;
import com.xiao1zhao2.seach.service.*;

public class Main {

	private static ISearchService service = new SearchService();

	public static void main(String[] args) throws Exception {

		SearchRequest request = new SearchRequestBuilder()
				.and(SearchFields.CITY.equal("bj"))
				.and(SearchFields.CATE.in(1, 2))
				.and(SearchFields.AGE.between(20, 35))
				.and(SearchFields.HAS_PHOTO.equal(true))
				.sort(SearchFields.AGE.desc())
				.sort(SearchFields.HAS_PHOTO.asc())
				.page(1)
				.pageSize(50)
				.build();

		SearchResponse<Entity> response = service.search(request);

	}
}
