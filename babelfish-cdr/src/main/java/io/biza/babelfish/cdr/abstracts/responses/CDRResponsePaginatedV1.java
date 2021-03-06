/*******************************************************************************
 * Copyright (C) 2020 Biza Pty Ltd
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation, either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *******************************************************************************/
package io.biza.babelfish.cdr.abstracts.responses;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import io.biza.babelfish.cdr.models.payloads.LinksPaginatedV1;
import io.biza.babelfish.cdr.models.payloads.MetaPaginatedV1;
import io.biza.babelfish.cdr.support.FormatChecker;

@Valid
public abstract class CDRResponsePaginatedV1 {

	public abstract LinksPaginatedV1 links();

	public abstract MetaPaginatedV1 meta();

	@AssertTrue(message = "First and Last Page Detected but Total Pages is >1")
	private boolean isTotalPagesBiggerThanLinks() {
		return (links() != null && links().next() == null && links().prev() == null)
				? (meta() != null && meta().totalPages() > 1 ? false : true)
				: true;
	}

	@AssertTrue(message = "Last Page URI page parameter should match totalPages")
	private boolean isLastPagePageParamValid() {
		try {
			return (links() != null && links().last() != null && meta() != null && meta().totalPages() != null)
					? ((Integer.parseInt(FormatChecker.mapifyQueryString(links().last()).get("page")) != meta()
							.totalPages()) ? false : true)
					: true;
		} catch (NumberFormatException e) {
			// 2020-05-10: Unchecked exception discovered by end user.
			return false;
		}
	}
}
