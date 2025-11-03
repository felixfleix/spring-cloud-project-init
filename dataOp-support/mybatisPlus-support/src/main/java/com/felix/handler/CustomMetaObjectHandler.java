package com.felix.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

public class CustomMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "gmtCreate", Date::new, Date.class);
        this.strictInsertFill(metaObject, "gmtModified", Date::new, Date.class);
        this.strictInsertFill(metaObject, "deleted", () -> 0, Integer.class);
        this.strictInsertFill(metaObject, "lockVersion", () -> 0, Integer.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "gmtModified", Date::new, Date.class);
    }
}
