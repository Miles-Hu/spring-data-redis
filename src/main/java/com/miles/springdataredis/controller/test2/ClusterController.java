package com.miles.springdataredis.controller.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Miles Hoo
 * @version v1.0.0
 * @since 18-12-31 下午5:17
 */
@RestController
@RequestMapping("/test")
public class ClusterController {

    private HashOperations hashOp;
    private ValueOperations stringOp;
    private ListOperations<String,String> listOp;
    private SetOperations setOp;
    private ZSetOperations zsetOp;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostConstruct
    public void initOperations(){
        hashOp = stringRedisTemplate.opsForHash();
        stringOp = stringRedisTemplate.opsForValue();
        listOp = stringRedisTemplate.opsForList();
        setOp = stringRedisTemplate.opsForSet();
        zsetOp = stringRedisTemplate.opsForZSet();
    }

    @GetMapping("/test1")
    public String findById(){
       /* stringOp.set("miles","male");
        HashMap map = new HashMap();
        map.put("jacob", "male");
        map.put("max", "male");
        stringOp.multiSet(map);*/
        List list = stringOp.multiGet(Arrays.asList("miles", "jacob", "max"));
        System.out.println(list);
        return list.toString();
    }

    @GetMapping("test2")
    public String test2() {

        System.out.println(listOp.leftPush("friends1", "Rachel"));
        listOp.rightPush("friends1", "Monica");
        List friends1 = listOp.range("friends1", 0l, -1);
        System.out.println(friends1);
        System.out.println(listOp.leftPop("friends1"));
        listOp.set("friends1",0l,"Joey");
        System.out.println(listOp.index("friends1",0l));
        return friends1.toString();
    }
    @GetMapping("test3")
    public String test3() {

        hashOp.put("friends2","rachel","female");
        HashMap<String, String> map = new HashMap<>();
        map.put("Ross", "male");
        map.put("Chandler", "male");
        hashOp.putAll("friends2",map);
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("Chandler");
        list1.add("rachel");
        List list = hashOp.multiGet("friends2", list1);
        System.out.println(list);

        System.out.println(hashOp.entries("friends2"));

        return null;
    }

    @GetMapping("test4")
    public String test4() {

        setOp.add("miles","handsom","programmer","young");
        System.out.println(setOp.isMember("miles", "handsom"));
        System.out.println(setOp.members("miles"));
        Cursor miles = setOp.scan("miles", ScanOptions.scanOptions().count(10l).build());
        while (miles.hasNext()) {
            System.out.println(miles.next());
        }
        return null;
    }

    @GetMapping("test5")
    public String test5() {

        Set<String> keys = stringRedisTemplate.keys("*");
        for (String key : keys) {
            if(!"miles".equals(key)){
                stringRedisTemplate.unlink(key);
            }
        }
        System.out.println(stringRedisTemplate.type("miles").code());
        stringRedisTemplate.rename("miles","miles1");
        return null;
    }

    @GetMapping("test6")
    public String test6() {

        stringRedisTemplate.expire("miles1", 10, TimeUnit.SECONDS);
        while (true) {
            Long countdown = stringRedisTemplate.getExpire("miles1");
            if (countdown == 1) {
                stringRedisTemplate.persist("miles1");
                break;
            }
            System.out.println(countdown);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return null;

    }

}
