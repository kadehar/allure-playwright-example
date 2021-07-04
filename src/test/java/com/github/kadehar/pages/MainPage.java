package com.github.kadehar.pages;

import com.github.kadehar.utils.ContextProvider;
import com.microsoft.playwright.Page;

public class MainPage {
    public final Page page = ContextProvider.getPage();
}
