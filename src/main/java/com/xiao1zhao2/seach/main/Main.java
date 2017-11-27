package com.xiao1zhao2.seach.main;

import com.xiao1zhao2.seach.core.SearchRequest;
import com.xiao1zhao2.seach.core.SearchRequestBuilder;
import com.xiao1zhao2.seach.service.ISearchService;
import com.xiao1zhao2.seach.service.SearchFields;
import com.xiao1zhao2.seach.service.SearchService;

public class Main {

	private static ISearchService service = new SearchService();

	public static void main(String[] args) throws Exception {

		/**
		 * expand : city=bj&cate=1|2&age=20_35&hasPhoto=1&sort=age_desc,hasPhoto_asc&page=1&size=50
		 */
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

		service.search(request);

	}
}
