package com.smart.spel;

import com.smart.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class PropertyExprSample {
    public static void main(String[] args) {
        User user = new User();
        user.setName("tom");
        user.setCredit(200);

        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        String name = (String)parser.parseExpression("name").getValue(context);
        int credit = (Integer)parser.parseExpression("credit").getValue(context);
        System.out.println(credit);
    }
}
