package com.example.miro.domain.userDevice.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserDevice is a Querydsl query type for UserDevice
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserDevice extends EntityPathBase<UserDevice> {

    private static final long serialVersionUID = -1899153019L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserDevice userDevice = new QUserDevice("userDevice");

    public final com.example.miro.global.common.QBaseEntity _super = new com.example.miro.global.common.QBaseEntity(this);

    public final BooleanPath autoCleanEnabled = createBoolean("autoCleanEnabled");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<com.example.miro.domain.userDevice.enums.CleanMode> defaultMode = createEnum("defaultMode", com.example.miro.domain.userDevice.enums.CleanMode.class);

    public final com.example.miro.domain.device.entity.QDevice device;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isInitialized = createBoolean("isInitialized");

    public final DateTimePath<java.time.LocalDateTime> lastConnectedAt = createDateTime("lastConnectedAt", java.time.LocalDateTime.class);

    public final ListPath<com.example.miro.domain.schedule.entity.Schedule, com.example.miro.domain.schedule.entity.QSchedule> schedules = this.<com.example.miro.domain.schedule.entity.Schedule, com.example.miro.domain.schedule.entity.QSchedule>createList("schedules", com.example.miro.domain.schedule.entity.Schedule.class, com.example.miro.domain.schedule.entity.QSchedule.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final com.example.miro.domain.user.entity.QUser user;

    public QUserDevice(String variable) {
        this(UserDevice.class, forVariable(variable), INITS);
    }

    public QUserDevice(Path<? extends UserDevice> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserDevice(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserDevice(PathMetadata metadata, PathInits inits) {
        this(UserDevice.class, metadata, inits);
    }

    public QUserDevice(Class<? extends UserDevice> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.device = inits.isInitialized("device") ? new com.example.miro.domain.device.entity.QDevice(forProperty("device")) : null;
        this.user = inits.isInitialized("user") ? new com.example.miro.domain.user.entity.QUser(forProperty("user")) : null;
    }

}

