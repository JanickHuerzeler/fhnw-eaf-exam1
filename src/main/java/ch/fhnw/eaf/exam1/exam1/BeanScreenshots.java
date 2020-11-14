package ch.fhnw.eaf.exam1.exam1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BeanScreenshots {

    @Autowired
    BeanFactory ctx;

    public BeanScreenshots(){
        ctx.getBean("Test");
    }
    
}
