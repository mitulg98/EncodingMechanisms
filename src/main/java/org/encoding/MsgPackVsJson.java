package org.encoding;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageUnpacker;

import java.io.IOException;
import java.util.Arrays;

public class MsgPackVsJson {
    public static void compare() throws IOException {
        Person person = new Person("John Doe", 30);
        String json = JacksonSerializer.serialize(person);

        MessageBufferPacker packer = MessagePack.newDefaultBufferPacker();
        packer.packMapHeader(2)
                .packString("name")
                .packString("John Doe")
                .packString("id")
                .packInt(30);

        packer.close();

        byte[] packagedPerson = packer.toByteArray();

        int jsonSize = json.getBytes().length;
        int msgPackSize = packagedPerson.length;

        System.out.println(json);
        System.out.println(Arrays.toString(packagedPerson));
        System.out.println("JSON Size : " + jsonSize + " bytes. Message Pack Size : " + msgPackSize + " bytes.");

//        for(byte b: packagedPerson) {
//            System.out.println(Integer.toBinaryString(b));
//        }

//        MessageUnpacker unpacker = MessagePack.newDefaultUnpacker(packagedPerson);
//        System.out.println(unpacker.unpackMapHeader());
//        System.out.println(unpacker.unpackString());
//        System.out.println(unpacker.unpackString());
//        System.out.println(unpacker.unpackString());
//        System.out.println(unpacker.unpackInt());
    }
}
