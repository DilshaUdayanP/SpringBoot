package com.example.MusicApp.Exception;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

import javax.swing.plaf.PanelUI;

public class VerifyTheUserCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return "okay".equalsIgnoreCase(context.getEnvironment().getProperty("Admin"));
    }

}
