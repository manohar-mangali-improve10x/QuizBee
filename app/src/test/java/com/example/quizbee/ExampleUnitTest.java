package com.example.quizbee;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.quizbee.model.Quiz;
import com.example.quizbee.network.FakeApi;
import com.example.quizbee.network.OnServiceApi;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void getShopDetails() throws IOException {
        OnServiceApi onService = new FakeApi().createFakeApiService();
        Call<List<Quiz>> call = onService.getDataApi();
        List<Quiz> shop = call.execute().body();
        assertFalse(shop.isEmpty());
        assertNotNull(shop);
        System.out.println(new Gson().toJson(shop));
    }
}