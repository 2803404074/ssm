package com.zt.model;

public class FB_all {
    private String id;
    private FB_BfInfo FBBfInfo;
    private FB_BqcInfo FBBqcInfo;
    private FB_JqsInfo FBJqsInfo;
    private FB_SpfInfo FBSpfInfo;

    public FB_all() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FB_BfInfo getFBBfInfo() {
        return FBBfInfo;
    }

    public void setFBBfInfo(FB_BfInfo FBBfInfo) {
        this.FBBfInfo = FBBfInfo;
    }

    public FB_BqcInfo getFBBqcInfo() {
        return FBBqcInfo;
    }

    public void setFBBqcInfo(FB_BqcInfo FBBqcInfo) {
        this.FBBqcInfo = FBBqcInfo;
    }

    public FB_JqsInfo getFBJqsInfo() {
        return FBJqsInfo;
    }

    public void setFBJqsInfo(FB_JqsInfo FBJqsInfo) {
        this.FBJqsInfo = FBJqsInfo;
    }

    public FB_SpfInfo getFBSpfInfo() {
        return FBSpfInfo;
    }

    public void setFBSpfInfo(FB_SpfInfo FBSpfInfo) {
        this.FBSpfInfo = FBSpfInfo;
    }
}
