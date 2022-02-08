package com.toy.anagrams;

import com.toy.anagrams.lib.StaticWordLibraryTest;
import com.toy.anagrams.lib.UserGuessNegativeTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({StaticWordLibraryTest.class, UserGuessNegativeTest.class})
public class AnagramsTestSuite {
}
