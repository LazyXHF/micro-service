package com.portjs.base.vo;

import com.portjs.base.entity.TMenuResource;

import java.util.List;

public class MenuResourceVO {
    private MenuResourceTree resourceTree;
    private List<TMenuResource> resources;

    public MenuResourceTree getResourceTree() {
        return resourceTree;
    }

    public void setResourceTree(MenuResourceTree resourceTree) {
        this.resourceTree = resourceTree;
    }

    public List<TMenuResource> getResources() {
        return resources;
    }

    public void setResources(List<TMenuResource> resources) {
        this.resources = resources;
    }
}
