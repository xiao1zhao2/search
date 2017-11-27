package com.xiao1zhao2.seach.condition;

import com.xiao1zhao2.seach.core.Render;

public interface Condition extends Render {

	Condition and(Condition other);
}
