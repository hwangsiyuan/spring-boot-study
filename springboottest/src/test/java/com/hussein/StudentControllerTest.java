package com.hussein;

import com.alibaba.fastjson.JSON;
import com.hussein.bean.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * <p>Title: StudentControllerTest</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/3 6:41 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class StudentControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;

    @Before
    public void setupMockMvc() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void addStudent() throws Exception {
        Student student = Student
                .builder()
                .name("孙悟空")
                .age(700)
                .address("花果山")
                .sex("男")
                .build();
        mvc.perform(
                MockMvcRequestBuilders
                        .post("/student/save")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(JSON.toJSONString(student).getBytes()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void findById() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders
                        .get("/student/get/1")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("孙悟空"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address").value("花果山"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(700))
                .andDo(MockMvcResultHandlers.print());
    }
}
