package me.teenyda.nCoV;

import com.alibaba.fastjson.JSONObject;
import com.orhanobut.logger.Logger;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        Map<String, String> map = new HashMap<>();
        map.put("age", "1");
        map.put("name", "tee");
        String json = JSONObject.toJSONString(map);
        Logger.d(json);
    }
}