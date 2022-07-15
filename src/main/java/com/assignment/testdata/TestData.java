package com.assignment.testdata;


import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "set")
@Getter
public class TestData {

    private String MainMenu;
    private String SubMenu;
    private String Filter;
    private String NthLargestNum;
}
