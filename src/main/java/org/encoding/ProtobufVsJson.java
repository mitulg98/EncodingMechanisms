package org.encoding;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Arrays;

public class ProtobufVsJson {
    public static void compare() throws JsonProcessingException, InvalidProtocolBufferException {
        Person person = new Person();
        person.setId(25);
        person.setName("Mitul Gupta");

        String json = JacksonSerializer.serialize(person);

        PersonOuterClass.Person protoPerson = PersonOuterClass.Person.
                newBuilder().
                setId(25).
                setName("Mitul Gupta").
                build();

        byte[] bytePerson = protoPerson.toByteArray();

        System.out.println("JSON Size : " + json.getBytes().length + " bytes. Protobuf Size : " + bytePerson.length + " bytes.");

        PersonOuterClass.Person person2 = PersonOuterClass.Person.parseFrom(bytePerson);
        System.out.println(person2.toString());
        System.out.println(Arrays.toString(bytePerson));
    }
}
