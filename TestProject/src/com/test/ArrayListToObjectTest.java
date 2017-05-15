package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListToObjectTest {
	public static void main(String[] args) {
	
		
		List<String> list = Arrays.asList("foo", "bar", "baz");
		String joined = String.join(" ,", list); // "foo and bar and baz"
		System.out.println(joined);
		
	}

}
