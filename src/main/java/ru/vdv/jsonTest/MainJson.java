package ru.vdv.jsonTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainJson {

  public static void main(String[] args) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();

    SomeData someData = new SomeData();
    InnerObject innerObject = new InnerObject();
    innerObject.setParam1("Za VDV!!!");
    innerObject.setParam2("Slava VDV!!!");

    someData.setInnerObject(innerObject);

    String result = objectMapper.writeValueAsString(someData);
    System.out.println(result);

    SomeData newData = objectMapper.readValue(result, SomeData.class);
  }
}
