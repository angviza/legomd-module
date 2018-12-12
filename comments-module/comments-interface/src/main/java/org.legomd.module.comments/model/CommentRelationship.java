package org.legomd.module.comments.model;

import javax.annotation.Nonnull;

/**
 * @Author: maru
 * @Date: 2018-12-13
 * @Description:
 */
public class CommentRelationship {
    // 每个评论都需要一个独立的标识符
    private String commentID;
    // 回复的评论标识符，如果是独立的回复，那么是空字符串
    private String replyCommentID;

    // -----  冗余统计字段，不要求实时同步，允许延时刷新
    private int likeCount;
    private int unlikeCount;
    private int replyCount;

    public String getCommentID() {
        return commentID;
    }

    public String getReplyCommentID() {
        return replyCommentID;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public int getUnlikeCount() {
        return unlikeCount;
    }

    public int getReplyCount() {
        return replyCount;
    }

    private CommentRelationship(Builder builder) {
        commentID = builder.commentID;
        replyCommentID = builder.replyCommentID;
        likeCount = builder.likeCount;
        unlikeCount = builder.unlikeCount;
        replyCount = builder.replyCount;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(@Nonnull CommentRelationship copy) {
        Builder builder = new Builder();
        builder.commentID = copy.getCommentID();
        builder.replyCommentID = copy.getReplyCommentID();
        builder.likeCount = copy.getLikeCount();
        builder.unlikeCount = copy.getUnlikeCount();
        builder.replyCount = copy.getReplyCount();
        return builder;
    }


    public static final class Builder {
        private String commentID;
        private String replyCommentID;
        private int likeCount;
        private int unlikeCount;
        private int replyCount;

        private Builder() {
        }

        public Builder withCommentID(@Nonnull String commentID) {
            this.commentID = commentID;
            return this;
        }

        public Builder withReplyCommentID(@Nonnull String replyCommentID) {
            this.replyCommentID = replyCommentID;
            return this;
        }

        public Builder withLikeCount(int likeCount) {
            this.likeCount = likeCount;
            return this;
        }

        public Builder withUnlikeCount(int unlikeCount) {
            this.unlikeCount = unlikeCount;
            return this;
        }

        public Builder withReplyCount(int replyCount) {
            this.replyCount = replyCount;
            return this;
        }

        public CommentRelationship build() {
            return new CommentRelationship(this);
        }
    }
}
