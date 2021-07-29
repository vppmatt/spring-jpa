package com.example.demoadvancedtesting.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
// Using this annotation we integrate JUnit 5 and Mockito frameworks
class SomeBusinessTest {

    // this tells mockito to inject any field annotated with @Mock into
    // businessWithInjectedDependency object [SUT]
    @InjectMocks
    SomeBusinessImpl businessWithInjectedDependency;


    // Since in unit test we test every component/class in isolation
    // all dependencies of SUT should be mocked, since we don't care about them in unit test
    // we only care about SUT.
    @Mock
    SomeDataService dataServiceMock;

    @Test
    public void calculateSum_basic() {
        // The class we want to test -> SUT [Subject Under Test]
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {1, 2, 3});
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {});
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {5});
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_basic() {
        // instructing our mock dependency
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1, 2, 3});
        int actualResult = businessWithInjectedDependency.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        // instructing our mock dependency
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        int actualResult = businessWithInjectedDependency.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        // instructing our mock dependency
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1});
        int actualResult = businessWithInjectedDependency.calculateSumUsingDataService();
        int expectedResult = 1;
        assertEquals(expectedResult, actualResult);
    }

}