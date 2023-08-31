package org.encoding;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
//        MsgPackVsJson.compare();
        ProtobufVsJson.compare();
    }
}