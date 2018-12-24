package org.legomd.module.comments.model;

import org.legomd.module.comments.enmu.CommentType;

import javax.annotation.Nonnull;

/**
 * @Author: maru
 * @Date: 2018-12-13
 * @Description:
 */
public class Comment {
    // 每个评论都需要一个独立的标识符
    private String commentID;
    // 评论者的标识符
    private String commenterID;
    // 评论类型，eg，文字评论，顶，踩等
    private CommentType type;
    // 文字评论的内容
    private String comment;

    private Comment(Builder builder) {
        commentID = builder.commentID;
        commenterID = builder.commenterID;
        type = builder.type;
        comment = builder.comment;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(@Nonnull Comment copy) {
        Builder builder = new Builder();
        builder.commentID = copy.getCommentID();
        builder.commenterID = copy.getCommenterID();
        builder.type = copy.getType();
        builder.comment = copy.getComment();
        return builder;
    }

    public String getCommentID() {
        return commentID;
    }

    public String getCommenterID() {
        return commenterID;
    }

    public CommentType getType() {
        return type;
    }

    public String getComment() {
        return comment;
    }

    public static final class Builder {
        private String commentID;
        private String commenterID;
        private CommentType type;
        private String comment;

        private Builder() {
        }

        @Nonnull
        public Builder withCommentID(@Nonnull String commentID) {
            this.commentID = commentID;
            return this;
        }

        @Nonnull
        public Builder withCommenterID(@Nonnull String commenterID) {
            this.commenterID = commenterID;
            return this;
        }

        @Nonnull
        public Builder withType(@Nonnull CommentType type) {
            this.type = type;
            return this;
        }

        @Nonnull
        public Builder withComment(@Nonnull String comment) {
            this.comment = comment;
            return this;
        }

        @Nonnull
        public Comment build() {
            return new Comment(this);
        }
    }
}
