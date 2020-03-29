package com.smart.spel;

import com.smart.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.List;
import java.util.Map;

public class CollectionExprSample {
    public static void main(String[] args) {
        User user = new User();
        user.setName("tom");
        user.setCredit(200);

        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        int[] array1 = (int [])parser.parseExpression("new int[]{1,2,3}").getValue(context);
        List list1 = (List)parser.parseExpression("{1,2,3,4}").getValue(context);
        List list2 = parser.parseExpression("{1,2,3,4}").getValue(context,List.class);

//        Map userInfo = (Map)parser.parseExpression("{name:'tom',credit:200}");

        System.out.println(array1[0]);
        System.out.println(list1);
        System.out.println(list2);
//        System.out.println(userInfo);
    }
}
