package com.example.miro.domain.history.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHistory is a Querydsl query type for History
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHistory extends EntityPathBase<History> {

    private static final long serialVersionUID = -1117380183L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHistory history = new QHistory("history");

    public final com.example.miro.global.common.QBaseEntity _super = new com.example.miro.global.common.QBaseEntity(this);

    public final NumberPath<Integer> areaSize = createNumber("areaSize", Integer.class);

    public final NumberPath<Integer> batteryUsage = createNumber("batteryUsage", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Integer> duration = createNumber("duration", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> endedAt = createDateTime("endedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<com.example.miro.domain.userDevice.enums.CleanMode> mode = createEnum("mode", com.example.miro.domain.userDevice.enums.CleanMode.class);

    public final DateTimePath<java.time.LocalDateTime> startedAt = createDateTime("startedAt", java.time.LocalDateTime.class);

    public final EnumPath<com.example.miro.domain.history.enums.HistoryStatus> status = createEnum("status", com.example.miro.domain.history.enums.HistoryStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final com.example.miro.domain.userDevice.entity.QUserDevice userDevice;

    public QHistory(String variable) {
        this(History.class, forVariable(variable), INITS);
    }

    public QHistory(Path<? extends History> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHistory(PathMetadata metadata, PathInits inits) {
        this(History.class, metadata, inits);
    }

    public QHistory(Class<? extends History> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userDevice = inits.isInitialized("userDevice") ? new com.example.miro.domain.userDevice.entity.QUserDevice(forProperty("userDevice"), inits.get("userDevice")) : null;
    }

}

