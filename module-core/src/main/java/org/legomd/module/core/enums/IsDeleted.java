package org.legomd.module.core.enums;


public enum IsDeleted {
    /**
     * 已删除  1
     */
    YES(1),
    /**
     * 未删除  0
     */
    NO(0);
    private int value;

    public int getValue() {
        return value;
    }

    IsDeleted(int value) {
        this.value = value;
    }
}
