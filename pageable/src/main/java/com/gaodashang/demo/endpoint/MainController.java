package com.gaodashang.demo.endpoint;

import com.gaodashang.demo.domain.Page;
import com.gaodashang.demo.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * comments.
 *
 * @author eva
 */
@RestController
public class MainController {

    //http://localhost:8077/pageable/hello?size=100
    @RequestMapping(value = "/hello")
    public Map<String, String> hello(Pageable pageable) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "gaodashang");
        map.put("age", "30");
        map.put("pageable", pageable.getPageNumber() + "");
        return map;
    }

    //curl -X POST http://192.168.1.99:8077/pageable/world -H "Content-Type: application/json;charset=UTF-8" -d "{\"page\":\"100\",\"size\":200,\"sort\":\"desc\",\"name\":\"gaodashang\",\"age\":30}"
    //user获取不到
    @RequestMapping(value = "/world")
    public Map<String, Object> world(@RequestBody Page page, User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", page);
        map.put("user", user);
        return map;
    }


}
