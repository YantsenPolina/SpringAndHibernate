package com.polinayantsen.jsondemo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.net.URL;

public class Driver {

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            URL url = Driver.class.getResource("/sample-full.json");
            Student student = mapper.readValue(new File(url.getPath()), Student.class);
            System.out.println("Student: " + student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
