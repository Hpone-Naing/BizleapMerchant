package com.bizleap.merchant.loader;

import java.util.Map;
import com.bizleap.common.domain.Error;

public interface ErrorHandler {
	public void handleLoadingError(int lineNumber, String message, Object source);
	public void handleLinkageError(String message, Object source);
	public Map<Integer,Error> getErrorMap();
	public boolean hasError();
}