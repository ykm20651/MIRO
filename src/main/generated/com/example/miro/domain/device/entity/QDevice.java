package com.example.miro.domain.device.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;


/**
 * QDevice is a Querydsl query type for Device
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDevice extends EntityPathBase<Device> {

    private static final long serialVersionUID = 1864416879L;

    public static final QDevice device = new QDevice("device");

    public final com.example.miro.global.common.QBaseEntity _super = new com.example.miro.global.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath firmwareVersion = createString("firmwareVersion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath modelName = createString("modelName");

    public final StringPath serialNumber = createString("serialNumber");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QDevice(String variable) {
        super(Device.class, forVariable(variable));
    }

    public QDevice(Path<? extends Device> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDevice(PathMetadata metadata) {
        super(Device.class, metadata);
    }

}

