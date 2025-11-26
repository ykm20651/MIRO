package com.example.miro.domain.firmware.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;


/**
 * QFirmware is a Querydsl query type for Firmware
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFirmware extends EntityPathBase<Firmware> {

    private static final long serialVersionUID = 24745849L;

    public static final QFirmware firmware = new QFirmware("firmware");

    public final com.example.miro.global.common.QBaseEntity _super = new com.example.miro.global.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath downloadUrl = createString("downloadUrl");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath latestVersion = createString("latestVersion");

    public final StringPath modelName = createString("modelName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QFirmware(String variable) {
        super(Firmware.class, forVariable(variable));
    }

    public QFirmware(Path<? extends Firmware> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFirmware(PathMetadata metadata) {
        super(Firmware.class, metadata);
    }

}

