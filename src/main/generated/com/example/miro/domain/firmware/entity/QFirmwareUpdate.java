package com.example.miro.domain.firmware.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFirmwareUpdate is a Querydsl query type for FirmwareUpdate
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFirmwareUpdate extends EntityPathBase<FirmwareUpdate> {

    private static final long serialVersionUID = -1478263390L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFirmwareUpdate firmwareUpdate = new QFirmwareUpdate("firmwareUpdate");

    public final com.example.miro.global.common.QBaseEntity _super = new com.example.miro.global.common.QBaseEntity(this);

    public final StringPath afterVersion = createString("afterVersion");

    public final StringPath beforeVersion = createString("beforeVersion");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final com.example.miro.domain.device.entity.QDevice device;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<com.example.miro.domain.firmware.enums.FirmwareUpdateStatus> status = createEnum("status", com.example.miro.domain.firmware.enums.FirmwareUpdateStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QFirmwareUpdate(String variable) {
        this(FirmwareUpdate.class, forVariable(variable), INITS);
    }

    public QFirmwareUpdate(Path<? extends FirmwareUpdate> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFirmwareUpdate(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFirmwareUpdate(PathMetadata metadata, PathInits inits) {
        this(FirmwareUpdate.class, metadata, inits);
    }

    public QFirmwareUpdate(Class<? extends FirmwareUpdate> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.device = inits.isInitialized("device") ? new com.example.miro.domain.device.entity.QDevice(forProperty("device")) : null;
    }

}

