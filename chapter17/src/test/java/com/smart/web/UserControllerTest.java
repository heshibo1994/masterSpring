package com.smart.web;

import com.smart.domain.User;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserControllerTest  extends AbstractTransactionalTestNGSpringContextTests {
    @Test
    public void testhandle41() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        form.add("userName", "tom");
        form.add("password", "123456");
        form.add("age", "45");
        restTemplate.postForLocation(
                "http://localhost:8080/chapter17/user/handle41.html", form);
    }

    @Test
    public void testhandle42() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        byte[] response = restTemplate.postForObject(
                "http://localhost:8080/chapter17/user/handle42/{itemId}.html", null, byte[].class, "1233");
        Resource outFile = new FileSystemResource("d:/image_copy.jpg");
        FileCopyUtils.copy(response, outFile.getFile());
    }

    @Test
    public void testHandle82(){
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String,String>form = new LinkedMultiValueMap<String,String>();
        form.add("userName","tom");
        form.add("birthday","2019-01-10");
        form.add("salary","4,455.09");
        String html = restTemplate.postForObject("http://localhost:8080/chapter17/user/handle82.html",form,String.class);
        Assert.assertNotNull(html);
        Assert.assertTrue(html.indexOf("tom")>-1);
    }


}
