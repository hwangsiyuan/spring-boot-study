package com.hussein;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>Title: GreetingController</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/26 10:56 AM
 */
@RestController
public class GreetingController {

    private final AtomicLong al = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(name = "name", defaultValue = "world") String name) {
        return new Greeting(al.incrementAndGet(), "Hello " + name);
    }

    private static class Greeting {

        private Long id;

        private String content;

        public Greeting(Long id, String content) {
            this.id = id;
            this.content = content;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
