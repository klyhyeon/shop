package com.jpa.shop.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCategoryItem is a Querydsl query type for CategoryItem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCategoryItem extends EntityPathBase<CategoryItem> {

    private static final long serialVersionUID = -943444157L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCategoryItem categoryItem = new QCategoryItem("categoryItem");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QCategory category;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final QItem item;

    public QCategoryItem(String variable) {
        this(CategoryItem.class, forVariable(variable), INITS);
    }

    public QCategoryItem(Path<? extends CategoryItem> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCategoryItem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCategoryItem(PathMetadata metadata, PathInits inits) {
        this(CategoryItem.class, metadata, inits);
    }

    public QCategoryItem(Class<? extends CategoryItem> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QCategory(forProperty("category")) : null;
        this.item = inits.isInitialized("item") ? new QItem(forProperty("item")) : null;
    }

}

