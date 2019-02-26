package com.project.mgt.entity;

public class TXietongRoleWithBLOBs extends TXietongRole {
    private String menus;

    private String menusSidebar;

    public String getMenus() {
        return menus;
    }

    public void setMenus(String menus) {
        this.menus = menus == null ? null : menus.trim();
    }

    public String getMenusSidebar() {
        return menusSidebar;
    }

    public void setMenusSidebar(String menusSidebar) {
        this.menusSidebar = menusSidebar == null ? null : menusSidebar.trim();
    }
}