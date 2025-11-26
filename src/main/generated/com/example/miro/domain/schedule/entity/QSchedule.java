package com.example.miro.domain.schedule.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSchedule is a Querydsl query type for Schedule
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSchedule extends EntityPathBase<Schedule> {

    private static final long serialVersionUID = -1497034447L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSchedule schedule = new QSchedule("schedule");

    public final com.example.miro.global.common.QBaseEntity _super = new com.example.miro.global.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath day = createString("day");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<com.example.miro.domain.userDevice.enums.CleanMode> mode = createEnum("mode", com.example.miro.domain.userDevice.enums.CleanMode.class);

    public final EnumPath<com.example.miro.domain.schedule.enums.RepeatType> repeatType = createEnum("repeatType", com.example.miro.domain.schedule.enums.RepeatType.class);

    public final StringPath time = createString("time");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final com.example.miro.domain.userDevice.entity.QUserDevice userDevice;

    public QSchedule(String variable) {
        this(Schedule.class, forVariable(variable), INITS);
    }

    public QSchedule(Path<? extends Schedule> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSchedule(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSchedule(PathMetadata metadata, PathInits inits) {
        this(Schedule.class, metadata, inits);
    }

    public QSchedule(Class<? extends Schedule> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userDevice = inits.isInitialized("userDevice") ? new com.example.miro.domain.userDevice.entity.QUserDevice(forProperty("userDevice"), inits.get("userDevice")) : null;
    }

}

