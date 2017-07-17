package com.pethoalpar;

import com.pethoalpar.beans.AsyncBean;
import com.pethoalpar.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by petho on 2017-07-17.
 */
public class Main {

    public static void main(String [] args){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AsyncBean b1 = context.getBean(AsyncBean.class);
        AsyncBean b2 = context.getBean(AsyncBean.class);
        AsyncBean b3 = context.getBean(AsyncBean.class);
        AsyncBean b4 = context.getBean(AsyncBean.class);
        AsyncBean b5 = context.getBean(AsyncBean.class);

        b1.runAsyncTask("1",7000);
        b2.runAsyncTask("2",1000);
        b3.runAsyncTask("3",3000);
        b4.runAsyncTask("4",4000);
        b5.runAsyncTask("5",6000);
    }
}
