package com.mds.vo;

import com.mds.entity.Role;

public class RoleVo extends Role {
    private int page;
    private int limit;
    private String isdel;

    @Override
    public int getPage() {
        return page;
    }

    @Override
    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public int getLimit() {
        return limit;
    }

    @Override
    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String getIsdel() {
        return isdel;
    }

    @Override
    public void setIsdel(String isdel) {
        this.isdel = isdel;
    }
}
