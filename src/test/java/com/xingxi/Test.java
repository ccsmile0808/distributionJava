package com.xingxi;

import com.xingxi.websocket.Person;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author cc
 * @Date 2019-03-03 23:04:04 Sunday
 */
@Slf4j
public class Test extends TestCase {

    private Optional<String> getNickName(String name){
        Map<String,String> nicknames = new HashMap<>();
        nicknames.put("xiejq","hahha");
        nicknames.put("xingxi","hahha");
        nicknames.put("baobao","hahha");
        return Optional.ofNullable(nicknames.get(name));

    }

    public void testNullable(){
        Optional<String> nickName = getNickName("hhh");
        if(nickName.isPresent()){
            System.out.print(getNickName("hhh").get());

        }
       System.out.print(getNickName("hhh").orElse("默认值"));
    }

    public void testDate(){
        LocalTime localTime = LocalTime.of(0,0,0);
        LocalDate localDate = LocalDate.of(1975,4,1);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate,localTime, ZoneId.of("Asia/Taipei"));

        System.out.print(zonedDateTime);
        System.out.print(zonedDateTime.toEpochSecond());
        System.out.print(zonedDateTime.toInstant().toEpochMilli());

    }

    public void testReverse() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:\\xingxi")));
        Person person = (Person)ois.readObject();
        log.info("读取的数据:{}",person.getName());
    }
}
