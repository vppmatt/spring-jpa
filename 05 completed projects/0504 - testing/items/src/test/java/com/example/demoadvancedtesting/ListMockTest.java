package com.example.demoadvancedtesting;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ListMockTest {
    // create a mock(unreal) list
    List<String> mockList = mock(List.class);

    @Test
    public void size_basic() {
        // instruct my mock object to exhibit the desired behaviour
        when(mockList.size()).thenReturn(5);

        // verify if my mock behaviour is working
        assertEquals(5, mockList.size());
    }

    @Test
    @Disabled
    public void multipleReturnValues() {
        when(mockList.size()).thenReturn(5).thenReturn(10);

        assertEquals(5, mockList.size());
        assertEquals(10, mockList.size());
    }

    @Test
    public void returnWithGenericParameters() {
        // anyInt() is an argumentMatcher
        when(mockList.get(anyInt())).thenReturn("mockedSuccessfully");
        assertEquals("mockedSuccessfully", mockList.get(9));
        assertEquals("mockedSuccessfully", mockList.get(5));
    }

    // VERIFICATION
    @Test
    public void verificationBasics() {
        String value1 = mockList.get(0);
        String value2 = mockList.get(1);

        // Verify
        verify(mockList).get(0);  // verify if my mockList is invoked with get(0) method
        verify(mockList, times(2)).get(anyInt()); // verify if our mockList.get() method is invoked 2 times with any input argument
        verify(mockList, atLeast(1)).get(anyInt());
        verify(mockList, atLeastOnce()).get(anyInt());
        verify(mockList, atMost(2)).get(anyInt());
        verify(mockList, never()).get(2);
    }

    // CAPTURING ARGUMENTS
    @Test
    public void argumentCapturing() {
        // We can also verify what arguments our mock objects are called with
        // ex. here we pass 'some string' to our mock list
        // we want to check if we have managed to call mock.add() method with
        // correct input arguments
        mockList.add("Some String");
        // First method:
        // verify(mockList).add("Some String");

        // Second method:
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(mockList).add(captor.capture());

        assertEquals("Some String", captor.getValue());

    }

    @Test
    public void multipleArgumentCapturing() {
        mockList.add("SomeString1");
        mockList.add("SomeString2");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        // Here we verify two things:
        // 1. If we have called/invoked add() method 2 times or not
        // 2. If we have passed the correct args on each invocation
        verify(mockList, times(2)).add(captor.capture());   // no longer we use anyString() or anyInt() since the input args this time are important to us

        List<String> allArguments = captor.getAllValues();

        assertEquals("SomeString1", allArguments.get(0));
        assertEquals("SomeString2", allArguments.get(1));
    }

    @Test
    public void mocking() {
        // Let's mock an arrayList object
        ArrayList mockArrayList = mock(ArrayList.class);

        // Let's see what is inside this mock arrayList
        System.out.println(mockArrayList.get(0)); // null

        // Let's check its size as well
        System.out.println(mockArrayList.size());

        // Now, let's interact with our mock arraylist 2 times by adding items to it
        mockArrayList.add("Test");
        mockArrayList.add("Test2");

        // Now, let's see what is the new size of the mock arraylist after adding two items
        // it is still empty.
        // This proves that your interaction with mock object has no impact on it at all.
        // Because the mock object has no knowledge on what to do when we call its size() method
        System.out.println(mockArrayList.size()); // 0

        // But we can instruct our mock arraylist how to behave
        when(mockArrayList.size()).thenReturn(5);

        // Now if you check the method arraylist size you will see
        System.out.println(mockArrayList.size());
    }

    // consider a scenario in which you want to mock an arraylist and teach him his size() method
    // BUT, we also want his others methods work normally as expected without teaching
    // Its like partially mocking an object
    // If you prefer an object to be instructed only on certain methods and exhibits normal behaviour on other methods,
    // you gonna need something called SPY

    @Test
    public void spying() {
        // Another types of objects we deal with in tests are spy objects
        // So, as the name suggests, spy is a real object
        // but since it is a spy, it also can behave based on what we instruct him
        // It means, they are real objects but with the capability to have mocked behaviour
        ArrayList spyArrayList = spy(ArrayList.class);
        spyArrayList.add("Test1");

        // This proves that our spy is behaving like a normal arraylist
        System.out.println(spyArrayList.get(0)); // Test1
        System.out.println(spyArrayList.size()); // 1
        spyArrayList.add("Test2");
        spyArrayList.add("Test3");
        System.out.println(spyArrayList.size()); // 3

        // Now, lets instruct our spy to show the desired behaviour
        when(spyArrayList.size()).thenReturn(6);
        System.out.println(spyArrayList.size());  // 6

        // Even though we have added another item to our arrayList,
        // but since this time we have instructed our spy to return 6 in response to size()
        // no matter how many more items you add to it, it always returns 6
        spyArrayList.add("Test4");
        System.out.println(spyArrayList.size());  // 6

        // We can use verify() for spy objects just like any other mock object
        verify(spyArrayList).add("Test4");


        // The point of using spy is:
        // sometimes you want a dependency to be mocked but the dependency is
        // really huge and it has lots of behaviour which you don't really care,
        // you don't want to write when().then() for every single method of it
        // So, you prefer to have the real object but mock the behaviours that
        // you are interested in and care about.
    }
}
